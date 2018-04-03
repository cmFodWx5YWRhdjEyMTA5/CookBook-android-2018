/*
 * ******************************************************************************
 *  Copyright Ⓒ 2017. All rights reserved
 *  Author DangTin. Create on 2017/11/19
 * ******************************************************************************
 */
package com.dangtin.cookbook.adapter.menu;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dangtin.cookbook.R;
import com.dangtin.cookbook.adapter.base.BaseRecyclerViewAdapter;
import com.dangtin.cookbook.adapter.base.Releasable;
import com.dangtin.cookbook.data.models.Menu;
import com.dangtin.cookbook.injection.ActivityContext;
import com.dangtin.cookbook.utils.ListDecorator;

import java.util.ArrayList;

import javax.inject.Inject;

public class MenuVerticalAdapter extends RecyclerView.Adapter<MenuVerticalAdapter.MenuVerticalViewHolder>
        implements Releasable {

    private Context context;
    private ArrayList<Menu> listMenu;
    private RecyclerView mRecyclerView;

    @Inject
    public MenuVerticalAdapter(@ActivityContext Context context) {
        this.context = context;
    }

    @Override
    public MenuVerticalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MenuVerticalViewHolder viewHolder = MenuVerticalViewHolder.create(parent);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MenuVerticalViewHolder holder, int position) {
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
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        mRecyclerView.setNestedScrollingEnabled(false);
        mRecyclerView.setFocusable(false);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(this);
        recyclerView.addItemDecoration(new ListDecorator());
    }

    @Override
    public void release() {
        context = null;
    }

    public static class MenuVerticalViewHolder extends BaseRecyclerViewAdapter.BaseViewHolder<Menu> {

        /*@BindView(R.id.image_banner)
        AspectRatioImageView imgBanner;*/

        public MenuVerticalViewHolder(View itemView) {
            super(itemView);
        }

        public static MenuVerticalViewHolder create(ViewGroup parent) {
            return new MenuVerticalViewHolder(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_menu_vertical, parent, false));
        }

        @Override
        public void bindData(Context context, Menu menu, int position) {
            if (menu != null) {

            }
        }

    }
}
