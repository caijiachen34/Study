package com.cjc.familybill.utils;

import android.app.Activity;

import com.cjc.familybill.activitys.BaseActivity;
import com.cjc.familybill.entity.AssetsEntity;
import com.cjc.familybill.http.presenter.AssetsPresenter;
import com.google.gson.internal.$Gson$Preconditions;

import java.util.List;

import rx.Subscriber;

/**
 * Created by CC
 **/
public class InsertRemain {


    public static Double InsertRemain(String uname, String assetsType) {
        final Double[] remain = new Double[1];

        AssetsPresenter.queryAssRemain(new Subscriber<List<AssetsEntity>>() {



            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(List<AssetsEntity> assetsEntities) {
                remain[0] = assetsEntities.get(0).getMoneyRemain();
            }
        }, uname, assetsType);
        return remain[0];
    }
}
