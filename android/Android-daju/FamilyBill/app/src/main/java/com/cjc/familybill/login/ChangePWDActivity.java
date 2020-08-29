package com.cjc.familybill.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.cjc.familybill.R;
import com.cjc.familybill.activitys.BaseActivity;
import com.cjc.familybill.entity.HttpResult;
import com.cjc.familybill.entity.MemberEntity;
import com.cjc.familybill.http.ProgressDialogSubscriber;
import com.cjc.familybill.http.presenter.MemberPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by CC
 **/
public class ChangePWDActivity extends BaseActivity {
    private static final String TAG = "ChangePWDActivity";
    @BindView(R.id.title_back)
    ImageView titleBack;
    @BindView(R.id.password_input_oldpass)
    EditText passwordInputOldpass;
    @BindView(R.id.password_input_newpass)
    EditText passwordInputNewpass;
    @BindView(R.id.password_input_repass)
    EditText passwordInputRepass;
    @BindView(R.id.change_button)
    Button changeButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.title_back, R.id.change_button})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
            case R.id.change_button:
                changePassword();
                break;
        }
    }

    private void changePassword() {
        String oldPWD=passwordInputOldpass.getText().toString().trim();
        String newPWD=passwordInputNewpass.getText().toString().trim();
        String newRePWD=passwordInputRepass.getText().toString().trim();
        if (TextUtils.isEmpty(oldPWD) || TextUtils.isEmpty(newPWD) || TextUtils.isEmpty(newRePWD)) {
            Toast.makeText(this, "密码不能为空！", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!newPWD.equals(newRePWD)) {
            Toast.makeText(this, "两次输入的新密码不一致！", Toast.LENGTH_SHORT).show();
            return;
        }
        String member_name = getSharedPreferences("loginInfo", 0).getString("loginUserName", "");

        MemberPresenter.changePassword2(new ProgressDialogSubscriber<HttpResult>(ChangePWDActivity.this) {
            @Override
            public void onNext(HttpResult httpResult) {
                String msg = httpResult.getMsg();
                Log.d(TAG, "msg: " + msg);
                if (httpResult.getMsg().contains("不存在此用户")) {
                    Toast.makeText(ChangePWDActivity.this, "未知错误，请尝试重新登陆", Toast.LENGTH_SHORT).show();
                }else if (httpResult.getMsg().contains("输入的原密码有误")){
                    Toast.makeText(ChangePWDActivity.this, "输入的原密码有误", Toast.LENGTH_SHORT).show();
                }else if (httpResult.getMsg().contains("修改密码成功")){
                    Toast.makeText(ChangePWDActivity.this, "修改密码成功,请重新登录", Toast.LENGTH_SHORT).show();
                    SharedPreferences sp = getSharedPreferences("config", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("USER_PWD","");
                    editor.commit();
                    finish();
                    Intent intent = new Intent(ChangePWDActivity.this,LoginActivity.class);
                    startActivity(intent);
                }
            }
        },member_name,oldPWD,newRePWD);
    }


}
