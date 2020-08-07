package com.example.administrator.mobileshop01.entity;

public class GoodsEntity {
    private int goods_id;
    private String name;
    private double price;
    private String mtkprice;
    private String small;
    private int mtk_enable;
    private String briefGoodscat;
    private String briefbrand;

    @Override
    public String toString() {
        return "GoodsEntity{" +
                "goods_id=" + goods_id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", mtkprice='" + mtkprice + '\'' +
                ", small='" + small + '\'' +
                ", mtk_enable=" + mtk_enable +
                ", briefGoodscat='" + briefGoodscat + '\'' +
                ", briefbrand='" + briefbrand + '\'' +
                '}';
    }

    public int getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(int goods_id) {
        this.goods_id = goods_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getMtkprice() {
        return mtkprice;
    }

    public void setMtkprice(String mtkprice) {
        this.mtkprice = mtkprice;
    }

    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small;
    }

    public int getMtk_enable() {
        return mtk_enable;
    }

    public void setMtk_enable(int mtk_enable) {
        this.mtk_enable = mtk_enable;
    }

    public String getBriefGoodscat() {
        return briefGoodscat;
    }

    public void setBriefGoodscat(String briefGoodscat) {
        this.briefGoodscat = briefGoodscat;
    }

    public String getBriefbrand() {
        return briefbrand;
    }

    public void setBriefbrand(String briefbrand) {
        this.briefbrand = briefbrand;
    }
}
