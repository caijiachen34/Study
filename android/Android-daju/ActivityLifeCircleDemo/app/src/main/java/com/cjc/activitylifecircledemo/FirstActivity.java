package com.cjc.activitylifecircledemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

/**
 * Created by CC
 **/
public class FirstActivity extends Activity {
    private static final String TAG = "FirstActivity";
    private Button skip2SecondActivity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        Log.d(TAG, "onCreate: ");
        initView();
        initListener();
    }

    private void initView() {
        skip2SecondActivity = findViewById(R.id.skip2SecondActivity);
    }

    private void initListener() {
        skip2SecondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handlerskip2SecondActivity();
            }
        });
    }

    private void handlerskip2SecondActivity() {
        Intent intent = new Intent(this,SecondActivity.class);


        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }
}
