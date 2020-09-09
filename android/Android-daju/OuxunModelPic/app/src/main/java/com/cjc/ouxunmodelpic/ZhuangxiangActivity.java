package com.cjc.ouxunmodelpic;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by CC
 **/
public class ZhuangxiangActivity extends Activity {
    @BindView(R.id.btn_zhuangxiang_ok)
    Button btnZhuangxiangOk;
    @BindView(R.id.btn_zhuangxiang_cancel)
    Button btnZhuangxiangCancel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhuangxiang);
        ButterKnife.bind(this);
        initListener();
    }

    private void initListener() {
        btnZhuangxiangOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),zhuangxiangokActivity.class);
                startActivity(intent);
            }
        });

        btnZhuangxiangCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



    }
}
