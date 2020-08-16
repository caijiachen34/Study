package com.cjc.servicedemo;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

import com.cjc.servicedemo.interfaces.ICommunication;
import com.cjc.servicedemo.services.SecondService;

/**
 * Created by CC
 **/
/*
* 开启服务的方式有两个
* 1. startService()开启服务 --->>> stopService()停止服务
*   优点：服务可以长期后台运行
*   缺点：不能进行通讯
*
*   生命周期：
*   最基本的生命周期
*   onCreate -> onStartCommand -> onDestroy
*   若服务已经启动，则不会走onCreate
*
* 2. bindService()绑定服务，如果没有服务，自动启动，--->>> unBindService()解绑服务
*   优点：可以进行通讯
*   确定：不可以长期后台运行，如果不解绑，则会发生泄露,如果解绑了，服务将停止
*
*   生命周期：
*   onCreate -> onBind -> onUnbind -> onDestroy
*
* 3.混合开启服务
*   生命周期：
*   1.开启服务，然后去绑定服务，如果不取消绑定服务，那么就无法停止服务
*   2.开启服务以后，多次绑定-解绑服务，服务不会停止，只能通过stopService()来停止服务
*
*   推荐的开启混合服务的方式:
*   1.开启服务：确保服务可以长期运行于后台
*   2.绑定服务：为了可以进行通讯
*   3.调用服务内部方法
*   4.退出界面(Activity)：要解绑服务->释放资源
*   5.如果不使用服务，要让服务停止，就要调用stopService
*
*
* */
public class SecondActivity extends Activity {

    private final String TAG = "SecondActivity";
    private boolean mIsBind;
    private ServiceConnection mServiceConnection;
    private ICommunication mCommunication;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    public void startServiceClick(View view){
        Log.d(TAG, "startServiceClick: ");
        Intent intent = new Intent(this, SecondService.class);

        startService(intent);
    }

    public void bindServiceClick(View view){
        Log.d(TAG, "bindServiceClick: ");
        Intent intent = new Intent(this,SecondService.class);
        mServiceConnection = new ServiceConnection();
        mIsBind = bindService(intent, mServiceConnection, BIND_AUTO_CREATE);
    }

    private class ServiceConnection implements android.content.ServiceConnection {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mCommunication = (ICommunication) service;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mCommunication = null;
        }
    }

    public void callServiceMethod(View view){
        if (mCommunication != null) {
            mCommunication.callServiceInnerMethod();
        }
    }

    public void unbindServiceClick(View view){
        Log.d(TAG, "unbindServiceClick: ");
        if (mServiceConnection != null && mIsBind) {
            unbindService(mServiceConnection);
        }
    }

    public void stopServiceClick(View view){
        Log.d(TAG, "stopServiceClick: ");
        Intent intent = new Intent(this, SecondService.class);

        stopService(intent);
    }

}
