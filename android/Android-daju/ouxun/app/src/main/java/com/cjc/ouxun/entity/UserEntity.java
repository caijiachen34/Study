package com.cjc.ouxun.entity;

/**
 * Created by CC
 **/
public class UserEntity {

    private String csrq;
    private Object create_time;
    private String modify_time;
    private String mobile;
    private int modify_by;
    private String dept_bm;
    private String is_delete;
    private Object create_by;
    private String is_dept_manager;
    private String xb_dm;
    private String nickname;
    private String tel;
    private int id;
    private String sfzjhm;
    private int dept_id;
    private String qtbz_dm;
    private int order_id;
    private String email;
    private String username;
    private String status;

    @Override
    public String toString() {
        return "UserEntity{" +
                "csrq='" + csrq + '\'' +
                ", create_time=" + create_time +
                ", modify_time='" + modify_time + '\'' +
                ", mobile='" + mobile + '\'' +
                ", modify_by=" + modify_by +
                ", dept_bm='" + dept_bm + '\'' +
                ", is_delete='" + is_delete + '\'' +
                ", create_by=" + create_by +
                ", is_dept_manager='" + is_dept_manager + '\'' +
                ", xb_dm='" + xb_dm + '\'' +
                ", nickname='" + nickname + '\'' +
                ", tel='" + tel + '\'' +
                ", id=" + id +
                ", sfzjhm='" + sfzjhm + '\'' +
                ", dept_id=" + dept_id +
                ", qtbz_dm='" + qtbz_dm + '\'' +
                ", order_id=" + order_id +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public String getCsrq() {
        return csrq;
    }

    public void setCsrq(String csrq) {
        this.csrq = csrq;
    }

    public Object getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Object create_time) {
        this.create_time = create_time;
    }

    public String getModify_time() {
        return modify_time;
    }

    public void setModify_time(String modify_time) {
        this.modify_time = modify_time;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getModify_by() {
        return modify_by;
    }

    public void setModify_by(int modify_by) {
        this.modify_by = modify_by;
    }

    public String getDept_bm() {
        return dept_bm;
    }

    public void setDept_bm(String dept_bm) {
        this.dept_bm = dept_bm;
    }

    public String getIs_delete() {
        return is_delete;
    }

    public void setIs_delete(String is_delete) {
        this.is_delete = is_delete;
    }

    public Object getCreate_by() {
        return create_by;
    }

    public void setCreate_by(Object create_by) {
        this.create_by = create_by;
    }

    public String getIs_dept_manager() {
        return is_dept_manager;
    }

    public void setIs_dept_manager(String is_dept_manager) {
        this.is_dept_manager = is_dept_manager;
    }

    public String getXb_dm() {
        return xb_dm;
    }

    public void setXb_dm(String xb_dm) {
        this.xb_dm = xb_dm;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSfzjhm() {
        return sfzjhm;
    }

    public void setSfzjhm(String sfzjhm) {
        this.sfzjhm = sfzjhm;
    }

    public int getDept_id() {
        return dept_id;
    }

    public void setDept_id(int dept_id) {
        this.dept_id = dept_id;
    }

    public String getQtbz_dm() {
        return qtbz_dm;
    }

    public void setQtbz_dm(String qtbz_dm) {
        this.qtbz_dm = qtbz_dm;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
