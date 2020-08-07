package com.cjc.androidactivitydemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;

/**
 * Created by CC
 **/

/*
* 第二个界面，通过显式意图跳转
* */
public class SecondActivity extends Activity {
    private static final String TAG = "SecondActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView info = findViewById(R.id.info);

        Intent intent = getIntent();
        String account = intent.getStringExtra("account");
        String password = intent.getStringExtra("password");
        Log.d(TAG, "账号===>>>>" + account);
        Log.d(TAG, "密码====>>>>" + password);
        info.setText("账号:" + account + "密码:" + password);

    }
}

