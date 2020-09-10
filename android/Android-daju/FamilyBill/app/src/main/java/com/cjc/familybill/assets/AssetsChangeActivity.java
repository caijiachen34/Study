package com.cjc.familybill.assets;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.cjc.familybill.R;
import com.cjc.familybill.activitys.BaseActivity;
import com.cjc.familybill.entity.AssetsEntity;
import com.cjc.familybill.http.presenter.AssetsPresenter;
import com.cjc.familybill.login.LoginActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Subscriber;

/**
 * Created by CC
 **/
public class AssetsChangeActivity extends BaseActivity {

    @BindView(R.id.iv_assets_change_title_back)
    ImageView ivAssetsChangeTitleBack;
    @BindView(R.id.et_change_assets_type)
    EditText etChangeAssetsType;
    @BindView(R.id.et_change_assets_money)
    EditText etChangeAssetsMoney;
    @BindView(R.id.et_change_assets_remarks)
    EditText etChangeAssetsRemarks;
    @BindView(R.id.btn_change_assets)
    Button btnChangeAssets;
    @BindView(R.id.btn_delete_assets)
    Button btnDeleteAssets;

    private int assets_id;
    private String assets_type;
    private Double assets_money;
    private String assets_remarks;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_assets);
        ButterKnife.bind(this);
        initData();
        initListener();
    }

    @Override
    protected void onResume() {
        super.onResume();
        initData();
    }

    private void initListener() {
        ivAssetsChangeTitleBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnChangeAssets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String money = etChangeAssetsMoney.getText().toString().trim();
                if (TextUtils.isEmpty(money)) {
                    Toast.makeText(AssetsChangeActivity.this, "请输入相关内容", Toast.LENGTH_SHORT).show();
                    return;
                }
                assets_type = etChangeAssetsType.getText().toString().trim();
                assets_money = Double.parseDouble(money);
                assets_remarks = etChangeAssetsRemarks.getText().toString().trim();
                if (TextUtils.isEmpty(assets_type) || TextUtils.isEmpty(assets_remarks)) {
                    Toast.makeText(AssetsChangeActivity.this, "请输入相关内容", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    handlerChange();
                }
            }
        });

        btnDeleteAssets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(AssetsChangeActivity.this);
                dialog.setTitle("删除资产");
                dialog.setMessage("是否删除?");
                dialog.setCancelable(true);
                dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        handlerDelete();
                    }
                });
                dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dialog.show();
            }
        });


    }

    private void handlerDelete() {
        AssetsPresenter.deleteAssById(new Subscriber<List<AssetsEntity>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(List<AssetsEntity> assetsEntities) {
                finish();
            }
        }, assets_id);
    }


    private void handlerChange() {
        AssetsPresenter.updateAssById(new Subscriber<List<AssetsEntity>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(List<AssetsEntity> assetsEntities) {
                Toast.makeText(getApplicationContext(), "修改账户成功", Toast.LENGTH_SHORT).show();
                finish();
            }
        }, assets_id, assets_type, assets_money, assets_remarks);
    }


    private void initData() {
        Intent intent = getIntent();
        assets_id = intent.getIntExtra("assets_id", -1);

        AssetsPresenter.queryAssById(new Subscriber<List<AssetsEntity>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(List<AssetsEntity> assetsEntities) {
                AssetsEntity assetsEntity = assetsEntities.get(0);
                etChangeAssetsType.setText(assetsEntity.getAssetsType());
                etChangeAssetsMoney.setText(String.valueOf(assetsEntity.getAssetsMoney()));
                etChangeAssetsRemarks.setText(assetsEntity.getRemarks());
            }
        }, assets_id);
    }
}
