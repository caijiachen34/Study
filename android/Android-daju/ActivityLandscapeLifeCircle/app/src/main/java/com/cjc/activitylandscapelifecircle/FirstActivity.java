package com.cjc.activitylandscapelifecircle;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

import androidx.appcompat.app.AppCompatActivity;


/*
* 任务栈：先进后出：
* 队列：先进后出
*
* 1.standard模式：android:launchMode="standard"
* 创建新的任务，置于栈顶。当我们返回的时候，就是销毁当前任务，也就是出栈
* 创建了多少个，就点多少次返回
* 使用场景：大多数场景，如果不配置，默认就是用此模式
*
* 2.singleTop模式: android:launchMode="singleTop"
* 如果栈顶已经是当前任务了，就不会创建新任务
* 使用场景：一般来说，为保证只有一个任务，而不被创建多个，所有就需要这种模式
* 比如我们的浏览器书签，应用通知推送
*
* 3.singleTask模式: android:launchMode="singleTask"
* 如果要创建的任务没有，就会创建任务，并且放在栈顶
* 如果要创建的任务已经存在，就会把这个任务以上的任务全部移除，
* 使得当前任务成为最顶部的任务
* 使用场景:当任务占的资源比较大时，就使用singleTask
*
* 4.singleInstance模式: android:launchMode="singleInstance"
*  singleInstance的特点：前面三种启动模式，都在同一个任务栈，
*  但是singleInstance很特别，他是独立一个任务栈
*  使用场景：在整个系统中只有一个唯一实例。
*
* */
public class FirstActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private Button openfirst;
    private Button opensecond;
    private Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        initView();
        initListener();
        context = getApplicationContext();
    }

    private void initView() {
        openfirst = findViewById(R.id.openfirst);
        opensecond = findViewById(R.id.opensecond);
    }

    private void initListener() {
        openfirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,FirstActivity.class);


                startActivity(intent);
            }
        });
        opensecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,SecondActiviry.class);


                startActivity(intent);
            }
        });
    }

}