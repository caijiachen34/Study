package com.example.administrator.mobileshop01.http.presenter;

import com.example.administrator.mobileshop01.entity.GoodsEntity;
import com.example.administrator.mobileshop01.entity.MemberEntity;
import com.example.administrator.mobileshop01.http.HttpMethods;

import java.util.List;

import rx.Observable;
import rx.Subscriber;

public class GoodsPresenter extends HttpMethods {

    public static void list(Subscriber< MemberEntity > subscriber,int catId){
        Observable observable=goodsService.list(catId)
                .map(new HttpResultFunc<List<GoodsEntity>>());//创建观察者
        toSubscribe(observable,subscriber);//订阅
    }


}
