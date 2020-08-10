package com.cjc.broadcastdemoforcourse;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

/**
 * Created by CC
 **/
public class SendOrderBroadcastActivity extends Activity {

    private Button btn_send_order;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_order);
        initView();
        initListener();
    }

    private void initView() {
        btn_send_order = findViewById(R.id.btn_send_order);
    }

    private void initListener() {
        btn_send_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Constants.ACTION_ORDER_BROADCAST);
                Bundle bundle = new Bundle();
                bundle.putCharSequence("content","上面分了五万元，请发到下级");
                sendOrderedBroadcast(intent,null,null,null,Activity.RESULT_OK,null,bundle);
            }
        });
    }
}
