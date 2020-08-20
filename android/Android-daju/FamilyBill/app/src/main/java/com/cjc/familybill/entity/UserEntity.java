package com.cjc.familybill.entity;

import android.content.Intent;

/**
 * Created by CC
 **/
public class UserEntity {
    private Integer user_id;
    private String uname;
    private String email;
    private String mobile;
    private Object regtime;
    private Object lastlogin;
    private String image;

    @Override
    public String toString() {
        return "UserEntity{" +
                "user_id=" + user_id +
                ", uname='" + uname + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", regtime=" + regtime +
                ", lastlogin=" + lastlogin +
                ", image='" + image + '\'' +
                '}';
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
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
