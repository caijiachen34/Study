package com.cjc.broadcastdemoforcourse;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by CC
 **/
public class MessageReceiver extends BroadcastReceiver {
    private static final String TAG = "MessageReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();

        Log.d(TAG, "action ===>>> " + action);
        String content = intent.getStringExtra(Constants.KEY_CONTENT);
        Log.d(TAG, "content ===>>> " + content);
        Toast.makeText(context,content,Toast.LENGTH_SHORT).show();
    }
}
