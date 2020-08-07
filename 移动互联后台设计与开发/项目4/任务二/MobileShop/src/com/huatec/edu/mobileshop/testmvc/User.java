package com.huatec.edu.mobileshop.testmvc;

import java.io.Serializable;

public class User implements Serializable {
	private String uname;
	private String password;
	//get、set方法
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
