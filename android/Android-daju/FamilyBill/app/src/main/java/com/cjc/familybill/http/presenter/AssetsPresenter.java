package com.cjc.familybill.http.presenter;

import com.cjc.familybill.entity.AssetsEntity;
import com.cjc.familybill.http.HttpMethods;

import java.util.List;

import retrofit2.http.Field;
import rx.Observable;
import rx.Subscriber;

/**
 * Created by CC
 **/
public class AssetsPresenter extends HttpMethods {

    public static void findAllByUname(Subscriber<List<AssetsEntity>> subscriber, String uname) {
        Observable<List<AssetsEntity>> observable = assetsService.findAllByUname(uname)
                .map(new HttpResultFunc<List<AssetsEntity>>());
        toSubscribeAsync(observable, subscriber);
    }

    public static void queryAssSum(Subscriber<List<AssetsEntity>> subscriber, String uname) {
        Observable<List<AssetsEntity>> observable = assetsService.queryAssSum(uname)
                .map(new HttpResultFunc<List<AssetsEntity>>());
        toSubscribeAsync(observable, subscriber);
    }

    public static void saveAssets(Subscriber<List<AssetsEntity>> subscriber, String uname, String assetsType, Double assetsMoney, String remarks) {
        Observable<List<AssetsEntity>> observable = assetsService.saveAssets(uname, assetsType, assetsMoney, remarks)
                .map(new HttpResultFunc<List<AssetsEntity>>());
        toSubscribeAsync(observable, subscriber);
    }

    public static void updateAssById(Subscriber<List<AssetsEntity>> subscriber, int assets_id, String assetsType, Double assetsMoney, String remarks) {
        Observable<List<AssetsEntity>> observable = assetsService.updateAssById(assets_id, assetsType, assetsMoney, remarks)
                .map(new HttpResultFunc<List<AssetsEntity>>());
        toSubscribeAsync(observable, subscriber);
    }

    public static void deleteAssById(Subscriber<List<AssetsEntity>> subscriber, int assets_id) {
        Observable<List<AssetsEntity>> observable = assetsService.deleteAssById(assets_id)
                .map(new HttpResultFunc<List<AssetsEntity>>());
        toSubscribeAsync(observable, subscriber);
    }

    public static void queryAssById(Subscriber<List<AssetsEntity>> subscriber, int assets_id) {
        Observable<List<AssetsEntity>> observable = assetsService.queryAssById(assets_id)
                .map(new HttpResultFunc<List<AssetsEntity>>());
        toSubscribeAsync(observable, subscriber);
    }

    public static void queryAssRemain(Subscriber<List<AssetsEntity>> subscriber, String uname, String assetsType) {
        Observable<List<AssetsEntity>> observable = assetsService.queryAssRemain(uname,assetsType)
                .map(new HttpResultFunc<List<AssetsEntity>>());
        toSubscribeAsync(observable, subscriber);
    }
}
