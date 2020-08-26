package com.cjc.familybill.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.cjc.familybill.R;

/**
 * Created by CC
 **/
public class SplashActivity extends Activity {

    private ImageView mSplashItem;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initView();
    }

    private void initView() {
        mSplashItem = findViewById(R.id.iv_splash_loading_item);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.splash_loading);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                //结束动画后的操作
                Intent intent = new Intent(SplashActivity.this,LoginActivity.class);
                startActivity(intent);
                //添加切换动画
                overridePendingTransition(R.anim.push_left_in,R.anim.push_left_out);
                finish();

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        mSplashItem.setAnimation(animation);
    }
}
