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
import com.cjc.familybill.assets.AssetsRemainAdapter;
import com.cjc.familybill.entity.AssetsEntity;
import com.cjc.familybill.entity.AssetsRemain;
import com.cjc.familybill.entity.HttpResult;
import com.cjc.familybill.http.HttpMethods;
import com.cjc.familybill.http.api.AssetsService;
import com.cjc.familybill.http.presenter.AssetsPresenter;
import com.cjc.familybill.utils.InsertRemain;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;
import rx.functions.Function;

import static com.cjc.familybill.utils.Constants.BASE_URL;

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
    private List<AssetsRemain> mDataRemain = new ArrayList<>();

    private AssetsAdapter assetsAdapter;
    private AssetsRemainAdapter assetsRemainAdapter;

    private String uname;

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

    private void initListener() {
        assetsRemainAdapter.setOnItemClickListener(new AssetsRemainAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position,int assets_id1,int assets_id2) {
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
        AssetsPresenter.queryAssSum(new Subscriber<List<AssetsEntity>>() {

            private double sum;

            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                sum=0.0;
                assetsSum.setText(sum + "");
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
                mData.clear();
                //assetsAdapter.notifyDataSetChanged();
            }

            @Override
            public void onNext(List<AssetsEntity> assetsEntities) {
                Log.d("MainActivity", "onNext: " + assetsEntities.size());
                if (assetsEntities.size() > 0) {
                    mData.clear();
                    mData.addAll(assetsEntities);
                    //boolean b = mData.addAll(assetsEntities);
                    //assetsAdapter.notifyDataSetChanged();
                    int i = System.identityHashCode(mData);
                    Log.d("MainActivity", "onNext: " + assetsEntities);
                    Log.d("MainActivity", "onNext: " + mData);
                    //Log.d("MainActivity", "onNext: " + b);
                    Log.d("MainActivity", "identityHashCode OnNext: " + i);
                }
            }
        }, uname);

        AssetsPresenter.queryAssRemainByUname(new Subscriber<List<AssetsRemain>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                mDataRemain.clear();
                assetsRemainAdapter.notifyDataSetChanged();
            }

            @Override
            public void onNext(List<AssetsRemain> assetsRemains) {
                if (assetsRemains.size()>0) {
                    mDataRemain.clear();
                    mDataRemain.addAll(assetsRemains);
                    assetsRemainAdapter.notifyDataSetChanged();
                }
            }
        },uname);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recycler_assets.setLayoutManager(layoutManager);
        assetsRemainAdapter = new AssetsRemainAdapter(getActivity(), mDataRemain,mData);
        int i = System.identityHashCode(mData);
        Log.d("MainActivity", "identityHashCode: " + i);
        Log.d("MainActivity", "initData: 设置适配器");
        recycler_assets.setAdapter(assetsRemainAdapter);
    }


}
