package com.cjc.alipay;

interface ThridPartPayResult {
    void onPaySuccess();

    void onPayFailed(in int errorCode,in String msg);
}
