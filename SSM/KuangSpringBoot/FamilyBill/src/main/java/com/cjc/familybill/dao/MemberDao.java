package com.cjc.familybill.dao;

import com.cjc.familybill.entity.Member;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface MemberDao {
    /* 此处的方法名与参数类型需和MemberSqlMap.xml中
     * 相应元素的id与parameterType的值相同
     */
    public int save(Member member);//insert元素
    public List<Member> findAll();//select元素
    public int updatePwdById(Map map);//update元素
    public int updatePwdByName(Map map);//update元素
    public int deleteById(int member_id);//delete元素
    public int dynamicUpdate(Member member);
    public Member findByName(String uname);//根据uname查询
    public Member findByEmail(String email);//根据email查询
    public Member findByMobile(String mobile);//根据email查询
    public Member findById(int member_id);//根据id查询
    public Member dynamicFind(Map map);
}
