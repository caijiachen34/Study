package com.example.administrator.mobileshop01.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.administrator.mobileshop01.R;
import com.example.administrator.mobileshop01.entity.MemberEntity;
import com.example.administrator.mobileshop01.http.ProgressDialogSubscriber;
import com.example.administrator.mobileshop01.http.presenter.MemberPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class LoginActivity extends BaseActivity {
    @BindView(R.id.title_back)
    ImageView titleBack;
    @BindView(R.id.titleText)
    TextView titleText;
    @BindView(R.id.common_title)
    RelativeLayout commonTitle;
    @BindView(R.id.login_page_input_name)
    TextView loginPageInputName;
    @BindView(R.id.login_input_name)
    EditText loginInputName;
    @BindView(R.id.login_page_input_name_layout)
    RelativeLayout loginPageInputNameLayout;
    @BindView(R.id.login_divider_line)
    View loginDividerLine;
    @BindView(R.id.login_page_input_password)
    TextView loginPageInputPassword;
    @BindView(R.id.login_input_password)
    EditText loginInputPassword;
    @BindView(R.id.login_page_input_password_layout)
    RelativeLayout loginPageInputPasswordLayout;
    @BindView(R.id.login_divider_verification_line)
    View loginDividerVerificationLine;
    @BindView(R.id.login_editor_layout)
    RelativeLayout loginEditorLayout;
    @BindView(R.id.login_button)
    Button loginButton;
    @BindView(R.id.register_link)
    TextView registerLink;
    @BindView(R.id.find_password_text)
    TextView findPasswordText;
    @BindView(R.id.login_page_find_and_vion)
    RelativeLayout loginPageFindAndVion;
    @BindView(R.id.login_relative)
    RelativeLayout loginRelative;
    @BindView(R.id.login_scroller)
    ScrollView loginScroller;
    @BindView(R.id.login_layout)
    LinearLayout loginLayout;

    private final int REQUEST_CODE_REGISTER=1;//快速注册状态号

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.title_back, R.id.login_button, R.id.register_link, R.id.find_password_text})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
            case R.id.login_button:
                login();
                break;
            case R.id.find_password_text:
                startActivity(new Intent(this,FindPWDActivity.class));
                break;
            case R.id.register_link:
                startActivityForResult(new Intent(this,RegisterActivity.class),REQUEST_CODE_REGISTER);//带回调的intent
                break;
        }
    }


    private void login(){
        //获取输入框的用户名密码数据，去掉空格
        final String username=loginInputName.getText().toString().trim();
        final String password=loginInputPassword.getText().toString().trim();

        /**
         * 进行本地判断，用户名密码是否符合规则
         */
        if(TextUtils.isEmpty(username)){
            Toast.makeText(this,"用户名不能为空",Toast.LENGTH_SHORT).show();
            return;
        }

        if(TextUtils.isEmpty(password)){
            Toast.makeText(this,"密码不能为空",Toast.LENGTH_SHORT).show();
            return;
        }
        /**
         * 通过我们之前的用户请求方法获取登录返回信息
         */
        MemberPresenter.login(new ProgressDialogSubscriber<MemberEntity>(this) {
            @Override
            public void onNext(MemberEntity memberEntity) {
                Toast.makeText(LoginActivity.this,"登录成功",Toast.LENGTH_SHORT).show();
                //使用sharedpreference在登录成功后保存部分数据
                SharedPreferences.Editor spEditor=getSharedPreferences("user",0).edit();
                spEditor.putInt("member_id",memberEntity.getMember_id());
                spEditor.putString("uname",memberEntity.getUname());
                spEditor.putString("email",memberEntity.getEmail());
                spEditor.putString("image",memberEntity.getImage());
                spEditor.commit();
                //返回之前的Activity，并返回数据
                goToActivity();
            }
        },username,password);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode== Activity.RESULT_OK&&requestCode==REQUEST_CODE_REGISTER){
            goToActivity();
        }
    }

    private void goToActivity(){
        Intent intent=new Intent();
        intent.putExtra("logined",true);
        setResult(AppCompatActivity.RESULT_OK,intent);
        finish();
    }
}
