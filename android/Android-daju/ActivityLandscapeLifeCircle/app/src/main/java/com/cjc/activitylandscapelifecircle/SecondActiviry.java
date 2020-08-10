package com.cjc.activitylandscapelifecircle;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

/**
 * Created by CC
 **/
public class SecondActiviry extends Activity {
    private static final String TAG = "SecondActiviry";
    private Button openfirst;
    private Button opensecond;
    private Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initView();
        initListener();
        context = getApplicationContext();
    }

    private void initView() {
        openfirst = findViewById(R.id.openfirst);
        opensecond = findViewById(R.id.opensecond);
    }

    private void initListener() {
        openfirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,FirstActivity.class);


                startActivity(intent);
            }
        });
        opensecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,SecondActiviry.class);


                startActivity(intent);
            }
        });
    }
}
