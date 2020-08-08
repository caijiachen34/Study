package com.cjc.componentdatadeliver;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;

/**
 * Created by CC
 **/
public class SendMsgActivity extends Activity {

    private static final String TAG = "SendMsgActivity";
    private EditText receiver_phone_number;
    private EditText message_content;
    private Button send_msg;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_msm);

        initView();
        initListener();

        Intent intent = getIntent();
        if (intent != null) {
            String targetNumber = intent.getStringExtra("targetNumberKey");
            Log.d(TAG, "targetNumber===>>> " + targetNumber);
            receiver_phone_number.setText(targetNumber);
            //getData:自动传过来
            Uri data = intent.getData();
            Log.d(TAG, "data===>>> " + data);
            if (data != null) {
                String content = data.toString().replace("msg:", "");
                message_content.setText(content);
            }
        }
    }

    private void initView() {
        receiver_phone_number = findViewById(R.id.receiver_phone_number_et);
        message_content = findViewById(R.id.message_content_et);
        send_msg = findViewById(R.id.send_msg_btn);
    }

    private void initListener() {
        send_msg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

}
