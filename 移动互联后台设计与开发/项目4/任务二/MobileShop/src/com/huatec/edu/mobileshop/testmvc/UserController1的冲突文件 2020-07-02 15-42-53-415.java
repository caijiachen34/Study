package com.huatec.edu.mobileshop.testmvc;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member")
public class UserController1 {
	@RequestMapping("/login.do")
	public String login(String uname,String password){
		if("zs".equals(uname)&&"123".equals(password)){
			//返回视图名称
			return "index";
		}
		return "error";
	}
	
	//使用HttpServletRequest接收请求参数
	@RequestMapping("/login1.do")
	public String login1(HttpServletRequest req){
		//使用HttpServletRequest接收请求参数
		String uname=req.getParameter("uname");
		String password=req.getParameter("password");
		System.out.println(uname+":"+password);
		return "index";
	}
	//使用Spring自动逐日方式接收请求参数
	@RequestMapping("/login2.do")
	public String login2(String uname,
		@RequestParam("password")String pwd){//表单name是password，用pwd接收
		System.out.println(uname+":"+pwd);
		return "index";
	}
	//自动注入Bean属性
	@RequestMapping("/login3.do")
	public String login3(User user){
		System.out.println(user.getUname());
		System.out.println(user.getPassword());
		return "index";
	}
	
	@RequestMapping("/login4.do")
	public ModelAndView login4(String uname,String password){
		User user=new User();
		user.setUname(uname);
		user.setPassword(password);
		Map<String,Object> data=new HashMap<String,Object>();
		data.put("user", user);
		return new ModelAndView("index",data);
	}
}
