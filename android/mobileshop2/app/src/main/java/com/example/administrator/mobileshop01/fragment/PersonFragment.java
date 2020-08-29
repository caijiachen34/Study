package com.example.administrator.mobileshop01.fragment;

import android.app.Activity;
import android.app.ProgressDialog;
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

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;

import com.example.administrator.mobileshop01.R;
import com.example.administrator.mobileshop01.activity.ChangePWDActivity;
import com.example.administrator.mobileshop01.activity.LoginActivity;
import com.example.administrator.mobileshop01.activity.MainActivity;
import com.example.administrator.mobileshop01.common.ImageLoaderManager;
import com.nostra13.universalimageloader.core.ImageLoader;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


public class PersonFragment extends BaseFragment {
    private static final String TAG = "PersonFragment";
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
    @BindView(R.id.person_header)
    RelativeLayout personHeader;
    @BindView(R.id.my_order_image)
    ImageView myOrderImage;
    @BindView(R.id.my_order_text)
    TextView myOrderText;
    @BindView(R.id.my_order_arrow)
    ImageView myOrderArrow;
    @BindView(R.id.person_my_order)
    RelativeLayout personMyOrder;
    @BindView(R.id.my_collect_image)
    ImageView myCollectImage;
    @BindView(R.id.my_collect_text)
    TextView myCollectText;
    @BindView(R.id.my_collect_arrow)
    ImageView myCollectArrow;
    @BindView(R.id.my_collect)
    RelativeLayout myCollect;
    @BindView(R.id.my_address_image)
    ImageView myAddressImage;
    @BindView(R.id.my_address_text)
    TextView myAddressText;
    @BindView(R.id.my_address_arrow)
    ImageView myAddressArrow;
    @BindView(R.id.my_address)
    RelativeLayout myAddress;
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
    private ProgressDialog progressDialog;
    private final int MY_FAVORITE=1;
    private final int MY_ORDER=2;
    private final int MY_ADDRESS=3;
    private final int MY_ACCOUNT_BEFORE=4;
    private final int MY_ACCOUNT_AFTER=5;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_person, container, false);
        unbinder = ButterKnife.bind(this, view);
        mainActivity= (MainActivity) getActivity();
        return view;
    }

    private void init(){
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("user", 0);
        String username = sharedPreferences.getString("uname", "");
        if (TextUtils.isEmpty(username)) {   //未登录
            personForLogin.setVisibility(View.GONE);
            personForNotLogin.setVisibility(View.VISIBLE);
            personLogoutLayout.setVisibility(View.GONE);
        } else {   //已登录
            personForLogin.setVisibility(View.VISIBLE);
            personForNotLogin.setVisibility(View.GONE);
            personLogoutLayout.setVisibility(View.VISIBLE);
            userName.setText(username);


            String image = sharedPreferences.getString("image", "");
            if (!TextUtils.isEmpty(image)) {
                ImageLoader.getInstance().displayImage(image, userImgView, ImageLoaderManager.user_options);
            }
        }
    }

    @Override
    public void onResume() {
        init();
        super.onResume();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.user_img_view, R.id.layout_name, R.id.name_balance_textview, R.id.person_for_login, R.id.person_login, R.id.person_click_to_login, R.id.person_for_not_login, R.id.person_header, R.id.person_my_order, R.id.my_collect, R.id.my_address, R.id.my_account, R.id.person_logout_layout, R.id.my_order_layout})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.user_img_view:
                break;
            case R.id.layout_name:
                break;
            case R.id.name_balance_textview:
                break;
            case R.id.person_for_login:
                break;
            case R.id.person_login://登录
                startActivity(new Intent(mainActivity, LoginActivity.class));
                break;
            case R.id.person_click_to_login:
                break;
            case R.id.person_for_not_login:
                break;
            case R.id.person_header:
                break;
            case R.id.person_my_order://我的订单
                break;
            case R.id.my_collect://我的收藏
                break;
            case R.id.my_address://收获地址
                break;
            case R.id.my_account://修改密码
                Log.d(TAG, "isLogin: " + mainActivity.isLogin());
                if (mainActivity.isLogin()){
                    startActivityForResult(new Intent(mainActivity, ChangePWDActivity.class),MY_ACCOUNT_AFTER);
                    return;
                }
                startActivityForResult(new Intent(mainActivity,LoginActivity.class),MY_ACCOUNT_BEFORE);
                break;
            case R.id.person_logout_layout://退出登录
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
            case R.id.my_order_layout:
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case MY_ORDER:
                break;
            case MY_FAVORITE:
                break;
            case MY_ADDRESS:
                break;
            case MY_ACCOUNT_BEFORE:
                if (requestCode== Activity.RESULT_OK&&data.getBooleanExtra("logined",false)){
                    Intent intent=new Intent(mainActivity,ChangePWDActivity.class);
                    startActivityForResult(intent,MY_ACCOUNT_AFTER);
                }
        }
    }

    /**
     * 退出登录时，需要将部分信息从presharedpreference数据文件中移除，防止二次进入读取到错误信息
     */
    private void logout(){
        SharedPreferences.Editor spEditor=mainActivity.getSharedPreferences("user",0).edit();
        spEditor.remove("member_id");
        spEditor.remove("uname");
        spEditor.remove("email");
        spEditor.remove("image");
        spEditor.commit();
        init();
        Toast.makeText(mainActivity,"退出登录成功！",Toast.LENGTH_SHORT).show();
    }

}
