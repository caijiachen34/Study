package com.cjc.ouxun.http;

import com.cjc.ouxun.utils.Constants;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by CC
 **/
public class RetrofitManager {
    //使用Builder模式实例化Retrofit对象
    public static OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .connectTimeout(5, TimeUnit.SECONDS)
            .readTimeout(5,TimeUnit.SECONDS)
            .writeTimeout(5,TimeUnit.SECONDS)
            .build();
    public static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())  //json数据映射为实体类
            .client(okHttpClient)
            .build();

    public static Retrofit getRetrofit(){
        return retrofit;
    }
}
