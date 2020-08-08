package com.cjc.componentdatadeliver;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

/**
 * Created by CC
 **/
public class LoginActivity extends Activity {

    private EditText musername;
    private EditText mpassword;
    private Button mregister;
    private Button mlogin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        initListener();
    }

    private void initView() {
        musername = findViewById(R.id.username_et);
        mpassword = findViewById(R.id.password_et);
        mregister = findViewById(R.id.register_btn);
        mlogin = findViewById(R.id.login_btn);
    }

    private void initListener() {
        mregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handlerRegister();
            }
        });


        mlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void handlerRegister() {
        String username = musername.getText().toString().trim();
        String password = mpassword.getText().toString().trim();
        if (TextUtils.isEmpty(username)) {
            Toast.makeText(this,"账号不能为空",Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this,"密码不能为空",Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent = new Intent(this,RegisterResultActivity.class);
        intent.putExtra("usernameKey",username);
        intent.putExtra("passwordKey",password);

        startActivity(intent);

        //结束此界面
        this.finish();

    }

}
