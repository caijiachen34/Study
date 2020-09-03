package com.cjc.familybill.fragment;

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

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by CC
 **/
public class AccountFragment extends BaseFragment {
    @BindView(R.id.add_account_iv)
    ImageView addAccountIv;
    @BindView(R.id.account_sum)
    TextView accountSum;
    @BindView(R.id.recycler_account)
    RecyclerView recyclerAccount;


    private String uname;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_account, container,false);
        uname = getUname();
        ButterKnife.bind(this, view);
        initData();
        return view;
    }

    private void initData() {














        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerAccount.setLayoutManager(layoutManager);
        assetsAdapter = new AssetsAdapter(getActivity(), mData);
        int i = System.identityHashCode(mData);
        Log.d("MainActivity", "identityHashCode: " + i);
        Log.d("MainActivity", "initData: 设置适配器");
        recycler_assets.setAdapter(assetsAdapter);
    }
}
