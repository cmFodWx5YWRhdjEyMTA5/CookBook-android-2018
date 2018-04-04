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
import android.widget.ImageView;
import android.widget.TextView;

import com.dangtin.cookbook.R;
import com.dangtin.cookbook.adapter.base.BaseRecyclerViewAdapter;
import com.dangtin.cookbook.adapter.base.Releasable;
import com.dangtin.cookbook.data.models.LevelDifficult;
import com.dangtin.cookbook.injection.ActivityContext;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;

public class LevelDifficultAdapter extends RecyclerView.Adapter<LevelDifficultAdapter.LevelDifficultViewHolder>
        implements Releasable {

    private Context context;
    private ArrayList<LevelDifficult> listLevelDifficult;
    private RecyclerView mRecyclerView;

    @Inject
    public LevelDifficultAdapter(@ActivityContext Context context) {
        this.context = context;
    }

    @Override
    public LevelDifficultViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LevelDifficultViewHolder viewHolder = LevelDifficultViewHolder.create(parent);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(LevelDifficultViewHolder holder, int position) {
        holder.bindData(context, listLevelDifficult.get(position), position);
    }

    @Override
    public int getItemCount() {
        return null == listLevelDifficult ? 0 : listLevelDifficult.size();
    }


    public void setListData(ArrayList<LevelDifficult> list) {
        this.listLevelDifficult = list;
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

    public static class LevelDifficultViewHolder extends BaseRecyclerViewAdapter.BaseViewHolder<LevelDifficult> {

        @BindView(R.id.tvLevel)
        TextView tvLevel;

        @BindView(R.id.image_level_1)
        ImageView image_level_1;

        @BindView(R.id.image_level_2)
        ImageView image_level_2;

        @BindView(R.id.image_level_3)
        ImageView image_level_3;

        public LevelDifficultViewHolder(View itemView) {
            super(itemView);
        }

        public static LevelDifficultViewHolder create(ViewGroup parent) {
            return new LevelDifficultViewHolder(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_search_level_difficult, parent, false));
        }

        @Override
        public void bindData(Context context, LevelDifficult levelDifficult, int position) {
            if (levelDifficult != null) {
                tvLevel.setText(levelDifficult.getTitle());
                switch (levelDifficult.getLevel()) {
                    case 1:
                        image_level_1.setVisibility(View.VISIBLE);
                        image_level_2.setVisibility(View.GONE);
                        image_level_3.setVisibility(View.GONE);
                        break;

                    case 2:
                        image_level_1.setVisibility(View.VISIBLE);
                        image_level_2.setVisibility(View.VISIBLE);
                        image_level_3.setVisibility(View.GONE);
                        break;

                    case 3:
                        image_level_1.setVisibility(View.VISIBLE);
                        image_level_2.setVisibility(View.VISIBLE);
                        image_level_3.setVisibility(View.VISIBLE);
                        break;
                }
            }
        }
    }
}
