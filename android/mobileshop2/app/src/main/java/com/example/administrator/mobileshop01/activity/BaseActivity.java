package com.example.administrator.mobileshop01.activity;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;

import androidx.appcompat.app.AppCompatActivity;

import com.example.administrator.mobileshop01.R;

public class BaseActivity extends AppCompatActivity {

    public void showGoods(int goodsId){
        Intent intent=new Intent(this,GoodsActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        intent.putExtra("goodsId",goodsId);
        startActivity(intent);
    }

    public boolean isLogin(){
        SharedPreferences sharedPreferences=getSharedPreferences("user",0);
        return TextUtils.isEmpty(sharedPreferences.getString("username",""));
    }
}
