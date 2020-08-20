package com.cjc.testprovider;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;

import java.util.Observer;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ContentResolver contentResolver = getContentResolver();
        Uri uri = Uri.parse("content://cjc");
        //true可以监听content://cjc往后的，比如content://cjc/user
        contentResolver.registerContentObserver(uri, true, new ContentObserver(new Handler()) {
            @Override
            public void onChange(boolean selfChange) {
                super.onChange(selfChange);
                Log.d(TAG, "onChange: 用户数据发生变化");
            }
        });
    }

    //点击事件
    public void getRemoteUsers(View view) {
        ContentResolver contentResolver = getContentResolver();
        //填写规则
        Uri uri = Uri.parse("content://cjc/user");
        Cursor cursor = contentResolver.query(uri, null, null, null, null);
        String[] columnNames = cursor.getColumnNames();
        for (String columnName : columnNames) {
            Log.d(TAG, "columnName ===>>>  " + columnName);
        }

        while (cursor.moveToNext()) {
            Log.d(TAG, "=================================");
            for (String columnName : columnNames) {
                String value = cursor.getString(cursor.getColumnIndex(columnName));

                Log.d(TAG, columnName + "------" + value);

            }
            Log.d(TAG, "=================================");
        }

        cursor.close();


    }


    public void addUser(View view) {
        ContentResolver contentResolver = getContentResolver();
        //填写规则
        Uri uri = Uri.parse("content://cjc/user");
        ContentValues values = new ContentValues();
        values.put("userName","44");
        values.put("password","44");
        values.put("sex","女");
        values.put("age","44");

        contentResolver.insert(uri,values);
    }
}