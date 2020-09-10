package com.cjc.ouxun.http.presenter;



import android.util.Log;

import com.cjc.ouxun.entity.UserEntity;
import com.cjc.ouxun.http.ProgressDialogSubscriber;
import com.cjc.ouxun.entity.HttpResult;
import com.cjc.ouxun.http.HttpMethods;

import rx.Observable;

/**
 * Created by CC
 **/
public class UserPresenter extends HttpMethods {

    public static void login(ProgressDialogSubscriber<UserEntity> subscriber, String username, String password) {
        HttpMethods instance = getInstance();
        Log.d("UserPresenter", "login: " + instance);
        Observable observable = userService.login(username, password)
                .map(new HttpResultFunc<UserEntity>());
        toSubscribeAsync(observable, subscriber);//订阅
    }


}
