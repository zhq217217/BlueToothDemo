package com.example.administrator.demo01.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.demo01.bean.BlueBean;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/3/29.
 */

public class BlueListAdapter extends RecyclerView.Adapter<BlueListAdapter.BlueListViewHolder> {
    private ArrayList<BlueBean> mBlueDatas;

    public BlueListAdapter(ArrayList<BlueBean> blueBeens) {
        mBlueDatas = blueBeens;
    }

    @Override
    public BlueListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(BlueListViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return null == mBlueDatas ? 0 : mBlueDatas.size();
    }

    class BlueListViewHolder extends RecyclerView.ViewHolder {

        public BlueListViewHolder(View itemView) {
            super(itemView);
        }
    }
}
