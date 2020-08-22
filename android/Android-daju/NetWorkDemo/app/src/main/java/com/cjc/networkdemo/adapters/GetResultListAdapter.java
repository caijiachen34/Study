package com.cjc.networkdemo.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.cjc.networkdemo.Constants;
import com.cjc.networkdemo.R;
import com.cjc.networkdemo.domain.GetTextItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CC
 **/
public class GetResultListAdapter extends RecyclerView.Adapter<GetResultListAdapter.InnerHolder> {

    private List<GetTextItem.DataBean> mData = new ArrayList<>();

    @NonNull
    @Override
    public InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_get_text, parent, false);
        return new InnerHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull InnerHolder holder, int position) {
        View itemView = holder.itemView;

        TextView titleTv = itemView.findViewById(R.id.tv_item_title);
        GetTextItem.DataBean dataBean = mData.get(position);
        titleTv.setText(dataBean.getTitle());

        ImageView cover = itemView.findViewById(R.id.iv_item);
        Glide.with(itemView.getContext()).load(Constants.BASE_URL + mData.get(position).getCover()).into(cover);

        TextView writer = itemView.findViewById(R.id.tv_item_writer);
        writer.setText("作者:" + dataBean.getUserName());

        TextView count = itemView.findViewById(R.id.tv_count);
        count.setText("阅读量:" + dataBean.getViewCount());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void setData(GetTextItem getTextItem) {
        mData.clear();
        mData.addAll(getTextItem.getData());
        //动态刷新数据
        notifyDataSetChanged();
    }

    public class InnerHolder extends RecyclerView.ViewHolder {
        public InnerHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
