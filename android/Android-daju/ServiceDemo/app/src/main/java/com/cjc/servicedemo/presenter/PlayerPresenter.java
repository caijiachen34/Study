package com.cjc.servicedemo.presenter;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Binder;
import android.util.Log;

import com.cjc.servicedemo.interfaces.IPlayerControl;
import com.cjc.servicedemo.interfaces.IPlayerViewControl;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by CC
 **/
//抽出来Ibinder实现逻辑层
public class PlayerPresenter extends Binder implements IPlayerControl {

    private static final String TAG = "PlayerPresenter";
    private IPlayerViewControl mViewController;
    private int mCurrentState = PLAY_STATE_STOP;
    private MediaPlayer mMediaPlayer;
    private Timer mTimer;
    private SeekTimeTask mSeekTimeTask;

    @Override
    public void registerViewController(IPlayerViewControl viewController) {
        this.mViewController = viewController;
    }

    @Override
    public void unRegisterViewController() {
        mViewController = null;
    }

    @Override
    public void PlayOrPause() {
        Log.d(TAG, "PlayOrPause: ");
        if (mCurrentState == PLAY_STATE_STOP) {
            //创建播放器
            initPlayer();
            //设置数据源
            try {
                mMediaPlayer.setDataSource("/sdcard/Download/说了再见(电影《海洋天堂》主题曲)-周杰伦.mp3");
                mMediaPlayer.prepare();
                mMediaPlayer.start();
                mCurrentState = PLAY_STATE_PLAY;
                startTimer();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (mCurrentState == PLAY_STATE_PLAY) {
            if (mMediaPlayer != null) {
                mMediaPlayer.pause();
                mCurrentState = PLAY_STATE_PAUSE;
                stopTimer();
            }
        } else if (mCurrentState == PLAY_STATE_PAUSE) {
            if (mMediaPlayer != null) {
                mMediaPlayer.start();
                mCurrentState = PLAY_STATE_PLAY;
                startTimer();
            }
        }
        //通知ui界面
        if (mViewController != null) {
            mViewController.onPlayerStateChange(mCurrentState);
        }
    }

    private void initPlayer() {
        if (mMediaPlayer == null) {
            mMediaPlayer = new MediaPlayer();
            mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        }
    }

    @Override
    public void stop() {
        Log.d(TAG, "stop: ");
        if (mMediaPlayer != null && mMediaPlayer.isPlaying()) {
            mMediaPlayer.stop();
            mCurrentState = PLAY_STATE_STOP;
            stopTimer();
            //通知ui界面
            if (mViewController != null) {
                mViewController.onPlayerStateChange(mCurrentState);
            }
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
    }

    @Override
    public void seekTo(int seek) {
        Log.d(TAG, "seekTo: " + seek);
        if (mMediaPlayer != null) {
            int tarSeek = (int) (seek * 1.0f / 100 * mMediaPlayer.getDuration());
            mMediaPlayer.seekTo(tarSeek);
        }
    }

    //计时器
    private void startTimer() {
        if (mSeekTimeTask == null) {
            mSeekTimeTask = new SeekTimeTask();
        }
        if (mTimer == null) {
            mTimer = new Timer();
        }
        //
        mTimer.schedule(mSeekTimeTask, 0, 200);
    }

    private void stopTimer() {
        if (mTimer != null) {
            mTimer.cancel();
            mTimer = null;
        }
        if (mSeekTimeTask != null) {
            mSeekTimeTask.cancel();
            mSeekTimeTask = null;
        }
    }

    private class SeekTimeTask extends TimerTask {

        @Override
        public void run() {
            //获取当前的播放进度
            if (mMediaPlayer != null && mViewController != null) {
                int currentPosition = mMediaPlayer.getCurrentPosition();
                //Log.d(TAG, "run: " + currentPosition);
                Log.d(TAG, "run111 " + currentPosition);
                Log.d(TAG, "run222 " + mMediaPlayer.getDuration());
                int curPosition = (int) (currentPosition*1.0f / mMediaPlayer.getDuration() * 100);
                mViewController.onSeekChange(curPosition);
            }
        }
    }
}
