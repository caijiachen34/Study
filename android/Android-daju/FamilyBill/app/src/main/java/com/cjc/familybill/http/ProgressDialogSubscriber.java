package com.cjc.familybill.http;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.widget.Toast;

import java.net.ConnectException;
import java.net.SocketTimeoutException;

import rx.Subscriber;

/**
 * 抽象类
 * @param <T>
 */
public abstract class ProgressDialogSubscriber<T> extends Subscriber<T> {

    private static final String TAG = "ProgressDialog";
    private Context mContext;
    private ProgressDialog mDialog;

    public ProgressDialogSubscriber(Context context){
        this.mContext=context;
    }

    @Override
    public void onNext(T t) {
        Log.i(TAG, "===============进入onNext" + t);
    }

    @Override
    public void onCompleted() {
        dismissProgressDialog();
    }

    @Override
    public void onError(Throwable e) {
        Log.i(TAG, "===============onError====" + e.getMessage());
        if(e instanceof SocketTimeoutException){
            Toast.makeText(mContext,"网络中断，请检查你的网络状态",Toast.LENGTH_SHORT).show();
        }else if (e instanceof ConnectException){
            Toast.makeText(mContext,"网络中断，请检查你的网络状态",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(mContext,"error"+e.getMessage(),Toast.LENGTH_SHORT).show();
            Log.v("=====","error:==="+e.getMessage());
        }
        dismissProgressDialog();
    }

    @Override
    public void onStart() {
        showProgressDialog();
    }


    private void showProgressDialog(){
        if (mDialog!=null){
            mDialog=new ProgressDialog(mContext);
            mDialog.setCancelable(true);
            mDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                @Override
                public void onCancel(DialogInterface dialog) {
                    //取消订阅，取消请求
                    ProgressDialogSubscriber.this.unsubscribe();
                }
            });
        }

        if (mDialog!=null&&mDialog.isShowing()){
            mDialog.show();
        }
    }

        private void dismissProgressDialog(){
        if (mDialog!=null&&mDialog.isShowing()){
            mDialog.dismiss();
            mDialog=null;
        }
        }



}
