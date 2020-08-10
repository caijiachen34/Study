package com.cjc.broadcastpermissiondemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by CC
 **/
public class OrderBroadcastReceiver extends BroadcastReceiver {
    private static final String TAG = "OrderBroadcastReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {

        Bundle resultExtras = getResultExtras(true);
        String content = resultExtras.getCharSequence("content").toString();
        Log.d(TAG, "上个应用的数据" + content);
    }
}
