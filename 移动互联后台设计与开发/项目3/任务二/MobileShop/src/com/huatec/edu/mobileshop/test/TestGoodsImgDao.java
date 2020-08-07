package com.huatec.edu.mobileshop.test;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.huatec.edu.mobileshop.dao.GoodsImgDao;
import com.huatec.edu.mobileshop.entity.GoodsImg;
import com.huatec.edu.mobileshop.util.MybatisUtil;

public class TestGoodsImgDao {
	//获取SqlSession
	SqlSession session=MybatisUtil.getSqlSession();
	//1.产生一个实现类 2.创建实现类的实例
	GoodsImgDao goodsImgDao=session.getMapper(GoodsImgDao.class);
	
	@Test
	public void testDynamicUpdate(){
		GoodsImg gi=new GoodsImg();
		gi.setGoods_id(4);
		Timestamp now=new Timestamp(System.currentTimeMillis());
		gi.setModifytime(now);
		gi.setImg_id(3);
		goodsImgDao.dynamicUpdate(gi);
		session.commit();
		session.close();
	}
	
	@Test
	public void testFindById(){
		GoodsImg gi=goodsImgDao.findById(1);
		System.out.println(gi);
		session.close();
	}
	
	@Test
	public void testFindAll(){
		List<GoodsImg> gis=goodsImgDao.findAll();
		for(GoodsImg gi:gis){
			System.out.println(gi);
		}
		session.close();
	}
	
	@Test
	public void testDelete(){
		goodsImgDao.deleteById(2);
		session.commit();
		session.close();
	}
	
	@Test
	public void testSave(){
		GoodsImg gi=new GoodsImg();
		gi.setImg_id(null);
		gi.setGoods_id(2);
		gi.setThumbnail("7_thumbnail.jpg");
		gi.setBig("7_big.jpg");
		gi.setSmall("7_small.jpg");
		gi.setOriginal("7_original.jpg");
		gi.setIsdefault(1);
		gi.setCreatime(null);
		gi.setModifytime(null);
		goodsImgDao.save(gi);
		session.commit();
		session.close();
	}
}
