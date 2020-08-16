package com.cjc.bankservicedemo.actions.interfaces;

/**
 * Created by CC
 **/
public interface IBankBossAction extends IBankWorkerAction {
    //修改用户账户金额
    void modifyUserAccountMoney(float money);
}
