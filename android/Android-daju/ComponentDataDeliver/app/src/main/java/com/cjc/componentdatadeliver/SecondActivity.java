package com.cjc.componentdatadeliver;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;

import androidx.annotation.Nullable;

import java.io.Serializable;

/**
 * Created by CC
 **/
public class SecondActivity extends Activity {

    private static final String TAG = "SecondActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();
        if (intent != null) {
            /* 传递基本数据类型 */
            //defaultValue:未传值时的默认值:-1
            int intKey = intent.getIntExtra("intKey", -1);
            boolean booleanKey = intent.getBooleanExtra("booleanKey", false);
            Log.d(TAG, "int Value ==>>" + intKey) ;
            Log.d(TAG, "boolean Value ==>>" + booleanKey) ;

            /* 传递对象 */
            User userKey = intent.getParcelableExtra("userKey");
            if (userKey != null) {
                Log.d(TAG, "username ===>>> " + userKey.getName());
                Log.d(TAG, "userage  ===>>> " + userKey.getAge());
                Log.d(TAG, "usertall ===>>> " + userKey.getTall());
                Log.d(TAG, "userKey  ===>>> " + userKey);
            }

            Serializable stringKey = intent.getSerializableExtra("stringKey");
            Parcelable bitmap = intent.getParcelableExtra("bitmap");
            Log.d(TAG, "stringKey  ===>>> " + stringKey);
            Log.d(TAG, "bitmap  ===>>> " + bitmap);


        }
    }
}
