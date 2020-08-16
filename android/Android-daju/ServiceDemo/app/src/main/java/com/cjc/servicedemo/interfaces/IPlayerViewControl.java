package com.cjc.servicedemo.interfaces;

/**
 * Created by CC
 **/
public interface IPlayerViewControl {
    //播放状态改变的通知
    void onPlayerStateChange(int state);

    //播放进度的改变
    void onSeekChange(int seek);
}
