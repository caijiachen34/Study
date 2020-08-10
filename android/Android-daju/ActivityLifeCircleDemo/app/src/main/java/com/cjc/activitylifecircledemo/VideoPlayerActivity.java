package com.cjc.activitylifecircledemo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

/**
 * Created by CC
 **/
public class VideoPlayerActivity  extends Activity {
    private static final String TAG = "VideoPlayerActivity";
    private TextView current_play_status;
    private Button play_control;
    private boolean isPlayer = false;
    //是不是因为生命周期变化而主动停止的
    private boolean isStopAtAmin = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        initView();
        initListener();
    }



    private void initListener() {
        play_control.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPlayer) {
                    //如果当前状态是播放,就停止
                    stop();
                }else {
                    //如果当前状态是停止,就播放
                    play();
                }
            }
        });
    }

    private void play(){
        Log.d(TAG, "play: 播放电影");
        current_play_status.setText("正在播放电影");
        play_control.setText("暂停");
        isPlayer = true;
    }

    private void stop(){
        Log.d(TAG, "stop: 停止播放电影");
        current_play_status.setText("电影停止");
        play_control.setText("播放");
        isPlayer = false;
    }

    private void initView() {
        current_play_status = findViewById(R.id.current_play_status);
        play_control = findViewById(R.id.play_control);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
        if (isStopAtAmin && !isPlayer) {
            play();
            isStopAtAmin = false;
        }
    }


    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
        if (isPlayer) {
            //如果电影是播放的，则停止
            stop();
            isStopAtAmin = true;
        }
    }
}
