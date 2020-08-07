package com.cjc.androidactivitydemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * 目标：
* 实现页面的跳转并且把数据传回另一个界面
*/
public class MainActivity extends AppCompatActivity {

    private EditText mAccount ;
    private EditText mPassword;
    private Button mLogin   ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initListener();
    }

    private void initView() {
        mAccount = findViewById(R.id.account);
        mPassword = findViewById(R.id.password);
        mLogin   = findViewById(R.id.login);
    }

    private void initListener() {
        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handlerLogin();
            }
        });
    }

    private void handlerLogin() {
        String account = mAccount.getText().toString().trim();
        String password = mPassword.getText().toString().trim();

        //账号空判断
        if (TextUtils.isEmpty(account)) {
            Toast.makeText(this,"输入的账号为空",Toast.LENGTH_SHORT).show();
            return;
        }
        //密码空判断
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this,"输入的密码为空",Toast.LENGTH_SHORT).show();
            return;
        }

        //创建一个意图，用来跳转到SecondActivity界面
        //通过putExtra传输数据
        /*这部分是显示意图*/

        //第一种写法
        //Intent intent = new Intent(this,SecondActivity.class);

        //第二种写法
        Intent intent = new Intent();
        //获取类目
        String packageName = getPackageName();
        String name = SecondActivity.class.getName();
        intent.setClassName(packageName,name);
        intent.putExtra("account",account);
        intent.putExtra("password",password);
        startActivity(intent);

        //接下来使用隐式意图
        /*Intent intent = new Intent();
        intent.setAction("com.cjc.LOGIN_INFO");
        //intent.addCategory("android.intent.category.DEFAULT");
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        intent.putExtra("account",account);
        intent.putExtra("password",password);
        startActivity(intent);*/

    }

}