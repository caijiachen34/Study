package com.cjc.mpandroidcharttest;

import android.accounts.Account;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * Created by CC
 **/
public class DateActivity extends Activity {

    private int mYear;
    private int mMonth;

    DateFormat format = DateFormat.getDateTimeInstance();
    private Calendar calendar;
    private Button btnDate;
    private TextView txtDate;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date);
        init();
        initListener();
    }

    private void initListener() {
        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog(DateActivity.this,  4, txtDate, calendar);
            }
        });
    }

    public static void showDatePickerDialog(Activity activity, int themeResId, final TextView tv, Calendar calendar) {
        new DatePickerDialog(activity, themeResId, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                tv.setText("您选择了：" + year + "年" + (month + 1) + "月" + dayOfMonth + "日");
            }
        }, calendar.get(Calendar.YEAR)
                , calendar.get(Calendar.MONTH)
                , calendar.get(Calendar.DAY_OF_MONTH)).show();
    }

    private void init() {
        btnDate = findViewById(R.id.btn_Date);
        txtDate = findViewById(R.id.txtDate);
        calendar = Calendar.getInstance(Locale.CHINA);
        mYear = calendar.get(Calendar.YEAR);
        mMonth = calendar.get(Calendar.MONTH);
    }
}
