package com.cjc.ouxun.http.presenter;



import android.util.Log;

import com.cjc.ouxun.entity.MemberEntity;
import com.cjc.ouxun.entity.UserEntity;
import com.cjc.ouxun.entity.HttpResult;
import com.cjc.ouxun.http.HttpMethods;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by CC
 **/
public class UserPresenter extends HttpMethods {

    public static void login(Subscriber<UserEntity> subscriber, String username, String password) {
        Observable observable = userService.login(username, password)
                .map(new HttpResultFunc<UserEntity>());
        toSubscribeAsync(observable, subscriber);//订阅
    }


}
