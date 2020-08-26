package com.cjc.familybill.common;

import android.app.Application;
import android.content.Context;

import com.cjc.familybill.http.HttpMethods;


/**
 * 创建Application后还需要再AndroidManifest中引用
 * */

public class MyApplication extends Application {
    private  static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext=getApplicationContext();

        //全局初始化Retrofit公共类
        HttpMethods.getInstance();

    }

    public static Context getContext(){
        return mContext;
    }
}
