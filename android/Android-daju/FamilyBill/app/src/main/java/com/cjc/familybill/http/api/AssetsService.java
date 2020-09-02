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

    //注册接口
    @POST("assets/findAll")
    Observable<HttpResult<List<AssetsEntity>>> findAll();
}
