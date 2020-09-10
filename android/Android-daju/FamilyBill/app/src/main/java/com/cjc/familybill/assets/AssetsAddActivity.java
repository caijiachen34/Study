package com.cjc.familybill.assets;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.cjc.familybill.R;
import com.cjc.familybill.account.AccountAddActivity;
import com.cjc.familybill.activitys.BaseActivity;
import com.cjc.familybill.entity.AssetsEntity;
import com.cjc.familybill.http.presenter.AssetsPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Subscriber;

/**
 * Created by CC
 **/
public class AssetsAddActivity extends BaseActivity {
    @BindView(R.id.iv_assets_add_title_back)
    ImageView ivAssetsAddTitleBack;
    @BindView(R.id.et_add_assets_type)
    EditText etAddAssetsType;
    @BindView(R.id.et_add_assets_money)
    EditText etAddAssetsMoney;
    @BindView(R.id.et_add_assets_remarks)
    EditText etAddAssetsRemarks;
    @BindView(R.id.btn_add_assets)
    Button btnAddAssets;

    private String uname;
    private String assets_type;
    private Double assets_money;
    private String assets_remarks;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assetsadd);
        uname = getUname(getApplicationContext());
        ButterKnife.bind(this);
        initListener();
    }


    private void initListener() {
        ivAssetsAddTitleBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnAddAssets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String money = etAddAssetsMoney.getText().toString().trim();
                if (TextUtils.isEmpty(money)) {
                    Toast.makeText(AssetsAddActivity.this, "请输入相关内容", Toast.LENGTH_SHORT).show();
                    return;
                }else {
                    assets_type = etAddAssetsType.getText().toString().trim();
                    assets_money = Double.parseDouble(money);
                }
                assets_remarks = etAddAssetsRemarks.getText().toString().trim();
                if (TextUtils.isEmpty(assets_type)||TextUtils.isEmpty(assets_remarks)) {
                    Toast.makeText(AssetsAddActivity.this, "请输入相关内容", Toast.LENGTH_SHORT).show();
                    return;
                }else {
                    AssetsPresenter.saveAssets(new Subscriber<List<AssetsEntity>>() {
                        @Override
                        public void onCompleted() {

                        }

                        @Override
                        public void onError(Throwable e) {

                        }

                        @Override
                        public void onNext(List<AssetsEntity> assetsEntities) {
                            Toast.makeText(getApplicationContext(),"添加账户成功",Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    },uname,assets_type,assets_money,assets_remarks);
                }

            }
        });

    }




}
