package com.cjc.alipay.services;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import com.cjc.alipay.Constants.Constants;
import com.cjc.alipay.ThirdPartPayAction;
import com.cjc.alipay.ThridPartPayResult;
import com.cjc.alipay.activitys.PayActivity;

public class PayService extends Service {

    private static final String TAG = "PayService";
    private ThirdPartPayImpl mThirdPartPay;

    //判断绑定请求
    @Override
    public IBinder onBind(Intent intent) {
        String action = intent.getAction();
        Log.d(TAG, "onBind: ");
        if (action != null && action.equals("com.cjc.alipay.THIRD_PART_PAY")) {
            //说明为第三方支付的服务
            mThirdPartPay = new ThirdPartPayImpl();
            return mThirdPartPay;
        }
        return new PayAction();
    }

    public class PayAction extends Binder{
        public void Pay(float payMoney){
            Log.d(TAG, "Pay ===>>> " + payMoney + " RMB");
            //支付方法
            if (mThirdPartPay != null) {
                mThirdPartPay.paySuccess();
            }
        }

        public void onUserCancel(){
            //用户点击界面的取消/退出
            mThirdPartPay.payFailed(1,"UserCanceled");
        }
    }

    private class ThirdPartPayImpl extends ThirdPartPayAction.Stub{

        private ThridPartPayResult mCallback;

        @Override
        public void requestPay(String orderInfo, float payMoney, ThridPartPayResult callback) {
            this.mCallback = callback;
            //判断为第三方应用发起绑定请求后执行拉起下面的PayActivity
            Intent intent = new Intent();
            intent.setClass(PayService.this, PayActivity.class);
            intent.putExtra(Constants.KEY_BILL_INFO,orderInfo);
            intent.putExtra(Constants.KEY_PAY_MONEY,payMoney);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }

        public void paySuccess(){
            try {
                if (mCallback != null) {
                    mCallback.onPaySuccess();
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        public void payFailed(int errorCode,String errorMsg){
            if (mCallback != null) {
                try {
                    mCallback.onPayFailed(errorCode,errorMsg);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
