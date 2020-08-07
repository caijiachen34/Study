package com.huatec.edu.ca.dao;

import java.util.List;

import com.huatec.edu.ca.entity.MonthPayment;

public interface MonthPaymentDao {
	public List<MonthPayment> findByUserName(String username);
}
