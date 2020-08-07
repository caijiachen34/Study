package com.huatec.edu.ca.dao;

import java.util.List;

import com.huatec.edu.ca.entity.CatPayment;

public interface CatPaymentDao {
	public List<CatPayment> findByUserName(String username);
}
