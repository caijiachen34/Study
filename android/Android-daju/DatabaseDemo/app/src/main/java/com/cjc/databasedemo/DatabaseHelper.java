package com.cjc.databasedemo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {


    private static final String TAG = "DatabaseHelper";

    /*
    * @param context 上下文
    * @param name    数据库名称
    * @param factory 游标工厂
    * @param version 版本号
    *
    * */
    public DatabaseHelper(@Nullable Context context) {
        super(context, Constants.DATABASE_NAME, null, Constants.VERSION_CODE);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //创建时的回调
        Log.d(TAG,"创建数据库");
        //创建字段
        //sql：create table table_name(_id integer,name varchar(50),age Integer,salary Integer);
        String sql = "create table "+Constants.TABLE_NAME+"(_id integer,name varchar(50),age Integer,salary integer)";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //升级时的回调
        Log.d(TAG,"升级数据库");

        //sql:alter table_name add phone integer;
        String sql;

        //用户版本的判断
        switch (oldVersion){
            case 1:
                //添加address和这个phone字段
                //sql = "alter table " + Constants.TABLE_NAME + " add phone integer , address varchar";
                db.execSQL("alter table " + Constants.TABLE_NAME + " add phone integer");
                db.execSQL("alter table " + Constants.TABLE_NAME + " add address varchar");
                break;
            case 2:
                //添加address字段
                sql = "alter table " + Constants.TABLE_NAME + " add address varchar";
                break;
            case 3:

                break;
        }
    }
}
