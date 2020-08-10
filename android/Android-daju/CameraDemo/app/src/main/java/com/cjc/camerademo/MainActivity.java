package com.cjc.camerademo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 1;
    private ImageView resultContainer;
    private ImageView takephotobtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initListener();
    }


    private void initView() {
        resultContainer = findViewById(R.id.iv_photo_result);
        takephotobtn = findViewById(R.id.take_photo);
    }

    private void initListener() {
        takephotobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(MainActivity.this,
                        Manifest.permission.CAMERA)!= PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(MainActivity.this,
                            new String[]{Manifest.permission.CAMERA},1);
                }else {
                    handlertakephoto();
                }

            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                handlertakephoto();
            }else {
                Toast.makeText(this,"请先允许权限",Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void handlertakephoto() {
        //拍照按钮点击后跳转到相机界面
        //startActivityForResult
        Intent intent = new Intent();
        intent.setAction("android.media.action.IMAGE_CAPTURE");
        intent.addCategory(Intent.CATEGORY_DEFAULT);



        startActivityForResult(intent, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK && data!=null) {
                //说明成功返回
                Bitmap result = data.getParcelableExtra("data");
                if (result != null) {
                    resultContainer.setImageBitmap(result);
                }

            }else if (resultCode == Activity.RESULT_CANCELED){
                //取消或者失败
                Toast.makeText(this,"您取消了拍照",Toast.LENGTH_SHORT).show();
            }
        }

    }
}