package com.huatec.edu.mobileshop.dao;

import java.util.List;

import com.huatec.edu.mobileshop.entity.Order;
import com.huatec.edu.mobileshop.entity.brief.BriefOrder;

public interface OrderDao {
	public int save(Order order);
	public List<Order> findAll();
	public int deleteById(int order_id);
	public Order findById(int order_id);
	public int dynamicUpdate(Order order);
	public List<Order> findUnionByMemberId(int member_id);
	public List<BriefOrder> findUnionByStatus(int status);
}
