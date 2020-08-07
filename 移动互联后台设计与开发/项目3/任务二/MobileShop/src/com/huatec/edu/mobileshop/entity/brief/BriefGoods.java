package com.huatec.edu.mobileshop.entity.brief;

import java.io.Serializable;
//简单的商品实体类，用于查询
public class BriefGoods implements Serializable {
	private Integer goods_id;//商品编号
	private String name;//名称
	private Double price;//销售价
	private Double mktprice;//市场价
	private String small;//小图
	//get、set方法
	public Integer getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(Integer goods_id) {
		this.goods_id = goods_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getMktprice() {
		return mktprice;
	}
	public void setMktprice(Double mktprice) {
		this.mktprice = mktprice;
	}
	public String getSmall() {
		return small;
	}
	public void setSmall(String small) {
		this.small = small;
	}
	//toString方法
	public String toString() {
		return "BriefGoods [goods_id=" + goods_id + ", name=" + name + ", price=" + price + ", mktprice=" + mktprice
				+ ", small=" + small + "]";
	}
	
}
