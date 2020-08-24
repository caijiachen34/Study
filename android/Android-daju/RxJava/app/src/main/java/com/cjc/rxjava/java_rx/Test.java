package com.cjc.rxjava.java_rx;

/**
 * Created by CC
 **/
public class Test {
    public static void main(String[] args) {
        Watched xiaoming = new ConcreteWatched();

        Watcher watcher1 = new ConcreteWatcher();
        Watcher watcher2 = new ConcreteWatcher();
        Watcher watcher3 = new ConcreteWatcher();

        xiaoming.addWatcher(watcher1);
        xiaoming.addWatcher(watcher2);
        xiaoming.addWatcher(watcher3);

        xiaoming.notifyWatchers("嘿嘿嘿");

    }
}
