package com.huatec.edu.mobileshop.testspring;

import com.huatec.edu.mobileshop.entity.brief.BriefBrand;
//创建静态工厂
public class BrandFactory {
	//创建静态方法
	public static BriefBrand createBrand(){
		//返回实例化的类的对象
		return new BriefBrand();
	}
	
	public BriefBrand createBrand1(){
		//返回实例化的类的对象
		return new BriefBrand();
	}
}
