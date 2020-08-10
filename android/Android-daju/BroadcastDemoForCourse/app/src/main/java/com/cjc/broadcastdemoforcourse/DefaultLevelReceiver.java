package com.cjc.broadcastdemoforcourse;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by CC
 **/
public class DefaultLevelReceiver extends BroadcastReceiver {
    private static final String TAG = "DefaultLevelReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "default action is ===>>> " + intent.getAction());
        //修改广播内容
        //接收到内容
        Bundle resultExtras = getResultExtras(true);
        String content = resultExtras.getCharSequence("content").toString();
        Log.d(TAG, "content ===>>> " +content);
        //修改的内容下发
        resultExtras.putCharSequence("content","上面分了5000元，请发到下级");
    }
}
