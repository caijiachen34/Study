package com.cjc.recyclerviewtest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.cjc.recyclerviewtest.adapters.GridViewAdapter;
import com.cjc.recyclerviewtest.adapters.ListViewAdapter;
import com.cjc.recyclerviewtest.adapters.RecyclerViewBaseAdapter;
import com.cjc.recyclerviewtest.adapters.StaggerViewAdapter;
import com.cjc.recyclerviewtest.beans.Datas;
import com.cjc.recyclerviewtest.beans.ItemBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
 * RecyclerView使用总结：
 * 1.添加RecyclerView依赖
 * 2.找到控件
 * 3.准备数据
 * 4.设置布局管理器（线性布局等）
 * 5.创建适配器
 * 5.设置适配器
 *
 * */
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private RecyclerView recycler_view;
    private List<ItemBean> mdata;
    private RecyclerViewBaseAdapter adapter;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //找到控件
        initView();
        //准备数据，一般开发，数据从网络获取
        initData();
        //设置默认显示为ListView
        showList(true, false);

        //处理下拉刷新
        handDownPullUpdate();

    }

    private void handDownPullUpdate() {
        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary,R.color.colorPrimaryDark,R.color.colorAccent);
        swipeRefreshLayout.setEnabled(true);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //执行刷新数据
                /*
                * 顶部下拉的时候，会触发这个方法
                * 这个方法一般是MainThread主线程，不可以执行耗时操作
                * 一般来说请求数据要再开一个线程
                * */
                //添加数据
                ItemBean data = new ItemBean();
                data.title = "我是新数据";
                data.icon = R.mipmap.pic_02;
                mdata.add(0,data);
                //更新ui
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //1.让刷新停止2.更新列表
                        adapter.notifyDataSetChanged();
                        swipeRefreshLayout.setRefreshing(false);
                    }
                },1000);
            }
        });
    }

    private void initListener() {
        adapter.setOnItemClickListener(new RecyclerViewBaseAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(int position) {
                //这里处理点击事件
                Toast.makeText(MainActivity.this,"您点击的是第"+ position + "个条目",Toast.LENGTH_SHORT).show();
            }
        });
        //处理上拉
        if (adapter instanceof ListViewAdapter) {
            ((ListViewAdapter)adapter).setOnRefreshListener(new ListViewAdapter.OnRefreshListener() {
                @Override
                public void onUpPullRefresh(final ListViewAdapter.LoaderMoreHolder loaderMoreHolder) {
                    //加载数据
                    //添加数据

                    //更新ui
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            Random random = new Random();

                            if (random.nextInt() % 2 == 0){
                                ItemBean data = new ItemBean();
                                data.title = "我是新数据";
                                data.icon = R.mipmap.pic_02;
                                mdata.add(data);
                                //1.让刷新停止2.更新列表
                                adapter.notifyDataSetChanged();
                                loaderMoreHolder.update(loaderMoreHolder.LOADER_STATE_NORMAL);
                            }else {
                                loaderMoreHolder.update(loaderMoreHolder.LOADER_STATE_RELOAD);
                            }

                        }
                    },1000);
                }
            });
        }
    }

    private void initView() {
        recycler_view = findViewById(R.id.recycler_view);
        swipeRefreshLayout = findViewById(R.id.refresh_layout);
    }

    /*用于初始化模拟数据*/
    private void initData() {
        //List<DataBeta>---->Adapter---->setAdapter---->显示数据
        //创建数据集合
        mdata = new ArrayList<>();

        //创建模拟数据
        for (int i = 0; i < Datas.icons.length; i++) {
            //创建数据对象
            ItemBean data = new ItemBean();
            data.icon = Datas.icons[i];
            data.title = "我是第 " + i + " 个条目";
            //添加到集合里面
            mdata.add(data);
        }

    }

    //创建optionMenu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //绑定自定义的menu
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //使用optionMenu选择器
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        switch (itemId) {
            //ListView部分
            case R.id.list_view_vertical_stander:
                Log.d(TAG, "list_view_vertical_stander");
                showList(true, false);
                break;
            case R.id.list_view_vertical_reverse:
                Log.d(TAG, "list_view_vertical_reverse");
                showList(true, true);
                break;
            case R.id.list_view_horizontal_stander:
                Log.d(TAG, "list_view_horizontal_stander");
                showList(false, false);
                break;
            case R.id.list_view_horizontal_reverse:
                Log.d(TAG, "list_view_horizontal_reverse");
                showList(false, true);
                break;

            //GridView部分
            case R.id.grid_view_vertical_stander:
                showGrid(true,false);
                break;
            case R.id.grid_view_vertical_reverse:
                showGrid(true,true);
                break;
            case R.id.grid_view_horizontal_stander:
                showGrid(false,false);
                break;
            case R.id.grid_view_horizontal_reverse:
                showGrid(false,true);
                break;

            //瀑布流部分
            case R.id.stagger_view_vertical_stander:
                showStagger(true,false);
                break;
            case R.id.stagger_view_vertical_reverse:
                showStagger(true,true);
                break;
            case R.id.stagger_view_horizontal_stander:
                showStagger(false,false);
                break;
            case R.id.stagger_view_horizontal_reverse:
                showStagger(false,true);
                break;

             //多种条目
            case R.id.more_type:
                //跳到新Activity
                Intent intent = new Intent(this, MoreTypeActivity.class);
                startActivity(intent);
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    //用于显示瀑布流效果
    private void showStagger(boolean isVertical,boolean isReverse) {
        //准备布局管理器
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2,isVertical?StaggeredGridLayoutManager.VERTICAL:StaggeredGridLayoutManager.HORIZONTAL);
        //设置正向还是反向
        layoutManager.setReverseLayout(isReverse);
        //设置布局管理器
        recycler_view.setLayoutManager(layoutManager);
        //创建适配器
        adapter = new StaggerViewAdapter(mdata);
        //设置适配器
        recycler_view.setAdapter(adapter);
        //初始化事件
        initListener();
    }

    //用于显示GridView效果
    private void showGrid(boolean isVertical, boolean isReverse) {
        //创建布局管理器
        GridLayoutManager layoutManager = new GridLayoutManager(this,3);
        //设置水平还是垂直
        layoutManager.setOrientation(isVertical ? GridLayoutManager.VERTICAL : GridLayoutManager.HORIZONTAL);
        //设置正向还是反向
        layoutManager.setReverseLayout(isReverse);
        //设置布局管理器
        recycler_view.setLayoutManager(layoutManager);
        //创建适配器
        adapter = new GridViewAdapter(mdata);
        //设置适配器
        recycler_view.setAdapter(adapter);
        //初始化事件
        initListener();
    }

    //用于显示listView效果
    private void showList(boolean isVertical, boolean isReverse) {
        //Recycler需要设置样式,设置布局管理器
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        //设置LinearLayout是水平还是垂直布局
        layoutManager.setOrientation(isVertical ? LinearLayoutManager.VERTICAL : LinearLayoutManager.HORIZONTAL);

        //设置正向还是反向
        layoutManager.setReverseLayout(isReverse);

        //RecyclerView设置布局方式
        recycler_view.setLayoutManager(layoutManager);

        //创建适配器
        adapter = new ListViewAdapter(mdata);
        //设置到RecyclerVIew里面去
        recycler_view.setAdapter(adapter);
        //初始化事件
        initListener();
    }
}