package com.cjc.networkdemo.retrofit;

import com.cjc.networkdemo.domain.CommentItem;
import com.cjc.networkdemo.domain.GetTextItem;
import com.cjc.networkdemo.domain.GetWithParamsResult;
import com.cjc.networkdemo.domain.PostWithParamsResult;

import java.util.List;
import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/**
 * Created by CC
 **/
public interface API {

    @GET("/get/text")
    Call<GetTextItem> getJson();

    @GET("/get/param")
    Call<GetWithParamsResult> getWithParams(
            @Query("keyword")String keyword,
            @Query("page")Integer page,
            @Query("order")String order);

    @GET("/get/param")
    Call<GetWithParamsResult> getWithParams(
            @QueryMap Map<String, Object> params);


    @POST("/post/string")
    Call<PostWithParamsResult> postWithParams(
            @Query("string")String content);

    @POST
    Call<PostWithParamsResult> postWithUrl(@Url String url);

    @POST("/post/comment")
    Call<PostWithParamsResult> postWithBody(@Body CommentItem commentItem);

    //单文件上传
    @Multipart
    @POST("/file/upload")
    Call<PostWithParamsResult> postFile(@Part MultipartBody.Part part);

    //多文件上传
    @Multipart
    @POST("/files/upload")
    Call<PostWithParamsResult> postFiles(@Part List<MultipartBody.Part> parts);

    @Multipart
    @POST("/file/params/upload")
    Call<PostWithParamsResult> postFileWithParams(@Part MultipartBody.Part part, @PartMap Map<String,String> params);

    //提交表单：如登录
    @FormUrlEncoded
    @POST("/login")
    Call<PostWithParamsResult> dologin(@Field("userName")String userName,@Field("password")String word);

    //Map提交表单
    @FormUrlEncoded
    @POST("/login")
    Call<PostWithParamsResult> dologin(@FieldMap Map<String,String> params);

    //文件下载
    @Streaming
    @GET
    Call<ResponseBody> downFile(@Url String url);

}
