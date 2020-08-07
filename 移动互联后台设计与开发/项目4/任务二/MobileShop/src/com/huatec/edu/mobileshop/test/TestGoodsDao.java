package com.huatec.edu.mobileshop.test;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.huatec.edu.mobileshop.dao.GoodsDao;
import com.huatec.edu.mobileshop.entity.Goods;
import com.huatec.edu.mobileshop.util.MybatisUtil;

public class TestGoodsDao {
	//获取SqlSession
	SqlSession session=MybatisUtil.getSqlSession();
	//1.产生一个实现类 2.创建实现类的实例
	GoodsDao goodsDao=session.getMapper(GoodsDao.class);
	
	@Test
	public void testDynamicUpdate(){
		Goods goods=new Goods();
		goods.setPrice(24.99);
		goods.setGoods_id(2);
		Timestamp now=new Timestamp(System.currentTimeMillis());
		goods.setLast_modify(now);
		goodsDao.dynamicUpdate(goods);
		session.commit();
		session.close();
	}
	@Test
	public void testFindById(){
		Goods gs=goodsDao.findById(2);
		System.out.println(gs);
		session.close();
	}
	@Test
	public void testFindAll(){
		List<Goods> gs=goodsDao.findAll();
		for(Goods g:gs){
			System.out.println(g);
		}
		session.close();
	}
	
	@Test
	public void testDelete(){
		goodsDao.deleteById(3);
		session.commit();
		session.close();
	}
	@Test
	public void testSave(){
		Goods goods=new Goods();
		goods.setGoods_id(null);
		goods.setName("汇源100%纯果汁 桃汁1L");
		goods.setSn("hygz003");
		goods.setBrief("汇源100%橙汁1L 出口标准升级装非可乐碳酸凉菜饮料");
		goods.setDescription("");
		goods.setPrice(23.88);
		goods.setCost(20.00);
		goods.setMktprice(30.00);
		goods.setMkt_enable(0);
		goods.setCat_id(2);
		goods.setBrand_id(6);
		goods.setWeight(1000.00);
		goods.setIntro("");
		goods.setParams("");
		goods.setCreatime(null);
		goods.setLast_modify(null);
		goods.setView_count(0);
		goods.setBuy_count(0);
		goods.setThumbnail("");
		goods.setBig("");
		goods.setSmall("");
		goods.setOriginal("");
		goodsDao.save(goods);
		session.commit();
		session.close();
	}
}
