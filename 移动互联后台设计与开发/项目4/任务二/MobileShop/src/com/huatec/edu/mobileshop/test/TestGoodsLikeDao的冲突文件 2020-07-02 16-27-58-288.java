package com.huatec.edu.mobileshop.test;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.huatec.edu.mobileshop.dao.GoodsLikeDao;
import com.huatec.edu.mobileshop.entity.GoodsLike;
import com.huatec.edu.mobileshop.util.MybatisUtil;

public class TestGoodsLikeDao {
	//获取SqlSession
	SqlSession session=MybatisUtil.getSqlSession();
	//1.产生一个实现类 2.创建实现类的实例
	GoodsLikeDao goodsLikeDao=session.getMapper(GoodsLikeDao.class);
	
	@Test
	public void testDynamicUpdate(){
		GoodsLike gl=new GoodsLike();
		gl.setMember_id(3);
		gl.setLike_id(1);
		Timestamp now=new Timestamp(System.currentTimeMillis());
		gl.setModifytime(now);
		goodsLikeDao.dynamicUpdate(gl);
		session.commit();
		session.close();
	}
	@Test
	public void testFindById(){
		GoodsLike gl=goodsLikeDao.findById(1);
		System.out.println(gl);
		session.close();
	}
	@Test
	public void testFindAll(){
		List<GoodsLike> gls=goodsLikeDao.findAll();
		for(GoodsLike gl:gls){
			System.out.println(gl);
		}
		session.close();
	}
	@Test
	public void testDelete(){
		goodsLikeDao.deleteById(3);
		session.commit();
		session.close();
	}
	@Test
	public void testSave(){
		GoodsLike gl=new GoodsLike();
		gl.setLike_id(null);
		gl.setGoods_id(5);
		gl.setMember_id(2);
		gl.setCreatime(null);
		gl.setModifytime(null);
		goodsLikeDao.save(gl);
		session.commit();
		session.close();
	}
}
