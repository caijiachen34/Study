package com.cjc.ouxun.entity;

/**
 * Created by CC
 **/
public class HttpResult<T> {

    /**
     * flag : true
     * apiUrl : http://39.106.173.47/filemgt/api/
     * aesKey : PerdvawlumfDdCesaLAbant
     * user : {"csrq":"2017-10-03","create_time":null,"modify_time":"2018-06-25 14:38:31","mobile":"18796919236","modify_by":1,"dept_bm":"03","is_delete":"N","create_by":null,"is_dept_manager":"N","xb_dm":"02","nickname":"系统管理员","tel":"0858-2345768","id":1,"sfzjhm":"520202xxxxxxxxx","dept_id":4,"qtbz_dm":"Y","order_id":1,"email":"chenli@sohu.com","username":"admin","status":"01"}
     */

    private boolean flag;
    private String apiUrl;
    private String aesKey;
    private T data;
    private String cust;
    private String errorMsg;

    @Override
    public String toString() {
        return "ResultEntity{" +
                "flag=" + flag +
                ", apiUrl='" + apiUrl + '\'' +
                ", aesKey='" + aesKey + '\'' +
                ", data=" + data +
                ", cust='" + cust + '\'' +
                ", errorMsg='" + errorMsg + '\'' +
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
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
}
