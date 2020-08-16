package com.cjc.alipay.activitys;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.cjc.alipay.Constants.Constants;
import com.cjc.alipay.R;
import com.cjc.alipay.services.PayService;


/**
 * Created by CC
 **/

/*
* 流程：
*   第三方应用发起对PayService的绑定，PayService的onBind方法判定为绑定的请求，
*   拉起PayActivity，拉起PayActivity的onCreate方法就会绑定服务doBindService(),
*   服务就会走onBind方法返回支付的动作类PayAction给PayActivity，然后走initView()，
*   判断密码是否正确，正确的话就发起支付，PayAction方法会调用mThirdPartPay.paySuccess();
*   然后回调告诉第三方应用支付成功。
*
*
* */
public class PayActivity extends Activity {
    private static final String TAG = "PayActivity";
    private PayServiceConnection mPayServiceConnection;
    private boolean mIsBind;
    private EditText et_pay_password;
    private PayService.PayAction mPayAction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);
        //Activity要跟服务器进行通讯，告诉服务支付结果，所以也要绑定服务
        doBindService();

        initView();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        mPayAction.onUserCancel();
    }

    private void initView() {
        Intent intent = getIntent();
        String orderInfo = intent.getStringExtra(Constants.KEY_BILL_INFO);
        final float payMoney = intent.getFloatExtra(Constants.KEY_PAY_MONEY, 0f);
        TextView tv_order_info = findViewById(R.id.tv_order_info);
        tv_order_info.setText("支付信息" + orderInfo);
        TextView tv_pay_money = findViewById(R.id.tv_pay_money);
        tv_pay_money.setText("支付金额" + payMoney + " 元");
        et_pay_password = findViewById(R.id.et_pay_password);
        Button btn_pay = findViewById(R.id.btn_pay);
        btn_pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //点击了提交
                String password = et_pay_password.getText().toString().trim();
                if (password.equals("123") && mPayAction != null) {
                    mPayAction.Pay(payMoney);
                    finish();
                    Log.d(TAG, "onClick ===>>> 支付成功");
                }else {
                    Toast.makeText(PayActivity.this,"密码错误",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void doBindService() {
        Intent intent = new Intent(this, PayService.class);
        mPayServiceConnection = new PayServiceConnection();
        mIsBind = bindService(intent, mPayServiceConnection, BIND_AUTO_CREATE);
    }

    private class PayServiceConnection implements ServiceConnection {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mPayAction = (PayService.PayAction) service;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mPayAction = null;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPayServiceConnection != null && mIsBind) {
            unbindService(mPayServiceConnection);
            mPayServiceConnection = null;
            mIsBind = false;
        }
    }
}
