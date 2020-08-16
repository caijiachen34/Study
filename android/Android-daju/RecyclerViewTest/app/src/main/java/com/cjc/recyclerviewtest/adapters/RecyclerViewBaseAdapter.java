package com.cjc.recyclerviewtest.adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cjc.recyclerviewtest.R;
import com.cjc.recyclerviewtest.beans.ItemBean;

import java.util.List;

/**
 * Created by CC
 **/
public abstract class RecyclerViewBaseAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    protected final List<ItemBean> mData;
    private OnItemClickListener mOnItemClickListener;

    public RecyclerViewBaseAdapter(List<ItemBean> data){
        this.mData = data;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = getSubView(parent,viewType);
        return new InnerHolder(view);
    }

    protected abstract View getSubView(ViewGroup parent, int viewType);

    //这个方法用来绑定holder，一般来设置数据
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((InnerHolder)holder).setData(mData.get(position),position);
    }

    //返回条目个数
    @Override
    public int getItemCount() {
        if (mData != null) {
            return mData.size();
        }
        return 0;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        //设置一个监听，就是设置一个回调接口
        this.mOnItemClickListener = listener;
    }

    /*
    * 编写回调接口的步骤
    * 1.创建这个接口
    * 2.定义接口内部的方法
    * 3.提供设置接口的方法（外部实现）
    * 4.接口方法的调用
    * */

    public interface OnItemClickListener{
        void OnItemClick(int position);
    }

    public class InnerHolder extends RecyclerView.ViewHolder {
        private ImageView micon;
        private TextView mtitle;
        private int mPosition;

        public InnerHolder(@NonNull View itemView) {
            super(itemView);

            //找到条目控件
            micon = itemView.findViewById(R.id.icon);
            mtitle = itemView.findViewById(R.id.title);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mOnItemClickListener != null) {
                        mOnItemClickListener.OnItemClick(mPosition);
                    }
                }
            });
        }

        //用于设置数据
        public void setData(ItemBean itemBean,int position) {
            this.mPosition = position;
            micon.setImageResource(itemBean.icon);
            mtitle.setText(itemBean.title);
        }
    }
}
