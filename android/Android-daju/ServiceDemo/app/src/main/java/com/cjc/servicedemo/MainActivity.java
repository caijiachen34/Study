package com.cjc.servicedemo;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.cjc.servicedemo.interfaces.ICommunication;
import com.cjc.servicedemo.services.FirstService;

public class MainActivity extends Activity {

    private static final String TAG = "MainActivity";
    private Button btn_startService;
    private Button btn_stopService;
    private Button btn_sayHello;
    private Button btn_bindService;
    private Button btn_unbindService;
    private boolean isServiceBind;
    private ICommunication mICommunication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initListener();
    }

    private void initView() {
        btn_startService = findViewById(R.id.btn_startService);
        btn_stopService = findViewById(R.id.btn_stopService);
        btn_sayHello = findViewById(R.id.btn_sayHello);
        btn_bindService = findViewById(R.id.btn_bindService);
        btn_unbindService = findViewById(R.id.btn_unbindService);
    }

    private void initListener() {
        btn_startService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, FirstService.class);

                startService(intent);
            }
        });

        btn_stopService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, FirstService.class);

               stopService(intent);
            }
        });

        btn_sayHello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callServiceMethod();
            }
        });

        btn_bindService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //绑定服务
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, FirstService.class);
                //绑定之后通知回调到serviceConnection
                isServiceBind = bindService(intent, mServiceConnection, BIND_AUTO_CREATE);
            }
        });


        btn_unbindService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //解绑服务
                if (mServiceConnection != null && isServiceBind) {
                    Log.d(TAG, "onClick: unbindService...");
                    unbindService(mServiceConnection);
                }
            }
        });
    }

    public void callServiceMethod(){
        Log.d(TAG, "callServiceMethod ===>>> say Hello ");
        mICommunication.callServiceInnerMethod();
    }

    private ServiceConnection mServiceConnection =new ServiceConnection() {
        @Override
        //onServiceConnected:已经连接
        public void onServiceConnected(ComponentName name, IBinder service) {
            if (service instanceof ICommunication){
                Log.d(TAG, "onServiceConnected: ...");
                mICommunication = (ICommunication) service;
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.d(TAG, "onServiceDisconnected: ...");
            mICommunication = null;
        }
    };

}
