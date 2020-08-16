package com.cjc.bankservicedemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;

import androidx.annotation.Nullable;

import com.cjc.bankservicedemo.actions.impl.BankBossActionImpl;
import com.cjc.bankservicedemo.actions.impl.BankWorkerActionImp;
import com.cjc.bankservicedemo.actions.impl.NormalUserAIDLActionImpl;
import com.cjc.bankservicedemo.actions.impl.NormalUserActionImpl;

/**
 * Created by CC
 **/
public class BankService extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        String action = intent.getAction();
        if (!TextUtils.isEmpty(action)) {
            if ("com.cjc.ACTION_NORMAL_USER".equals(action)){
                return new NormalUserAIDLActionImpl();
            }else if ("com.cjc.ACTION_BANK_WORKER".equals(action)){
                return new BankWorkerActionImp();
            }else if ("com.cjc.ACTION_BANK_BOSS".equals(action)){
                return new BankBossActionImpl();
            }
        }
        return null;
    }

}
