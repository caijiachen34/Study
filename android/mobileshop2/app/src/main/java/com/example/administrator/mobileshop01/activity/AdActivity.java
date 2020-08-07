package com.example.administrator.mobileshop01.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.administrator.mobileshop01.R;
import com.example.administrator.mobileshop01.common.Constants;
import com.example.administrator.mobileshop01.common.ImageLoaderManager;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

public class AdActivity extends AppCompatActivity {
    private ImageView adImage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad);
        adImage=findViewById(R.id.ad_image);
        loadAd("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1592243790929&di=26fd6ab2f0b835d4d224dee2d4116b05&imgtype=0&src=http%3A%2F%2Fpic1.win4000.com%2Fmobile%2F2019-02-18%2F5c6a6c24c1d09.jpg");

        final Button skipBtn=findViewById(R.id.skip_button);
        skipBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                skip();
            }
        });
    }


    private void loadAd(String url){
        ImageLoader.getInstance().displayImage(url, adImage, ImageLoaderManager.product_options, new ImageLoadingListener() {
            @Override
            public void onLoadingStarted(String imageUri, View view) {

            }

            /**
             * 加载失败直接跳过
             * @param imageUri
             * @param view
             * @param failReason
             */
            @Override
            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
                skip();
            }

            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                adImage.setImageBitmap(loadedImage);
                timer();
            }

            @Override
            public void onLoadingCancelled(String imageUri, View view) {
                skip();
            }
        });
    }

    private void skip(){
        startActivity(new Intent(this,MainActivity.class));
        finish();
    }

    private void timer(){
        final Handler handler=new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if (msg.what==-1){
                    skip();
                }
            }
        };

        new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    Thread.sleep(Constants.AD_TIME_SECOND);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                handler.sendEmptyMessage(-1);
            }
        }.start();
    }
}
