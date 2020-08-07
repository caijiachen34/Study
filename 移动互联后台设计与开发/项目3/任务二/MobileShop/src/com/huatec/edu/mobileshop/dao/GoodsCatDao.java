package com.huatec.edu.mobileshop.dao;

import java.util.List;

import com.huatec.edu.mobileshop.entity.GoodsCat;

public interface GoodsCatDao {
	public int save(GoodsCat goodsCat);
	public int deleteById(int cat_id);
	public List<GoodsCat> findAll();
	public GoodsCat findById(int cat_id);
	public int dynamicUpdate(GoodsCat goodsCat);
}
