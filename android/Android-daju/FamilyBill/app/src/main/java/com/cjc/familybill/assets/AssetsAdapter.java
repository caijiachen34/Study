package com.cjc.familybill.assets;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cjc.familybill.R;
import com.cjc.familybill.entity.AssetsEntity;

import java.util.List;

/**
 * Created by CC
 **/
public class AssetsAdapter extends RecyclerView.Adapter<AssetsAdapter.InnerHolder> {


    private static final String TAG = "MainActivity";
    private final List<AssetsEntity> mData;
    private final Context mContext;

    public AssetsAdapter(Context context,List<AssetsEntity> data){
        this.mContext = context;
        this.mData = data;
    }

    @NonNull
    @Override
    public InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "进入onCreateViewHolder: ");
        View view = View.inflate(mContext, R.layout.item_list_assets, null);
        InnerHolder innerHolder = new InnerHolder(view);
        return innerHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull InnerHolder holder, int position) {
        Log.d(TAG, "进入onBindViewHolder: ");
        holder.setData(mData.get(position));
    }

    @Override
    public int getItemCount() {
        if (mData != null) {
            return mData.size();
        }
        return 0;
    }

    public class InnerHolder extends RecyclerView.ViewHolder {

        private final TextView assets_assetsType;
        private final TextView assets_assetsMoney;

        public InnerHolder(@NonNull View itemView) {
            super(itemView);
            Log.d(TAG, "InnerHolder: 初始化InnerHolder");
            assets_assetsType = itemView.findViewById(R.id.assets_assetsType);
            assets_assetsMoney = itemView.findViewById(R.id.assets_assetsMoney);
        }

        public void setData(AssetsEntity assetsEntity) {
            Log.d(TAG, "setData: ");
            assets_assetsType.setText(assetsEntity.getAssetsType());
            assets_assetsMoney.setText(assetsEntity.getAssetsMoney()+"");
        }
    }
}
