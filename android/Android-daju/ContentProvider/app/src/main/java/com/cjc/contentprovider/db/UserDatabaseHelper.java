package com.cjc.contentprovider.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.cjc.contentprovider.utils.Constants;

/**
 * Created by CC
 **/
public class UserDatabaseHelper extends SQLiteOpenHelper {
    private static final String TAG = "UserDatabaseHelper";

    public UserDatabaseHelper(@Nullable Context context) {
        super(context, Constants.DB_NAME,null,Constants.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(TAG, "onCreate: create database");
        //创建数据库
        String createSql = "create table " + Constants.TABLE_NAME +
                "(_id integer primary key autoincrement,userName varchar(30),password varchar(32)," +
                "sex varchar(5),age integer)";
        db.execSQL(createSql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
