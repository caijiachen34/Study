package com.cjc.rxjava.rx_android_demo.api;

import com.cjc.rxjava.rx_android_demo2.entity.LoginResult;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/**
 * Created by CC
 **/
public interface API {
    //文件下载
    @Streaming
    @GET
    Call<ResponseBody> downFile(@Url String url);

    @FormUrlEncoded
    @POST("member/login")
    Call<LoginResult> login(@Field("uname") String username,@Field("password") String password);
}
