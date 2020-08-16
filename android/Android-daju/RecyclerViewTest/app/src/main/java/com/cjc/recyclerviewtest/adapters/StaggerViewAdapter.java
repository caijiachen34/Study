package com.cjc.recyclerviewtest.adapters;

import android.view.View;
import android.view.ViewGroup;

import com.cjc.recyclerviewtest.R;
import com.cjc.recyclerviewtest.beans.ItemBean;

import java.util.List;

/**
 * Created by CC
 **/
public class StaggerViewAdapter extends RecyclerViewBaseAdapter {

    public StaggerViewAdapter(List<ItemBean> data) {
        super(data);
    }

    @Override
    protected View getSubView(ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.item_stagger_view, null);
        return view;
    }
}
