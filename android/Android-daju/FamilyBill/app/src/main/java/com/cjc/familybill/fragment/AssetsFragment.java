package com.cjc.familybill.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.cjc.familybill.R;
import com.cjc.familybill.assets.AssetsAdapter;
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
    private List<AssetsEntity> mData=new ArrayList<>();

    private AssetsAdapter assetsAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_assets, container,false);
        ButterKnife.bind(this,view);
        initData();
        return view;
    }


    private void initData() {

        AssetsPresenter.findAll(new Subscriber<List<AssetsEntity>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(List<AssetsEntity> assetsEntities) {
                Log.d("MainActivity", "onNext: "+assetsEntities.size());
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
        });

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recycler_assets.setLayoutManager(layoutManager);
        assetsAdapter = new AssetsAdapter(getActivity(),mData);
        int i = System.identityHashCode(mData);
        Log.d("MainActivity", "identityHashCode: " + i);
        Log.d("MainActivity", "initData: 设置适配器");
        recycler_assets.setAdapter(assetsAdapter);
    }
}
