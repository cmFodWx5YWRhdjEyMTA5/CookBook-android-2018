/*
 * ******************************************************************************
 *  Copyright Ⓒ 2017. All rights reserved
 *  Author DangTin. Create on 2017/11/19
 * ******************************************************************************
 */
package com.dangtin.cookbook.adapter.food;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dangtin.cookbook.R;
import com.dangtin.cookbook.adapter.base.BaseRecyclerViewAdapter;
import com.dangtin.cookbook.adapter.base.Releasable;
import com.dangtin.cookbook.data.models.Food;
import com.dangtin.cookbook.injection.ActivityContext;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;

public class FoodFavoriteAdapter extends RecyclerView.Adapter<FoodFavoriteAdapter.FoodViewHolder>
        implements Releasable {

    private Context context;
    private ArrayList<Food> listFood;
    private RecyclerView mRecyclerView;

    @Inject
    public FoodFavoriteAdapter(@ActivityContext Context context) {
        this.context = context;
    }

    @Override
    public FoodViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        FoodViewHolder viewHolder = FoodViewHolder.create(parent);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(FoodViewHolder holder, int position) {
        holder.bindData(context, listFood.get(position), position);
    }

    @Override
    public int getItemCount() {
        return null == listFood ? 0 : listFood.size();
    }


    public void setListData(ArrayList<Food> list) {
        this.listFood = list;
        notifyDataSetChanged();
    }

    public void injectInto(RecyclerView recyclerView) {
        mRecyclerView = recyclerView;
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2,
                StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setNestedScrollingEnabled(false);
        mRecyclerView.setFocusable(false);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(this);
    }

    @Override
    public void release() {
        context = null;
    }

    public static class FoodViewHolder extends BaseRecyclerViewAdapter.BaseViewHolder<Food> {

        @BindView(R.id.tvTitle)
        TextView tvTitle;

        public FoodViewHolder(View itemView) {
            super(itemView);
        }

        public static FoodViewHolder create(ViewGroup parent) {
            return new FoodViewHolder(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_favorite, parent, false));
        }

        @Override
        public void bindData(Context context, Food food, int position) {
            if (food != null) {
                tvTitle.setText(food.getName());
            }
        }
    }
}
