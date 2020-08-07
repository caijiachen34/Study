package com.cjc;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class SDCardDemoActivity extends Activity {

    private Button writeDataBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sd_card);
        writeDataBtn = this.findViewById(R.id.write_data_2_sd_card_btn);
        writeDataBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //写数据到sd卡
                File filePath = new File("/storage/sdcard");
                File file = new File(filePath,"info.txt");

                try {
                    FileOutputStream fos = new FileOutputStream(file);
                    fos.write("cc".getBytes());
                    fos.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
