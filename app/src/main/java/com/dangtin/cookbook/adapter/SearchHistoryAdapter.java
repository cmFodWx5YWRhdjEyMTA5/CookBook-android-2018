/*
 * ******************************************************************************
 *  Copyright Ⓒ 2017. All rights reserved
 *  Author DangTin. Create on 2017/11/19
 * ******************************************************************************
 */
package com.dangtin.cookbook.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.dangtin.cookbook.R;
import com.dangtin.cookbook.adapter.base.BaseRecyclerViewAdapter;
import com.dangtin.cookbook.adapter.base.Releasable;
import com.dangtin.cookbook.constant.Constant;
import com.dangtin.cookbook.constant.GlobalFuntion;
import com.dangtin.cookbook.data.models.SearchHistory;
import com.dangtin.cookbook.injection.ActivityContext;
import com.dangtin.cookbook.ui.search_result.SearchResultActivity;
import com.dangtin.cookbook.utils.ListDecorator;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;

public class SearchHistoryAdapter extends RecyclerView.Adapter<SearchHistoryAdapter.SearchHistoryViewHolder>
        implements Releasable {

    private Context context;
    private ArrayList<SearchHistory> listSearchHistory;
    private RecyclerView mRecyclerView;

    @Inject
    public SearchHistoryAdapter(@ActivityContext Context context) {
        this.context = context;
    }

    @Override
    public SearchHistoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        SearchHistoryViewHolder viewHolder = SearchHistoryViewHolder.create(parent);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(SearchHistoryViewHolder holder, int position) {
        holder.bindData(context, listSearchHistory.get(position), position);
    }

    @Override
    public int getItemCount() {
        return null == listSearchHistory ? 0 : listSearchHistory.size();
    }


    public void setListData(ArrayList<SearchHistory> list) {
        this.listSearchHistory = list;
        notifyDataSetChanged();
    }

    public void injectInto(RecyclerView recyclerView) {
        mRecyclerView = recyclerView;
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        mRecyclerView.setNestedScrollingEnabled(false);
        mRecyclerView.setFocusable(false);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(this);
    }

    @Override
    public void release() {
        context = null;
    }

    public static class SearchHistoryViewHolder extends BaseRecyclerViewAdapter.BaseViewHolder<SearchHistory> {

        @BindView(R.id.tvTitle)
        TextView tvTitle;

        @BindView(R.id.layout_item_history)
        RelativeLayout layoutItemHistory;

        public SearchHistoryViewHolder(View itemView) {
            super(itemView);
        }

        public static SearchHistoryViewHolder create(ViewGroup parent) {
            return new SearchHistoryViewHolder(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_search_history, parent, false));
        }

        @Override
        public void bindData(Context context, SearchHistory searchHistory, int position) {
            if (searchHistory != null) {
                tvTitle.setText(searchHistory.getTitle());

                layoutItemHistory.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Bundle bundle = new Bundle();
                        bundle.putString(Constant.KEY_WORD, searchHistory.getTitle());
                        GlobalFuntion.startActivity(context, SearchResultActivity.class, bundle);
                    }
                });
            }
        }
    }
}
