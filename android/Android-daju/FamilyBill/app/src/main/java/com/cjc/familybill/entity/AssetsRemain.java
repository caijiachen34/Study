package com.cjc.familybill.entity;

/**
 * Created by CC
 **/
public class AssetsRemain {

    /**
     * remain_id : 9
     * uname : 777
     * assets_type : 微信
     * remain_money : 900
     */

    private int remain_id;
    private String uname;
    private String assets_type;
    private Double remain_money;

    @Override
    public String toString() {
        return "AssetsRemain{" +
                "remain_id=" + remain_id +
                ", uname='" + uname + '\'' +
                ", assets_type='" + assets_type + '\'' +
                ", remain_money=" + remain_money +
                '}';
    }

    public int getRemain_id() {
        return remain_id;
    }

    public void setRemain_id(int remain_id) {
        this.remain_id = remain_id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getAssets_type() {
        return assets_type;
    }

    public void setAssets_type(String assets_type) {
        this.assets_type = assets_type;
    }

    public Double getRemain_money() {
        return remain_money;
    }

    public void setRemain_money(Double remain_money) {
        this.remain_money = remain_money;
    }
}
