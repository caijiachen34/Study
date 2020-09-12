package com.cjc.familybill.service;

import com.cjc.familybill.dao.MemberDao;
import com.cjc.familybill.entity.Member;
import com.cjc.familybill.util.MSUtil;
import com.cjc.familybill.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

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
        Timestamp now = new Timestamp(System.currentTimeMillis());
        member.setPassword(md5_pwd);
        member.setEmail(email);
        member.setSex(1); //默认为男
        member.setMobile(mobile);
        member.setRegtime(now);
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
    public Result updatePwdByName(String uname, String oldPwd, String newPwd) {
        Result result=new Result();
        Member checkMember=memberDao.findByName(uname);
        if(checkMember==null){
            result.setStatus(1);
            result.setMsg("不存在此用户");
            return result;
        }
        //判断输入的原密码是否正确
        System.out.println("用户名:" + uname);
        System.out.println("老密码:" + oldPwd);
        System.out.println("新密码:" + newPwd);
        String md5_oldPwd=MSUtil.md5(oldPwd);
        String md5_newPwd=MSUtil.md5(newPwd);
        System.out.println("原密码加密："+md5_oldPwd);
        System.out.println("数据库中原密码："+checkMember.getPassword());
        if(!md5_oldPwd.equals(checkMember.getPassword())){
            result.setStatus(1);
            result.setMsg("输入的原密码有误");
            return result;
        }
        //更新密码
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("uname",uname);
        map.put("password",md5_newPwd);
        int i = memberDao.updatePwdByName(map);
        System.out.println(i);
        result.setStatus(0);
        result.setMsg("修改密码成功");
        return result;
    }

    @Override
    public Result resetPwd(String email) {
        return null;
    }

    @Override
    public Result updateImage(int memberId, String img, String url) {
        return null;
    }

    //根据用户名/邮箱/电话号进行登录
    public Result checkLogin2(String input, String password) {
        Result result=new Result();
        //手机号的正则表达式
        String regexMobile="\\d{11}";
        //邮箱的正则表达式
        String regexEmail="\\w+@\\w+(\\.[a-zA-Z]+)+";
        if("".equals(input)){
            result.setStatus(1);
            result.setMsg("输入的用户名/邮箱/手机号为空");
            return result;
        }
        //手机号登录
        if(input.matches(regexMobile)){
            Map<String,Object> map=new HashMap<String,Object>();
            map.put("mobile", input);
            Member member=memberDao.dynamicFind(map);
            return check(password,member);
        }
        //邮箱登录
        if(input.matches(regexEmail)){
            Map<String,Object> map=new HashMap<String,Object>();
            map.put("email", input);
            Member member=memberDao.dynamicFind(map);
            return check(password,member);
        }
        //用户名登录
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("uname", input);
        Member member=memberDao.dynamicFind(map);
        return check(password,member);
    }

    private Result check(String password, Member member) {
        Result result=new Result();
        if(member==null){
            result.setStatus(1);
            result.setMsg("不存在此用户");
            return result;
        }
        if(!MSUtil.md5(password).equals(member.getPassword())){
            result.setStatus(1);
            result.setMsg("密码不正确");
            return result;
        }
        result.setStatus(0);
        result.setMsg("登录成功");
        result.setData(member);
        return result;
    }

    @Override
    public Result checkIsUsed(String input) {
        Result result=new Result();
        //手机号的正则表达式
        String regexMobile="\\d{11}";
        //邮箱的正则表达式
        String regexEmail="\\w+@\\w+(\\.[a-zA-Z]+)+";
        if("".equals(input)){
            result.setStatus(1);
            result.setMsg("输入的用户名/邮箱/手机号为空");
            return result;
        }
        //手机号登录
        if(input.matches(regexMobile)){
            Map<String,Object> map=new HashMap<String,Object>();
            map.put("mobile", input);
            Member member=memberDao.dynamicFind(map);
            result.setStatus(0);
            result.setMsg("手机号存在");
            result.setData(member);
            return result;
        }
        //邮箱登录
        if(input.matches(regexEmail)){
            Map<String,Object> map=new HashMap<String,Object>();
            map.put("email", input);
            Member member=memberDao.dynamicFind(map);
            result.setStatus(0);
            result.setMsg("邮箱已存在");
            result.setData(member);
            return result;
        }
        //用户名登录
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("uname", input);
        Member member=memberDao.dynamicFind(map);
        result.setStatus(0);
        result.setMsg("用户名已存在");
        result.setData(member);
        return result;
    }

    @Override
    public Result addImage(String uname,MultipartFile file, HttpServletRequest request) throws IOException {
        //1.确定保存的文件夹
        String dirPath = request.getServletContext().getRealPath("upload");
        System.out.println("dirPath="+dirPath);
        File dir = new File(dirPath);
        if(!dir.exists()) {
            dir.mkdirs();
        }
        //2.确定保存的文件名
        String orginalFilename = file.getOriginalFilename();
        int beginIndex = orginalFilename.lastIndexOf(".");
        String suffix ="";
        if(beginIndex!=-1) {
            suffix = orginalFilename.substring(beginIndex);
        }
        String filename = UUID.randomUUID().toString()+suffix;
        //创建文件对象，表示要保存的头像文件,第一个参数表示存储的文件夹，第二个参数表示存储的文件
        File dest = new File(dir,filename);
        //执行保存
        file.transferTo(dest);
        String image = "upload/"+filename;
        memberDao.addImage(image,uname);
        Result result = new Result();
        result.setStatus(0);
        result.setMsg("上传成功");
        return result;
    }

    @Override
    public Result findByName(String uname) {
        Result result = new Result();
        Member member = memberDao.findByName(uname);
        if (member == null) {
            result.setStatus(1);
            result.setMsg("查询失败");
            return result;
        }
        result.setData(0);
        result.setMsg("查询成功");
        result.setData(member);
        return result;
    }
}
