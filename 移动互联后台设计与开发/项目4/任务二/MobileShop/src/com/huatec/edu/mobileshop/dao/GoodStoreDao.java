package com.huatec.edu.mobileshop.dao;

import java.util.List;

import com.huatec.edu.mobileshop.entity.GoodStore;

public interface GoodStoreDao {
	public int save(GoodStore goodStore);
	public int deleteById(int store_id);
	public List<GoodStore> findAll();
	public GoodStore findById(int store_id);
	public int dynamicUpdate(GoodStore goodStore);
}
