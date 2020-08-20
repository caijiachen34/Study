package com.cjc.networkdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class PicLoadActivity extends AppCompatActivity {

    private static final String TAG = "PicLoadActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pic_load);
    }

    public void loadPic(View view) {
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    URL url = new URL("https://avatars0.githubusercontent.com/u/1627211?s=60&v=4");
//                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//                    connection.setConnectTimeout(10000);
//                    connection.setRequestMethod("GET");
//                    connection.setRequestProperty("Accept-Language","zh-CN,zh;q=0.9");
//                    connection.setRequestProperty("Accept-Encoding","gzip,deflate");
//                    connection.setRequestProperty("Accept","*/*");
//                    connection.connect();
//                    int responseCode = connection.getResponseCode();
//                    Log.d(TAG, "responseCode ===>>> " + responseCode);
//                    if (responseCode == HttpURLConnection.HTTP_OK) {
//                        InputStream inputStream = connection.getInputStream();
//                        //转成bitmap
//                        final Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
//                        //更新ui
//                        runOnUiThread(new Runnable() {
//                            @Override
//                            public void run() {
//                                ImageView imageView = findViewById(R.id.result_image);
//                                imageView.setImageBitmap(bitmap);
//                            }
//                        });
//
//                    }
//
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }


        BitmapFactory.Options options = new BitmapFactory.Options();
        //计算大小的前提,true则不把图片载入内存
        options.inJustDecodeBounds = true;
        //拿到图片大小
        BitmapFactory.decodeResource(getResources(), R.drawable.test_pic, options);
        ImageView imageView = findViewById(R.id.result_image);
        int outHeight = options.outHeight;
        int outWidth = options.outWidth;

        //拿到控件尺寸
        int measuredHeight = imageView.getMeasuredHeight();
        int measuredWidth = imageView.getMeasuredWidth();

        options.inSampleSize = 1;
        //图片高度/控件高度
        //图片宽度/控件宽度
        //取两者最小值
        if (outHeight > measuredHeight || outWidth > measuredWidth) {
            int subHeight = outHeight / measuredHeight;
            int subWidth = outWidth / measuredWidth;
            options.inSampleSize = subHeight < subWidth ? subHeight : subWidth;
        }
        options.inJustDecodeBounds = false;

        //inSampleSize处理大图片，可将大图片按倍数缩小
        options.inSampleSize = 10;

        runOnUiThread(new Runnable() {
            @Override
            public void run() {

                Bitmap bigImage = BitmapFactory.decodeResource(getResources(), R.drawable.test_pic);
                //根据控件大小，动态计算sample值
                ImageView imageView = findViewById(R.id.result_image);
                imageView.setImageBitmap(bigImage);
            }
        });
//            }
//        }).start();
    }
}