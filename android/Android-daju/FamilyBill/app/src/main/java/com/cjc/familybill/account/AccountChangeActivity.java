package com.cjc.familybill.account;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.cjc.familybill.R;
import com.cjc.familybill.activitys.BaseActivity;
import com.cjc.familybill.assets.AssetsAddActivity;
import com.cjc.familybill.entity.AccountEntity;
import com.cjc.familybill.entity.AssetsEntity;
import com.cjc.familybill.http.presenter.AccountPresenter;
import com.cjc.familybill.http.presenter.AssetsPresenter;

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
public class AccountChangeActivity extends BaseActivity {


    @BindView(R.id.iv_account_change_title_back)
    ImageView ivAccountChangeTitleBack;
    @BindView(R.id.et_change_account_money)
    EditText etChangeAccountMoney;
    @BindView(R.id.et_change_account_type)
    Spinner etChangeAccountType;
    @BindView(R.id.et_change_account_pay_type)
    Spinner etChangeAccountPayType;
    @BindView(R.id.et_change_account_assets_type)
    Spinner etChangeAccountAssetsType;
    @BindView(R.id.et_change_account_remarks)
    EditText etChangeAccountRemarks;
    @BindView(R.id.btn_delete_account)
    Button btnDeleteAccount;
    @BindView(R.id.btn_change_account)
    Button btnChangeAccount;

    private int account_id;
    private String uname;
    private Double accountMoney;
    private String accountType;
    private String payType;
    private String assetsType;
    private String remarks;


    private String[] accountTypes = {"购物", "工资", "租房", "学习", "旅游", "交通", "饮食", "医疗", "其他消费"};
    private String[] payTypes = {"支出", "收入"};
    private String[] assetTypes;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_account);
        ButterKnife.bind(this);
        uname = getUname(getApplicationContext());
        initData();
        initListener();
    }

    @Override
    protected void onResume() {
        super.onResume();
        initData();
        initListener();
    }

    private void initData() {

        account_id = getIntent().getIntExtra("account_id", -1);

        AccountPresenter.queryAccById(new Subscriber<List<AccountEntity>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(List<AccountEntity> accountEntities) {
                AccountEntity accountEntity = accountEntities.get(0);
                Log.d("AccountChangeActivity", "onNext: " + accountEntity);
                etChangeAccountMoney.setText(accountEntity.getAccountMoney() + "");
                etChangeAccountRemarks.setText(accountEntity.getRemarks());
                int i1 = setSpinnerItemSelectedByValue(etChangeAccountType, accountEntity.getAccountType());
                int i2 = setSpinnerItemSelectedByValue(etChangeAccountPayType, accountEntity.getPayType());
                int i3 = setSpinnerItemSelectedByValue(etChangeAccountAssetsType, accountEntity.getAssetsType());
//                Log.d("AccountChangeActivity", "onNext: i1 " + i1 +" i2 "+i2+" i3 "+i3);
//                Log.d("AccountChangeActivity", "onNext: " + accountEntity.getRemarks());
            }
        }, account_id);



        etChangeAccountAssetsType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                assetsType = (String) etChangeAccountAssetsType.getSelectedItem();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        etChangeAccountPayType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                payType = (String) etChangeAccountPayType.getSelectedItem();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        etChangeAccountType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                accountType = (String) etChangeAccountType.getSelectedItem();
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
                Log.d("AccountChangeActivityS", "onNext: " + assetsEntities.size());
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
                Log.d("AccountChangeActivity", "assetTypes: " + Arrays.toString(assetTypes));
                ArrayAdapter<String> AccountAssetsTypeAdapter = new ArrayAdapter<String>(AccountChangeActivity.this, android.R.layout.simple_list_item_1, assetTypes);
                etChangeAccountAssetsType.setAdapter(AccountAssetsTypeAdapter);
            }
        }, uname);


        ArrayAdapter<String> accountTypeAdapter = new ArrayAdapter<String>(AccountChangeActivity.this, android.R.layout.simple_list_item_1, accountTypes);
        etChangeAccountType.setAdapter(accountTypeAdapter);
        ArrayAdapter<String> accountPayTypeAdapter = new ArrayAdapter<String>(AccountChangeActivity.this, android.R.layout.simple_list_item_1, payTypes);
        etChangeAccountPayType.setAdapter(accountPayTypeAdapter);
    }


    private void initListener() {

        ivAccountChangeTitleBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnDeleteAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AccountPresenter.deleteAccount(new Subscriber<List<AccountEntity>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(List<AccountEntity> accountEntities) {
                        Log.d("AccountChangeActivity", "onNext: delete");
                        Toast.makeText(getApplicationContext(), "删除成功", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }, account_id);
            }
        });

        btnChangeAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String money = etChangeAccountMoney.getText().toString();
                if (TextUtils.isEmpty(money)) {
                    Toast.makeText(AccountChangeActivity.this, "请输入相关内容", Toast.LENGTH_SHORT).show();
                    return;
                }
                accountMoney = Double.parseDouble(money);
                remarks = etChangeAccountRemarks.getText().toString();
                if (TextUtils.isEmpty(assetsType)||TextUtils.isEmpty(remarks)) {
                    Toast.makeText(AccountChangeActivity.this, "请输入相关内容", Toast.LENGTH_SHORT).show();
                    return;
                }else {
                    AccountPresenter.updateById(new Subscriber<List<AccountEntity>>() {
                        @Override
                        public void onCompleted() {

                        }

                        @Override
                        public void onError(Throwable e) {

                        }

                        @Override
                        public void onNext(List<AccountEntity> accountEntities) {
                            Log.d("AccountChangeActivity", "onNext: update");
                            Toast.makeText(getApplicationContext(), "修改成功", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    }, account_id, accountMoney, accountType, payType, assetsType, remarks);
                }

            }
        });


    }


}
