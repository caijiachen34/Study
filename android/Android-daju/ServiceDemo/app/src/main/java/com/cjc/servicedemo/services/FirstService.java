package com.cjc.servicedemo.services;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.cjc.servicedemo.interfaces.ICommunication;

/**
 * Created by CC
 **/
public class FirstService extends Service {
    private static final String TAG = "FirstService";

    private class InnerBinder extends Binder implements ICommunication {

        @Override
        public void callServiceInnerMethod() {
            sayHello();
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind: ...");
        return new InnerBinder();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: ...");
    }

    //onStart过时,用onStartCommand
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand: ...");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ...");
    }

    private void sayHello(){
        Toast.makeText(this,"你好",Toast.LENGTH_SHORT).show();
    }
}
