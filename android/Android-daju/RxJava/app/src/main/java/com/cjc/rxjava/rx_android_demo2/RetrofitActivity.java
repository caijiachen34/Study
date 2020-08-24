package com.cjc.rxjava.rx_android_demo2;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;

import com.cjc.rxjava.R;
import com.cjc.rxjava.rx_android_demo2.untils.LoginUtils;

import rx.Scheduler;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by CC
 **/
public class RetrofitActivity extends Activity {

    private static final String TAG = "RetrofitActivity";
    private EditText username;
    private EditText password;
    private Button button;
    private LoginUtils loginUtils;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        loginUtils = new LoginUtils();
        initView();
        initListener();
    }

    private void initView() {
        username = findViewById(R.id.tv_username);
        password = findViewById(R.id.tv_password);
        button = findViewById(R.id.btn_submit);
    }

    private void initListener() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uname = username.getText().toString().trim();
                String upwd = password.getText().toString().trim();
                loginUtils.login(uname,upwd).observeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG, "onCompleted: ");
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(String s) {
                        Log.d(TAG, "onNext: " + s.toString());
                    }
                });
            }
        });
    }


}
