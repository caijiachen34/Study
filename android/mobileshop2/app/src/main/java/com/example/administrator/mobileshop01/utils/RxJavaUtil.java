package com.example.administrator.mobileshop01.utils;


import rx.Observable;
import rx.Observer;
import rx.Subscriber;

public class RxJavaUtil {
    //创建观察者方法1
    Observer<String>observer=new Observer<String>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onNext(String s) {

        }
    };


    //创建观察者方法2
    Subscriber<String>subscriber=new Subscriber<String>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onNext(String s) {

        }
    };

    //创建被观察者
    Observable observable=  Observable.create(new Observable.OnSubscribe<String>() {
        @Override
        public void call(Subscriber<? super String> subscriber) {
            //根据名字先后顺序设置名字任务的执行
            subscriber.onNext("hello1");
            subscriber.onNext("hello2");
            subscriber.onNext("hello3");
            subscriber.onNext("hello4");

            subscriber.onCompleted();
        }
    });

    

}
