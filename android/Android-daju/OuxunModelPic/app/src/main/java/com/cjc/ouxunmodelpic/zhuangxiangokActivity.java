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
public class zhuangxiangokActivity extends Activity {
    @BindView(R.id.btn_zhuangxiangok_again)
    Button btnZhuangxiangokAgain;
    @BindView(R.id.btn_zhuangxiangok_back)
    Button btnZhuangxiangokBack;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhuangxiangok);
        ButterKnife.bind(this);

        btnZhuangxiangokAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SaoMiaoInActivity.class);
                startActivity(intent);
            }
        });

        btnZhuangxiangokBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
