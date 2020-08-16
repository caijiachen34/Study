package com.cjc.recyclerviewtest;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cjc.recyclerviewtest.adapters.MoreTypeAdapter;
import com.cjc.recyclerviewtest.beans.Datas;
import com.cjc.recyclerviewtest.beans.MoreTypeBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by CC
 **/
public class MoreTypeActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<MoreTypeBean> mdata;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_activity);

        //找到控件
        recyclerView = findViewById(R.id.more_type_list);

        //准备数据
        mdata = new ArrayList<>();

        initDatas();

        //设置布局管理器
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        //创建适配器
        MoreTypeAdapter adapter = new MoreTypeAdapter(mdata);

        //设置适配器
        recyclerView.setAdapter(adapter);


    }

    private void initDatas() {
        Random random = new Random();


        for (int i = 0; i < Datas.icons.length; i++) {
            MoreTypeBean data = new MoreTypeBean();
            data.pic = Datas.icons[i];
            data.type = random.nextInt(3);

            mdata.add(data);
        }
    }
}
