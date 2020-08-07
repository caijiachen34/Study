package com.huatec.edu.mobileshop.dao;

import java.util.List;

import com.huatec.edu.mobileshop.entity.GoodsLike;

public interface GoodsLikeDao {
	public int save(GoodsLike goodsLike);
	public int deleteById(int like_id);
	public List<GoodsLike> findAll();
	public GoodsLike findById(int like_id);
	public int dynamicUpdate(GoodsLike goodsLike);
}
