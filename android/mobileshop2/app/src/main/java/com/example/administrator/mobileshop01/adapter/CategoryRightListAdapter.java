package com.example.administrator.mobileshop01.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.administrator.mobileshop01.R;
import com.example.administrator.mobileshop01.common.ImageLoaderManager;
import com.example.administrator.mobileshop01.db.Category;
import com.example.administrator.mobileshop01.entity.CategoryEntity;
import com.example.administrator.mobileshop01.utils.DesityUtils;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

import java.util.List;

public class CategoryRightListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View
        .OnClickListener {
    private Context mContext;
    private List<CategoryEntity> mRightData;
    private OnRecyclerViewItemClickListener mOnItemClickListener = null;
    //选中的索引
    private int selectedCategoryId = 0;

    public CategoryRightListAdapter(Context context, List<CategoryEntity> leftData) {
        this.mContext = context;
        this.mRightData = leftData;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_category_list_right,viewGroup,false);
        int left_width= (int) mContext.getResources().getDimension(R.dimen.category_list_left_width);
        int width= DesityUtils.getWidth(mContext);
        LinearLayout.LayoutParams params=new LinearLayout.LayoutParams((width-left_width)/3,ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(params);
        ViewHolder holder=new ViewHolder(view);
        view.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if(viewHolder instanceof CategoryRightListAdapter.ViewHolder){
            final CategoryRightListAdapter.ViewHolder newHolder= (ViewHolder) viewHolder;
            CategoryEntity entity=mRightData.get(i);
            newHolder.title1.setText(entity.getName());
            ImageLoader.getInstance().displayImage(entity.getImage(), newHolder.image1, ImageLoaderManager.product_options, new ImageLoadingListener() {
                @Override
                public void onLoadingStarted(String imageUri, View view) {

                }

                @Override
                public void onLoadingFailed(String imageUri, View view, FailReason failReason) {

                }

                @Override
                public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                    int image_width= (int) mContext.getResources().getDimension(R.dimen.category_list_right_image_width);
                    if (loadedImage!=null){
                        Bitmap bmp=Bitmap.createBitmap(loadedImage,0,0,loadedImage.getWidth(),loadedImage.getHeight());
                        bmp=Bitmap.createScaledBitmap(bmp,image_width,image_width,false);
                        newHolder.image1.setImageBitmap(bmp);
                    }
                }

                @Override
                public void onLoadingCancelled(String imageUri, View view) {

                }
            });
            viewHolder.itemView.setTag(entity);
        }
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    @Override
    public void onClick(View v) {
        if (mOnItemClickListener!=null){
            mOnItemClickListener.onItemClick(v,(CategoryEntity)v.getTag());
        }
    }

    public void setmOnItemClickListener(OnRecyclerViewItemClickListener listener){
        this.mOnItemClickListener=listener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView title1;
        private ImageView image1;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title1=itemView.findViewById(R.id.category_item_have_picture_text_1);
            image1=itemView.findViewById(R.id.category_item_have_picture_image_1);
        }
    }
}
