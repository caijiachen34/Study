package com.cjc.familybill.activitys;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

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

    //根据值选中spinner方法
    public int setSpinnerItemSelectedByValue(Spinner spinner, String value) {
        SpinnerAdapter apsAdapter = spinner.getAdapter(); //得到SpinnerAdapter对象
        int k = apsAdapter.getCount();
        Log.d("AccountChangeActivity", "k: " + k);
        for (int i = 0; i < k; i++) {
            if (value.equals(apsAdapter.getItem(i).toString())) {
                Log.d("AccountChangeActivity", "setSpinnerItemSelectedByValue: " + apsAdapter.getItem(i).toString());
                spinner.setSelection(i, true);// 默认选中项
            }
        }
        return 0;
    }
}
