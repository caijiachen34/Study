package com.cjc.familybill.http.presenter;

import com.cjc.familybill.entity.MemberEntity;
import com.cjc.familybill.http.HttpMethods;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by CC
 **/
public class MemberPresenter extends HttpMethods {

    public static void register(Subscriber<MemberEntity> subscriber,String username,String password,String email,String mobile){
        Observable observable = memberService.register(username,password,email,mobile)
                .map(new HttpResultFunc<MemberEntity>());
        toSubscribe(observable,subscriber);
    }

    public static void login(Subscriber<MemberEntity> subscriber, String username, String password) {
        Observable observable = memberService.login(username, password)
                .map(new HttpResultFunc<MemberEntity>());//创建观察者
        toSubscribe(observable, subscriber);//订阅
    }

}
