package com.huatec.edu.ca.entity;

import java.io.Serializable;

public class MonthPayment implements Serializable {
	private Integer id;
	private String username;
	private String month;
	private String payment;
	//get、set方法
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	//toString方法
	public String toString() {
		return "MonthPayment [id=" + id + ", username=" + username + ", month=" + month + ", payment=" + payment + "]";
	}
}
