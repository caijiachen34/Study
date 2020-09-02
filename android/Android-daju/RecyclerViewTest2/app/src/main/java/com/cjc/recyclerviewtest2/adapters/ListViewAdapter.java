package com.cjc.recyclerviewtest2.adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cjc.recyclerviewtest2.R;
import com.cjc.recyclerviewtest2.beans.ItemBean;

import java.util.List;

/**
 * Created by CC
 **/
public class ListViewAdapter extends RecyclerView.Adapter<ListViewAdapter.InnerHolder> {

    private final List<ItemBean> mData;

    public ListViewAdapter(List<ItemBean> data){
        this.mData = data;
    }


    @NonNull
    @Override
    //创建初始化InnerHolder并将xml布局（item）传递给InnerHolder
    public InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //传进去InnerHolder的itemview就是item布局界面
        View view = View.inflate(parent.getContext(), R.layout.item_list_view, null);
        InnerHolder innerHolder = new InnerHolder(view);
        return innerHolder;
    }


    @Override
    //操作item,设置数据
    public void onBindViewHolder(@NonNull InnerHolder holder, int position) {
        holder.setData(mData.get(position));
    }

    @Override
    //返回条目个数
    public int getItemCount() {
        if (mData != null) {
            return mData.size();
        }
        return 0;
    }

    //初始化控件
    public class InnerHolder extends RecyclerView.ViewHolder {

        private final ImageView mIcon;
        private final TextView mTitle;

        public InnerHolder(@NonNull View itemView) {
            super(itemView);
            //找到item控件
            mIcon = itemView.findViewById(R.id.list_view_icon);
            mTitle = itemView.findViewById(R.id.list_view_title);
        }


        //设置数据
        public void setData(ItemBean itemBean) {
            mIcon.setImageResource(itemBean.icon);
            mTitle.setText(itemBean.title);
        }
    }
}
