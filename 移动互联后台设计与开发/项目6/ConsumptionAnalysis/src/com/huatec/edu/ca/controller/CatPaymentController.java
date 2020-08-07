package com.huatec.edu.ca.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huatec.edu.ca.service.CatPaymentService;
import com.huatec.edu.ca.util.Result;

@Controller
@RequestMapping("/cat/payment")
public class CatPaymentController {
	@Resource
	private CatPaymentService catPaymentService;
	//post方式
	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	public Result loadByUserName(String username){
		Result result=catPaymentService.loadByUserName(username);
		return result;
	}
	//get方式
	@RequestMapping(value="/{username}",method=RequestMethod.GET)
	@ResponseBody
	public Result loadByUserName2(@PathVariable("username") String username){
		Result result=catPaymentService.loadByUserName(username);
		return result;
	}
}
