package com.cjc.rxjava.rx_java2;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by CC
 **/
public class SimpleObserver implements Observer {

    public SimpleObserver(SimpleObservable observable){
        observable.addObserver(this);
    }

    public void update(Observable observable,Object object){
        System.out.println("data is changed: " + ((SimpleObservable)observable).getData());
    }
}
