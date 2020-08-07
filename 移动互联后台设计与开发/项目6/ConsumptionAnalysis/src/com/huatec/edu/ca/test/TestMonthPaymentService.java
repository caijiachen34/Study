package com.huatec.edu.ca.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.huatec.edu.ca.entity.CatPayment;
import com.huatec.edu.ca.entity.MonthPayment;
import com.huatec.edu.ca.service.MonthPaymentService;
import com.huatec.edu.ca.util.Result;

public class TestMonthPaymentService {
	//获取MonthPaymentService
	String conf="applicationContext.xml";
	ApplicationContext ac=new ClassPathXmlApplicationContext(conf);
	MonthPaymentService monthPaymentService=ac.getBean("monthPaymentServiceImpl",MonthPaymentService.class);
	@Test
	public void test1(){
		Result result=monthPaymentService.loadByUserName("tom");
		System.out.println(result.getMsg());
		List<MonthPayment> mps=(List<MonthPayment>) result.getData();
		for(MonthPayment mp:mps){
			System.out.println(mp);
		}
	}
}
