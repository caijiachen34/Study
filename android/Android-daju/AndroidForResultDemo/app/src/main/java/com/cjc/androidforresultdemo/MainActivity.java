package com.cjc.androidforresultdemo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btn_pay;
    private TextView tv_pay_result;
    private Context context;

    private static final int PAY_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = getApplicationContext();

        initView();
        initListener();


    }


    private void initView() {
        btn_pay = findViewById(R.id.btn_pay);
        tv_pay_result = findViewById(R.id.tv_pay_result);
    }

    private void initListener() {
        btn_pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,PayActivity.class);

                //1:设置startActivityForResult代替startActivity
                startActivityForResult(intent,PAY_REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //在这里会返回充值界面返回的数据
        if (requestCode == PAY_REQUEST_CODE) {
            String resultContent = null;
            if (resultCode == 2) {
                //充值成功
                resultContent = data.getStringExtra("resultContent");
            }else if (resultCode == 3){
                //充值失败
                resultContent = data.getStringExtra("resultContent");
            }
            tv_pay_result.setText(resultContent);
        }
    }
}