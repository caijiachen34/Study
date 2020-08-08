package com.cjc.androidforresultdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PayActivity extends AppCompatActivity {

    private EditText et_pay_input;
    private Button btn_pay2;
    private Button btn_pay_cancel;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);
        initView();
        initListener();
        context = getApplicationContext();
    }


    private void initView() {
        et_pay_input = findViewById(R.id.et_pay_input);
        btn_pay2 = findViewById(R.id.btn_pay2);
        btn_pay_cancel = findViewById(R.id.btn_pay_cancel);
    }

    private void initListener() {

        btn_pay2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handlerpay();
            }
        });

        btn_pay_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handlerCancel();
            }
        });

    }

    private void handlerpay() {
        String paynumber = et_pay_input.getText().toString().trim();
        if (TextUtils.isEmpty(paynumber)) {
            Toast.makeText(context,"请输入金额",Toast.LENGTH_SHORT).show();
            return;
        }

        //进行充值

        Intent intent = new Intent();
        intent.putExtra("resultContent","充值成功");
        setResult(2,intent);
        finish();
    }

    private void handlerCancel() {
        Intent intent = new Intent();
        intent.putExtra("resultContent","充值失败");
        setResult(3,intent);
        finish();
    }


}