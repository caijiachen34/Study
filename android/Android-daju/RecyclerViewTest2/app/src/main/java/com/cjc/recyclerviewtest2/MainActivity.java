package com.cjc.recyclerviewtest2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.cjc.recyclerviewtest2.adapters.ListViewAdapter;
import com.cjc.recyclerviewtest2.beans.Datas;
import com.cjc.recyclerviewtest2.beans.ItemBean;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mList;
    private List<ItemBean> mData;
    private ListViewAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //1.找到控件
        mList = findViewById(R.id.recycler_view);
        //2.准备数据
        initData();
        //创建监听事件
        initListener();
    }

    private void initListener() {
        mAdapter.setOnItemClickListener(new ListViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(MainActivity.this,"点击了第" + position +"个条目",Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void initData() {
        //List<DataBean> ===>>> Adapter ===>>> setAdapter ===>>> 显示数据
        //创建数据集合
        mData = new ArrayList<>();

        //创建模拟数据
        for (int i = 0; i < Datas.icons.length; i++) {
            //创建对象
            ItemBean data = new ItemBean();
            data.icon = Datas.icons[i];
            data.title = "我是第 " + i + " 个条目";
            mData.add(data);
        }

        //RecyclerView需要设置样式,即布局管理器
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mList.setLayoutManager(layoutManager);

        //创建适配器
        mAdapter = new ListViewAdapter(mData);
        //设置到Adapter到RecyclerView里面
        mList.setAdapter(mAdapter);

    }
}