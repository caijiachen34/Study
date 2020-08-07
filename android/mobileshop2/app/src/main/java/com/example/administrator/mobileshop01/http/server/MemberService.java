package com.example.administrator.mobileshop01.http.server;

import com.example.administrator.mobileshop01.entity.HttpResult;
import com.example.administrator.mobileshop01.entity.MemberEntity;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import rx.Observable;


public interface MemberService {
    //注册接口
    @FormUrlEncoded
    @POST("member")
    Observable<HttpResult<MemberEntity>> register(
        @Field("uname") String uname,
        @Field("password") String password,
        @Field("email") String email
    );

    //用户登录接口
    @FormUrlEncoded
    @POST("member/login")
    Observable<HttpResult<MemberEntity>> login(
                    @Field("uname") String uname,
                    @Field("password") String password
            );

    //修改密码接口
    @FormUrlEncoded
    @POST("member/{memberId}")
    Observable<HttpResult> changePassword(
            @Path("memberId") String memberId,
            @Field("old_pwd") String old_pwd,
            @Field("new_pwd") String new_pwd
    );

    //找回密码
    @FormUrlEncoded
    @POST("member/pwd")
    Observable<HttpResult> findPassword(
            @Field("email") String email
    );
}
