/*
 * ******************************************************************************
 *  Copyright Ⓒ 2017. All rights reserved
 *  Author DangTin. Create on 2017/11/19
 * ******************************************************************************
 */
package com.dangtin.cookbook.adapter.food;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dangtin.cookbook.R;
import com.dangtin.cookbook.adapter.base.BaseRecyclerViewAdapter;
import com.dangtin.cookbook.adapter.base.Releasable;
import com.dangtin.cookbook.data.models.Food;
import com.dangtin.cookbook.injection.ActivityContext;
import com.dangtin.cookbook.utils.ListDecorator;

import java.util.ArrayList;

import javax.inject.Inject;

public class FoodHorizontalAdapter extends RecyclerView.Adapter<FoodHorizontalAdapter.FoodHorizontalViewHolder>
        implements Releasable {

    private Context context;
    private ArrayList<Food> listFood;
    private RecyclerView mRecyclerView;

    @Inject
    public FoodHorizontalAdapter(@ActivityContext Context context) {
        this.context = context;
    }

    @Override
    public FoodHorizontalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        FoodHorizontalViewHolder viewHolder = FoodHorizontalViewHolder.create(parent);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(FoodHorizontalViewHolder holder, int position) {
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
        GridLayoutManager layoutManager = new GridLayoutManager(context, 2);
        mRecyclerView.setNestedScrollingEnabled(false);
        mRecyclerView.setFocusable(false);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(this);
    }

    @Override
    public void release() {
        context = null;
    }

    public static class FoodHorizontalViewHolder extends BaseRecyclerViewAdapter.BaseViewHolder<Food> {

        /*@BindView(R.id.image_banner)
        AspectRatioImageView imgBanner;*/

        public FoodHorizontalViewHolder(View itemView) {
            super(itemView);
        }

        public static FoodHorizontalViewHolder create(ViewGroup parent) {
            return new FoodHorizontalViewHolder(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_food_horizontal, parent, false));
        }

        @Override
        public void bindData(Context context, Food food, int position) {
            if (food != null) {

            }
        }

    }
}
