package com.cjc.familybill.account;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cjc.familybill.R;
import com.cjc.familybill.entity.AccountEntity;
import com.cjc.familybill.entity.AssetsEntity;

import java.util.List;

/**
 * Created by CC
 **/
public class AccountAdapter extends RecyclerView.Adapter<AccountAdapter.InnerHolder> {


    private static final String TAG = "MainActivity";
    private final List<AccountEntity> mData;
    private final Context mContext;
    private OnItemClickListener mOnItemClickListener;

    public AccountAdapter(Context context, List<AccountEntity> data){
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
        holder.setData(mData.get(position),position);
    }

    @Override
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
        void onItemClick(int position, int assets_id);
    }

    public class InnerHolder extends RecyclerView.ViewHolder {

        private final TextView account_accountType;
        private final TextView account_accountMoney;
        private final ImageView account_img;
        private int mPosition;
        private int mAccount_id;

        public InnerHolder(@NonNull View itemView) {
            super(itemView);
            Log.d(TAG, "InnerHolder: 初始化InnerHolder");
            account_accountType = itemView.findViewById(R.id.account_accountType);
            account_accountMoney = itemView.findViewById(R.id.account_accountMoney);
            account_img = itemView.findViewById(R.id.account_img);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mOnItemClickListener != null) {
                        mOnItemClickListener.onItemClick(mPosition, mAccount_id);
                    }
                }
            });
        }

        public void setData(AccountEntity accountEntity,int position) {
            this.mPosition = position;
            Log.d(TAG, "setData: ");
            String assetsType = accountEntity.getAssetsType();
            account_accountType.setText(assetsType);
            account_accountMoney.setText(accountEntity.getAccountMoney()+"");// TODO: 2020/9/3  
            if (assetsType.contains("支付宝")){
                account_img.setImageResource(R.drawable.alipay);
            }else if (assetsType.contains("微信")){
                account_img.setImageResource(R.drawable.wepay);
            }else if (assetsType.contains("卡")){
                account_img.setImageResource(R.drawable.cardpay);
            }else {
                account_img.setImageResource(R.drawable.defaultpay);
            }
            int assets_id = accountEntity.getAccount_id();
            this.mAccount_id = assets_id;
        }
    }
}
