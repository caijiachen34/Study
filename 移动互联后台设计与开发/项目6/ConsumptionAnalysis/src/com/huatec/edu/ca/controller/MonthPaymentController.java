package com.huatec.edu.ca.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huatec.edu.ca.service.MonthPaymentService;
import com.huatec.edu.ca.util.Result;

@Controller
@RequestMapping("/month/payment")
public class MonthPaymentController {
	@Resource
	private MonthPaymentService monthPaymentService;
	//post方式
	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	public Result loadByUserName(String username){
		Result result=monthPaymentService.loadByUserName(username);
		return result;
	}
	//get方式
	@RequestMapping(value="/{username}",method=RequestMethod.GET)
	@ResponseBody
	public Result loadByUserName2(@PathVariable("username") String username){
		Result result=monthPaymentService.loadByUserName(username);
		return result;
	}
}
