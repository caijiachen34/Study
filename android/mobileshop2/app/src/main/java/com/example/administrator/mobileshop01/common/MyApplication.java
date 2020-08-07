package com.example.administrator.mobileshop01.common;

import android.app.Application;
import android.content.Context;

import com.example.administrator.mobileshop01.db.GreenDaoManager;
import com.example.administrator.mobileshop01.http.HttpMethods;
import com.nostra13.universalimageloader.core.ImageLoader;

/**
 * 创建Application后还需要再AndroidManifest中引用
 * */

public class MyApplication extends Application {
    private  static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext=getApplicationContext();

        //GreenDao全局初始化，只初始化一次
        GreenDaoManager.getmInstance();

        //全局初始化Retrofit公共类
        HttpMethods.getInstance();

        //全局初始化图片加载类
        ImageLoaderManager.getInstance();
    }

    public static Context getContext(){
        return mContext;
    }
}
