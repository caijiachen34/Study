package com.cjc.ouxun;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by CC
 **/
public class MainAdapter extends RecyclerView.Adapter<MainAdapter.InnerHolder> {

    private final Context mContext;
    private final int[] mImageId;
    private final String[] mBoxState;



    public MainAdapter(Context context, int[] ImageId, String[] BoxState) {
        this.mContext = context;
        this.mImageId = ImageId;
        this.mBoxState = BoxState;
    }

    @NonNull
    @Override
    public InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(mContext, R.layout.item_main_list, null);
        InnerHolder innerHolder = new InnerHolder(view);
        return innerHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull InnerHolder holder, int position) {
        holder.setData(mImageId[position], mBoxState[position],position);
    }

    @Override
    public int getItemCount() {
        if (mImageId != null) {
            return mImageId.length;
        }
        return 0;
    }

    public class InnerHolder extends RecyclerView.ViewHolder {

        private final ImageView iv_main_item_box;
        private final TextView tv_main_item_state;
        private final TextView tv_main_item_box_id;
        private final TextView tv_main_item_box_from;
        private final TextView tv_main_item_box_time;
        private int mPosition;

        public InnerHolder(@NonNull View itemView) {
            super(itemView);
            iv_main_item_box = itemView.findViewById(R.id.iv_main_item_box);
            tv_main_item_state = itemView.findViewById(R.id.tv_main_item_state);
            tv_main_item_box_id = itemView.findViewById(R.id.tv_main_item_box_id);
            tv_main_item_box_from = itemView.findViewById(R.id.tv_main_item_box_from);
            tv_main_item_box_time = itemView.findViewById(R.id.tv_main_item_box_time);


        }

        public void setData(int mImageID, String mState, int position) {
            this.mPosition = position;
            iv_main_item_box.setImageResource(mImageID);
            tv_main_item_state.setText(mState);

        }
    }
}
