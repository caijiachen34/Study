package com.cjc.ouxun;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;

import com.cjc.ouxun.utils.Constant;

import cn.qqtheme.framework.picker.OptionPicker;
import cn.qqtheme.framework.picker.WheelPicker;
import cn.qqtheme.framework.widget.WheelView;

/**
 * Created by CC
 **/
public class LoginActivity extends Activity {


    private static final String TAG = "LoginActivity";

    private EditText editText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editText = findViewById(R.id.et_select);
        listner();

    }

    private void listner() {
        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPicker();
                Log.d(TAG, "onClick: ");
            }
        });
    }

    private void onPicker() {
        OptionPicker picker = new OptionPicker(this, Constant.personType);
        picker.setCycleDisable(true);
        picker.setTopBackgroundColor(0xFFEEEEEE);
        picker.setTopHeight(40);
        picker.setTopLineColor(0xff00574B);
        picker.setTopLineHeight(1);
        picker.setTitleText("请选择");
        picker.setTitleTextColor(Color.parseColor("#3366FF"));
        picker.setTitleTextSize(15);
        picker.setCancelTextColor(Color.parseColor("#3366FF"));
        picker.setCancelTextSize(16);
        picker.setSubmitTextColor(Color.parseColor("#3366FF"));
        picker.setSubmitTextSize(16);
        picker.setTextColor(Color.parseColor("#3366FF"),0xFF999999);
        picker.setTextSize(20);
        WheelView.DividerConfig config = new WheelView.DividerConfig();
        config.setColor(0xff00574B);
        config.setAlpha(140);
        config.setRatio((float)(1.0/8.0));
        picker.setDividerConfig(config);
        picker.setBackgroundColor(0xFFE1E1E1);
        picker.setSelectedIndex(7);
        picker.setCanceledOnTouchOutside(true);
        picker.setOnOptionPickListener(new OptionPicker.OnOptionPickListener() {
            @Override
            public void onOptionPicked(int index, String item) {
                editText.setText(item);
                Constant.current_crop_id = index;
            }
        });
        picker.show();
    }
}
