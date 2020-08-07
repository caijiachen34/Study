package com.example.administrator.mobileshop01.db;

import com.example.administrator.mobileshop01.common.MyApplication;
import com.example.administrator.mobileshop01.gen.DaoMaster;
import com.example.administrator.mobileshop01.gen.DaoSession;

public class GreenDaoManager {
    private static GreenDaoManager mInstance;
    private static DaoMaster mDaoMaster;
    private static DaoSession mDaoSession;

    public GreenDaoManager(){
        if (mInstance==null){
            /**
             * 初始化并设置数据库名，添加myapplication全局类
             */
            DaoMaster.DevOpenHelper devOpenHelper=new DaoMaster.DevOpenHelper(MyApplication.getContext(),"mydb",null);
            mDaoMaster=new DaoMaster(devOpenHelper.getWritableDatabase());
            mDaoSession=mDaoMaster.newSession();
        }
    }
    public static GreenDaoManager getmInstance(){
        if(mInstance==null){
            synchronized (GreenDaoManager.class){
                if (mInstance==null){
                    mInstance=new GreenDaoManager();
                }
            }
        }
        return mInstance;
    }

    public static DaoMaster getMaster(){
        return mDaoMaster;
    }
    public static DaoSession getSession(){
        return mDaoSession;
    }
    public static DaoSession getNewSession(){
        mDaoSession=mDaoMaster.newSession();
        return mDaoSession;
    }
}
