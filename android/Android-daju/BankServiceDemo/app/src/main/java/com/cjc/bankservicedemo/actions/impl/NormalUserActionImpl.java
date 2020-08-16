package com.cjc.bankservicedemo.actions.impl;

import android.os.Binder;
import android.util.Log;

import com.cjc.bankservicedemo.actions.interfaces.INormalUserAction;

/**
 * Created by CC
 **/
public class NormalUserActionImpl extends Binder implements INormalUserAction {

    private static final String TAG = "NormalUserImpl";

    @Override
    public void saveMoney(float money) {
        Log.d(TAG, "savemoney ===>>> " + money);
    }

    @Override
    public float getMoney() {
        Log.d(TAG, "getmoney ===>>> 100.00");
        return 100.00f;
    }

    @Override
    public float loanMoney() {
        Log.d(TAG, "loanmoney ===>>> 100.00" );
        return 100.00f;
    }
}
