package com.huatec.edu.mobileshop.testspring.aop;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAOP {
	ApplicationContext ac=
			new ClassPathXmlApplicationContext("applicationContext.xml");
	@Test
	public void test1(){
		Buyer b=ac.getBean("buyer",Buyer.class);
		b.shopping();
	}
}
