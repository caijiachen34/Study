package com.huatec.edu.mobileshop.entity;

import java.io.Serializable;
import java.sql.Timestamp;
//商品库存
public class GoodStore implements Serializable {
	private Integer store_id;//库存编号
	private Integer goods_id;//商品编号
	private Integer store;//库存数量
	private Integer enable_store;//可用库存
	private Integer operate_type;//操作类型，0：入库，1：出库
	private Timestamp intime;//入库时间
	private Timestamp outime;//出库时间
	
	public Integer getStore_id() {
		return store_id;
	}
	public void setStore_id(Integer store_id) {
		this.store_id = store_id;
	}
	public Integer getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(Integer goods_id) {
		this.goods_id = goods_id;
	}
	public Integer getStore() {
		return store;
	}
	public void setStore(Integer store) {
		this.store = store;
	}
	public Integer getEnable_store() {
		return enable_store;
	}
	public void setEnable_store(Integer enable_store) {
		this.enable_store = enable_store;
	}
	public Integer getOperate_type() {
		return operate_type;
	}
	public void setOperate_type(Integer operate_type) {
		this.operate_type = operate_type;
	}
	public Timestamp getIntime() {
		return intime;
	}
	public void setIntime(Timestamp intime) {
		this.intime = intime;
	}
	public Timestamp getOutime() {
		return outime;
	}
	public void setOutime(Timestamp outime) {
		this.outime = outime;
	}
	public String toString() {
		return "GoodStore [store_id=" + store_id + ", goods_id=" + goods_id + ", store=" + store + ", enable_store="
				+ enable_store + ", operate_type=" + operate_type + ", intime=" + intime + ", outime=" + outime + "]";
	}
	
}
