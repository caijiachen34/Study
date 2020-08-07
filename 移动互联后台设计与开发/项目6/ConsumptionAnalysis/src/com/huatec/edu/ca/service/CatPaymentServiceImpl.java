package com.huatec.edu.ca.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huatec.edu.ca.dao.CatPaymentDao;
import com.huatec.edu.ca.entity.CatPayment;
import com.huatec.edu.ca.util.Result;

@Service
//@Transactional：开启事务
@Transactional
public class CatPaymentServiceImpl implements CatPaymentService {
	@Resource
	private CatPaymentDao catPaymentDao;
	
	public Result loadByUserName(String username) {
		Result result=new Result();
		List<CatPayment> cps=catPaymentDao.findByUserName(username);
		if(cps.isEmpty()){
			result.setStatus(1);
			result.setMsg("不存在此用户");
			result.setData(cps);
			return result;
		}
		result.setStatus(0);
		result.setMsg("查询成功");
		result.setData(cps);
		return result;
	}
}
