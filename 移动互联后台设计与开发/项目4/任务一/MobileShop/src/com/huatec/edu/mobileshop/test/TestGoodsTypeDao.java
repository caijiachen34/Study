package com.huatec.edu.mobileshop.test;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.huatec.edu.mobileshop.dao.GoodsTypeDao;
import com.huatec.edu.mobileshop.entity.GoodsType;
import com.huatec.edu.mobileshop.util.MybatisUtil;

import net.sf.json.JSONObject;

public class TestGoodsTypeDao {
	//获取SqlSession
	SqlSession session=MybatisUtil.getSqlSession();
	//1.产生一个实现类 2.创建实现类的实例
	GoodsTypeDao goodsTypeDao=session.getMapper(GoodsTypeDao.class);
	//测试查询
	
	@Test
	public void testDynamicUpdate(){
		GoodsType goodsType=new GoodsType();
		goodsType.setName("酒水test");
		//获取当前系统时间
		Timestamp now=new Timestamp(System.currentTimeMillis());
		goodsType.setModifytime(now);
		goodsType.setType_id(6);
		goodsTypeDao.dynamicUpdate(goodsType);
		session.commit();
		session.close();
	}
	@Test
	public void testFindById(){
		GoodsType gt=goodsTypeDao.findById(4);
		System.out.println(gt);
		session.close();
	}
	@Test
	public void testFindAll(){
		List<GoodsType> gts=goodsTypeDao.findAll();
		for(GoodsType gt:gts){
			System.out.println(gt);
		}
		session.close();
	}
	//测试删除
	@Test
	public void testDelete(){
		goodsTypeDao.deleteById(3);
		session.commit();
		session.close();
	}
	//测试添加
	@Test
	public void testSave(){
		GoodsType goodsType=new GoodsType();
		//构建参数
		//因为一个类型的参数有很多，所以采用map的形式
		//Map<String,Object> map2=new HashMap<String,Object>();
		Map<String,Object> map3=new HashMap<String,Object>();
		map3.put("产地", "");
		map3.put("配料", "");
		map3.put("储存方法", "");
		map3.put("净含量", "");
		map3.put("保质期", "");
		map3.put("品种", "");
		//map2.put("参数", map3);
		//将map转为json
		//JSONObject jsonParams=JSONObject.fromObject(map2);
		JSONObject jsonParams=JSONObject.fromObject(map3);
		//设置值
		goodsType.setType_id(null);
		goodsType.setName("酒水2");
		//将json格式的数据转换成字符串存入params字段中
		goodsType.setParams(jsonParams.toString());
		goodsType.setDisabled(0);
		goodsType.setIs_physical(0);
		goodsType.setCreatime(null);
		goodsType.setModifytime(null);
		goodsTypeDao.save(goodsType);
		session.commit();
		session.close();
	}
}
