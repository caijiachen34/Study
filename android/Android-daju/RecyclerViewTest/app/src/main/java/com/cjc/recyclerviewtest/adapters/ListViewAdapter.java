package com.cjc.recyclerviewtest.adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cjc.recyclerviewtest.R;
import com.cjc.recyclerviewtest.beans.ItemBean;

import java.util.List;

/**
 * Created by CC
 **/
public class ListViewAdapter extends RecyclerViewBaseAdapter {

    //普通的条目类型
    public static final int TYPE_NORMAL = 0;
    //加载更多
    public static final int TYPE_LOADER_MORE = 1;
    private OnRefreshListener mUpPullRefreshListener;

    //构造方法从外部传输数据
    public ListViewAdapter(List<ItemBean> data){
        super(data);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = getSubView(parent, viewType);
        if (viewType == TYPE_NORMAL) {
            return new InnerHolder(view);
        }else {
            return new LoaderMoreHolder(view);
        }
    }

    @Override
    protected View getSubView(ViewGroup parent, int viewType) {
        View view;

        //根据类型创建view
        if (viewType == TYPE_NORMAL){
            view = View.inflate(parent.getContext(), R.layout.item_list_view, null);
        }else {
            view = View.inflate(parent.getContext(), R.layout.item_list_loader_more, null);
        }
        return view;
    }

    //这个方法用来绑定holder，一般来设置数据
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position)==TYPE_NORMAL && holder instanceof InnerHolder) {
            ((InnerHolder) holder).setData(mData.get(position), position);
        }else if (getItemViewType(position)==TYPE_LOADER_MORE && holder instanceof LoaderMoreHolder){
            ((LoaderMoreHolder) holder).update(LoaderMoreHolder.LOADER_STATE_LOADING);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == getItemCount()-1) {
            //最后一个则返回加载更多
            return TYPE_LOADER_MORE;
        }

        return TYPE_NORMAL;
    }

    //设置刷新监听的接口
    public void setOnRefreshListener(OnRefreshListener listener) {
        this.mUpPullRefreshListener = listener;
    }

    //定义接口
    public interface OnRefreshListener{
        void onUpPullRefresh(LoaderMoreHolder loaderMoreHolder);
    }

    public class LoaderMoreHolder extends RecyclerView.ViewHolder{
        public static final int LOADER_STATE_LOADING = 0;
        public static final int LOADER_STATE_RELOAD = 1;
        public static final int LOADER_STATE_NORMAL = 2;

        private LinearLayout loading;
        private TextView reload;

        public LoaderMoreHolder(@NonNull View itemView) {
            super(itemView);

            loading = itemView.findViewById(R.id.loading);
            reload = itemView.findViewById(R.id.reload);
            reload.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //这里面触发加载数据
                    update(LOADER_STATE_LOADING);
                }
            });
        }
        public void update(int state){

            //重置两个控件的状态
            loading.setVisibility(View.GONE);
            reload.setVisibility(View.GONE);

            switch (state){
                case LOADER_STATE_LOADING:
                    loading.setVisibility(View.VISIBLE);
                    startLoaderMore();
                    break;

                case LOADER_STATE_RELOAD:
                    reload.setVisibility(View.VISIBLE);
                    break;

                case LOADER_STATE_NORMAL:
                    loading.setVisibility(View.GONE);
                    reload.setVisibility(View.GONE);
                    break;
            }
        }

        private void startLoaderMore() {
            if (mUpPullRefreshListener != null) {
                mUpPullRefreshListener.onUpPullRefresh(this);
            }
        }
    }
}
