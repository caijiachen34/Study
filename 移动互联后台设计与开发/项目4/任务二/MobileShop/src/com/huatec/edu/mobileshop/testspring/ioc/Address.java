package com.huatec.edu.mobileshop.testspring.ioc;

import java.io.Serializable;

public class Address implements Serializable {
	private String mobile;
	private String address;
	//get、set方法
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	//toString方法
	public String toString() {
		return "Address [mobile=" + mobile + ", address=" + address + "]";
	}
}
