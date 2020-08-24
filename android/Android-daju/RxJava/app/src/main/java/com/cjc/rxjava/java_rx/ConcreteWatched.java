package com.cjc.rxjava.java_rx;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CC
 **/
public class ConcreteWatched implements Watched {

    private List<Watcher> list = new ArrayList<>();

    @Override
    public void addWatcher(Watcher watcher) {
        list.add(watcher);
    }

    @Override
    public void removeWatcher(Watcher watcher) {
        list.remove(watcher);
    }

    @Override
    public void notifyWatchers(String str) {
        for (Watcher watcher : list) {
            watcher.update(str);
        }
    }
}
