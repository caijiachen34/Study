package com.cjc.rxjava.rx_android_demo2.untils;


import android.text.TextUtils;
import android.util.Log;

import com.cjc.rxjava.rx_android_demo.api.API;
import com.cjc.rxjava.rx_android_demo.utils.RetrofitManager;
import com.cjc.rxjava.rx_android_demo2.entity.LoginResult;

import java.net.HttpURLConnection;
import java.util.Map;

import okhttp3.FormBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import rx.Observable;
import rx.Subscriber;

/**
 * Created by CC
 **/
public class LoginUtils {
    private static final String TAG = "LoginUtils";
//    private Retrofit client;
//
//    public LoginUtils(){
//        client = new Retrofit.Builder().baseUrl("http://baidu.com").build();
//    }

    public Observable<String> login(String username,String password){
        return Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                if (!subscriber.isUnsubscribed()) {
                    API api = RetrofitManager.getRetrofit().create(API.class);
                    Call<LoginResult> task = api.login(username, password);
                    task.enqueue(new Callback<LoginResult>() {
                        @Override
                        public void onResponse(Call<LoginResult> call, Response<LoginResult> response) {
                            int code = response.code();
                            Log.d(TAG, "code: " + code);
                            if (code == HttpURLConnection.HTTP_OK) {
                                Log.d(TAG, "onResponse: " + response.body());
                                if (response.body().getData() != null) {
                                Log.d(TAG, "email: " + response.body().getData().getEmail());

                                }
                            }
                        }

                        @Override
                        public void onFailure(Call<LoginResult> call, Throwable t) {
                            Log.d(TAG, "onFailure: " + call.toString());
                            Log.d(TAG, "onFailure: " + t.toString());
                        }
                    });

                }

            }
        });
    }

}
