package com.cjc.ouxun.http;

import android.util.Log;


import com.cjc.ouxun.entity.HttpResult;
import com.cjc.ouxun.http.api.UserService;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

import static com.cjc.ouxun.utils.Constants.BASE_URL;


/**
 * Created by CC
 **/
public class HttpMethods {
    private static final String TAG = "HttpMethods";
    private static HttpMethods mInstance;
    private static final int DEFAULT_TIMEOUT = 5;
    private Retrofit retrofit;

    //用户信息接口
    protected static UserService userService;

    public HttpMethods() {
        Log.d(TAG, "mInstance: " + mInstance);
        if (mInstance == null) {
            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                    .readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                    .writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                    .build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .client(okHttpClient)
                    .build();

            userService = retrofit.create(UserService.class);
        }
    }

    public static HttpMethods getInstance() {
        if (mInstance == null) {
            synchronized (HttpMethods.class) {
                if (mInstance == null) {
                    mInstance = new HttpMethods();
                }
            }
        }
        return mInstance;
    }

    public static class HttpResultFunc<T> implements Func1<HttpResult<T>, T> {

        @Override
        public T call(HttpResult<T> httpResult) {
            Log.i(TAG, "status:" + httpResult.isFlag());
            Log.i(TAG, "msg:" + httpResult.getApiUrl());
            Log.i(TAG, "msg:" + httpResult.getAesKey());
            Log.i(TAG, "data:" + httpResult.getData());
            return httpResult.getData();
        }
    }

    public static class HttpResultFunc2<T> implements Func1<HttpResult<T>, HttpResult> {
        @Override
        public HttpResult call(HttpResult<T> httpResult) {
            Log.i(TAG, "flag:" + httpResult.isFlag());
            Log.i(TAG, "url:" + httpResult.getApiUrl());
            Log.i(TAG, "key:" + httpResult.getAesKey());
            Log.i(TAG, "data:" + httpResult.getData());
            return httpResult;
        }
    }

    //异步订阅
    public static <T> void toSubscribeAsync(Observable<T> o, Subscriber<T> s) {
        o.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s);
    }

    //同步订阅
    public static <T> void toSubscribeSync(Observable<T> o, Subscriber<T> s) {
        o.subscribeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s);
    }

}
