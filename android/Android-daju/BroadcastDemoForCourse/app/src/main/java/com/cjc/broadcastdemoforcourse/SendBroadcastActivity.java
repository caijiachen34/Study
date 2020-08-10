package com.cjc.broadcastdemoforcourse;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;

/**
 * Created by CC
 **/
public class SendBroadcastActivity extends Activity {

    private Button btn_send;
    private EditText et_content;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send);
        initView();
        initListener();
    }

    private void initView() {
        btn_send = findViewById(R.id.btn_send);
        et_content = findViewById(R.id.et_content);
    }

    /*
    *
    * */
    private void initListener() {
        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //调用以后去发送广播
                String content = et_content.getText().toString().trim();
                Intent intent = new Intent();
                intent.setAction(Constants.ACTION_SEND_MSG);
                intent.putExtra(Constants.KEY_CONTENT,content);
                //发射广播
                sendBroadcast(intent);
            }
        });
    }
}
