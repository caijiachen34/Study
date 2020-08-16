package com.cjc.bankservicedemo.actions.interfaces;

/**
 * Created by CC
 **/
public interface IBankWorkerAction extends INormalUserAction {
    //查询用户信用
    void checkUserCredit();

    //冻结用户账号
    void freezeUserAccount();
}
