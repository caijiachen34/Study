package com.cjc.activitylifecircledemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private static final String MSG_RECORD = "msg_record";
    private static final String RECORD_KEY = "msg";
    private EditText et_content;
    private Button btn_send;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initListener();
        //恢复数据
        sharedPreferences = getSharedPreferences(MSG_RECORD, MODE_PRIVATE);
        String record = sharedPreferences.getString(RECORD_KEY, null);
        if (!TextUtils.isEmpty(record)) {
            et_content.setText(record);
        }
    }

    private void initView() {
        et_content = findViewById(R.id.et_content);
        btn_send = findViewById(R.id.btn_send);
    }

    private void initListener() {
        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取内容
                String content = et_content.getText().toString().trim();
                if (TextUtils.isEmpty(content)) {
                    Toast.makeText(MainActivity.this,"请输入内容",Toast.LENGTH_SHORT).show();
                    return;
                }
                Log.d(TAG, "发送短信===>>>" + content);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //把数据用SharedPreferences保存起来
        String content = et_content.getText().toString().trim();
        if (TextUtils.isEmpty(content)) {
            Toast.makeText(this,"请输入要发送的内容",Toast.LENGTH_SHORT).show();
            return;
        }
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(RECORD_KEY,content);
        editor.commit();

    }
}