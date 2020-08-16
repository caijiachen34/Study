package com.cjc.bankservicedemo.actions.impl;

import android.os.RemoteException;
import android.util.Log;

import com.cjc.bankservicedemo.NormalUserAction;

/**
 * Created by CC
 **/
public class NormalUserAIDLActionImpl extends NormalUserAction.Stub {


    private static final String TAG = "NormalUserAIDLAction";

    @Override
    public void saveMoney(float money){
        Log.d(TAG, "saveMoney ===>>> " + money);
    }

    @Override
    public float getMoney(){

        return 1000;
    }

    @Override
    public float loanMoney(){
        return 50000;
    }
}
