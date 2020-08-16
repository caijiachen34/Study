package com.cjc.servicedemo.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

import com.cjc.servicedemo.presenter.PlayerPresenter;

/**
 * Created by CC
 **/
public class PlayerService extends Service {

    private static final String TAG = "PlayerService";
    private PlayerPresenter mPlayerPresenter;

    @Override
    public void onCreate() {
        Log.d(TAG, "onCreate: ");
        super.onCreate();
        if (mPlayerPresenter == null) {
            mPlayerPresenter = new PlayerPresenter();
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mPlayerPresenter;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPlayerPresenter != null) {
            mPlayerPresenter = null;
        }
    }
}
