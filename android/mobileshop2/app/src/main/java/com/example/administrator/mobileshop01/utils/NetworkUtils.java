package com.example.administrator.mobileshop01.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import androidx.appcompat.app.AppCompatActivity;

public class NetworkUtils {
    public static boolean isNetworkAvailable(AppCompatActivity act){
        Context context=act.getApplicationContext();
        ConnectivityManager connectivityManager= (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager==null){
            return false;
        }else {
            NetworkInfo[] networkInfoArr=connectivityManager.getAllNetworkInfo();
            if(networkInfoArr!=null&&networkInfoArr.length>0){
                for (int i=0;i<networkInfoArr.length;i++){
                    if(networkInfoArr[i].getState()== NetworkInfo.State.CONNECTED){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
