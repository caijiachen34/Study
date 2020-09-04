package com.cjc.familybill.http.presenter;

import com.cjc.familybill.entity.AccountEntity;
import com.cjc.familybill.http.HttpMethods;

import java.util.List;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by CC
 **/
public class AccountPresenter extends HttpMethods {

    public static void queryAccByType(Subscriber<List<AccountEntity>> subscriber, String payType, String uname) {
        Observable<List<AccountEntity>> observable = accountService.queryAccByType(payType,uname)
                .map(new HttpResultFunc<List<AccountEntity>>());
        toSubscribeAsync(observable, subscriber);
    }

    public static void queryAccByUname(Subscriber<List<AccountEntity>> subscriber,String uname) {
        Observable<List<AccountEntity>> observable = accountService.queryAccByUname(uname)
                .map(new HttpResultFunc<List<AccountEntity>>());
        toSubscribeAsync(observable, subscriber);
    }

    public static void saveAccount(Subscriber<List<AccountEntity>> subscriber,String uname, Double accountMoney, String accountType, String payType, String assetsType,  String remarks) {
        Observable<List<AccountEntity>> observable = accountService.saveAccount(uname, accountMoney, accountType, payType, assetsType, remarks)
                .map(new HttpResultFunc<List<AccountEntity>>());
        toSubscribeAsync(observable, subscriber);
    }

}
