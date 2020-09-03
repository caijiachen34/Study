package com.cjc.familybill.activitys;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;

import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {

//    public void showGoods(int goodsId){
//        Intent intent=new Intent(this,GoodsActivity.class);
//        intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
//        intent.putExtra("goodsId",goodsId);
//        startActivity(intent);
//    }

    public boolean isLogin(){
        SharedPreferences sharedPreferences=getSharedPreferences("loginInfo",0);
        return !TextUtils.isEmpty(sharedPreferences.getString("loginUserName",""));
    }


    public String getUname(Context context){
        SharedPreferences sp = context.getSharedPreferences("loginInfo", MODE_PRIVATE);
        String uname = sp.getString("loginUserName", "");
        return uname;
    }
}
