package com.huatec.edu.mobileshop.dao;

import java.util.List;

import com.huatec.edu.mobileshop.entity.TagGoods;

public interface TagGoodsDao {
	public int save(TagGoods tagGoods);
	public int deleteById(int id);
	public List<TagGoods> findAll();
	public TagGoods findById(int id);
	public int dynamicUpdate(TagGoods tagGoods);
	public List<TagGoods> findUnionByTagId(int tag_id);
}
