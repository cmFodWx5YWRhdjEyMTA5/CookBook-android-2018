/*
 * ******************************************************************************
 *  Copyright Ⓒ 2017. All rights reserved
 *  Author DangTin. Create on 2017/11/19
 * ******************************************************************************
 */
package com.dangtin.cookbook.adapter.menu;

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
import com.dangtin.cookbook.data.models.Menu;
import com.dangtin.cookbook.injection.ActivityContext;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;

public class MenuFavoriteAdapter extends RecyclerView.Adapter<MenuFavoriteAdapter.MenuViewHolder>
        implements Releasable {

    private Context context;
    private ArrayList<Menu> listMenu;
    private RecyclerView mRecyclerView;

    @Inject
    public MenuFavoriteAdapter(@ActivityContext Context context) {
        this.context = context;
    }

    @Override
    public MenuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MenuViewHolder viewHolder = MenuViewHolder.create(parent);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MenuViewHolder holder, int position) {
        holder.bindData(context, listMenu.get(position), position);
    }

    @Override
    public int getItemCount() {
        return null == listMenu ? 0 : listMenu.size();
    }


    public void setListData(ArrayList<Menu> list) {
        this.listMenu = list;
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

    public static class MenuViewHolder extends BaseRecyclerViewAdapter.BaseViewHolder<Menu> {

        @BindView(R.id.tvTitle)
        TextView tvTitle;

        public MenuViewHolder(View itemView) {
            super(itemView);
        }

        public static MenuViewHolder create(ViewGroup parent) {
            return new MenuViewHolder(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_favorite, parent, false));
        }

        @Override
        public void bindData(Context context, Menu menu, int position) {
            if (menu != null) {
                tvTitle.setText(menu.getName());
            }
        }
    }
}
