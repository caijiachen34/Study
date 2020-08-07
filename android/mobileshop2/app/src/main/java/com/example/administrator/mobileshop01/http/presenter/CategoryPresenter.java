package com.example.administrator.mobileshop01.http.presenter;

import com.example.administrator.mobileshop01.entity.CategoryEntity;
import com.example.administrator.mobileshop01.entity.MemberEntity;
import com.example.administrator.mobileshop01.http.HttpMethods;

import java.util.List;

import rx.Observable;
import rx.Subscriber;

public class CategoryPresenter extends HttpMethods {
    //获取一级分类列表
    public static void getTopList(Subscriber<List<CategoryEntity>> subscriber) {
        Observable<List<CategoryEntity>> observable = categoryService.getTopList()
                .map(new HttpResultFunc<List<CategoryEntity>>());
        toSubscribe(observable, subscriber);
    }

    //获取二级分类列表
    public static void getSecondList(Subscriber subscriber, int parentId) {
        Observable<List<CategoryEntity>> observable = categoryService.getSecondList(parentId)
                .map(new HttpResultFunc<List<CategoryEntity>>());
        toSubscribe(observable, subscriber);
    }
}
