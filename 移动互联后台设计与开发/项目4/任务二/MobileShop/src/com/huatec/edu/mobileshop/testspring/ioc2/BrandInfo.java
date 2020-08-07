package com.huatec.edu.mobileshop.testspring.ioc2;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
/* 
 * @Component修饰类
 * 生成Bean的默认名称是brandInfo（类名首字母小写）
 * 也可以使用@Component("bi")方式指定名称
 */
@Component
public class BrandInfo implements Serializable {
	//@Value：基本值注入，修饰字段
	@Value("汇源")
	private String name;
	private String logo;
	//get、set方法
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLogo() {
		return logo;
	}
	//@Value：基本值注入，修饰set方法
	@Value("汇源logo")
	public void setLogo(String logo) {
		this.logo = logo;
	}
	//toString方法
	public String toString() {
		return "BrandInfo [name=" + name + ", logo=" + logo + "]";
	}
}
