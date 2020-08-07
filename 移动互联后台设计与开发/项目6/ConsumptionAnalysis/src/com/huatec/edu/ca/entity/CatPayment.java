package com.huatec.edu.ca.entity;

import java.io.Serializable;

public class CatPayment implements Serializable {
	private Integer id;
	private String username;
	private String category;
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
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	//toString方法
	public String toString() {
		return "CatPayment [id=" + id + ", username=" + username + ", category=" + category + ", payment=" + payment
				+ "]";
	}
}
