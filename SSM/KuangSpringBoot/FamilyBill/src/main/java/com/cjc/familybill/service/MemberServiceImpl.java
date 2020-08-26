package com.cjc.familybill.service;

import com.cjc.familybill.dao.MemberDao;
import com.cjc.familybill.entity.Member;
import com.cjc.familybill.util.MSUtil;
import com.cjc.familybill.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberDao memberDao;

    //注册
    @Override
    public Result registMember(String uname, String password, String email,String mobile) {
        Result result = new Result();
        Member checkMember1 = memberDao.findByName(uname);
        if (checkMember1 != null) {
            result.setStatus(1);
            result.setMsg("此用户已存在");
            return result;
        }
        Member checkMember2 = memberDao.findByEmail(email);
        if (checkMember2 != null) {
            result.setStatus(1);
            result.setMsg("此邮箱已存在");
            return result;
        }
        Member checkMember3 = memberDao.findByMobile(mobile);
        if (checkMember3 != null) {
            result.setStatus(1);
            result.setMsg("此手机号已存在");
            return result;
        }
        Member member = new Member();
        member.setMember_id(null);
        member.setUname(uname);
        //密码加密
        String md5_pwd = MSUtil.md5(password);
        member.setPassword(md5_pwd);
        member.setEmail(email);
        member.setSex(1); //默认为男
        member.setMobile(mobile);
        member.setRegtime(null);
        member.setLastlogin(null);
        member.setImage("");
        //调用memberDao的save方法将数据存入数据库
        memberDao.save(member);
        //装载结果信息
        result.setStatus(0);
        result.setMsg("注册成功");
        result.setData(member);
        return result;
    }

    //登录
    @Override
    public Result checkLogin(String uname, String password) {
        Result result = new Result();
        Member member = memberDao.findByName(uname);
        if (member==null) {
            result.setStatus(1);
            result.setMsg("此用户不存在");
            return result;
        }
        String md5_pwd = MSUtil.md5(password);
        if (!md5_pwd.equals(member.getPassword())) {
            result.setStatus(1);
            result.setMsg("密码错误");
            return result;
        }
        //更新最后登录时间
        Integer member_id = member.getMember_id();
        Member updateMember = new Member();
        updateMember.setMember_id(member_id);
        //获取系统当前时间
        Timestamp now = new Timestamp(System.currentTimeMillis());
        updateMember.setLastlogin(now);
        updateMember.setSex(0);
        memberDao.dynamicUpdate(updateMember);
        Member member3 = memberDao.findByName(uname);
        result.setStatus(0);
        result.setMsg("登录成功");
        result.setData(member3);
        return result;
    }

    @Override
    public Result loadMemberById(int memberId) {
        Result result=new Result();
        Member member=memberDao.findById(memberId);
        //判断此会员是否存在
        if(member==null){
            result.setStatus(1);
            result.setMsg("此会员不存在");
            return result;
        }
        result.setStatus(0);
        result.setMsg("加载此会员信息成功");
        result.setData(member);
        return result;
    }

    @Override
    public Result updateMember(int memberId, String uname, String email, int sex, String mobile) {
        return null;
    }

    @Override
    public Result updatePwd(int memberId, String oldPwd, String newPwd) {
        return null;
    }

    @Override
    public Result resetPwd(String email) {
        return null;
    }

    @Override
    public Result updateImage(int memberId, String img, String url) {
        return null;
    }

    @Override
    public Result checkLogin2(String input, String password) {
        return null;
    }
}
