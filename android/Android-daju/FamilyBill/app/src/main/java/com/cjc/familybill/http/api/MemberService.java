package com.cjc.familybill.http.api;


import com.cjc.familybill.entity.HttpResult;
import com.cjc.familybill.entity.MemberEntity;
import com.cjc.familybill.http.resultentity.LoginResult;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Streaming;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by CC
 **/
public interface MemberService {

    //注册接口
    @FormUrlEncoded
    @POST("member")
    Observable<HttpResult<MemberEntity>> register(
            @Field("uname") String uname,
            @Field("password") String password,
            @Field("email") String email,
            @Field("mobile") String mobile
    );

    //登录接口
    @FormUrlEncoded
    @POST("member/login")
    Observable<HttpResult<MemberEntity>> login(@Field("uname") String username, @Field("password") String password);

    //检查手机/邮箱是否已注册
    @FormUrlEncoded
    @POST("member/check")
    Observable<HttpResult<MemberEntity>> check(@Field("input") String input);

    @FormUrlEncoded
    @POST("member/login2")
    Observable<HttpResult<MemberEntity>> checkEmailIsUsed(@Field("input") String input, @Field("password") String password);


    //登录接口
    @FormUrlEncoded
    @POST("member/changepassword2")
    Observable<HttpResult<MemberEntity>> changePassword2(@Field("uname") String uname, @Field("oldPwd") String oldPwd, @Field("newPwd") String newPwd);


}
