package com.example.administrator.mobileshop01.http.server;



import com.example.administrator.mobileshop01.entity.GoodsEntity;
import com.example.administrator.mobileshop01.entity.HttpResult;
import com.example.administrator.mobileshop01.entity.MemberEntity;
import com.example.administrator.mobileshop01.utils.JsonResult;
import com.example.administrator.mobileshop01.utils.JsonResultGet;
import com.example.administrator.mobileshop01.utils.JsonResultPost;
import com.example.administrator.mobileshop01.utils.PostWithUrl;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;
import rx.Observable;

// http://v.juhe.cn/toutiao/index?type=keji&key=f3c68b23dc99865f20120175607e2adc
public interface GoodsService {
    @GET("/toutiao/index") //设置该接口为Get请求方式，请求接口名为goods，需要传递参数goods。需要传递数据为page，count
    Call<JsonResult>getJson(
            @Query("type") String type,
            @Query("key") String key
            );

    @GET("/toutiao/index")
    Call<JsonResultGet> getJson2(@QueryMap Map<String,String>params);

    @POST("/toutiao/index")
    Call<JsonResultPost> postJson(@QueryMap Map<String,String>params);

    @POST
    Call<PostWithUrl>PostWithUrl(@Url String url);

    @FormUrlEncoded
    @POST
    Call<PostWithUrl>PostWithForm(@FieldMap Map<String,String> params);


    @GET("goods/cat/{catId}")
    Observable<HttpResult<List<GoodsEntity>>> list(
            @Path("catId") int catId
    );
}
