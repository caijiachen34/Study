package com.cjc.broadcastdemoforcourse;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by CC
 **/
public class HighLevelReceiver extends BroadcastReceiver {
    private static final String TAG = "HighLevelReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG,"high action is ===>>>" + intent.getAction());
        //终止向下传达
        //abortBroadcast();
        //修改广播内容
        //接收到内容
        Bundle resultExtras = getResultExtras(true);
        String content = resultExtras.getCharSequence("content").toString();
        Log.d(TAG, "content ===>>> " + content);
        resultExtras.putCharSequence("content","上面分了两万元，请发到下级");
        //修改的内容下发
        setResultExtras(resultExtras);
    }
}
