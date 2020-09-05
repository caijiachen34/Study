package com.cjc.familybill.http.api;

import com.cjc.familybill.entity.AccountEntity;
import com.cjc.familybill.entity.AssetsEntity;
import com.cjc.familybill.entity.HttpResult;

import java.util.List;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by CC
 **/
public interface AccountService {

    @FormUrlEncoded
    @POST("account")
    Observable<HttpResult<List<AccountEntity>>> saveAccount(
            @Field("uname") String uname,
            @Field("accountMoney") Double accountMoney,
            @Field("accountType") String accountType,
            @Field("payType") String payType,
            @Field("assetsType") String assetsType,
            @Field("remarks") String remarks);

    @FormUrlEncoded
    @POST("account/queryAccByType")
    Observable<HttpResult<List<AccountEntity>>> queryAccByType(@Field("payType") String payType, @Field("uname") String uname);

    @FormUrlEncoded
    @POST("account/queryAccByUname")
    Observable<HttpResult<List<AccountEntity>>> queryAccByUname(@Field("uname") String uname);



    @FormUrlEncoded
    @POST("account/delete")
    Observable<HttpResult<List<AccountEntity>>> deleteAccount(@Field("account_id") int account_id);


    @FormUrlEncoded
    @POST("account/updateById")
    Observable<HttpResult<List<AccountEntity>>> updateById(
            @Field("account_id") int account_id,
            @Field("accountMoney") Double accountMoney,
            @Field("accountType") String accountType,
            @Field("payType") String payType,
            @Field("assetsType") String assetsType,
            @Field("remarks") String remarks);


    @FormUrlEncoded
    @POST("account/queryAccById")
    Observable<HttpResult<List<AccountEntity>>> queryAccById(@Field("account_id") int account_id);


}
