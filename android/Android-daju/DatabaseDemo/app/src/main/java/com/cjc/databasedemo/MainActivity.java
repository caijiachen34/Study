package com.cjc.databasedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //创建数据库
        DatabaseHelper helper = new DatabaseHelper(this);
        helper.getWritableDatabase();

    }
}