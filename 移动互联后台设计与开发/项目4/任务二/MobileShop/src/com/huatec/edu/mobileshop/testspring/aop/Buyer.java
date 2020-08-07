package com.huatec.edu.mobileshop.testspring.aop;

import org.springframework.stereotype.Component;

@Component
public class Buyer {
	public void shopping() {
		System.out.println("开始进行网上购物");
	}
}
