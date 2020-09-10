package com.cjc.familybill.service;

import com.cjc.familybill.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


public interface MemberService {
    //会员注册
    public Result registMember(String uname,String password,String email,String mobile);
    //会员登录
    public Result checkLogin(String uname,String password);
    //根据id加载会员信息
    public Result loadMemberById(int memberId);
    //根据id更新会员基本信息
    public Result updateMember(int memberId,String uname,String email,int sex,String mobile);
    //根据id修改密码
    public Result updatePwd(int memberId, String oldPwd, String newPwd);
    //根据uname修改密码
    public Result updatePwdByName(String uname, String oldPwd, String newPwd);
    //根据邮箱重置密码
    public Result resetPwd(String email);
    //根据id更新image（设置会员头像）
    public Result updateImage(int memberId, String img, String url);
    //根据用户名/邮箱/电话号进行登录
    public Result checkLogin2(String input,String password);
    //查询用户名/邮箱/手机号是否已注册
    public Result checkIsUsed(String input);
    //上传头像
    public Result addImage(String uname,MultipartFile file, HttpServletRequest request) throws IOException;

}
