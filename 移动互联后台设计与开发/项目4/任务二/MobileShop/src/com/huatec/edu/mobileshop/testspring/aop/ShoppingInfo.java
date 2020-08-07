package com.huatec.edu.mobileshop.testspring.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect//指定为切面
public class ShoppingInfo {
	/*
	 * 定义通知，@Before：前置通知；@After：后置通知；
	 * execution：定义切入点，这里的切入点便是Buyer类中的shopping方法
	 */
	@Before("execution(* com.huatec.edu.mobileshop.testspring.aop.Buyer.shopping())")
	public void Login(){
		System.out.println("购物之前需要先登录购物平台");
	}
	@After("execution(* com.huatec.edu.mobileshop.testspring.aop.Buyer.shopping())")
	public void logout(){
		System.out.println("购物之后要退出购物平台");
	}
}
