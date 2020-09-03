package com.cjc.familybill.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cjc.familybill.R;
import com.cjc.familybill.assets.AssetsAdapter;
import com.cjc.familybill.assets.AssetsAddActivity;
import com.cjc.familybill.assets.AssetsChangeActivity;
import com.cjc.familybill.entity.AssetsEntity;
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
    private List<AssetsEntity> mData = new ArrayList<>();

    private AssetsAdapter assetsAdapter;

    private String uname;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_assets, container, false);
        uname = getUname();
        ButterKnife.bind(this, view);
        initData();
        initListener();
        Log.d("MainActivity", "uname: " + uname);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        initData();
        initListener();
    }

    private void initListener() {
        assetsAdapter.setOnItemClickListener(new AssetsAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position,int assets_id) {
                //Toast.makeText(getActivity(), "点击了第" + position + "个条目", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), AssetsChangeActivity.class);
                intent.putExtra("assets_id",assets_id);
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
        AssetsPresenter.queryAssSum(new Subscriber<List<AssetsEntity>>() {

            private double sum;

            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(List<AssetsEntity> assetsEntities) {
                Log.d("MainActivity", "onNext: SUM List " + assetsEntities);
                if (assetsEntities.size() > 0) {
                    sum = assetsEntities.get(0).getSum();
                }
                Log.d("MainActivity", "onNext: SUM " + sum);
                assetsSum.setText(sum + "");
            }
        }, uname);

        AssetsPresenter.findAllByUname(new Subscriber<List<AssetsEntity>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(List<AssetsEntity> assetsEntities) {
                Log.d("MainActivity", "onNext: " + assetsEntities.size());
                if (assetsEntities.size() > 0) {
                    mData.clear();
                    mData.addAll(assetsEntities);
                    //boolean b = mData.addAll(assetsEntities);
                    assetsAdapter.notifyDataSetChanged();
                    int i = System.identityHashCode(mData);
                    Log.d("MainActivity", "onNext: " + assetsEntities);
                    Log.d("MainActivity", "onNext: " + mData);
                    //Log.d("MainActivity", "onNext: " + b);
                    Log.d("MainActivity", "identityHashCode OnNext: " + i);
                }
            }
        }, uname);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recycler_assets.setLayoutManager(layoutManager);
        assetsAdapter = new AssetsAdapter(getActivity(), mData);
        int i = System.identityHashCode(mData);
        Log.d("MainActivity", "identityHashCode: " + i);
        Log.d("MainActivity", "initData: 设置适配器");
        recycler_assets.setAdapter(assetsAdapter);
    }


}
