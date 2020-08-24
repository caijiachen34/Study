package com.cjc.rxjava.java_rx;

/**
 * Created by CC
 **/
public interface Watched {

    public void addWatcher(Watcher watcher);

    public void removeWatcher(Watcher watcher);

    public void notifyWatchers(String str);
}
