package com.example.administrator.mobileshop01.http.presenter;

import com.example.administrator.mobileshop01.entity.MemberEntity;
import com.example.administrator.mobileshop01.http.HttpMethods;

import rx.Observable;
import rx.Subscriber;

public class MemberPresenter extends HttpMethods {
    /**
     * 用户注册
     *
     * @param subscriber
     */

    public static void register(Subscriber<MemberEntity> subscriber, String username, String password, String email) {
        Observable observable = memberService.register(username, password, email)
                .map(new HttpResultFunc<MemberEntity>());//创建观察者
        toSubscribe(observable, subscriber);//订阅
    }


    /**
     * 用户登录
     *
     * @param subscriber
     * @param username
     * @param password
     */
    public static void login(Subscriber<MemberEntity> subscriber, String username, String password) {
        Observable observable = memberService.login(username, password)
                .map(new HttpResultFunc<MemberEntity>());
        toSubscribe(observable, subscriber);//订阅
    }


    /**
     * 修改密码和找回密码
     *
     * @param subscriber
     * @param memberId
     * @param old_pwd
     * @param new_pwd
     */
    public static void changePassword(Subscriber subscriber, String memberId, String old_pwd, String new_pwd) {
        Observable observable = memberService.changePassword(memberId, old_pwd, new_pwd);
        toSubscribe(observable, subscriber);//订阅
    }

    public static void findPassword(Subscriber subscriber, String email) {
        Observable observable = memberService.findPassword(email);
        toSubscribe(observable, subscriber);
    }
}
