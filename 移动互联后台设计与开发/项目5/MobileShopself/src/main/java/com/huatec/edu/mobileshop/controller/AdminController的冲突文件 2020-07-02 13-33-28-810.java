package com.huatec.edu.mobileshop.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huatec.edu.mobileshop.service.AdminService;
import com.huatec.edu.mobileshop.util.Result;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Resource
	private AdminService adminService;
	
	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	public Result add(String mobile,String realName,int roleId){
		Result result=adminService.addAdmin(mobile, realName, roleId);
		return result;
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	@ResponseBody
	public Result checkLogin(String input,String password){
		Result result=adminService.checkLogin(input, password);
		return result;
	}
	
	@RequestMapping(value="/{adminId}",method=RequestMethod.PUT)
	@ResponseBody
	public Result updateById(@PathVariable("adminId") int adminId,
			String username,String password,String email,int sex){
		Result result=adminService.updateAdmin(adminId, username, password, email, sex);
		return result;
	}
	
	@RequestMapping(value="/mobile_realName/{adminId}",method=RequestMethod.PUT)
	@ResponseBody
	public Result updateMobileAndRealName(@PathVariable("adminId") int adminId,
			String mobile,String realName){
		Result result=adminService.updateMobileAndRealName(adminId, mobile, realName);
		return result;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody
	public Result loadAll(){
		Result result=adminService.loadAllAdmin();
		return result;
	}
	
	@RequestMapping(value="/{adminId}",method=RequestMethod.GET)
	@ResponseBody
	public Result loadById(@PathVariable("adminId") int adminId){
		Result result=adminService.loadAdminById(adminId);
		return result;
	}
	
	@RequestMapping(value="/{adminId}",method=RequestMethod.DELETE)
	@ResponseBody
	public Result deleteById(@PathVariable("adminId") int adminId){
		Result result=adminService.deleteAdminById(adminId);
		return result;
	}
	
}
