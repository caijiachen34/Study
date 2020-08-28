package com.cjc.familybill.login;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.cjc.familybill.R;
import com.cjc.familybill.activitys.MainActivity;
import com.cjc.familybill.activitys.MainActivity1;
import com.cjc.familybill.entity.HttpResult;
import com.cjc.familybill.http.ProgressDialogSubscriber;
import com.cjc.familybill.http.loginutils.LoginUtils;
import com.cjc.familybill.http.presenter.MemberPresenter;
import com.cjc.familybill.utils.MD5Util;

/**
 * Created by CC
 **/
public class LoginActivity extends Activity {

    private TextView tv_go2register; //点击注册
    private Button btn_login; //登录按钮
    private EditText et_user_name, et_user_pwd; //用户名密码控件
    private String username, pwd, spPwd; //用户名密码控件的获取值
    private CheckBox cb_remember_me; //记住密码
    private TextView tv_main_title;
    private RelativeLayout rl_title_bar;
    private TextView tv_back;
    private static String mUsername;
    private boolean IsChecked = false;
    private SharedPreferences sps;
    private final String USER_NAME = "USER_NAME";
    private final String USER_PWD = "USER_PWD";
    private final String IS_CHECKED = "IS_CHECKED";

    private LoginUtils loginUtils;
    private static final String TAG = "LoginActivity";

    //请求码
    private final int REQUEST_CODE_REGISTER = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_login);
        //loginUtils = new LoginUtils();
        IsChecked = loadStatus();
        init();
        initData();
        initListener();

    }

    private void init() {
        //监听
        tv_go2register = findViewById(R.id.tv_go2register);
        btn_login = findViewById(R.id.btn_login);
        et_user_name = findViewById(R.id.et_user_name_login);
        et_user_pwd = findViewById(R.id.et_user_pwd_login);
        cb_remember_me = findViewById(R.id.cb_remember_me);

        //title赋值
        tv_main_title = findViewById(R.id.tv_main_title);
        tv_main_title.setText("登录");
        //设置背景透明
        rl_title_bar = findViewById(R.id.title_bar);
        rl_title_bar.setBackgroundColor(Color.TRANSPARENT);
        //顶部
        tv_back = findViewById(R.id.tv_back);
        tv_back.setVisibility(View.GONE);

    }


    private void initListener() {
        //立即注册的点击事件
        tv_go2register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivityForResult(intent, REQUEST_CODE_REGISTER);
            }
        });

        //登录按钮点击事件
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handlerLogin();
            }


        });


        //记住账户
        //1.记住用户名
        et_user_name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            //文本改变之后记住账号
            @Override
            public void afterTextChanged(Editable s) {
                if (IsChecked) {
                    if (sps == null) {
                        //获取config文件
                        sps=getApplicationContext().getSharedPreferences("config", Context.MODE_PRIVATE);
                    }
                    //实例化SharedPreferences的编辑者对象
                    SharedPreferences.Editor editor = sps.edit();
                    //存储用户名数据
                    editor.putString(USER_NAME, et_user_name.getText().toString().trim());
                    editor.commit();
                }
            }
        });

        //2.记住密码
        et_user_pwd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            //文本改变后记住密码
            @Override
            public void afterTextChanged(Editable s) {
                if (IsChecked) {
                    if (sps == null) {
                        sps = getApplication().getSharedPreferences("config", Context.MODE_PRIVATE);
                    }

                    //实例化SharedPreferences的编辑者对象
                    SharedPreferences.Editor editor = sps.edit();
                    //存储用户名数据
                    editor.putString(USER_PWD, et_user_pwd.getText().toString());
                    editor.commit();
                }
            }
        });

        //3.监听记住密码按钮
        cb_remember_me.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                IsChecked = isChecked;
                    if (isChecked) {
                    if (sps == null) {
                        sps = getApplicationContext().getSharedPreferences("config", Context.MODE_PRIVATE);
                    }
                    //实例化编辑对象
                    SharedPreferences.Editor editor = sps.edit();
                    //存储数据
                    editor.putString(USER_NAME, et_user_name.getText().toString().trim());
                    editor.putString(USER_PWD, et_user_pwd.getText().toString().trim());
                    //记住密码，下次读取
                    editor.putBoolean(IS_CHECKED, isChecked);
                    //Toast.makeText(LoginActivity.this,"记住密码",Toast.LENGTH_SHORT).show();
                    editor.commit();
                } else {
                    //取消记住密码
                    SharedPreferences.Editor editor = sps.edit();
                    //存储数据
                    editor.putString(USER_NAME, null);
                    editor.putString(USER_PWD, null);
                    //记住密码状态
                    editor.putBoolean(IS_CHECKED, isChecked);
                    //Toast.makeText(LoginActivity.this,"取消记住密码",Toast.LENGTH_SHORT).show();
                    editor.commit();
                }
            }
        });
    }

    private void saveLoginStatus(boolean status, String username) {
        this.mUsername = username;
        //loginInfo表示文件名
        SharedPreferences sp = getSharedPreferences("loginInfo", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean("isLogin", status);
        editor.putString("loginUserName", username);
        editor.commit();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode== REQUEST_CODE_REGISTER) {
            if (data != null) {
                //接收注册界面传过来的用户名
                String username = data.getStringExtra("username");
                if (!TextUtils.isEmpty(username)) {
                    et_user_name.setText(username);
                    et_user_pwd.setText("");
                    //设置光标的位置
                    et_user_name.setSelection(username.length());
                }
            }
        }

    }

    private void initData() {
        if (sps == null) {
            sps = getApplicationContext().getSharedPreferences("config", Context.MODE_PRIVATE);
        }
        et_user_name.setText(sps.getString(USER_NAME, ""));
        et_user_pwd.setText(sps.getString(USER_PWD, ""));
        IsChecked = sps.getBoolean(IS_CHECKED, false);
        cb_remember_me.setChecked(IsChecked);
    }

    public static String getmUserName() {
        return mUsername;
    }

    private String readPwd(String username) {
        SharedPreferences sp = getSharedPreferences("loginInfo", MODE_PRIVATE);
        String pwd = sp.getString(username, "");
        return pwd;
    }

    private boolean loadStatus() {
        SharedPreferences sp = getSharedPreferences("config", MODE_PRIVATE);
        boolean status = sp.getBoolean(IS_CHECKED, false);
        return status;
    }

    private void handlerLogin() {
        String md5Pwd;
        username = et_user_name.getText().toString().trim();
        pwd = et_user_pwd.getText().toString().trim();
        md5Pwd = MD5Util.MD5(pwd);
        spPwd = readPwd(username);

        //判空
        if (TextUtils.isEmpty(username)) {
            Toast.makeText(LoginActivity.this, "请输入用户名", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(pwd)) {
            Toast.makeText(LoginActivity.this, "请输入密码", Toast.LENGTH_SHORT).show();
            return;
        }

        MemberPresenter.login(new ProgressDialogSubscriber<HttpResult>(this) {

            @Override
            public void onNext(HttpResult httpResult) {
//                if (username.equals(memberEntity.getUname())) {
//                    Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
//                    //把登录状态和登录的用户名保存到SharedPreferences里面
//                    saveLoginStatus(true, username);
//                    //登录成功后通过Intent把登录成功的状态传递到MainActivity.java中
//                    Intent data = new Intent();
//                    data.putExtra("isLogin", true);
//                    setResult(RESULT_OK, data); //setResult为OK，关闭当前页面
//                    LoginActivity.this.finish();
//                    //登录成功跳转
//                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
//                    return;
//                }

                String msg = httpResult.getMsg();
                if (msg.contains("此用户不存在")) {
                    Toast.makeText(LoginActivity.this, "用户名不存在", Toast.LENGTH_SHORT).show();
                    return;
                }else if (msg.contains("密码错误")){
                    Toast.makeText(LoginActivity.this, "密码错误", Toast.LENGTH_SHORT).show();
                    return;
                }else {
                        Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                        //把登录状态和登录的用户名保存到SharedPreferences里面
                        saveLoginStatus(true, username);
                        //登录成功后通过Intent把登录成功的状态传递到MainActivity.java中
                        Intent data = new Intent();
                        data.putExtra("isLogin", true);
                        setResult(RESULT_OK, data); //setResult为OK，关闭当前页面
                        LoginActivity.this.finish();
                        //登录成功跳转
                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                }


            }
        }, username, pwd);


//        if (md5Pwd.equals(spPwd)){
//                    Toast.makeText(LoginActivity.this,"登录成功",Toast.LENGTH_SHORT).show();
//                    //把登录状态和登录的用户名保存到SharedPreferences里面
//                    saveLoginStatus(true,username);
//                    //登录成功后通过Intent把登录成功的状态传递到MainActivity.java中
//                    Intent data = new Intent();
//                    data.putExtra("isLogin",true);
//                    setResult(RESULT_OK,data); //setResult为OK，关闭当前页面
//                    LoginActivity.this.finish();
//                    //登录成功跳转
//                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
//                    return;
//        }else if ((!TextUtils.isEmpty(spPwd)&& !md5Pwd.equals(spPwd))){
//            Toast.makeText(LoginActivity.this,"用户名或密码错误",Toast.LENGTH_SHORT).show();
//            return;
//        }else {
//            Toast.makeText(LoginActivity.this,"此用户不存在",Toast.LENGTH_SHORT).show();
//        }
    }

}
