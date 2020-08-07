package com.huatec.edu.mobileshop.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.huatec.edu.mobileshop.dao.MemberDao;
import com.huatec.edu.mobileshop.entity.Member;
import com.huatec.edu.mobileshop.entity.MemberAddress;
import com.huatec.edu.mobileshop.util.MybatisUtil;

public class TestMemberDao {
	//获取SqlSession
	SqlSession session=MybatisUtil.getSqlSession();
	//1.产生一个实现类 2.创建实现类的实例
	MemberDao memberDao=session.getMapper(MemberDao.class);
	
	@Test
	public void testfindUnion(){
		List<Member> members=memberDao.findUnion(2);
		for(Member member:members){
			System.out.println(member.getUname());
			List<MemberAddress> mas=member.getMemberAddresses();
			for(MemberAddress ma:mas){
				System.out.println(ma);
			}
		}
		session.close();
	}
	@Test
	public void testDynamicUpdate(){
		Member m=new Member();
//		m.setUname("李四");
//		m.setPassword("ls123");
		m.setMobile("13887432165");
		m.setMember_id(2);
		int rows=memberDao.dynamicUpdate(m);
		System.out.println(rows);
		session.commit();
		session.close();
	}
	@Test
	public void testSave(){
		Member member=new Member();
		member.setMember_id(null);//主键自增，直接赋值为null即可
		member.setUname("王五");
		member.setPassword("123456");
		member.setEmail("ww@qq.com");
		member.setSex(0);
		member.setMobile("13643218765");
		member.setRegtime(null);//默认当前系统时间，直接赋值为null即可
		member.setLastlogin(null);
		member.setImage("");
		memberDao.save(member);
		session.commit();
		session.close();
	}
	
	@Test
	public void testFindAll(){
		List<Member> members=memberDao.findAll();
		for(Member member:members){
			System.out.println(member);
		}
		session.close();
	}
	
	
}
