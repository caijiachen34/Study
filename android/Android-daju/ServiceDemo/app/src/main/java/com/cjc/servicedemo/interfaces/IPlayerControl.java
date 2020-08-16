package com.cjc.servicedemo.interfaces;

/**
 * Created by CC
 **/
public interface IPlayerControl {
    //播放状态
    //播放
    int PLAY_STATE_PLAY = 1;
    int PLAY_STATE_PAUSE = 2;
    int PLAY_STATE_STOP = 3;

    //把ui控制的接口设置给逻辑层
    void registerViewController(IPlayerViewControl viewController);
    //取消接口通知的注册
    void unRegisterViewController();
    //播放或暂停
    void PlayOrPause();
    //停止播放
    void stop();
    //设置播放进度
    void seekTo(int seek);
}
