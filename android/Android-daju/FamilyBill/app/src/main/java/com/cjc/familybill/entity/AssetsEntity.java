package com.cjc.familybill.entity;

/**
 * Created by CC
 **/
public class AssetsEntity {


    /**
     * assets_id : 1
     * uname : 888
     * assetsType : 银行卡
     * assetsMoney : 8000.0
     * remarks : 工资
     * sum : null
     */

    private int assets_id;
    private String uname;
    private String assetsType;
    private double assetsMoney;
    private String remarks;
    private double sum;

    @Override
    public String toString() {
        return "AssetsEntity{" +
                "assets_id=" + assets_id +
                ", uname='" + uname + '\'' +
                ", assetsType='" + assetsType + '\'' +
                ", assetsMoney=" + assetsMoney +
                ", remarks='" + remarks + '\'' +
                ", sum=" + sum +
                '}';
    }

    public int getAssets_id() {
        return assets_id;
    }

    public void setAssets_id(int assets_id) {
        this.assets_id = assets_id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getAssetsType() {
        return assetsType;
    }

    public void setAssetsType(String assetsType) {
        this.assetsType = assetsType;
    }

    public double getAssetsMoney() {
        return assetsMoney;
    }

    public void setAssetsMoney(double assetsMoney) {
        this.assetsMoney = assetsMoney;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }
}
