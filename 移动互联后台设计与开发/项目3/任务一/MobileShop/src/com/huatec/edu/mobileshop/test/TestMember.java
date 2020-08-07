package com.huatec.edu.mobileshop.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.huatec.edu.mobileshop.entity.Member;
import com.huatec.edu.mobileshop.util.MybatisUtil;

public class TestMember {
	@Test
	public void testInsert(){
		//获取SqlSession
		SqlSession session=MybatisUtil.getSqlSession();
		Member member=new Member();
		member.setMember_id(null);//主键自增，直接赋值为null即可
		member.setUname("李四");
		member.setPassword("123456");
		member.setEmail("ls@qq.com");
		member.setSex(0);
		member.setMobile("13687654321");
		member.setRegtime(null);//默认当前系统时间，直接赋值为null即可
		member.setLastlogin(null);
		member.setImage("");
		//使用session的insert方法插入数据
		//save为MemberSqlMap.xml中insert元素的id名
		session.insert("save",member);
		//增删改需要提交事务
		session.commit();
		//用过后需将session关闭
		session.close();
	}
	
	@Test
	public void testSelect(){
		SqlSession session=MybatisUtil.getSqlSession();
		//因为findAll是查询所有的会员，使用session的selectList方法
		List<Member> members=session.selectList("findAll");
		for(Member member:members){
			System.out.println(member);
		}
		session.close();
	}
	
	@Test
	public void testUpdate(){
		SqlSession session=MybatisUtil.getSqlSession();
		//MemberSqlMap.xml中update元素中传入的参数是map
		Map<String,Object> params=new HashMap<String,Object>();
		//将张三的密码修改为1234
		params.put("password", "1234");
		params.put("member_id", 1);
		session.update("updatePwdById", params);
		session.commit();
		session.close();
	}
	
	@Test
	public void testDelete(){
		SqlSession session=MybatisUtil.getSqlSession();
		//将张三那条记录从数据库中删除
		session.delete("deleteById",1);
		session.commit();
		session.close();
	}
}
