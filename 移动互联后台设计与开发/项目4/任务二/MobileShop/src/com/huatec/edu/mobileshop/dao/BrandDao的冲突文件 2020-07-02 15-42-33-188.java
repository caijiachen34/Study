package com.huatec.edu.mobileshop.dao;

import java.util.List;

import com.huatec.edu.mobileshop.entity.Brand;

public interface BrandDao {
	public int save(Brand brand);
	public int deleteById(int brand_id);
	public List<Brand> findAll();
	public Brand findById(int brand_id);
	public int dynamicUpdate(Brand brand);
}
