package com.huatec.edu.mobileshop.test;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.huatec.edu.mobileshop.dao.GoodsCatDao;
import com.huatec.edu.mobileshop.entity.GoodsCat;
import com.huatec.edu.mobileshop.util.MybatisUtil;

public class TestGoodsCatDao {
	//获取SqlSession
	SqlSession session=MybatisUtil.getSqlSession();
	//1.产生一个实现类 2.创建实现类的实例
	GoodsCatDao goodsCatDao=session.getMapper(GoodsCatDao.class);
	
	@Test
	public void testDynamicUpdate(){
		GoodsCat goodsCat=new GoodsCat();
		goodsCat.setName("茶饮料");
		goodsCat.setCat_id(4);
		Timestamp now=new Timestamp(System.currentTimeMillis());
		goodsCat.setModifytime(now);
		goodsCatDao.dynamicUpdate(goodsCat);
		session.commit();
		session.close();
	}
	@Test
	public void testFindById(){
		GoodsCat gc=goodsCatDao.findById(2);
		System.out.println(gc);
		session.close();
	}
	@Test
	public void testFindAll(){
		List<GoodsCat> gcs=goodsCatDao.findAll();
		for(GoodsCat gc:gcs){
			System.out.println(gc);
		}
		session.close();
	}
	@Test
	public void testDelete(){
		goodsCatDao.deleteById(3);
		session.commit();
		session.close();
	}
	@Test
	public void testSave(){
		GoodsCat goodsCat=new GoodsCat();
		goodsCat.setCat_id(null);
		goodsCat.setName("碳酸饮料");
		goodsCat.setParent_id(1);
		//分类的路径
		goodsCat.setCat_path("0,1,2");
		goodsCat.setGoods_count(0);
		goodsCat.setSort(0);
		goodsCat.setType_id(4);
		goodsCat.setList_show(0);
		goodsCat.setImage("");
		goodsCat.setCreatime(null);
		goodsCat.setModifytime(null);
		goodsCatDao.save(goodsCat);
		session.commit();
		session.close();
	}
}
