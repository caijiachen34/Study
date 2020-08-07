package com.huatec.edu.mobileshop.test;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.huatec.edu.mobileshop.dao.BrandDao;
import com.huatec.edu.mobileshop.entity.Brand;
import com.huatec.edu.mobileshop.util.MybatisUtil;

public class TestBrandDao {
	//获取SqlSession
	SqlSession session=MybatisUtil.getSqlSession();
	//1.产生一个实现类 2.创建实现类的实例
	BrandDao brandDao=session.getMapper(BrandDao.class);
	
	@Test
	public void testDynamicUpdate(){
		Brand brand=new Brand();
		brand.setKeywords("果汁");
		brand.setBrand_id(5);
		Timestamp now=new Timestamp(System.currentTimeMillis());
		brand.setModifytime(now);
		brandDao.dynamicUpdate(brand);
		session.commit();
		session.close();
	}
	@Test
	public void testFindById(){
		Brand b=brandDao.findById(2);
		System.out.println(b);
		session.close();
	}
	@Test
	public void testFindAll(){
		List<Brand> brands=brandDao.findAll();
		for(Brand b:brands){
			System.out.println(b);
		}
		session.close();
	}
	
	@Test
	public void testDelete(){
		brandDao.deleteById(8);
		session.commit();
		session.close();
	}
	
	@Test
	public void testSave(){
		Brand brand=new Brand();
		brand.setBrand_id(null);
		brand.setName("康师傅");
		brand.setLogo("");
		brand.setKeywords("饮料，方便面，糕饼");
		brand.setDescription("康师傅控股有限公司（康师傅公司），总部设于天津市，主要在中国从事生产和销售方便面、饮品、糕饼以及相关配套产业的经营。");
		brand.setUrl("");
		brand.setDisabled(0);
		brand.setCreatime(null);
		brand.setModifytime(null);
		brandDao.save(brand);
		session.commit();
		session.close();
	}
	
}
