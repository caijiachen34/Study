package com.cjc.rxjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.cjc.rxjava.android_rx.RxUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void createMethod(View view){
        RxUtils.createObserable();
    }

    public void createMethod2(View view){
        RxUtils.createPrint();
    }

    public void formMethod(View view){
        RxUtils.from();
    }

    public void intervalMethod(View view){
        RxUtils.interval();
    }

    public void justMethod(View view){
        RxUtils.just();
    }

    public void rangeMethod(View view){
        RxUtils.range();
    }

    public void filterMethod(View view){
        RxUtils.filter();
    }
}