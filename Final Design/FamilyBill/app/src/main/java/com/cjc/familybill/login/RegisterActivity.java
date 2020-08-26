package com.cjc.familybill.login;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.cjc.familybill.R;
import com.cjc.familybill.utils.MD5Util;

/**
 * Created by CC
 **/
public class RegisterActivity extends Activity {

    private TextView tv_main_title;
    private RelativeLayout rl_title_bar;
    private TextView tv_back;
    private Button btn_register;
    private EditText et_user_name;
    private EditText et_user_pwd;
    private EditText et_user_pwd_again;
    private String username,pwd,pwd_again;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_register);
        init();
    }

    private void init() {
        tv_main_title = findViewById(R.id.tv_main_title);
        tv_main_title.setText("注册");
        tv_back = findViewById(R.id.tv_back);
        rl_title_bar = findViewById(R.id.title_bar);
        rl_title_bar.setBackgroundColor(Color.TRANSPARENT);

        btn_register = findViewById(R.id.btn_register);
        et_user_name = findViewById(R.id.et_user_name_register);
        et_user_pwd = findViewById(R.id.et_user_pwd_register);
        et_user_pwd_again = findViewById(R.id.et_user_pwd_again_register);
        //点击返回图标
        tv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //关闭当前页面
                RegisterActivity.this.finish();
            }
        });

        //注册点击事件
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = et_user_name.getText().toString().trim();
                pwd = et_user_pwd.getText().toString();
                pwd_again = et_user_pwd_again.getText().toString().trim();
                if (TextUtils.isEmpty(username)) {
                    Toast.makeText(RegisterActivity.this,"请输入用户名",Toast.LENGTH_SHORT).show();
                    return;
                }else if (TextUtils.isEmpty(pwd)) {
                    Toast.makeText(RegisterActivity.this, "请输入密码", Toast.LENGTH_SHORT).show();
                    return;
                } else if (TextUtils.isEmpty(pwd_again)) {
                    Toast.makeText(RegisterActivity.this, "请再次输入密码", Toast.LENGTH_SHORT).show();
                    return;
                } else if (!pwd.equals(pwd_again)) {
                    Toast.makeText(RegisterActivity.this, "两次输入的密码不一样", Toast.LENGTH_SHORT).show();
                    return;
                } else if (isExistUserName(username)) {
                    Toast.makeText(RegisterActivity.this, "此用户已经存在", Toast.LENGTH_SHORT).show();
                    return;
                }else {
                    Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                    //把数据保存到SharedPreferences里面
                    saveRegisterInfo(username,pwd);
                    //注册成功后通过Intent把用户名传递到LoginActivity.java中
                    Intent data = new Intent();
                    data.putExtra("username",username);
                    setResult(RESULT_OK,data);
                    RegisterActivity.this.finish();

                }
            }
        });
    }

    private void saveRegisterInfo(String username, String pwd) {
        String md5Pwd = MD5Util.MD5(pwd);
        SharedPreferences sp = getSharedPreferences("loginInfo", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(username,md5Pwd);
        editor.commit();
    }

    private boolean isExistUserName(String username) {
        boolean has_userName = false;
        SharedPreferences sp = getSharedPreferences("loginInfo", MODE_PRIVATE);
        String spPwd = sp.getString(username, "");
        if (!TextUtils.isEmpty(spPwd)) {
            has_userName = true;
        }
        return has_userName;
    }
}
