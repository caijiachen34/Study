package com.cjc.familybill.login;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.cjc.familybill.R;
import com.cjc.familybill.entity.HttpResult;
import com.cjc.familybill.entity.MemberEntity;
import com.cjc.familybill.http.ProgressDialogSubscriber;
import com.cjc.familybill.http.presenter.MemberPresenter;
import com.cjc.familybill.utils.MD5Util;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by CC
 **/
public class RegisterActivity extends Activity {

    private static final String TAG = "RegisterActivity";
    private TextView tv_main_title;
    private RelativeLayout rl_title_bar;
    private TextView tv_back;
    private Button btn_register;
    private EditText et_user_name;
    private EditText et_user_pwd;
    private EditText et_user_pwd_again;
    private EditText et_user_email;
    private EditText et_user_mobile;
    private String username, pwd, pwd_again, email, mobile;
    private String http_username = null;
    private String http_email = null;
    private String http_mobile = null;

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
        et_user_email = findViewById(R.id.et_user_email);
        et_user_mobile = findViewById(R.id.et_user_mobile);

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
                email = et_user_email.getText().toString().trim();
                mobile = et_user_mobile.getText().toString().trim();

                //用户名检查
                if (TextUtils.isEmpty(username)) {
                    Toast.makeText(RegisterActivity.this, "用户名不能为空", Toast.LENGTH_SHORT).show();
                    return;
                } else if (username.length() < 4 || username.length() > 20) {
                    Toast.makeText(RegisterActivity.this, "用户名长度为4-20位", Toast.LENGTH_SHORT).show();
                    return;
                } else if (username.contains("@")) {
                    Toast.makeText(RegisterActivity.this, "用户名不能包含@等特殊字符", Toast.LENGTH_SHORT).show();
                    return;
                }

                //密码检查
                if (TextUtils.isEmpty(pwd)) {
                    Toast.makeText(RegisterActivity.this, "密码不能为空！", Toast.LENGTH_SHORT).show();
                    return;
                } else if (!pwd.equals(pwd_again)) {
                    Toast.makeText(RegisterActivity.this, "两次输入密码不一致!", Toast.LENGTH_LONG).show();
                    return;
                }

                //邮箱检查
                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(RegisterActivity.this, "邮箱不能为空！", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    Pattern p = Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");
                    Matcher m = p.matcher(email);
                    if (!m.matches()) {
                        Toast.makeText(RegisterActivity.this, "邮箱格式不正确！", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }

                //手机号检查
                if (TextUtils.isEmpty(mobile)) {
                    Toast.makeText(RegisterActivity.this, "手机号不能为空！", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    Pattern p = Pattern.compile("^[1](([3][0-9])|([4][5,7,9])|([5][0-9])|([6][6])|([7][3,5,6,7,8])|([8][0-9])|([9][8,9]))[0-9]{8}$");
                    Matcher m = p.matcher(mobile);
                    if (!m.matches()) {
                        Toast.makeText(RegisterActivity.this, "手机格式不正确！", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }


                //checkUserName(username);
                //checkEmail(email);
                //checkPWD(pwd,pwd_again);
                //checkMobile(mobile);
                handlerRegister();


            }
        });
    }

    private void checkMobile(String mobile) {
        if (TextUtils.isEmpty(mobile)) {
            Toast.makeText(RegisterActivity.this, "手机号不能为空！", Toast.LENGTH_SHORT).show();
            return;
        }
        Pattern p = Pattern.compile("^[1](([3][0-9])|([4][5,7,9])|([5][0-9])|([6][6])|([7][3,5,6,7,8])|([8][0-9])|([9][8,9]))[0-9]{8}$");
        Matcher m = p.matcher(mobile);
        if (!m.matches()) {
            Toast.makeText(RegisterActivity.this, "手机格式不正确！", Toast.LENGTH_SHORT).show();
            return;
        }
    }

    private void checkPWD(String pwd, String pwd_again) {
        if (TextUtils.isEmpty(pwd)) {
            Toast.makeText(RegisterActivity.this, "密码不能为空！", Toast.LENGTH_SHORT).show();
            return;
        } else if (!pwd.equals(pwd_again)) {
            Toast.makeText(RegisterActivity.this, "两次输入密码不一致!", Toast.LENGTH_LONG).show();
            return;
        }
    }

    private void checkEmail(String email) {
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(RegisterActivity.this, "邮箱不能为空！", Toast.LENGTH_SHORT).show();
            return;
        } else {
            Pattern p = Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");
            Matcher m = p.matcher(email);
            if (!m.matches()) {
                Toast.makeText(RegisterActivity.this, "邮箱格式不正确！", Toast.LENGTH_SHORT).show();
                return;
            }
        }
    }

    private void checkUserName(String username) {

    }


    private void handlerRegister() {

        MemberPresenter.register(new ProgressDialogSubscriber<HttpResult>(this) {
            @Override
            public void onNext(HttpResult memberEntity) {
                String msg = memberEntity.getMsg();
                Log.d(TAG, "onNext: " + msg);
                if (msg.contains("此用户已存在")) {
                    Toast.makeText(RegisterActivity.this, "用户名已使用", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (msg.contains("此邮箱已存在")) {
                    Toast.makeText(RegisterActivity.this, "邮箱已使用", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (msg.contains("此手机号已存在")) {
                    Toast.makeText(RegisterActivity.this, "手机号已使用", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    //Log.d(TAG, "onNext: " + memberEntity.getData().getUname());
                    Log.d(TAG, "onNext: 注册成功");
                    Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                    saveRegisterInfo(username, pwd);
                    //注册成功后通过Intent把用户名传递到LoginActivity.java中
                    Intent data = new Intent();
                    data.putExtra("username", username);
                    setResult(1, data);//setResult为OK，关闭当前页面
                    RegisterActivity.this.finish();//在登录的时候，如果用户还没有注册则注册。注册成功后把注册成功后的用户名返回给前一个页面
                }

            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG, "===============onError====" + e.getMessage());
                if (e instanceof SocketTimeoutException) {
                    Toast.makeText(RegisterActivity.this, "网络中断，请检查你的网络状态", Toast.LENGTH_SHORT).show();
                } else if (e instanceof ConnectException) {
                    Toast.makeText(RegisterActivity.this, "网络中断，请检查你的网络状态", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(RegisterActivity.this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
                    Log.v("=====", "error:===" + e.getMessage());
                }

            }
        }, username, pwd_again, email, mobile);

    }


    private void getHttpUserInfo() {
        MemberPresenter.check(new ProgressDialogSubscriber<MemberEntity>(this) {
            @Override
            public void onNext(MemberEntity memberEntity) {
                http_username = memberEntity.getUname();
            }
        }, username);
    }

    private void getHttpEmailInfo() {
        MemberPresenter.check(new ProgressDialogSubscriber<MemberEntity>(this) {
            @Override
            public void onNext(MemberEntity memberEntity) {
                http_email = memberEntity.getEmail();
            }
        }, email);
    }

    private void getHttpMobileInfo() {
        MemberPresenter.check(new ProgressDialogSubscriber<MemberEntity>(this) {
            @Override
            public void onNext(MemberEntity memberEntity) {
                http_mobile = memberEntity.getMobile();
            }
        }, mobile);
    }


    private void saveRegisterInfo(String username, String pwd) {
        String md5Pwd = MD5Util.MD5(pwd);
        SharedPreferences sp = getSharedPreferences("loginInfo", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(username, md5Pwd);
        editor.commit();
    }

//    private boolean isExistUserName(String username) {
//        boolean has_userName = false;
//        SharedPreferences sp = getSharedPreferences("loginInfo", MODE_PRIVATE);
//        String spPwd = sp.getString(username, "");
//        if (!TextUtils.isEmpty(spPwd)) {
//            has_userName = true;
//        }
//        return has_userName;
//    }
}
