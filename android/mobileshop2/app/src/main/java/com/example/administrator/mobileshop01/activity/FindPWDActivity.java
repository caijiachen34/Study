package com.example.administrator.mobileshop01.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.mobileshop01.R;
import com.example.administrator.mobileshop01.entity.HttpResult;
import com.example.administrator.mobileshop01.http.ProgressDialogSubscriber;
import com.example.administrator.mobileshop01.http.presenter.MemberPresenter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FindPWDActivity extends BaseActivity {
    @BindView(R.id.title_back)
    ImageView titleBack;
    @BindView(R.id.titleText)
    TextView titleText;
    @BindView(R.id.common_title)
    RelativeLayout commonTitle;
    @BindView(R.id.et_email)
    EditText etEmail;
    @BindView(R.id.find_password_layout)
    RelativeLayout findPasswordLayout;
    @BindView(R.id.login_button)
    Button loginButton;
    @BindView(R.id.login_relative)
    RelativeLayout loginRelative;
    @BindView(R.id.login_scroller)
    ScrollView loginScroller;
    @BindView(R.id.login_layout)
    RelativeLayout loginLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_pwd);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.title_back, R.id.login_button})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
            case R.id.login_button:
                changePassword();
                break;
        }
    }

    private void changePassword(){
        String email=etEmail.getText().toString().trim();
        if(TextUtils.isEmpty(email)){
            Toast.makeText(this,"邮箱不能为空",Toast.LENGTH_SHORT).show();
            return;
        }
        Pattern p = Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");
        Matcher m = p.matcher(email);
        if (!m.matches()) {
            Toast.makeText(FindPWDActivity.this, "邮箱格式不正确！", Toast.LENGTH_SHORT).show();
            return;
        }
        //联网请求
        MemberPresenter.findPassword(new ProgressDialogSubscriber<HttpResult>(this) {
            @Override
            public void onNext(HttpResult httpResult) {
                if (httpResult.getStatus() == 0) {
                    Toast.makeText(FindPWDActivity.this, "操作成功，请登录注册邮箱使用新的密码进行登录", Toast.LENGTH_LONG).show();
                    //重新登录
                    startActivity(new Intent(FindPWDActivity.this, LoginActivity.class));
                    finish();
                } else {
                    Toast.makeText(FindPWDActivity.this, httpResult.getMsg(), Toast.LENGTH_LONG).show();
                }
            }
        },email);
    }
}
