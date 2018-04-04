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
import com.dangtin.cookbook.data.models.MaterialFood;
import com.dangtin.cookbook.data.models.QuantityFood;
import com.dangtin.cookbook.injection.ActivityContext;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;

public class MaterialFoodAdapter extends RecyclerView.Adapter<MaterialFoodAdapter.MaterialFoodViewHolder>
        implements Releasable {

    private Context context;
    private ArrayList<MaterialFood> listMaterialFood;
    private RecyclerView mRecyclerView;

    @Inject
    public MaterialFoodAdapter(@ActivityContext Context context) {
        this.context = context;
    }

    @Override
    public MaterialFoodViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MaterialFoodViewHolder viewHolder = MaterialFoodViewHolder.create(parent);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MaterialFoodViewHolder holder, int position) {
        holder.bindData(context, listMaterialFood.get(position), position);
    }

    @Override
    public int getItemCount() {
        return null == listMaterialFood ? 0 : listMaterialFood.size();
    }


    public void setListData(ArrayList<MaterialFood> list) {
        this.listMaterialFood = list;
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

    public static class MaterialFoodViewHolder extends BaseRecyclerViewAdapter.BaseViewHolder<MaterialFood> {

        @BindView(R.id.tvTitle)
        TextView tvTitle;

        public MaterialFoodViewHolder(View itemView) {
            super(itemView);
        }

        public static MaterialFoodViewHolder create(ViewGroup parent) {
            return new MaterialFoodViewHolder(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_search_material_food, parent, false));
        }

        @Override
        public void bindData(Context context, MaterialFood materialFood, int position) {
            if (materialFood != null) {
                tvTitle.setText(materialFood.getTitle());
            }
        }
    }
}
