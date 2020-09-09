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
public class ChukuActivity extends Activity {
    @BindView(R.id.btn_chuku_again)
    Button btnChukuAgain;
    @BindView(R.id.btn_chuku_back)
    Button btnChukuBack;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chukuok);
        ButterKnife.bind(this);

        btnChukuAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),SaoMiaoInActivity.class);
                startActivity(intent);

            }
        });

        btnChukuBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
