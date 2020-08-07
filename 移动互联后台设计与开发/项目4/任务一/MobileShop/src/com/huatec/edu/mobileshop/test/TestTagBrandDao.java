package com.huatec.edu.mobileshop.test;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.huatec.edu.mobileshop.dao.TagBrandDao;
import com.huatec.edu.mobileshop.entity.TagBrand;
import com.huatec.edu.mobileshop.util.MybatisUtil;

public class TestTagBrandDao {
	//获取SqlSession
	SqlSession session=MybatisUtil.getSqlSession();
	//1.产生一个实现类 2.创建实现类的实例
	TagBrandDao tagBrandDao=session.getMapper(TagBrandDao.class);
	
	@Test
	public void testfindUnion(){
		List<TagBrand> tbs=tagBrandDao.findUnionByTagId(4);
		for(TagBrand tb:tbs){
			System.out.println(tb);
		}
		session.close();
	}
	@Test
	public void testDynamicUpdate(){
		TagBrand tagBrand=new TagBrand();
		tagBrand.setBrand_id(3);
		tagBrand.setId(1);
		Timestamp now=new Timestamp(System.currentTimeMillis());
		tagBrand.setModifytime(now);
		tagBrandDao.dynamicUpdate(tagBrand);
		session.commit();
		session.close();
	}
	@Test
	public void testFindById(){
		TagBrand tb=tagBrandDao.findById(2);
		System.out.println(tb);
		session.close();
	}
	@Test
	public void testFindAll(){
		List<TagBrand> tbs=tagBrandDao.findAll();
		for(TagBrand tb:tbs){
			System.out.println(tb);
		}
		session.close();
	}
	@Test
	public void testDelete(){
		tagBrandDao.deleteById(3);
		session.commit();
		session.close();
	}
	@Test
	public void testSave(){
		TagBrand tagBrand=new TagBrand();
		tagBrand.setId(null);
		tagBrand.setTag_id(4);
		tagBrand.setBrand_id(6);
		tagBrand.setSort(0);
		tagBrand.setCreatime(null);
		tagBrand.setModifytime(null);
		tagBrandDao.save(tagBrand);
		session.commit();
		session.close();
	}
}
