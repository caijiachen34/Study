package com.huatec.edu.mobileshop.testspring;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.huatec.edu.mobileshop.entity.brief.BriefBrand;
import com.huatec.edu.mobileshop.testspring.ioc.MemberInfo;
import com.huatec.edu.mobileshop.testspring.ioc2.BrandInfo;
import com.huatec.edu.mobileshop.testspring.ioc2.GoodsInfo;

public class TestBean {
	ApplicationContext ac=
			new ClassPathXmlApplicationContext("applicationContext.xml");
	
	@Test
	public void test7(){
		BrandInfo bi=ac.getBean("brandInfo",BrandInfo.class);
		System.out.println(bi);
	}
	@Test
	public void test6(){
		GoodsInfo gi=ac.getBean("gi",GoodsInfo.class);
		System.out.println(gi);
	}
	
	@Test
	public void test5(){
		MemberInfo mi=ac.getBean("memberInfo",MemberInfo.class);
		System.out.println(mi);
	}
	@Test
	public void test4(){
		BriefBrand bb=ac.getBean("brand3",BriefBrand.class);
		System.out.println(bb);
	}
	@Test
	public void test3(){
		BriefBrand bb=ac.getBean("brand2",BriefBrand.class);
		System.out.println(bb);
	}
	@Test
	public void test2(){
		ApplicationContext ac=
				new ClassPathXmlApplicationContext("applicationContext.xml");
		BriefBrand bb=ac.getBean("brand1",BriefBrand.class);
		System.out.println(bb);
	}
	@Test
	public void test1(){
		//创建ApplicationContext类型的容器
		ApplicationContext ac=
				new ClassPathXmlApplicationContext("applicationContext.xml");
		//通过容器获取Bean的实例
		BriefBrand bb=ac.getBean("brand",BriefBrand.class);
		System.out.println(bb);
	}
	
}
