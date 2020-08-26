package com.cjc.familybill.entity;

import android.content.Intent;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by CC
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberEntity {
    private int member_id;
    private String uname;
    private String email;
    private int sex;
    private String mobil;
    private Object regtime;
    private Object lastlogin;
    private String image;

}
