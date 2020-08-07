package com.huatec.edu.mobileshop.test;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.huatec.edu.mobileshop.dao.TagGoodsDao;
import com.huatec.edu.mobileshop.entity.TagGoods;
import com.huatec.edu.mobileshop.util.MybatisUtil;

public class TestTagGoodsDao {
	//获取SqlSession
	SqlSession session=MybatisUtil.getSqlSession();
	//1.产生一个实现类 2.创建实现类的实例
	TagGoodsDao tagGoodsDao=session.getMapper(TagGoodsDao.class);
	
	@Test
	public void testDynamicUpdate(){
		TagGoods tagGoods=new TagGoods();
		tagGoods.setGoods_id(5);
		tagGoods.setId(2);
		Timestamp now=new Timestamp(System.currentTimeMillis());
		tagGoods.setModifytime(now);
		tagGoodsDao.dynamicUpdate(tagGoods);
		session.commit();
		session.close();
	}
	@Test
	public void testfindUnion(){
		List<TagGoods> tgs=tagGoodsDao.findUnionByTagId(2);
		for(TagGoods tg:tgs){
			System.out.println(tg);
		}
		session.close();
	}
	@Test
	public void testFindById(){
		TagGoods tg=tagGoodsDao.findById(2);
		System.out.println(tg);
		session.close();
	}
	@Test
	public void testFindAll(){
		List<TagGoods> tgs=tagGoodsDao.findAll();
		for(TagGoods tg:tgs){
			System.out.println(tg);
		}
		session.close();
	}
	@Test
	public void testDelete(){
		tagGoodsDao.deleteById(3);
		session.commit();
		session.close();
	}
	@Test
	public void testSave(){
		TagGoods tagGoods=new TagGoods();
		tagGoods.setId(null);
		tagGoods.setTag_id(2);
		tagGoods.setGoods_id(4);
		tagGoods.setSort(0);
		tagGoods.setCreatime(null);
		tagGoods.setModifytime(null);
		tagGoodsDao.save(tagGoods);
		session.commit();
		session.close();
	}
}
