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
import com.dangtin.cookbook.data.models.News;
import com.dangtin.cookbook.injection.ActivityContext;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder>
        implements Releasable {

    private Context context;
    private ArrayList<News> listNews;
    private RecyclerView mRecyclerView;

    @Inject
    public NewsAdapter(@ActivityContext Context context) {
        this.context = context;
    }

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        NewsViewHolder viewHolder = NewsViewHolder.create(parent);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(NewsViewHolder holder, int position) {
        holder.bindData(context, listNews.get(position), position);
    }

    @Override
    public int getItemCount() {
        return null == listNews ? 0 : listNews.size();
    }


    public void setListData(ArrayList<News> list) {
        this.listNews = list;
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

    public static class NewsViewHolder extends BaseRecyclerViewAdapter.BaseViewHolder<News> {

        @BindView(R.id.tvTitle)
        TextView tvTitle;

        @BindView(R.id.tvContent)
        TextView tvContent;

        @BindView(R.id.tvDate)
        TextView tvDate;

        public NewsViewHolder(View itemView) {
            super(itemView);
        }

        public static NewsViewHolder create(ViewGroup parent) {
            return new NewsViewHolder(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_news, parent, false));
        }

        @Override
        public void bindData(Context context, News news, int position) {
            if (news != null) {
                tvTitle.setText(news.getTitle());
                tvContent.setText(news.getContent());
                tvDate.setText(news.getDate());
            }
        }
    }
}
