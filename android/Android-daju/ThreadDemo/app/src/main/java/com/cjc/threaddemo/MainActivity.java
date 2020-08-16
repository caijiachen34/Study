package com.cjc.threaddemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;

import com.cjc.services.MyIntentService;
import com.cjc.services.MyService;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private MyService.DownloadBinder downloadBinder;
    private boolean mIsBind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void startClick(View view){
        Intent intent = new Intent(this, MyService.class);

        startService(intent);
    }

    public void stopClick(View view){
        Intent intent = new Intent(this, MyService.class);

        stopService(intent);
    }

    public void bindService(View view){
        Intent intent = new Intent(this,MyService.class);

        mIsBind = bindService(intent, mConnect, BIND_AUTO_CREATE);
    }

    public void unBindService(View view){
        Log.d(TAG, "unBindService ===>>> 解绑服务");
        unbindService(mConnect);
    }

    public void startThreadService(View view){
        Intent intent = new Intent(this, MyIntentService.class);

        startService(intent);
    }

    private ServiceConnection mConnect = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.d(TAG, "ComponentName ===>>> " + name);
            downloadBinder = (MyService.DownloadBinder) service;
            downloadBinder.startDwonload();
            downloadBinder.getProgress();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mIsBind) {
            unbindService(mConnect);
            mIsBind = false;
        }
    }
}