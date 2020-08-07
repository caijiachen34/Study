package com.huatec.edu.mobileshop.dao;

import java.util.List;

import com.huatec.edu.mobileshop.entity.TypeBrand;

public interface TypeBrandDao {
	public int save(TypeBrand typeBrand);
	public int deleteById(int id);
	public List<TypeBrand> findAll();
	public TypeBrand findById(int id);
	public int dynamicUpdate(TypeBrand typeBrand);
	public List<TypeBrand> findUnionByTypeId(int type_id);
}
