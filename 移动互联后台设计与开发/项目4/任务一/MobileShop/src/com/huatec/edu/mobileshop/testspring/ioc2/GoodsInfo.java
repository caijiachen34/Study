package com.huatec.edu.mobileshop.testspring.ioc2;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("gi")
public class GoodsInfo implements Serializable {
	@Value("汇源果汁")
	private String name;//名称
	@Value("汇源果汁是汇源品牌的经典产品")
	private String brief;//简介
	//@Resource按名称注入
	//@Autowired注解默认按类型进行自动装配
	//当@Autowired注解需要指定名称时需和@Qualifier注解配合使用
	@Autowired
	@Qualifier("brandInfo")
	private BrandInfo brandInfo;
	//get、set方法
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrief() {
		return brief;
	}
	public void setBrief(String brief) {
		this.brief = brief;
	}
	//toString方法
	public String toString() {
		return "GoodsInfo [name=" + name + ", brief=" + brief + ", brandInfo=" + brandInfo + "]";
	}
}
