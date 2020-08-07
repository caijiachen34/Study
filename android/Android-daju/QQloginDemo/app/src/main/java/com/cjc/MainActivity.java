package com.cjc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

/*
* 安卓直接谢文件名时候去写文件抛出异常是read-only
* 安卓里每一个应用就是一个用户，每个用户权限是特定的，不可操作其他用户的内容
*
* */
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private EditText maccount;
    private EditText mpassword;
    private Button mbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListener();
    }

    private void initListener() {
        mbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"点击了登录按钮");
                handlerLoginEvent(v);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
//        File filesDir = this.getFilesDir();
//        File saveFile = new File(filesDir,"info.text");

        try {
            FileInputStream fileInputStream = this.openFileInput("info.text");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            String info = bufferedReader.readLine();
            //fos.write((accountText+"***"+passwordTest).getBytes());
            //上面是之前保存的形式,要对数据进行切割
            String[] splits = info.split("\\*\\*\\*");
            String account = splits[0];
            String password = splits[1];
            //回显数据
            maccount.setText(account);
            mpassword.setText(password);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //处理登录事件
    private void handlerLoginEvent(View v) {
        //拿到界面的内容
        //账号
        String accountText = maccount.getText().toString();
        String passwordTest = mpassword.getText().toString();

        //在实际开发中需要对账号进行检查
        //判空
//        if (accountText.length()==0) {
//            Toast.makeText(this,"账号不可以为空",Toast.LENGTH_SHORT).show();
//            return;
//        }
//        if (passwordTest.length()==0) {
//            Toast.makeText(this,"密码不可以为空",Toast.LENGTH_SHORT).show();
//            return;
//        }

        if (TextUtils.isEmpty(accountText)) {
            Toast.makeText(this,"账号不能为空..",Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(passwordTest)) {
            Toast.makeText(this,"密码不能为空..",Toast.LENGTH_SHORT).show();
            return;
        }
        if(!TextUtils.isEmpty(accountText)&&!TextUtils.isEmpty(passwordTest)){
            //保存账号和密码
            saveUserInfo(accountText,passwordTest);
            return;
        }

    }

    private void saveUserInfo(String accountText, String passwordTest) {
        Log.d(TAG,"保存用户信息");

        /*
        * 获取缓存路径 cache dir == /data/data/com.cjc/cache
        * this.getCacheDir();
        * */

        //如何获取到保存路径 得到路径为：/data/data/com.cjc/files这个文件夹路径
        File filesDir = this.getFilesDir();
        File saveFile = new File(filesDir,"info.text");
        Log.d(TAG,"files dir ===" + filesDir.toString());

        try {
        if (!saveFile.exists()) {
            saveFile.createNewFile();
        }

            FileOutputStream fos = new FileOutputStream(saveFile);
            //以特定格式存储
            //账号***密码
            fos.write((accountText+"***"+passwordTest).getBytes());

            fos.close();
            Toast.makeText(this,"数据保存成功",Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void initView() {
        maccount = this.findViewById(R.id.et_account);
        mpassword = this.findViewById(R.id.et_password);
        mbutton = this.findViewById(R.id.bt_login);
    }
}