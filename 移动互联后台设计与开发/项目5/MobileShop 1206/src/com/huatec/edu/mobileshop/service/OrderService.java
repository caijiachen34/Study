package com.huatec.edu.mobileshop.service;

import com.huatec.edu.mobileshop.util.Result;

public interface OrderService {
	//创建订单
	public Result addOrder(int memberId,int addressId,int paytypeId,double carriage);
	//根据id加载
	public Result loadOrderById(int orderId);
	//根据会员id加载（“我的订单”页面，订单表、订单商品表、商品表关联查询）
	public Result loadOrderByMemberId(int memberId);
	//更新订单状态（取消订单）
	public Result updateOrderStatus(int orderId);
}
