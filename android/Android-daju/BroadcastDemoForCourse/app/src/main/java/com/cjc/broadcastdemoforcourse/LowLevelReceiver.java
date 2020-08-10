package com.cjc.broadcastdemoforcourse;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by CC
 **/
public class LowLevelReceiver extends BroadcastReceiver {
    private static final String TAG = "LowLevelReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "low action is ===>>> " + intent.getAction());
        //修改广播内容
        //接收到内容
        Bundle resultExtras = getResultExtras(true);
        String content = resultExtras.getCharSequence("content").toString();
        Log.d(TAG, "content ===>>> " +content);
    }
}
