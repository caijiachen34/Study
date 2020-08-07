package com.cjc;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.Switch;

import androidx.annotation.Nullable;

public class PreferenceDemoActivity extends Activity {

    private static final String TAG = "PreferenceDemoActivity";
    private Switch misAllowUnknownSource;
    private SharedPreferences msharedPreferences;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preference_demo);
        misAllowUnknownSource = this.findViewById(R.id.is_allow_unknown_app_sources_switch);
        initListener();
        //1.拿到SharedPreferences
        msharedPreferences = this.getSharedPreferences("settings_info", MODE_PRIVATE);
        //5.sharedPreferences数据的回显（defValue:数据的默认值）
        boolean state = msharedPreferences.getBoolean("state", false);
        misAllowUnknownSource.setChecked(state);
    }

    private void initListener() {
        misAllowUnknownSource.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.d(TAG,"current state ==" + isChecked);
                //2.进入编辑模式
                SharedPreferences.Editor edit = msharedPreferences.edit();
                //3.保存数据
                edit.putBoolean("state",isChecked);
                //4.提交编辑器
                edit.commit();
            }
        });
    }
}
