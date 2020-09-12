package com.cjc.ouxun.entity;

/**
 * Created by CC
 **/
public class HttpResult<T> {
    private boolean flag;
    private String apiUrl;
    private String aesKey;
    private String cust;
    private String errorMsg;
    private T user;

    @Override
    public String toString() {
        return "HttpResult{" +
                "flag=" + flag +
                ", apiUrl='" + apiUrl + '\'' +
                ", aesKey='" + aesKey + '\'' +
                ", cust='" + cust + '\'' +
                ", errorMsg='" + errorMsg + '\'' +
                ", user=" + user +
                '}';
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getApiUrl() {
        return apiUrl;
    }

    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    public String getAesKey() {
        return aesKey;
    }

    public void setAesKey(String aesKey) {
        this.aesKey = aesKey;
    }

    public String getCust() {
        return cust;
    }

    public void setCust(String cust) {
        this.cust = cust;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public T getUser() {
        return user;
    }

    public void setUser(T user) {
        this.user = user;
    }
}
