package com.example.administrator.mobileshop01.http;

import android.util.Log;

import com.example.administrator.mobileshop01.common.Constants;
import com.example.administrator.mobileshop01.db.Category;
import com.example.administrator.mobileshop01.entity.HttpResult;
import com.example.administrator.mobileshop01.http.server.CategoryService;
import com.example.administrator.mobileshop01.http.server.GoodsService;
import com.example.administrator.mobileshop01.http.server.MemberService;
import com.google.gson.Gson;

import java.security.acl.LastOwnerException;
import java.util.concurrent.TimeUnit;


import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class HttpMethods {
    protected static  final String BASE_URL= Constants.BASE_URL;
    private static final int DEFAULT_TIMEOUT=5;
    protected static final String TAG="HTTP_METHODS";
    private Retrofit retrofit;
    private static HttpMethods mInstance;
    //用户信息接口
    protected static MemberService memberService;

    //商品分类接口
    protected static CategoryService categoryService;

    /**
     * 所有服务端访问接口都可以在这里初始化
     */
    //Goods接口
    protected static GoodsService goodsService;

    public HttpMethods(){
        if(mInstance==null){
            OkHttpClient okHttpClient= new OkHttpClient.Builder()
                    .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                    .readTimeout(DEFAULT_TIMEOUT,TimeUnit.SECONDS)
                    .writeTimeout(DEFAULT_TIMEOUT,TimeUnit.SECONDS)
                    .build();
            retrofit=new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .client(okHttpClient)
                    .build();
            memberService=retrofit.create(MemberService.class);
            goodsService=retrofit.create(GoodsService.class);
            categoryService=retrofit.create(CategoryService.class);
        }
    }

    public static HttpMethods getInstance(){
        if (mInstance==null){
            synchronized (HttpMethods.class){
                if (mInstance==null){
                    mInstance=new HttpMethods();
                }
            }
        }
        return mInstance;
    }

    public static class HttpResultFunc<T> implements Func1<HttpResult<T>, T> {
        @Override
        public T call(HttpResult<T> httpResult) {
            Log.i(TAG, "status:" + httpResult.getStatus());
            Log.i(TAG, "msg:" + httpResult.getMsg());
            Log.i(TAG, "data:" + httpResult.getData());
            return httpResult.getData();
        }
    }

    public static <T> void toSubscribe(Observable<T> o, Subscriber<T> s){
        o.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s);
    }
}
