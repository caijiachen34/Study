package com.cjc.rxjava.android_rx;

import android.drm.DrmStore;
import android.util.Log;


import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by CC
 **/
public class RxUtils {
    private static final String TAG = RxUtils.class.getSimpleName();

    public static void createObserable() {
        //定义被观察者
        Observable<String> observable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                if (!subscriber.isUnsubscribed()) {
                    subscriber.onNext("111");
                    subscriber.onNext("222");
                    subscriber.onNext("333");
                    subscriber.onNext("444");
                    subscriber.onCompleted();
                }
            }
        });

        Subscriber<String> showsub = new Subscriber<String>() {

            @Override
            public void onCompleted() {
                Log.d(TAG, "onCompleted: ");
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError: " + e.getMessage());
            }

            @Override
            public void onNext(String s) {
                Log.d(TAG, "onNext: " + s);
            }
        };
        //关联被观察者
        observable.subscribe(showsub);
    }

    public static String downloadJson() {
        return "json data";
    }

    public static void createPrint() {
        Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                if (!subscriber.isUnsubscribed()) {
                    for (int i = 0; i < 10; i++) {
                        subscriber.onNext(i);
                    }
                }
            }
        }).subscribe(new Subscriber<Integer>() {

            @Override
            public void onCompleted() {
                Log.d(TAG, "onCompleted: ");
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError: " + e.getMessage());
            }

            @Override
            public void onNext(Integer integer) {
                Log.d(TAG, "onNext: " + integer);
            }
        });
    }

    //使用在被观察者,返回的对象一般都是数据类型
    public static void from() {
        Integer[] items = {1, 2, 3, 4, 5, 6, 7};
        Observable observable = Observable.from(items);
        observable.subscribe(new Action1() {
            @Override
            public void call(Object o) {
                Log.d(TAG, "call: " + o.toString());
            }
        });
    }

    //指定某一时刻发送数据
    public static void interval() {
        Integer[] items = {1, 2, 3, 4, 5};
        Observable observable = Observable.interval(1, 1, TimeUnit.SECONDS);
        observable.subscribe(new Action1() {
            @Override
            public void call(Object o) {
                Log.d(TAG, "call: " + o.toString());
            }
        });
    }


    //处理数组集合
    public static void just() {
        Integer[] item1 = {1, 2, 3, 4};
        Integer[] item2 = {5, 6, 7, 8};
        Observable observable = Observable.just(item1, item2);
        observable.subscribe(new Subscriber<Integer[]>() {
            @Override
            public void onCompleted() {
                Log.d(TAG, "onCompleted: ");
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError: " + e.getMessage());
            }

            @Override
            public void onNext(Integer[] o) {
                for (int i = 0; i < o.length; i++) {
                    Log.d(TAG, "onNext: " + o[i]);
                }
            }
        });
    }


    public static void range() {
        Observable observable = Observable.range(1, 40);
        observable.subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {
                Log.d(TAG, "onCompleted: ");
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError: " + e.getMessage());
            }

            @Override
            public void onNext(Integer o) {
                Log.d(TAG, "onNext: " + o);
            }
        });
    }

    public static void filter() {
        Observable observable = Observable.just(1, 2, 3, 4, 5, 6, 7, 8);
        observable.filter(new Func1<Integer,Boolean>() {
            @Override
            public Boolean call(Integer o) {
                return o<5;
            }
        }).observeOn(Schedulers.io()).subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Integer o) {
                Log.d(TAG, "onNext: " + o);
            }
        });
    }
}
