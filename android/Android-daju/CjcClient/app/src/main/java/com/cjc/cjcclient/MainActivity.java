package com.cjc.cjcclient;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.cjc.alipay.ThirdPartPayAction;
import com.cjc.alipay.ThridPartPayResult;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private TextView mtv_count;
    private Button mbtn_buy;
    private boolean mIsBind;
    private AlipayConncetion mAlipayConncetion;
    private ThirdPartPayAction mThirdPartPayAction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //绑定支付宝服务
        bindAliPayService();
        initView();
        setListener();
    }

    //绑定支付宝服务
    private void bindAliPayService() {
        Intent intent = new Intent();
        intent.setAction("com.cjc.alipay.THIRD_PART_PAY");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setPackage("com.cjc.alipay");
        mAlipayConncetion = new AlipayConncetion();
        mIsBind = bindService(intent, mAlipayConncetion, BIND_AUTO_CREATE);
    }

    private void setListener() {
        mbtn_buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //充值
                try {
                    if (mThirdPartPayAction != null) {
                    mThirdPartPayAction.requestPay("充值100",100.00f,new PayCallback());
                    }
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                //TODO:今天
            }
        });
    }

    private void initView() {
        mtv_count = findViewById(R.id.tv_count);
        mbtn_buy = findViewById(R.id.btn_buy);
    }

    private class AlipayConncetion implements ServiceConnection{

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.d(TAG, "onServiceConnected ===>>> " + service);
            mThirdPartPayAction = ThirdPartPayAction.Stub.asInterface(service);

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.d(TAG, "onServiceDisconnected ===>>> " + name);
        }
    }

    private class PayCallback extends ThridPartPayResult.Stub{

        @Override
        public void onPaySuccess(){
            //支付成功修改ui内容，实际要去修改服务器
            mtv_count.setText("100");
            Toast.makeText(MainActivity.this,"充值成功",Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onPayFailed(int errorCode, String msg){
            Log.d(TAG, "onPayFailed ===>>> errorCode:" + errorCode + " : " + msg);
            Toast.makeText(MainActivity.this,"充值失败",Toast.LENGTH_SHORT).show();
        }

    }

    //释放资源
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mAlipayConncetion != null && mIsBind) {
            unbindService(mAlipayConncetion);
            mIsBind = false;
            mAlipayConncetion = null;
            Log.d(TAG, "onDestroy ===>>> 资源已销毁 ");
        }
    }
}