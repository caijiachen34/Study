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
import com.cjc.familybill.account.AccountAdapter;
import com.cjc.familybill.account.AccountAddActivity;
import com.cjc.familybill.assets.AssetsAddActivity;
import com.cjc.familybill.entity.AccountEntity;
import com.cjc.familybill.http.presenter.AccountPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Subscriber;

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

    private List<AccountEntity> mData = new ArrayList<>();
    AccountAdapter accountAdapter;


    private String uname;
    private Double sumout=0.0;
    private Double sumin =0.0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_account, container,false);
        uname = getUname();
        ButterKnife.bind(this, view);
        initData();
        initListener();
        return view;
    }

    private void initListener() {
        addAccountIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), AccountAddActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        initData();
    }

    private void initData() {

        //支出总额
        AccountPresenter.queryAccByType(new Subscriber<List<AccountEntity>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(List<AccountEntity> accountEntities) {
                Log.d("AccountFragment", "sumout: " + "进入支出");
                sumout = accountEntities.get(0).getSum();
                accountSum.setText((sumin-sumout)+"");
            }

        },"支出",uname);

        //支出总额
        AccountPresenter.queryAccByType(new Subscriber<List<AccountEntity>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(List<AccountEntity> accountEntities) {
                sumin = accountEntities.get(0).getSum();
                Log.d("AccountFragment", "sumin: " + sumin);
                accountSum.setText((sumin-sumout)+"");
            }

        },"收入",uname);


        AccountPresenter.queryAccByUname(new Subscriber<List<AccountEntity>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Log.d("AccountFragment", "onError: " + e.getCause());
            }

            @Override
            public void onNext(List<AccountEntity> accountEntities) {
                Log.d("AccountFragment", "onNext: " + accountEntities);
                if (accountEntities.size() > 0) {
                    mData.clear();
                    mData.addAll(accountEntities);
                    //boolean b = mData.addAll(assetsEntities);
                    accountAdapter.notifyDataSetChanged();
                    int i = System.identityHashCode(mData);

                    Log.d("AccountFragment", "onNext: " + mData);
                    //Log.d("MainActivity", "onNext: " + b);
                    Log.d("AccountFragment", "identityHashCode OnNext: " + i);
                }
            }
        },uname);








        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerAccount.setLayoutManager(layoutManager);
        accountAdapter = new AccountAdapter(getActivity(), mData);
        int i = System.identityHashCode(mData);
        Log.d("AccountFragment", "identityHashCode: " + i);
        Log.d("AccountFragment", "initData: 设置适配器");
        recyclerAccount.setAdapter(accountAdapter);
    }
}
