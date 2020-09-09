package com.cjc.ouxunmodelpic;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.INotificationSideChannel;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by CC
 **/
public class SaoMiaoInActivity extends Activity {
    @BindView(R.id.btn_zhuangxiang)
    Button btnZhuangxiang;
    @BindView(R.id.btn_hedui)
    Button btnHedui;
    @BindView(R.id.btn_shangsuo)
    Button btnShangsuo;
    @BindView(R.id.btn_ruku)
    Button btnRuku;
    @BindView(R.id.btn_chuku)
    Button btnChuku;
    @BindView(R.id.btn_fanhui)
    Button btnFanhui;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saomiaoin);
        ButterKnife.bind(this);
        initListener();
    }

    private void initListener() {
        btnZhuangxiang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ZhuangxiangActivity.class);
                startActivity(intent);

            }
        });

        btnFanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnShangsuo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ShangsuoActivity.class);
                startActivity(intent);
            }
        });

        btnRuku.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),RukuActivity.class);
                startActivity(intent);
            }
        });

        btnChuku.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ChukuActivity.class);
                startActivity(intent);
            }
        });
    }
}
