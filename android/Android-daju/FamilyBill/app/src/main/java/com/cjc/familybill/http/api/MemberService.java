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

    @FormUrlEncoded
    @POST("member/login")
    Observable<HttpResult<MemberEntity>> login(@Field("uname") String username, @Field("password") String password);
}
