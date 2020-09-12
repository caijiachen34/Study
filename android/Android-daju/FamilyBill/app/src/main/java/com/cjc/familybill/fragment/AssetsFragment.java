package com.cjc.familybill.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cjc.familybill.R;
import com.cjc.familybill.assets.AssetsAdapter;
import com.cjc.familybill.assets.AssetsAddActivity;
import com.cjc.familybill.assets.AssetsChangeActivity;
import com.cjc.familybill.assets.AssetsRemainAdapter;
import com.cjc.familybill.entity.AssetsEntity;
import com.cjc.familybill.entity.AssetsRemain;
import com.cjc.familybill.http.presenter.AssetsPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Subscriber;

/**
 * Created by CC
 **/
public class AssetsFragment extends BaseFragment {

    @BindView(R.id.recycler_assets)
    RecyclerView recycler_assets;
    @BindView(R.id.add_assets_iv)
    ImageView addAssetsIv;
    @BindView(R.id.assets_sum)
    TextView assetsSum;
    @BindView(R.id.assets_refresh)
    ImageView assetsRefresh;

    private List<AssetsEntity> mData = new ArrayList<>();
    private List<AssetsRemain> mDataRemain = new ArrayList<>();

    private AssetsAdapter assetsAdapter;
    private AssetsRemainAdapter assetsRemainAdapter;

    private String uname;
    private Double remain_money;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_assets, container, false);
        uname = getUname();
        ButterKnife.bind(this, view);
        initData();
        initListener();
        Log.d("AssetsFragment", "uname: " + uname);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("AssetsFragment", "onResume: ");
        initData();
        initListener();
        assetsRemainAdapter.notifyDataSetChanged();
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("AssetsFragment", "onPause: ");
    }

    private void initListener() {
        assetsRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initData();
                initListener();
                assetsRemainAdapter.notifyDataSetChanged();
                onPause();
                onResume();
            }
        });

        assetsRemainAdapter.setOnItemClickListener(new AssetsRemainAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position, int assets_id1, int assets_id2) {
                //Toast.makeText(getActivity(), "点击了第" + position + "个条目", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), AssetsChangeActivity.class);
                intent.putExtra("assets_id", assets_id2);
                startActivity(intent);
            }
        });

        addAssetsIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), AssetsAddActivity.class);
                startActivity(intent);
            }
        });
    }


    private void initData() {
        //Double remain = InsertRemain.InsertRemain(uname, "银行卡");
        //Log.d("AssetsFragment", "remain: " + remain);
//        AssetsPresenter.queryAssSum(new Subscriber<List<AssetsEntity>>() {
//
//            private double sum;
//
//            @Override
//            public void onCompleted() {
//
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                remain_money = 0.0;
//                assetsSum.setText(remain_money + "");
//            }
//
//            @Override
//            public void onNext(List<AssetsEntity> assetsEntities) {
//                Log.d("AssetsFragment", "onNext: SUM List " + assetsEntities);
//                if (assetsEntities.size() > 0) {
//                    sum = assetsEntities.get(0).getSum();
//                }
//                Log.d("AssetsFragment", "onNext: SUM " + sum);
//                assetsSum.setText(remain_money + "");
//            }
//        }, uname);

        AssetsPresenter.findAllByUname(new Subscriber<List<AssetsEntity>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                mData.clear();
                //assetsAdapter.notifyDataSetChanged();
            }

            @Override
            public void onNext(List<AssetsEntity> assetsEntities) {
                Log.d("AssetsFragment", "onNext: " + assetsEntities.size());
                if (assetsEntities.size() > 0) {
                    mData.clear();
                    mData.addAll(assetsEntities);
                    //boolean b = mData.addAll(assetsEntities);
                    //assetsAdapter.notifyDataSetChanged();
                    int i = System.identityHashCode(mData);
                    Log.d("AssetsFragment", "onNext: " + assetsEntities);
                    Log.d("AssetsFragment", "onNext: " + mData);
                    //Log.d("MainActivity", "onNext: " + b);
                    Log.d("AssetsFragment", "identityHashCode OnNext: " + i);
                }
            }
        }, uname);

        AssetsPresenter.queryAssRemainByUname(new Subscriber<List<AssetsRemain>>() {
            @Override
            public void onCompleted() {
                assetsSum.setText(remain_money + "");
            }

            @Override
            public void onError(Throwable e) {
                mDataRemain.clear();
                assetsRemainAdapter.notifyDataSetChanged();
            }

            @Override
            public void onNext(List<AssetsRemain> assetsRemains) {
                if (assetsRemains.size() > 0) {
                    Log.d("AssetsFragment", "assetsRemains: " + assetsRemains);
                    mDataRemain.clear();
                    mDataRemain.addAll(assetsRemains);
                    assetsRemainAdapter.notifyDataSetChanged();
                    remain_money =0.0;
                    for (AssetsRemain assetsRemain : assetsRemains) {
                        remain_money = assetsRemain.getRemain_money()+remain_money;
                    }
                }
            }
        }, uname);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recycler_assets.setLayoutManager(layoutManager);
        assetsRemainAdapter = new AssetsRemainAdapter(getActivity(), mDataRemain, mData);
        int i = System.identityHashCode(mData);
        assetsRemainAdapter.notifyDataSetChanged();
        Log.d("AssetsFragment", "identityHashCode: " + i);
        Log.d("AssetsFragment", "initData: 设置适配器");
        recycler_assets.setAdapter(assetsRemainAdapter);
    }


}
