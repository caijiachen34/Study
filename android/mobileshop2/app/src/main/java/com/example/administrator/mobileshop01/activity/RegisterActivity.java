package com.example.administrator.mobileshop01.activity;

import android.content.Intent;
import android.content.SharedPreferences;
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
import com.example.administrator.mobileshop01.entity.MemberEntity;
import com.example.administrator.mobileshop01.http.ProgressDialogSubscriber;
import com.example.administrator.mobileshop01.http.presenter.MemberPresenter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class RegisterActivity extends BaseActivity {
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
    @BindView(R.id.login_divider_line0)
    View loginDividerLine0;
    @BindView(R.id.login_input_email)
    TextView login_input_email;
    @BindView(R.id.login_page_input_email_layout)
    RelativeLayout loginPageInputEmailLayout;
    @BindView(R.id.login_divider_line)
    View loginDividerLine;
    @BindView(R.id.login_page_input_password)
    TextView loginPageInputPassword;
    @BindView(R.id.login_input_password)
    EditText loginInputPassword;
    @BindView(R.id.login_page_input_password_layout)
    RelativeLayout loginPageInputPasswordLayout;
    @BindView(R.id.login_divider_line1)
    View loginDividerLine1;
    @BindView(R.id.login_page_input_repassword)
    TextView loginPageInputRepassword;
    @BindView(R.id.login_input_repassword)
    EditText loginInputRepassword;
    @BindView(R.id.login_page_input_repassword_layout)
    RelativeLayout loginPageInputRepasswordLayout;
    @BindView(R.id.login_divider_verification_line)
    View loginDividerVerificationLine;
    @BindView(R.id.login_editor_layout)
    RelativeLayout loginEditorLayout;
    @BindView(R.id.register_button)
    Button registerButton;
    @BindView(R.id.login_relative)
    RelativeLayout loginRelative;
    @BindView(R.id.login_scroller)
    ScrollView loginScroller;
    @BindView(R.id.login_layout)
    RelativeLayout loginLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.title_back, R.id.register_button})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
            case R.id.register_button:
                register();
                break;
        }
    }
    private void register(){
        String username=loginInputName.getText().toString().trim();
        String email=login_input_email.getText().toString().trim();
        String password=loginInputPassword.getText().toString().trim();
        String rePassword=loginInputRepassword.getText().toString().trim();
        checkUserName(username);
        checkEmail(email);
        checkPWD(password,rePassword);
        //参数传递根据实际情况，传入对应参数。这三个参数都是字符串类型的，如果顺序错了，注册也会出问题
        MemberPresenter.register(new ProgressDialogSubscriber<MemberEntity>(this) {
            @Override
            public void onNext(MemberEntity memberEntity) {
                Toast.makeText(RegisterActivity.this, "注册成功！", Toast.LENGTH_SHORT).show();
                SharedPreferences.Editor loacleditor = getSharedPreferences("user", 0).edit();
                loacleditor.putInt("member_id", memberEntity.getMember_id());
                loacleditor.putString("uname", memberEntity.getUname());
                loacleditor.putString("email", memberEntity.getEmail());
                loacleditor.putString("image", memberEntity.getImage());
                loacleditor.commit();
                //返回之前页面并传回数据
                Intent returnIntent = new Intent();
                returnIntent.putExtra("logined", true);
                setResult(RESULT_OK, returnIntent);
                finish();
            }
        },username,password,email);
    }


    //用户名验证
    private void checkUserName(String username){
        if(TextUtils.isEmpty(username)){
            Toast.makeText(RegisterActivity.this,"用户名不能为空",Toast.LENGTH_SHORT).show();
            return;
        }
        if(username.length()<=4||username.length()>20){
            Toast.makeText(RegisterActivity.this,"用户名长度为4-20位",Toast.LENGTH_SHORT).show();
            return;
        }
        if(username.contains("@")){
            Toast.makeText(this,"用户名不能包含@等特殊字符",Toast.LENGTH_SHORT).show();
            return;
        }
    }

    //验证邮箱
    private void checkEmail(String email) {
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(RegisterActivity.this, "邮箱不能为空！", Toast.LENGTH_SHORT).show();
            return;
        }
        Pattern p = Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");
        Matcher m = p.matcher(email);
        if (!m.matches()) {
            Toast.makeText(RegisterActivity.this, "邮箱格式不正确！", Toast.LENGTH_SHORT).show();
            return;
        }
    }

    //验证密码
    private void checkPWD(String password, String repassword) {
        if (TextUtils.isEmpty(repassword)) {
            Toast.makeText(RegisterActivity.this, "密码不能为空！", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!password.equals(repassword)) {
            Toast.makeText(RegisterActivity.this, "两次输入密码不一致!", Toast.LENGTH_LONG).show();
            return;
        }
    }
}
