package com.cjc.networkdemo.utils;

import com.cjc.networkdemo.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by CC
 **/
public class RetrofitManager {
    //使用Builder模式实例化Retrofit对象
    public static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())  //json数据映射为实体类
            .build();

    public static Retrofit getRetrofit(){
        return retrofit;
    }
}
