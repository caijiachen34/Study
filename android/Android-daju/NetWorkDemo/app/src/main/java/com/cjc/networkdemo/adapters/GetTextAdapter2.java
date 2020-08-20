package com.cjc.networkdemo.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.cjc.networkdemo.R;
import com.cjc.networkdemo.domain.GetTextItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CC
 **/
public class GetTextAdapter2 extends RecyclerView.Adapter<GetTextAdapter2.InnerHolder> {

    private static final String TAG = "GetTextAdapter2";
    private List<GetTextItem.DataBean> mData = new ArrayList<>();

    //创建ViewHolder，就是xml传送给创建ViewHolder的
    @NonNull
    @Override
    public InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_get_text_okhttp, parent, false);
        return new InnerHolder(itemView);
    }

    //操作item
    @Override
    public void onBindViewHolder(@NonNull InnerHolder holder, int position) {
        View itemView = holder.itemView;
        GetTextItem.DataBean dataBean = mData.get(position);
        Glide.with(itemView.getContext()).load("http://192.168.2.143:9102" + dataBean.getCover()).into(holder.image);
        holder.writer.setText("作者" + dataBean.getUserName());
        holder.title.setText(dataBean.getTitle());
        holder.count.setText("数量" + dataBean.getViewCount());
        Log.d(TAG, "count: " + dataBean.getViewCount());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void setData(GetTextItem getTextItem) {
        mData.clear();
        mData.addAll(getTextItem.getData());
        notifyDataSetChanged();
    }

    //初始化控件
    public class InnerHolder extends RecyclerView.ViewHolder {

        private final ImageView image;
        private final TextView title;
        private final TextView writer;
        private final TextView count;

        public InnerHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.iv_item_okhttp);
            title = itemView.findViewById(R.id.tv_item_title_okhttp);
            writer = itemView.findViewById(R.id.tv_item_writer_okhttp);
            count = itemView.findViewById(R.id.tv_count_okhttp);
        }
    }
}
