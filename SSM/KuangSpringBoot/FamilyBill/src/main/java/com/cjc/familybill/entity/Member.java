package com.cjc.familybill.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member implements Serializable {
    private Integer member_id;//编号
    private String uname;//会员名
    private String password;//密码
    private String email;//邮箱
    private Integer sex;//性别，男：0，女：1
    private String mobile;//手机号
    @JsonFormat(timezone = "GMT+8")
    private Timestamp regtime;//注册时间
    @JsonFormat(timezone = "GMT+8")
    private Timestamp lastlogin;//最后登录时间
    private String image;//头像

}
