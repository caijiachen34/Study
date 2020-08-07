package com.example.administrator.mobileshop01.http.server;

import com.example.administrator.mobileshop01.entity.CategoryEntity;
import com.example.administrator.mobileshop01.entity.HttpResult;
import com.example.administrator.mobileshop01.entity.MemberEntity;

import java.util.List;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import rx.Observable;


public interface CategoryService {
    //加载一级分类
    @GET("cat/show")
    Observable<HttpResult<List<CategoryEntity>>> getTopList();

    //加载二级分类
    @GET("cat/show/{parentId}")
    Observable<HttpResult<List<CategoryEntity>>> getSecondList(
            @Path("parentId") int parentId
    );
}
