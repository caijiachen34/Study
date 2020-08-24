package com.cjc.rxjava.rx_android_demo.utils;

import android.util.Log;

import com.cjc.rxjava.rx_android_demo.api.API;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import rx.Observable;
import rx.Subscriber;

/**
 * Created by CC
 **/
public class DownloadUtils {


    private static final String TAG = "DownloadUtils";
    private Retrofit client;

    public DownloadUtils(){
        client = new Retrofit.Builder().baseUrl("http://baidu.com").build();
    }

    public Observable<byte[]> downLoadImage(String path){
        return Observable.create(new Observable.OnSubscribe<byte[]>() {
            @Override
            public void call(Subscriber<? super byte[]> subscriber) {
                if (!subscriber.isUnsubscribed()) {
                    //访问网络操作
                    API api = RetrofitManager.getRetrofit().create(API.class);
                    Call<ResponseBody> task = api.downFile(path);
                    task.enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                            if (response.isSuccessful()) {
                                try {
                                    //Log.d(TAG, "onResponse: " + response.body().string());
                                    byte[] data = response.body().bytes();
                                    if (data != null) {
                                        subscriber.onNext(data);
                                    }
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                            subscriber.onCompleted();
                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable t) {
                            subscriber.onError(t);
                        }
                    });

                }
            }
        });
    }

}
