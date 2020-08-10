package com.cjc.broadcastdemoforcourse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private TextView tv_batterylevel;
    private BatteryLevelReceiver batteryLevelReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        //动态注册电量广播
        registerBatteryReceiver();

    }

    private void initView() {
        tv_batterylevel = findViewById(R.id.tv_batterylevel);
    }


    private void registerBatteryReceiver() {
        //这种注册方式是动态注册
        //收听的频道是：电量变化
        //2.意图
        IntentFilter intentFilter = new IntentFilter();
        //3.设置频道
        intentFilter.addAction(Intent.ACTION_BATTERY_CHANGED);
        intentFilter.addAction(Intent.ACTION_POWER_CONNECTED);
        intentFilter.addAction(Intent.ACTION_POWER_DISCONNECTED);
        //4.初始化广播接收者
        batteryLevelReceiver = new BatteryLevelReceiver();
        //5.注册广播
        this.registerReceiver(batteryLevelReceiver,intentFilter);
    }

    /*
    * 1.创建一个广播接收者
    * */
    private class BatteryLevelReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (Intent.ACTION_BATTERY_CHANGED.equals(action)) {
                int currentlevel = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
                int maxlevel = intent.getIntExtra(BatteryManager.EXTRA_SCALE, 0);
                double present = currentlevel * 1.0 / maxlevel * 100;

                tv_batterylevel.setText("当前电量=" + currentlevel + "当前电量百分比是=" + present);
                //Log.d(TAG, "action is ===>>> " + action);
                Log.d(TAG, "当前电量 ===>>> " + currentlevel);
            }else if(Intent.ACTION_POWER_CONNECTED.equals(action)){
                Log.d(TAG, "usb已连接");
                //Log.d(TAG, "action is ===>>> " + action);
            }else if (Intent.ACTION_POWER_DISCONNECTED.equals(action)){
                Log.d(TAG, "usb断开了");
                //Log.d(TAG, "action is ===>>> " + action);
            }
            Log.d(TAG, "action is ===>>>=== " + action);


        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //取消广播注册，否则会内存泄露
        if (batteryLevelReceiver != null) {
            this.unregisterReceiver(batteryLevelReceiver);
            Log.d(TAG, "已取消广播注册");
        }
    }
}