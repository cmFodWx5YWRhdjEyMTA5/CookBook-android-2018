/*
 * ******************************************************************************
 *  Copyright Ⓒ 2017. All rights reserved
 *  Author DangTin. Create on 2017/11/19
 * ******************************************************************************
 */
package com.dangtin.cookbook.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dangtin.cookbook.R;
import com.dangtin.cookbook.adapter.base.BaseRecyclerViewAdapter;
import com.dangtin.cookbook.adapter.base.Releasable;
import com.dangtin.cookbook.data.models.QuantityFood;
import com.dangtin.cookbook.injection.ActivityContext;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;

public class QuantityFoodAdapter extends RecyclerView.Adapter<QuantityFoodAdapter.QuantityFoodViewHolder>
        implements Releasable {

    private Context context;
    private ArrayList<QuantityFood> listQuantityFood;
    private RecyclerView mRecyclerView;

    @Inject
    public QuantityFoodAdapter(@ActivityContext Context context) {
        this.context = context;
    }

    @Override
    public QuantityFoodViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        QuantityFoodViewHolder viewHolder = QuantityFoodViewHolder.create(parent);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(QuantityFoodViewHolder holder, int position) {
        holder.bindData(context, listQuantityFood.get(position), position);
    }

    @Override
    public int getItemCount() {
        return null == listQuantityFood ? 0 : listQuantityFood.size();
    }


    public void setListData(ArrayList<QuantityFood> list) {
        this.listQuantityFood = list;
        notifyDataSetChanged();
    }

    public void injectInto(RecyclerView recyclerView) {
        mRecyclerView = recyclerView;
        LinearLayoutManager layoutManager = new LinearLayoutManager(context,
                LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView.setNestedScrollingEnabled(false);
        mRecyclerView.setFocusable(false);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(this);
    }

    @Override
    public void release() {
        context = null;
    }

    public static class QuantityFoodViewHolder extends BaseRecyclerViewAdapter.BaseViewHolder<QuantityFood> {

        @BindView(R.id.tvTitle)
        TextView tvTitle;

        public QuantityFoodViewHolder(View itemView) {
            super(itemView);
        }

        public static QuantityFoodViewHolder create(ViewGroup parent) {
            return new QuantityFoodViewHolder(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_search_quantity_food, parent, false));
        }

        @Override
        public void bindData(Context context, QuantityFood quantityFood, int position) {
            if (quantityFood != null) {
                tvTitle.setText(quantityFood.getQuantityFood() + " "
                        + context.getString(R.string.food));
            }
        }
    }
}
