package com.huatec.edu.ca.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.huatec.edu.ca.dao.MonthPaymentDao;
import com.huatec.edu.ca.entity.MonthPayment;

public class TestMonthPaymentDao {
	//获取MonthPaymentDao
	String conf="applicationContext.xml";
	ApplicationContext ac=new ClassPathXmlApplicationContext(conf);
	MonthPaymentDao monthPaymentDao=ac.getBean("monthPaymentDao",MonthPaymentDao.class);
	
	@Test
	public void test1(){
		List<MonthPayment> mps=monthPaymentDao.findByUserName("tom");
		for(MonthPayment mp:mps){
			System.out.println(mp);
		}
	}
}
