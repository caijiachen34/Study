package com.cjc.rxjava.rx_java2;

import java.util.Observable;

/**
 * Created by CC
 **/
public class SimpleObservable extends Observable {

    private int data = 0;

    public int getData() {
        return data;
    }

    public void setData(int i) {
        if (this.data!=i) {
            this.data = i;
            setChanged();//发生改变
            notifyObservers();//通知观察者，表示状态改变
        }
    }
}
