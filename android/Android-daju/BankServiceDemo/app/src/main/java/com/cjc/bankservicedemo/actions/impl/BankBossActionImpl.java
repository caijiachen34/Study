package com.cjc.bankservicedemo.actions.impl;

import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import com.cjc.bankservicedemo.actions.interfaces.IBankBossAction;

/**
 * Created by CC
 **/
public class BankBossActionImpl extends Binder implements IBankBossAction {

    private static final String TAG = "BankBossAction";
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

    @Override
    public void checkUserCredit() {
        Log.d(TAG, "checkUserCredit ===>>> 790 ");
    }

    @Override
    public void freezeUserAccount() {
        Log.d(TAG, "freezeUserAccount ===>>> 0");
    }

    @Override
    public void modifyUserAccountMoney(float money) {
        Log.d(TAG, "modifyUserAccountMoney ===>>> 9999999999999.99" );
    }
}
