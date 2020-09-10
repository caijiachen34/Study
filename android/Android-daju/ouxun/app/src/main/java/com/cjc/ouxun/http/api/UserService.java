package com.cjc.ouxun.http.api;



import com.cjc.ouxun.entity.HttpResult;
import com.cjc.ouxun.entity.UserEntity;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by CC
 **/
public interface UserService {

    //登录接口
    @GET("user/checklogin")
    Observable<HttpResult<UserEntity>> login(@Query("username") String username, @Query("password") String password);



}
