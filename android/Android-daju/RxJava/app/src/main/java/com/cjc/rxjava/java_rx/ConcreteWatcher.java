package com.cjc.rxjava.java_rx;

/**
 * Created by CC
 **/
public class ConcreteWatcher implements Watcher {
    @Override
    public void update(String str) {
        System.out.println(str);
    }
}
