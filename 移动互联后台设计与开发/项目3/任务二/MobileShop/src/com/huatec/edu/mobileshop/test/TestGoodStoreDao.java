package com.huatec.edu.mobileshop.test;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.huatec.edu.mobileshop.dao.GoodStoreDao;
import com.huatec.edu.mobileshop.entity.GoodStore;
import com.huatec.edu.mobileshop.util.MybatisUtil;

public class TestGoodStoreDao {
	//获取SqlSession
	SqlSession session=MybatisUtil.getSqlSession();
	//1.产生一个实现类 2.创建实现类的实例
	GoodStoreDao goodStoreDao=session.getMapper(GoodStoreDao.class);
	
	@Test
	public void testDynamicUpdate(){
		GoodStore gs=new GoodStore();
		gs.setStore_id(2);
		gs.setOperate_type(1);
		gs.setStore(98);
		gs.setEnable_store(98);
		Timestamp now=new Timestamp(System.currentTimeMillis());
		gs.setOutime(now);
		goodStoreDao.dynamicUpdate(gs);
		session.commit();
		session.close();
	}
	@Test
	public void testFindById(){
		GoodStore gs=goodStoreDao.findById(2);
		System.out.println(gs);
		session.close();
	}
	@Test
	public void testFindAll(){
		List<GoodStore> gses=goodStoreDao.findAll();
		for(GoodStore gs:gses){
			System.out.println(gs);
		}
		session.close();
	}
	@Test
	public void testDelete(){
		goodStoreDao.deleteById(1);
		session.commit();
		session.close();
	}
	@Test
	public void testSave(){
		GoodStore gs=new GoodStore();
		gs.setStore_id(null);
		gs.setGoods_id(5);
		gs.setStore(155);
		gs.setEnable_store(150);
		gs.setOperate_type(0);//入库
		gs.setIntime(null);
		gs.setOutime(null);
		goodStoreDao.save(gs);
		session.commit();
		session.close();
	}
}
