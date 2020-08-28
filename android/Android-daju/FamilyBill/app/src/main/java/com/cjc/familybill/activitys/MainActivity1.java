package com.cjc.familybill.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cjc.familybill.R;

public class MainActivity1 extends AppCompatActivity implements View.OnClickListener {

    private TextView tv_back;
    private TextView tv_main_title;
    private RelativeLayout rl_title_bar;
    private LinearLayout mBottomLayout;
    private View mAccountBtn;
    private View mAssetsBtn;
    private View mMyInfoBtn;
    private TextView tv_account;
    private TextView tv_assets;
    private TextView tv_myInfo;
    private ImageView iv_account;
    private ImageView iv_assets;
    private ImageView iv_myInfo;
    private View mChartBtn;
    private TextView tv_chart;
    private ImageView iv_chart;
    private FrameLayout mBodyLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        init();
        initBottomBar();
        setListener();
        setInitStatus();
    }



    private void init() {
        tv_back =  findViewById(R.id.tv_back);
        tv_main_title =  findViewById(R.id.tv_main_title);
        tv_main_title.setText("记账APP");
        rl_title_bar =  findViewById(R.id.title_bar);
        rl_title_bar.setBackgroundColor(Color.parseColor("#30B4FF"));
        tv_back.setVisibility(View.GONE);
        //获取底部导航栏上的控件
        initBodyLayout();
    }

    private void initBodyLayout() {
        //中间主体窗口
        mBodyLayout = findViewById(R.id.main_body);
    }

    private void initBottomBar() {
        mBottomLayout = findViewById(R.id.main_bottom_bar);
        mAccountBtn = findViewById(R.id.bottom_bar_account_btn);
        mAssetsBtn = findViewById(R.id.bottom_bar_assets_btn);
        mChartBtn = findViewById(R.id.bottom_bar_chart_btn);
        mMyInfoBtn = findViewById(R.id.bottom_bar_myinfo_btn);
        tv_account = findViewById(R.id.bottom_bar_text_account);
        tv_assets = findViewById(R.id.bottom_bar_text_assets);
        tv_chart = findViewById(R.id.bottom_bar_text_chart);
        tv_myInfo = findViewById(R.id.bottom_bar_text_myinfo);
        iv_account = findViewById(R.id.bottom_bar_image_account);
        iv_assets = findViewById(R.id.bottom_bar_image_assets);
        iv_chart = findViewById(R.id.bottom_bar_image_chart);
        iv_myInfo = findViewById(R.id.bottom_bar_image_myinfo);
    }

    //设置底部三个按钮的点击监听事件
    private void setListener() {
        for (int i = 0; i < mBottomLayout.getChildCount(); i++) {
            mBottomLayout.getChildAt(i).setOnClickListener(this);
        }
    }


    private void setInitStatus() {
        clearBottomImageState();
        setSelectedStatus(0);
        createView(0);
    }


    //清除底部按钮的选中状态
    private void clearBottomImageState() {
        tv_account.setTextColor(Color.parseColor("#666666"));
        tv_assets.setTextColor(Color.parseColor("#666666"));
        tv_chart.setTextColor(Color.parseColor("#666666"));
        tv_myInfo.setTextColor(Color.parseColor("#666666"));
        iv_account.setImageResource(R.drawable.index_1);
        iv_assets.setImageResource(R.drawable.index_2);
        iv_chart.setImageResource(R.drawable.index_3);
        iv_myInfo.setImageResource(R.drawable.index_4);
        for (int i = 0; i < mBottomLayout.getChildCount(); i++) {
            mBottomLayout.getChildAt(i).setSelected(false);
        }
    }


    //设置底部按钮选中状态
    public void setSelectedStatus(int index) {
        switch (index) {
            case 0:
                mAccountBtn.setSelected(true);
                iv_account.setImageResource(R.drawable.index_1_lan);
                tv_account.setTextColor(Color.parseColor("#0097F7"));
                rl_title_bar.setVisibility(View.VISIBLE);
                tv_main_title.setText("记账APP");
                break;
            case 1:
                mAssetsBtn.setSelected(true);
                iv_assets.setImageResource(R.drawable.index_2_lan);
                tv_assets.setTextColor(Color.parseColor("#0097F7"));
                rl_title_bar.setVisibility(View.VISIBLE);
                tv_main_title.setText("资产账户");
                break;
            case 2:
                mChartBtn.setSelected(true);
                iv_chart.setImageResource(R.drawable.index_3_lan);
                tv_chart.setTextColor(Color.parseColor("#0097F7"));
                rl_title_bar.setVisibility(View.GONE);
                break;
            case 3:
                mMyInfoBtn.setSelected(true);
                iv_myInfo.setImageResource(R.drawable.index_4_lan);
                tv_myInfo.setTextColor(Color.parseColor("#0097F7"));
                rl_title_bar.setVisibility(View.GONE);
        }
    }


    private void createView(int viewIndex) {
        switch (viewIndex){
            case 0:

        }
    }




    @Override
    public void onClick(View v) {

    }
}