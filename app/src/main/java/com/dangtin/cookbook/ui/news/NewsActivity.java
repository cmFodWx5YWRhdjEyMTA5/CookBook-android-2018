/*
 * ******************************************************************************
 *  Copyright Ⓒ 2018. All rights reserved
 *  Author DangTin. Create on 2018/01/30
 * ******************************************************************************
 */

package com.dangtin.cookbook.ui.news;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;

import com.dangtin.cookbook.R;
import com.dangtin.cookbook.adapter.NewsAdapter;
import com.dangtin.cookbook.constant.GlobalFuntion;
import com.dangtin.cookbook.data.models.News;
import com.dangtin.cookbook.ui.base.BaseMVPDialogActivity;
import com.dangtin.cookbook.ui.main.MainActivity;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsActivity extends BaseMVPDialogActivity implements NewsMVPView,
        SwipeRefreshLayout.OnRefreshListener{

    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;

    @BindView(R.id.rcvNews)
    RecyclerView rcvNews;

    @Inject
    NewsAdapter newsAdapter;

    @Inject
    NewsPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getActivityComponent().inject(this);
        viewUnbind = ButterKnife.bind(this);
        presenter.initialView(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.news);

        swipeRefreshLayout.setColorSchemeColors(getResources().getColor(R.color.colorPrimary));
        swipeRefreshLayout.setOnRefreshListener(this);

        newsAdapter.injectInto(rcvNews);
        presenter.getListNews();
    }

    @Override
    protected boolean bindView() {
        return true;
    }

    @Override
    protected int addContextView() {
        return R.layout.activity_news;
    }

    @Override
    protected void onDestroy() {
        presenter.destroyView();

        if (newsAdapter != null) {
            newsAdapter.release();
        }
        super.onDestroy();
    }

    @Override
    public void showNoNetworkAlert() {
        showAlert(getString(R.string.error_not_connect_to_internet));
    }

    @Override
    public void onErrorCallApi(int code) {
        GlobalFuntion.showMessageError(this, code);
    }

    @Override
    public void onRefresh() {
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void updateListNews(ArrayList<News> listNews) {
        newsAdapter.setListData(listNews);
    }
}
