package com.cjc.activitylandscapelifecircle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.SeekBar;


/*
* 横竖屏时生命周期的变化
* D/MainActivity: onCreate:
* D/MainActivity: onStart:
* D/MainActivity: onResume:
* D/MainActivity: onPause:
* D/MainActivity: onStop:
* D/MainActivity: onDestroy:
* D/MainActivity: onCreate:
* D/MainActivity: onStart:
* D/MainActivity: onResume:
*
* 如上可知竖屏切换成横屏的时候，Activity会销毁，并重新创建
* 横屏切换成竖屏时Activity也会销毁，并重新创建
*
* 实际开发的场景：
* 1.游戏开发
* 2.视频播放器
* 3.其他场景
*
* 横竖屏切换的时候，activity的生命周期发生变化
*
* 如何解决？
* 1.禁止旋转，指定方向(大多用于游戏)
* android:screenOrientation="landscape" 横屏
* android:screenOrientation="portrait"  竖屏
*
* 2.对配置不敏感(大多用于视频app)
* android:configChanges="keyboardHidden|screenSize|orientation"
* */
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private SeekBar progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: ");
        initView();
        //initListener();
    }

    private void initView() {
        progress = findViewById(R.id.progress);
        Log.d(TAG, "progress: " + progress.toString());
        //设置初始化数据
        progress.setMax(100);
        progress.post(new Runnable() {
            @Override
            public void run() {
                progress.setProgress(0);
            }
        });

    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }
}