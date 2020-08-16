package com.cjc.bankservicedemo;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

import com.cjc.bankservicedemo.actions.impl.NormalUserAIDLActionImpl;
import com.cjc.bankservicedemo.actions.interfaces.INormalUserAction;

/**
 * Created by CC
 **/

/*
* 1.绑定服务doBindService();
* 2.新建一个类继承ServiceConnection
* 3.
*
*
* */
public class NormalUserActivity extends Activity {

    private static final String TAG = "NormalUserActivity";
    private NormalUserConnection mNormalUserConnection;
    private boolean misBind;
    private NormalUserAction mNormalUserAction;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_user);
        doBindService();
    }

    private void doBindService() {
        Log.d(TAG, "doBindService ===>>> 绑定服务");
        Intent intent = new Intent();
        intent.setAction("com.cjc.ACTION_NORMAL_USER");
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        intent.setPackage("com.cjc.bankservicedemo");
        mNormalUserConnection = new NormalUserConnection();
        misBind = bindService(intent, mNormalUserConnection, BIND_AUTO_CREATE);
    }

    private class NormalUserConnection implements ServiceConnection {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.d(TAG, "onServiceConnected ===>>> 服务绑定 " + name);
            mNormalUserAction = NormalUserAction.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.d(TAG, "onServiceDisconnected ===>>> " + name);
        }
    }

    public void saveMoneyClick(View view){
        Log.d(TAG, "saveMoneyClick ===>>> 存钱方法");
        try {
            mNormalUserAction.saveMoney(10000);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void getMoneyClick(View view){
        Log.d(TAG, "getMoneyClick ===>>> 取钱方法");
        try {
            float money = mNormalUserAction.getMoney();
            Log.d(TAG, "getMoneyClick ===>>> " + money);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void loanMoneyClick(View view){
        Log.d(TAG, "loanMoneyClick ===>>> 贷款方法");
        try {
            mNormalUserAction.loanMoney();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mNormalUserConnection != null && misBind) {
            unbindService(mNormalUserConnection);
            Log.d(TAG, "onDestroy ===>>> 服务解绑了");
            mNormalUserConnection = null;
            misBind = false;
        }
    }
}
