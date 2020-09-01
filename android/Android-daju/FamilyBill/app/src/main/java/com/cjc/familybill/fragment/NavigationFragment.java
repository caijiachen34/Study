package com.cjc.familybill.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.cjc.familybill.R;
import com.cjc.familybill.activitys.MainActivity;
import com.cjc.familybill.login.LoginActivity;

/**
 * Created by CC
 **/
public class NavigationFragment extends BaseFragment implements View.OnClickListener {

    private static final String TAG = "NavigationFragment";
    private RelativeLayout tabItemAccount;
    private RelativeLayout tabItemAssets;
    private RelativeLayout tabItemChart;
    private RelativeLayout tabItemMyinfo;

    private ImageView tabItemAccountBtn;
    private ImageView tabItemAssetsBtn;
    private ImageView tabItemChartBtn;
    private ImageView tabItemMyinfoBtn;

    private AccountFragment accountFragment;
    private AssetsFragment assetsFragment;
    private ChartFragment chartFragment;
    private MyinfoFragment myinfoFragment;

    private FragmentManager fragmentManager;
    public int currentId;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_nagition, null);
        initViews(view);
        setTabSelection(R.id.bottom_bar_account_btn);
        return view;
    }

    private void initViews(View view) {
        tabItemAccount = view.findViewById(R.id.bottom_bar_account_btn);
        tabItemAccount.setOnClickListener(this);

        tabItemAssets = view.findViewById(R.id.bottom_bar_assets_btn);
        tabItemAssets.setOnClickListener(this);

        tabItemChart = view.findViewById(R.id.bottom_bar_chart_btn);
        tabItemChart.setOnClickListener(this);

        tabItemMyinfo = view.findViewById(R.id.bottom_bar_myinfo_btn);
        tabItemMyinfo.setOnClickListener(this);

        tabItemAccountBtn = view.findViewById(R.id.bottom_bar_image_account);
        tabItemAssetsBtn = view.findViewById(R.id.bottom_bar_image_assets);
        tabItemChartBtn = view.findViewById(R.id.bottom_bar_image_chart);
        tabItemMyinfoBtn = view.findViewById(R.id.bottom_bar_image_myinfo);

        fragmentManager = getFragmentManager();
    }

    public void setTabSelection(int id) {
        tabItemAccountBtn.setImageResource(R.drawable.index_1);
        tabItemAssetsBtn.setImageResource(R.drawable.index_2);
        tabItemChartBtn.setImageResource(R.drawable.index_3);
        tabItemMyinfoBtn.setImageResource(R.drawable.index_4);
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if (accountFragment != null) {
            fragmentTransaction.hide(accountFragment);
        }
        if (assetsFragment != null) {
            fragmentTransaction.hide(assetsFragment);
        }
        if (chartFragment != null) {
            fragmentTransaction.hide(chartFragment);
        }
        if (myinfoFragment != null) {
            fragmentTransaction.hide(myinfoFragment);
        }

        switch (id){
            case R.id.bottom_bar_account_btn:// TODO: 2020/8/30
                if (checkIsLogin()) {
                    tabItemAccountBtn.setImageResource(R.drawable.index_1_lan);
                    if (accountFragment == null){
                        accountFragment = new AccountFragment();
                        fragmentTransaction.add(R.id.content,accountFragment);
                    }else {
                        fragmentTransaction.show(accountFragment);
                    }
                }else {
                    Toast.makeText(getContext(),"请先登录",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getContext(), LoginActivity.class));
                    //若未登陆，跳到个人信息页
//                    tabItemMyinfoBtn.setImageResource(R.drawable.index_4_lan);
//                    if (myinfoFragment == null){
//                        myinfoFragment = new MyinfoFragment();
//                        fragmentTransaction.add(R.id.content,myinfoFragment);
//                    }else {
//                        fragmentTransaction.show(myinfoFragment);
//                    }
                }

                break;
            case R.id.bottom_bar_assets_btn:
                if (checkIsLogin()) {
                    tabItemAssetsBtn.setImageResource(R.drawable.index_2_lan);
                    if (assetsFragment == null) {
                        assetsFragment = new AssetsFragment();
                        fragmentTransaction.add(R.id.content, assetsFragment);
                    } else {
                        fragmentTransaction.show(assetsFragment);
                    }
                }else {
                    Toast.makeText(getContext(),"请先登录",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getContext(), LoginActivity.class));
                    //若未登陆，跳到个人信息页
//                    tabItemMyinfoBtn.setImageResource(R.drawable.index_4_lan);
//                    if (myinfoFragment == null){
//                        myinfoFragment = new MyinfoFragment();
//                        fragmentTransaction.add(R.id.content,myinfoFragment);
//                    }else {
//                        fragmentTransaction.show(myinfoFragment);
//                    }
                }
                break;
            case R.id.bottom_bar_chart_btn:
                if (checkIsLogin()){
                    tabItemChartBtn.setImageResource(R.drawable.index_3_lan);
                    if (chartFragment == null){
                        chartFragment = new ChartFragment();
                        fragmentTransaction.add(R.id.content,chartFragment);
                    }else {
                        fragmentTransaction.show(chartFragment);
                    }
                }else {
                    Toast.makeText(getContext(),"请先登录",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getContext(), LoginActivity.class));
//                    tabItemMyinfoBtn.setImageResource(R.drawable.index_4_lan);
//                    if (myinfoFragment == null){
//                        myinfoFragment = new MyinfoFragment();
//                        fragmentTransaction.add(R.id.content,myinfoFragment);
//                    }else {
//                        fragmentTransaction.show(myinfoFragment);
//                    }
                }
                break;
            case R.id.bottom_bar_myinfo_btn:

                    tabItemMyinfoBtn.setImageResource(R.drawable.index_4_lan);
                    if (myinfoFragment == null){
                        myinfoFragment = new MyinfoFragment();
                        fragmentTransaction.add(R.id.content,myinfoFragment);
                    }else {
                        fragmentTransaction.show(myinfoFragment);
                    }

                break;

        }
        fragmentTransaction.commit();
        currentId = id;

    }

    @Override
    public void onClick(View v) {
        setTabSelection(v.getId());
    }


}
