package com.cjc.rxjava.rx_android_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.cjc.rxjava.R;
import com.cjc.rxjava.rx_android_demo.utils.Constants;
import com.cjc.rxjava.rx_android_demo.utils.DownloadUtils;

import rx.Scheduler;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class AsyncActivity extends AppCompatActivity {

    private static final String TAG = "AsyncActivity";
    private Button button;
    private ImageView imageView;
    private DownloadUtils utils;
    String url = "https://dss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1141259048,554497535&fm=26&gp=0.jpg";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async);

        button = findViewById(R.id.button);
        imageView = findViewById(R.id.imageView);
        utils = new DownloadUtils();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                utils.downLoadImage(url).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<byte[]>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG, "onCompleted: ");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: " + e.getMessage());
                    }

                    @Override
                    public void onNext(byte[] bytes) {
                        Bitmap bitmap = BitmapFactory.decodeByteArray(bytes,0,bytes.length);
                        imageView.setImageBitmap(bitmap);
                    }
                });
            }
        });

    }
}