package com.cjc.componentdatadeliver;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;

/**
 * Created by CC
 **/
public class RegisterResultActivity extends Activity {

    private TextView registerresult;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        registerresult = findViewById(R.id.register_result_tv);

        Intent intent = getIntent();
        if (intent != null) {
            String usernameKey = intent.getStringExtra("usernameKey");
            String passwordKey = intent.getStringExtra("passwordKey");
            registerresult.setText("恭喜【"+usernameKey+" "+passwordKey+"】注册成功");
        }

    }
}
