package com.cjc.bankservicedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void normalUserClick(View view){
        Intent intent = new Intent(this,NormalUserActivity.class);

        startActivity(intent);
    }

    public void bankWorkerClick(View view){
        Intent intent = new Intent(this,BankWorkerActivity.class);

        startActivity(intent);
    }

    public void bankBossClick(View view){
        Intent intent = new Intent(this,BankBossActivity.class);

        startActivity(intent);
    }

}