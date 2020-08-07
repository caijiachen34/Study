package com.cjc.transcationdemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.zip.DataFormatException;

/**
 * Created by CC
 **/

@RunWith(AndroidJUnit4.class)
public class TestDatabase {
    private static final String TAG = "TestDatabase";
    Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();


    @Test
    public void testDatabase(){
        DataBaseHelper helper = new DataBaseHelper(appContext);
        helper.getReadableDatabase();
    }

    @Test
    public void testInsert(){
        DataBaseHelper helper = new DataBaseHelper(appContext);
        SQLiteDatabase db = helper.getReadableDatabase();
        long start = System.currentTimeMillis();
        ContentValues values = new ContentValues();
        values.put("_id",1);
        values.put("name","cjc1");
        values.put("money",110);

        //开启事务 插入3000条耗时296ms
        //不开启耗时11835ms
        db.beginTransaction();

        for (int i = 0; i < 3000; i++) {
            db.insert("account",null,values);
        }
        //关闭事务
        db.endTransaction();

        Log.d(TAG, "testInsert: useTime==="+(System.currentTimeMillis() - start));

        db.close();
    }

    @Test
    public void testUpdate(){
        DataBaseHelper helper = new DataBaseHelper(appContext);
        SQLiteDatabase db = helper.getReadableDatabase();

        db.beginTransaction();
        try {
            //发生异常
            //int i = 10 / 0;
            ContentValues values = new ContentValues();
            values.put("money",9999);
            db.update("account",values,"_id = ?",new String[]{"2"});
            db.setTransactionSuccessful();
            Log.d(TAG, "testUpdate: =====>>> 事务正常");

        } catch (Exception e){
            //处理异常
            Log.d(TAG, "testUpdate: =====>>> 发生异常");
            Log.d(TAG, "testUpdate: " +e);
        }finally {
            db.endTransaction();
            db.close();
        }

    }
}
