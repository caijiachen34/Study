package com.cjc.familybill.entity;

import com.google.gson.annotations.JsonAdapter;

import java.sql.Timestamp;

/**
 * Created by CC
 **/
public class AccountEntity {

    /**
     * account_id : 1
     * uname : 888
     * accountMoney : 1000
     * accountType : 饮食
     * payType : 支出
     * assetsType : 支付宝
     * time : 2020-09-01 16:04:58
     * remarks : 黄焖鸡
     * sum : null
     */

    private int account_id;
    private String uname;
    private Double accountMoney;
    private String accountType;
    private String payType;
    private String assetsType;
    private String time;
    private String remarks;
    private Double sum;

    @Override
    public String toString() {
        return "AccountEntity{" +
                "account_id=" + account_id +
                ", uname='" + uname + '\'' +
                ", accountMoney=" + accountMoney +
                ", accountType='" + accountType + '\'' +
                ", payType='" + payType + '\'' +
                ", assetsType='" + assetsType + '\'' +
                ", time=" + time +
                ", remarks='" + remarks + '\'' +
                ", sum=" + sum +
                '}';
    }


    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public Double getAccountMoney() {
        return accountMoney;
    }

    public void setAccountMoney(Double accountMoney) {
        this.accountMoney = accountMoney;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getAssetsType() {
        return assetsType;
    }

    public void setAssetsType(String assetsType) {
        this.assetsType = assetsType;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }
}
