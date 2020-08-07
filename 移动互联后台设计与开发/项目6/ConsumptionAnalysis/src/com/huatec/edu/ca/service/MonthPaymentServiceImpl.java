package com.huatec.edu.ca.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huatec.edu.ca.dao.MonthPaymentDao;
import com.huatec.edu.ca.entity.MonthPayment;
import com.huatec.edu.ca.util.Result;
@Service
@Transactional
public class MonthPaymentServiceImpl implements MonthPaymentService {
	@Resource
	private MonthPaymentDao monthPaymentDao;
	
	public Result loadByUserName(String username) {
		Result result=new Result();
		List<MonthPayment> mps=monthPaymentDao.findByUserName(username);
		if(mps.isEmpty()){
			result.setStatus(1);
			result.setMsg("不存在此用户");
			result.setData(mps);
			return result;
		}
		result.setStatus(0);
		result.setMsg("查询成功");
		result.setData(mps);
		return result;
	}
}
