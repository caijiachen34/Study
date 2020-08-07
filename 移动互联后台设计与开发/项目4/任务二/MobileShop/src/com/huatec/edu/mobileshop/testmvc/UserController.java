package com.huatec.edu.mobileshop.testmvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class UserController implements Controller {
	//重写Controller接口中的handleRequest方法
	public ModelAndView handleRequest
	(HttpServletRequest req, HttpServletResponse res) 
			throws Exception {
		//进行业务逻辑处理
		String uname=req.getParameter("uname");
		String password=req.getParameter("password");
		if("zs".equals(uname)&&"123".equals(password)){
			//返回ModelAndView对象
			return new ModelAndView("index");
		}
		//返回ModelAndView对象
		return new ModelAndView("error");
	}
}
