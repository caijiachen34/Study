package com.huatec.edu.ca.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.huatec.edu.ca.dao.CatPaymentDao;
import com.huatec.edu.ca.entity.CatPayment;

public class TestCatPaymentDao {
	//获取CatPaymentDao
	String conf="applicationContext.xml";
	ApplicationContext ac=new ClassPathXmlApplicationContext(conf);
	CatPaymentDao catPaymentDao=ac.getBean("catPaymentDao",CatPaymentDao.class);
	
	@Test
	public void test1(){
		List<CatPayment> cps=catPaymentDao.findByUserName("tom");
		for(CatPayment cp:cps){
			System.out.println(cp);
		}
	}
}
