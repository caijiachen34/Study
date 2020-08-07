package com.example.administrator.mobileshop01.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.administrator.mobileshop01.R;
import com.example.administrator.mobileshop01.entity.CategoryEntity;

import java.util.List;

public class CategoryLeftListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View
        .OnClickListener {
    private Context mContext;
    private List<CategoryEntity> mLeftData;
    private OnRecyclerViewItemClickListener mOnItemClickListener = null;
    //选中的索引
    private int selectedCategoryId = 0;

    public CategoryLeftListAdapter(Context context, List<CategoryEntity> leftData) {
        this.mContext = context;
        this.mLeftData = leftData;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_category_list_left, viewGroup, false);
        view.setOnClickListener(this);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if(viewHolder instanceof CategoryLeftListAdapter.ViewHolder){
            CategoryLeftListAdapter.ViewHolder newHolder= (ViewHolder) viewHolder;
            CategoryEntity entity=mLeftData.get(i);
            newHolder.textView.setText(entity.getName());
            newHolder.itemView.setTag(entity);
            if(entity.getCat_id()==selectedCategoryId){
                newHolder.itemView.setBackgroundResource(R.drawable.category_left_bg_focus);
                newHolder.textView.setTextColor(viewHolder.itemView.getResources().getColor(R.color.category_left_red_font));
            }else {
                viewHolder.itemView.setBackgroundResource(R.drawable.category_left_bg_normal);
                newHolder.textView.setTextColor((viewHolder.itemView.getResources().getColor(R.color.category_left_dark_font)));
            }
        }
    }

    @Override
    public int getItemCount() {
        return mLeftData.size();
    }

    public void setmOnItemClickListener(OnRecyclerViewItemClickListener listener){
        this.mOnItemClickListener=listener;
    }

    public void setSelection(int categoryId){
        selectedCategoryId=categoryId;
        this.notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {
        if (mOnItemClickListener!=null){
            CategoryEntity entity=(CategoryEntity)v.getTag();
            mOnItemClickListener.onItemClick(v,entity);
        }
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView=itemView.findViewById(R.id.text);
        }
    }
}
