package com.cjc.familybill.http.api;

import com.cjc.familybill.entity.AssetsEntity;
import com.cjc.familybill.entity.HttpResult;
import com.cjc.familybill.entity.MemberEntity;

import java.util.List;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by CC
 **/
public interface AssetsService {

    //根据uname查账户
    @FormUrlEncoded
    @POST("assets/findAllByUname")
    Observable<HttpResult<List<AssetsEntity>>> findAllByUname(@Field("uname") String uname);

    @FormUrlEncoded
    @POST("assets/queryAssSum")
    Observable<HttpResult<List<AssetsEntity>>> queryAssSum(@Field("uname") String uname);


    @FormUrlEncoded
    @POST("assets")
    Observable<HttpResult<List<AssetsEntity>>> saveAssets(
            @Field("uname") String uname,
            @Field("assetsType") String assetsType,
            @Field("assetsMoney") Double assetsMoney,
            @Field("remarks") String remarks);


    @FormUrlEncoded
    @POST("assets/updateAssById")
    Observable<HttpResult<List<AssetsEntity>>> updateAssById(
            @Field("assets_id") int assets_id,
            @Field("assetsType") String assetsType,
            @Field("assetsMoney") Double assetsMoney,
            @Field("remarks") String remarks);


    @FormUrlEncoded
    @POST("assets/deleteAssById")
    Observable<HttpResult<List<AssetsEntity>>> deleteAssById(@Field("assets_id") int assets_id);


    @FormUrlEncoded
    @POST("assets/queryAssById")
    Observable<HttpResult<List<AssetsEntity>>> queryAssById(@Field("assets_id") int assets_id);

    @FormUrlEncoded
    @POST("assets/queryAssRemain")
    Observable<HttpResult<List<AssetsEntity>>> queryAssRemain(@Field("uname") String uname,@Field("assetsType") String assetsType);

}
