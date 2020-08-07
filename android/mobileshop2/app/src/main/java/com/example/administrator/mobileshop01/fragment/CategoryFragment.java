package com.example.administrator.mobileshop01.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.administrator.mobileshop01.R;
import com.example.administrator.mobileshop01.activity.GoodsListActivity;
import com.example.administrator.mobileshop01.adapter.CategoryLeftListAdapter;
import com.example.administrator.mobileshop01.adapter.CategoryRightListAdapter;
import com.example.administrator.mobileshop01.adapter.OnRecyclerViewItemClickListener;
import com.example.administrator.mobileshop01.common.Constants;
import com.example.administrator.mobileshop01.entity.CategoryEntity;
import com.example.administrator.mobileshop01.http.presenter.CategoryPresenter;
import com.example.administrator.mobileshop01.utils.AndroidUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import rx.Subscriber;

public class CategoryFragment extends BaseFragment {
    @BindView(R.id.title_back)
    ImageView titleBack;
    @BindView(R.id.search_title_icon)
    ImageView searchTitleIcon;
    @BindView(R.id.search_keyword)
    TextView searchKeyword;
    @BindView(R.id.product_list_search_clean)
    ImageButton productListSearchClean;
    @BindView(R.id.search_layout)
    RelativeLayout searchLayout;
    @BindView(R.id.product_list_search_layout)
    RelativeLayout productListSearchLayout;
    @Nullable
    @BindView(R.id.product_list_top_layout)
    RelativeLayout productListTopLayout;
    @BindView(R.id.common_title)
    RelativeLayout commonTitle;
    @BindView(R.id.left_list)
    RecyclerView leftList;
    @BindView(R.id.right_list)
    RecyclerView rightList;
    @BindView(R.id.mainlayout)
    LinearLayout mainlayout;
    Unbinder unbinder;

    private List<CategoryEntity> leftData=new ArrayList<>();
    private List<CategoryEntity> rightData=new ArrayList<>();
    private CategoryLeftListAdapter leftAdapter;
    private CategoryRightListAdapter rightAdapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_category, container, false);
        unbinder = ButterKnife.bind(this, view);
        initViews();
        return view;
    }

    private void initViews(){
        //调整搜索栏的样式
        titleBack.setVisibility(View.GONE);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams
                .MATCH_PARENT, AndroidUtils.dp2px(this.getActivity(), 30));
        layoutParams.setMargins(10, 3, 10, 0);
        searchLayout.setLayoutParams(layoutParams);
        //设置列表样式
        LinearLayoutManager leftManager = new LinearLayoutManager(getActivity());
        leftManager.setOrientation(RecyclerView.VERTICAL);
        //垂直表格
        GridLayoutManager rightManager = new GridLayoutManager(getActivity(),
                Constants.SPAN_COUNT,
                RecyclerView.VERTICAL, false);
        leftList.setLayoutManager(leftManager);
        rightList.setLayoutManager(rightManager);
        //适配数据
        leftAdapter = new CategoryLeftListAdapter(getActivity(), leftData);
        rightAdapter = new CategoryRightListAdapter(getActivity(), rightData);
        leftList.setAdapter(leftAdapter);
        rightList.setAdapter(rightAdapter);
        //加载左侧列表数据和item0对应的右侧列表数据
        CategoryPresenter.getTopList(new Subscriber<List<CategoryEntity>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(List<CategoryEntity> categoryEntities) {
                if (categoryEntities.size() > 0) {
                    leftData.addAll(categoryEntities);
                    leftAdapter.notifyDataSetChanged();
                    //载入item0的右侧列表数据
                    int cat_id = categoryEntities.get(0).getCat_id();
                    loadRight(cat_id);
                    //默认选中第一项
                    leftAdapter.setSelection(cat_id);
                }
            }
        });
        //左侧列表点击事件
        leftAdapter.setmOnItemClickListener(new OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, CategoryEntity entity) {
               /* Toast.makeText(getActivity(), "name:" + entity.getName() + "\r\ncat_id:" + entity.getCat_id(), Toast
                        .LENGTH_SHORT)
                        .show();*/
                //加载右侧数据
                loadRight(entity.getCat_id());
                leftAdapter.setSelection(entity.getCat_id());
            }
        });
        //右侧列表点击事件
        rightAdapter.setmOnItemClickListener(new OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, CategoryEntity entity) {
                //跳转到商品列表界面
                Intent intent = new Intent(getActivity(), GoodsListActivity.class);
                intent.putExtra("cat_id", entity.getCat_id());
                startActivity(intent);
            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.title_back, R.id.product_list_search_clean})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.title_back:
                break;
            case R.id.product_list_search_clean:
                break;
        }
    }


    /**
     * 加载右侧列表数据
     *
     * @param cat_id
     */
    private void loadRight(int cat_id) {
        CategoryPresenter.getSecondList(new Subscriber<List<CategoryEntity>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(List<CategoryEntity> categoryEntities) {


                if (categoryEntities.size() > 0) {

                    for (int i = 0; i < categoryEntities.size(); i++) {
                        Log.i("CategoryFragment", "rightlist-->" + categoryEntities.get(i).toString());
                    }
                    rightData.clear();
                    rightData.addAll(categoryEntities);
                    rightAdapter.notifyDataSetChanged();
                }
            }
        }, cat_id);
    }
}
