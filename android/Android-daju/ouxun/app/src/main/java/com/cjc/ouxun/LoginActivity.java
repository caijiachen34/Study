package com.cjc.ouxun;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.cjc.ouxun.entity.HttpResult;
import com.cjc.ouxun.entity.UserEntity;
import com.cjc.ouxun.http.presenter.UserPresenter;
import com.cjc.ouxun.utils.Constants;

import cn.qqtheme.framework.picker.OptionPicker;
import cn.qqtheme.framework.widget.WheelView;
import rx.Subscriber;

/**
 * Created by CC
 **/
public class LoginActivity extends Activity {


    private static final String TAG = "LoginActivity";

    private EditText select_guest;
    private Button btn_login;
    private TextView et_username;
    private TextView et_password;

    private String username;
    private String password;
    private ImageView iv_visible;
    private ImageView iv_gone;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initData();
        initListener();

    }

    private void initData() {
        et_username = findViewById(R.id.et_username);
        et_password = findViewById(R.id.et_password);
        select_guest = findViewById(R.id.et_select_guest);
        btn_login = findViewById(R.id.btn_login);
        iv_visible = findViewById(R.id.iv_visible);
        iv_gone = findViewById(R.id.iv_gone);
    }

    private void initListener() {
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handlerLogin();
            }
        });

        select_guest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPicker();
                Log.d(TAG, "onClick: ");
            }
        });

        iv_gone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv_gone.setVisibility(View.GONE);
                iv_visible.setVisibility(View.VISIBLE);
                et_password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            }
        });

        iv_visible.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv_visible.setVisibility(View.GONE);
                iv_gone.setVisibility(View.VISIBLE);
                et_password.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
        });
    }

    private void handlerLogin() {
        username = et_username.getText().toString().trim();
        password = et_password.getText().toString().trim();

        if (TextUtils.isEmpty(username)) {
            Toast.makeText(getApplicationContext(), "请输入账号", Toast.LENGTH_SHORT).show();
            return;
        } else if (TextUtils.isEmpty(password)) {
            Toast.makeText(getApplicationContext(), "请输入密码", Toast.LENGTH_SHORT).show();
            return;
        } else {
            UserPresenter.login(new Subscriber<UserEntity>() {
                @Override
                public void onCompleted() {

                }

                @Override
                public void onError(Throwable e) {
                    Log.d(TAG, "onError: ");
                }

                @Override
                public void onNext(UserEntity userEntity) {
                    String username = userEntity.getUsername();
                    Log.d(TAG, "userEntity: " + username);
                    int id = userEntity.getId();
                    SharedPreferences loginInfo = getSharedPreferences("LoginInfo", MODE_PRIVATE);
                    SharedPreferences.Editor editor = loginInfo.edit();
                    editor.putString("username",username);
                    editor.putInt("id",id);
                    editor.commit();
                }
            }, username, password);
        }

    }

    private void onPicker() {
        OptionPicker picker = new OptionPicker(this, Constants.personType);
        picker.setCycleDisable(true);
        picker.setTopBackgroundColor(0xFFEEEEEE);
        picker.setTopHeight(40);
        picker.setTopLineColor(0xff00574B);
        picker.setTopLineHeight(1);
        picker.setTitleText("请选择");
        picker.setTitleTextColor(Color.parseColor("#3366FF"));
        picker.setTitleTextSize(15);
        picker.setCancelTextColor(Color.parseColor("#3366FF"));
        picker.setCancelTextSize(16);
        picker.setSubmitTextColor(Color.parseColor("#3366FF"));
        picker.setSubmitTextSize(16);
        picker.setTextColor(Color.parseColor("#3366FF"), 0xFF999999);
        picker.setTextSize(20);
        WheelView.DividerConfig config = new WheelView.DividerConfig();
        config.setColor(0xff00574B);
        config.setAlpha(140);
        config.setRatio((float) (1.0 / 8.0));
        picker.setDividerConfig(config);
        picker.setBackgroundColor(0xFFE1E1E1);
        picker.setSelectedIndex(7);
        picker.setCanceledOnTouchOutside(true);
        picker.setOnOptionPickListener(new OptionPicker.OnOptionPickListener() {
            @Override
            public void onOptionPicked(int index, String item) {
                select_guest.setText(item);
                Constants.current_crop_id = index;
            }
        });
        picker.show();
    }
}
