package com.cjc.ouxun.entity;


/**
 * Created by CC
 **/

public class MemberEntity {
    private int member_id;
    private String uname;
    private String email;
    private int sex;
    private String mobile;
    private Object regtime;
    private Object lastlogin;
    private String image;

    @Override
    public String toString() {
        return "MemberEntity{" +
                "member_id=" + member_id +
                ", uname='" + uname + '\'' +
                ", email='" + email + '\'' +
                ", sex=" + sex +
                ", mobile='" + mobile + '\'' +
                ", regtime=" + regtime +
                ", lastlogin=" + lastlogin +
                ", image='" + image + '\'' +
                '}';
    }

    public int getMember_id() {
        return member_id;
    }

    public void setMember_id(int member_id) {
        this.member_id = member_id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Object getRegtime() {
        return regtime;
    }

    public void setRegtime(Object regtime) {
        this.regtime = regtime;
    }

    public Object getLastlogin() {
        return lastlogin;
    }

    public void setLastlogin(Object lastlogin) {
        this.lastlogin = lastlogin;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
