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
public class RukuActivity extends Activity {
    @BindView(R.id.btn_ruku_again)
    Button btnRukuAgain;
    @BindView(R.id.btn_ruku_back)
    Button btnRukuBack;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rukuok);
        ButterKnife.bind(this);

        btnRukuAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SaoMiaoInActivity.class);
                startActivity(intent);
            }
        });

        btnRukuBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
