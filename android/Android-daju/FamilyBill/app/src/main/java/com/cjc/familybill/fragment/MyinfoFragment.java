package com.cjc.familybill.fragment;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.cjc.familybill.R;
import com.cjc.familybill.activitys.MainActivity;
import com.cjc.familybill.login.ChangePWDActivity;
import com.cjc.familybill.login.LoginActivity;
import com.nostra13.universalimageloader.core.ImageLoader;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by CC
 **/
public class MyinfoFragment extends BaseFragment {


    private static final String TAG = "MyinfoFragment";
    @BindView(R.id.person_title)
    FrameLayout personTitle;
    @BindView(R.id.user_img_view)
    ImageView userImgView;
    @BindView(R.id.user_name)
    TextView userName;
    @BindView(R.id.layout_name)
    LinearLayout layoutName;
    @BindView(R.id.user_level)
    TextView userLevel;
    @BindView(R.id.name_balance_textview)
    RelativeLayout nameBalanceTextview;
    @BindView(R.id.person_for_login)
    RelativeLayout personForLogin;
    @BindView(R.id.person_for_wellcome)
    TextView personForWellcome;
    @BindView(R.id.person_login)
    Button personLogin;
    @BindView(R.id.person_click_to_login)
    LinearLayout personClickToLogin;
    @BindView(R.id.person_for_not_login)
    RelativeLayout personForNotLogin;
    @BindView(R.id.my_account_image)
    ImageView myAccountImage;
    @BindView(R.id.my_account_text)
    TextView myAccountText;
    @BindView(R.id.my_account_arrow)
    ImageView myAccountArrow;
    @BindView(R.id.my_account)
    RelativeLayout myAccount;
    @BindView(R.id.person_logout_layout)
    RelativeLayout personLogoutLayout;
    @BindView(R.id.my_order_layout)
    LinearLayout myOrderLayout;
    Unbinder unbinder;

    private MainActivity mainActivity;

    private final int MY_ACCOUNT_BEFORE = 4;
    private final int MY_ACCOUNT_AFTER = 5;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_myinfo, container, false);
        unbinder = ButterKnife.bind(this, view);
        mainActivity = (MainActivity) getActivity();
        return view;
    }

    private void init() {
        SharedPreferences sp = getActivity().getSharedPreferences("loginInfo", MODE_PRIVATE);
        String username = sp.getString("loginUserName", "");
        if (TextUtils.isEmpty(username)) {
            personForLogin.setVisibility(View.GONE);
            personForNotLogin.setVisibility(View.VISIBLE);
            personLogoutLayout.setVisibility(View.GONE);
        } else {
            personForLogin.setVisibility(View.VISIBLE);
            personForNotLogin.setVisibility(View.GONE);
            personLogoutLayout.setVisibility(View.VISIBLE);
            userName.setText("你好," + username);

        }
    }

    @Override
    public void onResume() {
        init();
        super.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    @OnClick({R.id.user_img_view, R.id.layout_name, R.id.name_balance_textview, R.id.person_for_login, R.id.person_login, R.id.person_click_to_login, R.id.person_for_not_login, R.id.my_account, R.id.person_logout_layout, R.id.my_order_layout})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.person_login:
                Log.d(TAG, "进入登录界面");
                startActivity(new Intent(mainActivity, LoginActivity.class));
                break;
            case R.id.my_account:
                if (mainActivity.isLogin()) {
                    startActivityForResult(new Intent(mainActivity, ChangePWDActivity.class), MY_ACCOUNT_AFTER);
                    return;
                }
                startActivityForResult(new Intent(mainActivity, LoginActivity.class), MY_ACCOUNT_BEFORE);
                break;
            case R.id.person_logout_layout:
                new AlertDialog.Builder(mainActivity)
                        .setTitle("退出登录")
                        .setMessage("您确认要退出登录吗？")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                logout();
                            }
                        })
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).create().show();
                break;
        }
    }
    /**
     * 退出登录时，需要将部分信息从presharedpreference数据文件中移除，防止二次进入读取到错误信息
     */
    private void logout(){
        SharedPreferences.Editor spEditor=mainActivity.getSharedPreferences("loginInfo",0).edit();
        spEditor.remove("loginUserName");
        spEditor.remove("isLogin");
//        spEditor.remove("email");
//        spEditor.remove("image");
        spEditor.commit();
        init();
        Toast.makeText(mainActivity,"退出登录成功！",Toast.LENGTH_SHORT).show();
    }
}
