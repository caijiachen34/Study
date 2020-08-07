package com.huatec.edu.mobileshop.testspring.ioc;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class MemberInfo implements Serializable {
	private String name;
	//测试Bean注入
	private Address address;
	//测试集合注入
	private List<String> loveBrands;
	private Set<String> loveGoods;
	private Map<String,String> comment;
	private Properties dbinfo;
	//get、set方法
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public List<String> getLoveBrands() {
		return loveBrands;
	}
	public void setLoveBrands(List<String> loveBrands) {
		this.loveBrands = loveBrands;
	}
	public Set<String> getLoveGoods() {
		return loveGoods;
	}
	public void setLoveGoods(Set<String> loveGoods) {
		this.loveGoods = loveGoods;
	}
	public Map<String, String> getComment() {
		return comment;
	}
	public void setComment(Map<String, String> comment) {
		this.comment = comment;
	}
	public Properties getDbinfo() {
		return dbinfo;
	}
	public void setDbinfo(Properties dbinfo) {
		this.dbinfo = dbinfo;
	}
	//toString方法
	public String toString() {
		return "MemberInfo [name=" + name + ", address=" + address + ", loveBrands=" + loveBrands + ", loveGoods="
				+ loveGoods + ", comment=" + comment + ", dbinfo=" + dbinfo + "]";
	}
}
