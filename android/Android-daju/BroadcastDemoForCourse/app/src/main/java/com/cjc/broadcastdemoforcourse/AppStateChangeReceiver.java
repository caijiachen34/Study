package com.cjc.broadcastdemoforcourse;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by CC
 **/
//监听应用安装与卸载:收集信息
public class AppStateChangeReceiver extends BroadcastReceiver{
    public static final String TAG = "AppStateChangeReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (Intent.ACTION_PACKAGE_ADDED.equals(action)) {
            Log.d(TAG, "应用安装了 ===>>> " + intent.getData());
        }else if(Intent.ACTION_PACKAGE_REMOVED.equals(action)){
            Log.d(TAG, "应用卸载了 ===>>> " + intent.getData());
        }
    }
}
