package com.cjc.rxjava.rx_java2;

/**
 * Created by CC
 **/
public class MyTest {
    public static void main(String[] args) {
        SimpleObservable Observable = new SimpleObservable();
        SimpleObserver Observer = new SimpleObserver(Observable);

        Observable.setData(1);
        Observable.setData(2);
        //若结果为变化，则不通知观察者
        Observable.setData(2);
        Observable.setData(3);

    }
}
