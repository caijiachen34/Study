package com.huatec.edu.mobileshop.test;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.huatec.edu.mobileshop.dao.TagDao;
import com.huatec.edu.mobileshop.entity.Tag;
import com.huatec.edu.mobileshop.util.MybatisUtil;

public class TestTagDao {
	//获取SqlSession
	SqlSession session=MybatisUtil.getSqlSession();
	//1.产生一个实现类 2.创建实现类的实例
	TagDao tagDao=session.getMapper(TagDao.class);
	
	@Test
	public void testDynamicUpdate(){
		Tag tag=new Tag();
		tag.setName("品牌1");
		tag.setType(1);
		tag.setCount(6);
		tag.setTeam(0);
		Timestamp now=new Timestamp(System.currentTimeMillis());
		tag.setModifytime(now);
		tag.setTag_id(4);
		tagDao.dynamicUpdate(tag);
		session.commit();
		session.close();
	}
	@Test
	public void testFindById(){
		Tag t=tagDao.findById(3);
		System.out.println(t);
		session.close();
	}
	@Test
	public void testFindAll(){
		List<Tag> tags=tagDao.findAll();
		for(Tag t:tags){
			System.out.println(t);
		}
		session.close();
	}
	@Test
	public void testDelete(){
		tagDao.deleteById(6);
		session.commit();
		session.close();
	}
	@Test
	public void testSave(){
		Tag tag=new Tag();
		tag.setTag_id(null);
		tag.setName("品牌3");
		tag.setType(1);//品牌标签
		tag.setCount(6);//每个标签最多6个品牌
		tag.setSort(0);
		tag.setTeam(0);
		tag.setCreatime(null);
		tag.setModifytime(null);
		tagDao.save(tag);
		session.commit();
		session.close();
	}
}
