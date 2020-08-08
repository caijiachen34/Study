package com.cjc.componentdatadeliver;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.hardware.usb.UsbRequest;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button mbutton;
    private Button mbuttonObject;
    private Button mbuttongo2login;
    private Button mbuttongo2dial;
    private Button buttongo2message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListener();
    }

    private void initView() {
        mbutton = findViewById(R.id.button_go2second);
        mbuttonObject = findViewById(R.id.button_go2secondObject);
        mbuttongo2login = findViewById(R.id.button_go2login);
        mbuttongo2dial = findViewById(R.id.button_go2dial);
        buttongo2message = findViewById(R.id.button_go2message);
    }

    private void initListener() {
        mbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handlerIntent1();
            }
        });
        mbuttonObject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handlerIntent2();
            }
        });
        mbuttongo2login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handlerIntent2Login();
            }
        });
        /* android6.0危险权限需要进行申请
        * PackageManager.PERMISSION_GRANTED为有权限，PackageManager.PERMISSION_DENIED为无权限
        *
        * 步骤：
        * 若电话无权限,则通过ActivityCompat.requestPermissions申请权限，若有权限，则实现相关方法
        * 调用完requestPermissions后弹出权限对话框，询问是否允许权限
        * 再调用onRequestPermissionsResult
        * 若同意了权限则会将权限加入再调用onRequestPermissionsResult方法的grantResults中
        * 若同意权限则实现相关业务，反之提示需要权限
        *
        *
        *
        *  */
        mbuttongo2dial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(MainActivity.this,
                        Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(MainActivity.this,new
                            String[]{Manifest.permission.CALL_PHONE},1);
                }else {
                    handlerIntent2Dial();
                }

            }
        });

        buttongo2message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handlerIntent2Message();
            }
        });
    }

    private void handlerIntent2Message() {
        Intent intent = new Intent();

        intent.setAction("com.cjc.componentdatadeliver.SEND_MSG");
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        intent.putExtra("targetNumberKey","10086");

        //Scheme:msg后面的内容
        Uri uri = Uri.parse("msg:你好，小帅哥");
        intent.setData(uri);

        startActivity(intent);
    }

    /* 打电话给10086 */
    private void handlerIntent2Dial() {
        Intent intent = new Intent();
        //intent.setAction("android.intent.action.CALL");
        //上面可以写成下面这种
        intent.setAction(Intent.ACTION_CALL);
        intent.addCategory("android.intent.category.DEFAULT");

        Uri uri = Uri.parse("tel:10086");
        intent.setData(uri);
        startActivity(intent);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case 1:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    handlerIntent2Dial();
                }else {
                    Toast.makeText(this,"请先允许权限",Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode,permissions,grantResults);
        }
    }

    private void handlerIntent2Login() {
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
    }

    //基本数据类型传送到第二个界面
    private void handlerIntent1() {
        Intent intent = new Intent(this,SecondActivity.class);
        intent.putExtra("intKey",100);
        intent.putExtra("booleanKey",true);
        startActivity(intent);
    }

    //把对象传给第二个界面
    /*
    * 步骤: 1先实现界面跳转
    *       2创建对象对象实现接口Parcelable
    *       3.putExtra一个对象
    *       4.在第二个界面getParcelableExtra
    * */
    private void handlerIntent2() {
        /*
        *
        */
        Intent intent = new Intent(this,SecondActivity.class);

        User user = new User();
        user.setAge(3);
        user.setName("cc");
        user.setTall(181f);

        intent.putExtra("userKey",user);

        //传递Stirng
        intent.putExtra("stringKey","String Value");
        //传递bitMap位图
        Bitmap bitmap = null;
        intent.putExtra("bitmap",bitmap);
        startActivity(intent);

    }

}