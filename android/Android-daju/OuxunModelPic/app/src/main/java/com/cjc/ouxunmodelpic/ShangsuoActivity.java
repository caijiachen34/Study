package com.cjc.ouxunmodelpic;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by CC
 **/
public class ShangsuoActivity extends Activity {
    @BindView(R.id.btnshangsuo_ok)
    Button btnshangsuoOk;
    @BindView(R.id.btnshangsuo_cancel)
    Button btnshangsuoCancel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shangsuo);
        ButterKnife.bind(this);

        btnshangsuoOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnshangsuoCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
