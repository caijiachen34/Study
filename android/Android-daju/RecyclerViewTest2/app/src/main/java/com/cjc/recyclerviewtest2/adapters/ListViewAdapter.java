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
    private OnItemClickListener mOnItemClickListener;

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
        holder.setData(mData.get(position),position);
    }

    @Override
    //返回条目个数
    public int getItemCount() {
        if (mData != null) {
            return mData.size();
        }
        return 0;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        //设置监听，其实就是设置一个接口，一个回调接口
        this.mOnItemClickListener = listener;
    }

    /*
    * 编写回调接口步骤
    * 1.创建接口
    * 2.定义接口内部方法
    * 3.提供设置接口的方法（外部实现）
    * 4.接口方法的调用
    * */

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    //初始化控件
    public class InnerHolder extends RecyclerView.ViewHolder {

        private final ImageView mIcon;
        private final TextView mTitle;
        private int mPosition;

        public InnerHolder(@NonNull View itemView) {
            super(itemView);
            //找到item控件
            mIcon = itemView.findViewById(R.id.list_view_icon);
            mTitle = itemView.findViewById(R.id.list_view_title);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mOnItemClickListener != null) {
                        mOnItemClickListener.onItemClick(mPosition);
                    }
                }
            });
        }


        //设置数据
        public void setData(ItemBean itemBean,int position) {
            this.mPosition = position;
            mIcon.setImageResource(itemBean.icon);
            mTitle.setText(itemBean.title);
        }
    }
}
