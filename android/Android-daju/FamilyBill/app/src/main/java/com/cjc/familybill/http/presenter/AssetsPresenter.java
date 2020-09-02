package com.cjc.familybill.http.presenter;

import com.cjc.familybill.entity.AssetsEntity;
import com.cjc.familybill.http.HttpMethods;
import com.cjc.familybill.http.api.AssetsService;

import java.util.List;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by CC
 **/
public class AssetsPresenter extends HttpMethods {

        public static void findAll(Subscriber<List<AssetsEntity>> subscriber){
            Observable<List<AssetsEntity>> observable = assetsService.findAll()
                    .map(new HttpResultFunc<List<AssetsEntity>>());
            toSubscribeAsync(observable,subscriber);
        }

}
