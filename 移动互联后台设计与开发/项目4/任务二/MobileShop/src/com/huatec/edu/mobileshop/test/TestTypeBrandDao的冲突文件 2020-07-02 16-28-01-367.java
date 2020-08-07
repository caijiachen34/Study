package com.huatec.edu.mobileshop.test;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.huatec.edu.mobileshop.dao.TypeBrandDao;
import com.huatec.edu.mobileshop.entity.TypeBrand;
import com.huatec.edu.mobileshop.util.MybatisUtil;

public class TestTypeBrandDao {
	//获取SqlSession
	SqlSession session=MybatisUtil.getSqlSession();
	//1.产生一个实现类 2.创建实现类的实例
	TypeBrandDao typeBrandDao=session.getMapper(TypeBrandDao.class);
	
	@Test
	public void testfindUnion(){
		List<TypeBrand> tbs=typeBrandDao.findUnionByTypeId(4);
		for(TypeBrand tb:tbs){
			System.out.println(tb);
		}
		session.close();
	}
	@Test
	public void testDynamicUpdate(){
		TypeBrand typeBrand=new TypeBrand();
		typeBrand.setBrand_id(5);
		Timestamp now=new Timestamp(System.currentTimeMillis());
		typeBrand.setModifytime(now);
		typeBrand.setId(4);
		typeBrandDao.dynamicUpdate(typeBrand);
		session.commit();
		session.close();
	}
	@Test
	public void testFindById(){
		TypeBrand tb=typeBrandDao.findById(2);
		System.out.println(tb);
		session.close();
	}
	@Test
	public void testFindAll(){
		List<TypeBrand> tbs=typeBrandDao.findAll();
		for(TypeBrand tb:tbs){
			System.out.println(tb);
		}
		session.close();
	}
	
	@Test
	public void testDelete(){
		typeBrandDao.deleteById(1);
		session.commit();
		session.close();
	}
	@Test
	public void testSave(){
		TypeBrand typeBrand=new TypeBrand();
		typeBrand.setId(null);
		typeBrand.setType_id(4);
		typeBrand.setBrand_id(9);
		typeBrand.setCreatime(null);
		typeBrand.setModifytime(null);
		typeBrandDao.save(typeBrand);
		session.commit();
		session.close();
	}
}
