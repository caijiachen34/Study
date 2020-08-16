package com.cjc.alipay;
import com.cjc.alipay.ThridPartPayResult;


interface ThirdPartPayAction {

   /*
   * 发起支付
   */
   void requestPay(String orderInfo,float payMoney,ThridPartPayResult callback);



}
