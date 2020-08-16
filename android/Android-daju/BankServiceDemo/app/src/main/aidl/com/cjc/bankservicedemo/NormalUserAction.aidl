// NormalUserAction.aidl
package com.cjc.bankservicedemo;

// Declare any non-default types here with import statements

interface NormalUserAction {

            //存钱
            void saveMoney(in float money);
            //取钱
            float getMoney();
            //贷款
            float loanMoney();
}
