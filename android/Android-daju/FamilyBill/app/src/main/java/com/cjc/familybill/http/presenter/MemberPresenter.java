package com.cjc.familybill.http.presenter;

import com.cjc.familybill.entity.HttpResult;
import com.cjc.familybill.entity.MemberEntity;
import com.cjc.familybill.http.HttpMethods;
import com.cjc.familybill.http.ProgressDialogSubscriber;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by CC
 **/
public class MemberPresenter extends HttpMethods {

//    public static void register(Subscriber<MemberEntity> subscriber,String username,String password,String email,String mobile){
//        Observable observable = memberService.register(username,password,email,mobile)
//                .map(new HttpResultFunc<MemberEntity>());
//        toSubscribeAsync(observable,subscriber);
//    }

    public static void register(ProgressDialogSubscriber<HttpResult> subscriber, String username, String password, String email, String mobile){
        Observable observable = memberService.register(username,password,email,mobile)
                .map(new HttpResultFunc2<MemberEntity>());
        toSubscribeAsync(observable,subscriber);
    }

    public static void login(ProgressDialogSubscriber<HttpResult> subscriber, String username, String password) {
        Observable observable = memberService.login(username, password)
                .map(new HttpResultFunc2<MemberEntity>());
        toSubscribeAsync(observable, subscriber);//订阅
    }

    public static void checkEmailIsUsed(Subscriber<MemberEntity> subscriber, String input, String password) {
        Observable observable = memberService.checkEmailIsUsed(input, password)
                .map(new HttpResultFunc<MemberEntity>());
        toSubscribeAsync(observable, subscriber);//订阅
    }

    public static void check(Subscriber<MemberEntity> subscriber, String input) {
        Observable observable = memberService.check(input)
                .map(new HttpResultFunc<MemberEntity>());
        toSubscribeSync(observable, subscriber);//订阅
    }

    public static void changePassword2(ProgressDialogSubscriber<HttpResult> subscriber, String uname,String oldPwd,String newPwd){
        Observable observable = memberService.changePassword2(uname,oldPwd,newPwd)
                .map(new HttpResultFunc2<MemberEntity>());
        toSubscribeAsync(observable, subscriber);//订阅
    };

}
