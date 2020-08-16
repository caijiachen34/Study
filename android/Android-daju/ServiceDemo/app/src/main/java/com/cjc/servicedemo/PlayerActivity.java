package com.cjc.servicedemo;

import android.Manifest;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.cjc.servicedemo.interfaces.IPlayerControl;
import com.cjc.servicedemo.interfaces.IPlayerViewControl;
import com.cjc.servicedemo.services.PlayerService;

import static com.cjc.servicedemo.interfaces.IPlayerControl.PLAY_STATE_PAUSE;
import static com.cjc.servicedemo.interfaces.IPlayerControl.PLAY_STATE_PLAY;
import static com.cjc.servicedemo.interfaces.IPlayerControl.PLAY_STATE_STOP;

/**
 * Created by CC
 **/
public class PlayerActivity extends Activity {

    private static final String TAG = "PlayerActivity";
    private SeekBar seek_skb;
    private Button btn_play_or_pause;
    private Button btn_stop;
    private PlayerConnection mPlayerConnection;
    private IPlayerControl mPlayerControl;
    private boolean isUserTouchProgressBar = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        initPermission();
        initView();
        initListener();
        initStartService();
        initBindService();
    }

    private void initPermission() {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,new
                    String[]{Manifest.permission.READ_EXTERNAL_STORAGE},1);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    private void initStartService() {
        Log.d(TAG, "initStartService ===>>> ");
        Intent intent = new Intent(this,PlayerService.class);
        startService(intent);
    }

    private void initBindService() {
        Log.d(TAG, "initBindService ===>>> ");
        Intent intent = new Intent(this, PlayerService.class);
        if (mPlayerConnection == null) {
            mPlayerConnection = new PlayerConnection();
        }
        boolean mIsBind = bindService(intent, mPlayerConnection, BIND_AUTO_CREATE);
    }

    private class PlayerConnection implements ServiceConnection {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.d(TAG, "onServiceConnected ===>>> " + service);
            mPlayerControl = (IPlayerControl) service;
            mPlayerControl.registerViewController(mIPlayerViewControl);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.d(TAG, "onServiceDisconnected ===>>> ");
            mPlayerControl = null;
        }
    }

    private void initListener() {
        seek_skb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //进度条改变
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //手已经触摸
                isUserTouchProgressBar = true;
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                int touchProgress = seekBar.getProgress();
                Log.d(TAG, "onStopTrackingTouch ===>>> " + touchProgress);

                //停止拖动
                if (mPlayerControl != null) {
                    mPlayerControl.seekTo(touchProgress);
                }
                isUserTouchProgressBar = false;
            }
        });
        btn_play_or_pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //播放或暂停
                if (mPlayerControl != null) {
                    mPlayerControl.PlayOrPause();
                }
            }
        });
        btn_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //停止按钮被点击
                if (mPlayerControl != null) {
                    mPlayerControl.stop();
                }
            }
        });
    }

    private void initView() {
        seek_skb = findViewById(R.id.seek_skb);
        btn_play_or_pause = findViewById(R.id.btn_play_or_pause);
        btn_stop = findViewById(R.id.btn_stop);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPlayerConnection != null) {
            //释放
            mPlayerControl.unRegisterViewController();
            Log.d(TAG, "onDestroy ===>>> unbindService ");
            unbindService(mPlayerConnection);
        }
    }

    private IPlayerViewControl mIPlayerViewControl = new IPlayerViewControl() {

        @Override
        public void onPlayerStateChange(int state) {
            //根据播放状态修改ui
            switch (state){
                case PLAY_STATE_PLAY:
                    //正在播放的话，显示为暂停
                    btn_play_or_pause.setText("暂停");
                    break;
                case PLAY_STATE_PAUSE:
                    btn_play_or_pause.setText("播放");
                    break;
                case PLAY_STATE_STOP:
                    btn_play_or_pause.setText("播放");
                    break;
            }
        }

        @Override
        public void onSeekChange(final int seek) {
            //改变播放进度，条件：当用户的手触摸到进度条，就不更新
            //为什么非主线程更新ui不会崩
            //在android里面，有两个控件可以用子线程更新
            //一个是progressbar，一个是surfaceView
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (!isUserTouchProgressBar) {
                        seek_skb.setProgress(seek);
                    }
                }
            });
        }
    };
}
