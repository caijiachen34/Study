package com.cjc.familybill.account;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.cjc.familybill.R;
import com.cjc.familybill.activitys.BaseActivity;
import com.cjc.familybill.entity.AccountEntity;
import com.cjc.familybill.entity.AssetsEntity;
import com.cjc.familybill.http.presenter.AccountPresenter;
import com.cjc.familybill.http.presenter.AssetsPresenter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Subscriber;

/**
 * Created by CC
 **/
public class AccountAddActivity extends BaseActivity {
    @BindView(R.id.iv_account_add_title_back)
    ImageView ivAccountAddTitleBack;
    @BindView(R.id.et_add_account_money)
    EditText etAddAccountMoney;
    @BindView(R.id.et_add_account_type)
    Spinner etAddAccountType;
    @BindView(R.id.et_add_account_pay_type)
    Spinner etAddAccountPayType;
    @BindView(R.id.et_add_account_assets_type)
    Spinner etAddAccountAssetsType;
    @BindView(R.id.et_add_account_remarks)
    EditText etAddAccountRemarks;
    @BindView(R.id.btn_add_account)
    Button btnAddAccount;

    private String uname;
    private Double accountMoney;
    private String accountType;
    private String payType;
    private String assetsType;
    private String remarks;

    //private List<AssetsEntity> mData = new ArrayList<>();
    private String[] accountTypes = {"购物", "工资", "租房", "学习", "旅游", "交通", "饮食", "医疗", "其他消费"};
    private String[] payTypes = {"支出", "收入"};
    private String[] assetTypes;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accountadd);
        uname = getUname(getApplicationContext());
        ButterKnife.bind(this);
        initData();
        initListener();
    }


    private void initData() {

        etAddAccountAssetsType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                assetsType = (String) etAddAccountAssetsType.getSelectedItem();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        etAddAccountPayType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                payType = (String) etAddAccountPayType.getSelectedItem();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        etAddAccountType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                accountType = (String) etAddAccountType.getSelectedItem();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        AssetsPresenter.findAllByUname(new Subscriber<List<AssetsEntity>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(List<AssetsEntity> assetsEntities) {
                Log.d("AccountAddActivity", "onNext: " + assetsEntities.size());
                if (assetsEntities.size() > 0) {
                    int size = assetsEntities.size();
                    Set<Object> objects = new HashSet<>();
                    assetTypes = new String[size];
                    String[] assetTypestemp = new String[size];
                    for (int i = 0; i < assetsEntities.size(); i++) {
                        assetTypestemp[i] = assetsEntities.get(i).getAssetsType();
                    }
                    List<String> templist = Arrays.asList(assetTypestemp);
                    Set tempset = new HashSet(templist);
                    assetTypes = (String[]) tempset.toArray(new String[0]);
                }
                Log.d("AccountAddActivity", "assetTypes: " + Arrays.toString(assetTypes));
                ArrayAdapter<String> AccountAssetsTypeAdapter = new ArrayAdapter<String>(AccountAddActivity.this, android.R.layout.simple_list_item_1, assetTypes);
                etAddAccountAssetsType.setAdapter(AccountAssetsTypeAdapter);
            }
        }, uname);


        ArrayAdapter<String> accountTypeAdapter = new ArrayAdapter<String>(AccountAddActivity.this, android.R.layout.simple_list_item_1, accountTypes);
        etAddAccountType.setAdapter(accountTypeAdapter);
        ArrayAdapter<String> accountPayTypeAdapter = new ArrayAdapter<String>(AccountAddActivity.this, android.R.layout.simple_list_item_1, payTypes);
        etAddAccountPayType.setAdapter(accountPayTypeAdapter);
    }

    private void initListener() {
        ivAccountAddTitleBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        btnAddAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                accountMoney = Double.parseDouble(etAddAccountMoney.getText().toString());
                remarks = etAddAccountRemarks.getText().toString();
                AccountPresenter.saveAccount(new Subscriber<List<AccountEntity>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(List<AccountEntity> accountEntities) {
                        Toast.makeText(AccountAddActivity.this, "添加成功", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }, uname, accountMoney, accountType, payType, assetsType, remarks);
            }
        });
    }


}
