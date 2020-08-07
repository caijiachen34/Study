package com.huatec.edu.ca.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.huatec.edu.ca.entity.CatPayment;
import com.huatec.edu.ca.service.CatPaymentService;
import com.huatec.edu.ca.util.Result;

public class TestCatPaymentService {
	//获取CatPaymentService
	String conf="applicationContext.xml";
	ApplicationContext ac=new ClassPathXmlApplicationContext(conf);
	CatPaymentService catPaymentService=ac.getBean("catPaymentServiceImpl",CatPaymentService.class);
	@Test
	public void test1(){
		Result result=catPaymentService.loadByUserName("tom");
		System.out.println(result.getMsg());
		List<CatPayment> cps=(List<CatPayment>) result.getData();
		for(CatPayment cp:cps){
			System.out.println(cp);
		}
	}
}
