package com.cjc.familybill.assets;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cjc.familybill.R;
import com.cjc.familybill.entity.AssetsEntity;
import com.cjc.familybill.entity.AssetsRemain;

import java.util.List;

/**
 * Created by CC
 **/
public class AssetsRemainAdapter extends RecyclerView.Adapter<AssetsRemainAdapter.InnerHolder> {


    private static final String TAG = "MainActivity";
    private final List<AssetsRemain> mData1;
    private final List<AssetsEntity> mData2;
    private final Context mContext;
    private OnItemClickListener mOnItemClickListener;

    public AssetsRemainAdapter(Context context, List<AssetsRemain> data1, List<AssetsEntity> data2){
        this.mContext = context;
        this.mData1 = data1;
        this.mData2 = data2;
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
        holder.setData(mData1.get(position),mData2.get(position),position);
    }

    @Override
    public int getItemCount() {
        if (mData1 != null) {
            return mData1.size();
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
        void onItemClick(int position, int assets_id1,int assets_id2);
    }

    public class InnerHolder extends RecyclerView.ViewHolder {

        private final TextView assets_assetsType;
        private final TextView assets_assetsMoney;
        private final ImageView assets_img;
        private int mPosition;
        private int mRemian_id;
        private int mAssets_id;

        public InnerHolder(@NonNull View itemView) {
            super(itemView);
            Log.d(TAG, "InnerHolder: 初始化InnerHolder");
            assets_assetsType = itemView.findViewById(R.id.assets_assetsType);
            assets_assetsMoney = itemView.findViewById(R.id.assets_assetsMoney);
            assets_img = itemView.findViewById(R.id.assets_img);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mOnItemClickListener != null) {
                        mOnItemClickListener.onItemClick(mPosition, mRemian_id,mAssets_id);
                    }
                }
            });
        }

        public void setData(AssetsRemain AssetsRemain,AssetsEntity assetsEntity,int position) {
            this.mPosition = position;
            Log.d(TAG, "setData: ");
            String assetsType = AssetsRemain.getAssets_type();
            assets_assetsType.setText(assetsType);
            assets_assetsMoney.setText(AssetsRemain.getRemain_money()+"");
            if (assetsType.contains("支付宝")){
                assets_img.setImageResource(R.drawable.alipay);
            }else if (assetsType.contains("微信")){
                assets_img.setImageResource(R.drawable.wepay);
            }else if (assetsType.contains("卡")){
                assets_img.setImageResource(R.drawable.cardpay);
            }else {
                assets_img.setImageResource(R.drawable.defaultpay);
            }
            int remain_id = AssetsRemain.getRemain_id();
            int assets_id = assetsEntity.getAssets_id();
            this.mRemian_id = remain_id;
            this.mAssets_id = assets_id;
        }
    }
}
