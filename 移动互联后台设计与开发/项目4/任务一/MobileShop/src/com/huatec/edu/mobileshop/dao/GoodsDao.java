package com.huatec.edu.mobileshop.dao;

import java.util.List;

import com.huatec.edu.mobileshop.entity.Goods;

public interface GoodsDao {
	public int save(Goods goods);
	public int deleteById(int goods_id);
	public List<Goods> findAll();
	public Goods findById(int goods_id);
	public int dynamicUpdate(Goods goods);
}
