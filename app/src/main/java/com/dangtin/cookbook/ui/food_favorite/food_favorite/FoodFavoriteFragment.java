/*
 * ******************************************************************************
 *  Copyright Ⓒ 2017. All rights reserved
 *  Author DangTin. Create on 2017/11/16
 * ******************************************************************************
 */

package com.dangtin.cookbook.ui.food_favorite.food_favorite;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dangtin.cookbook.R;
import com.dangtin.cookbook.adapter.food.FoodFavoriteAdapter;
import com.dangtin.cookbook.adapter.food.FoodGridViewAdapter;
import com.dangtin.cookbook.constant.GlobalFuntion;
import com.dangtin.cookbook.data.models.Food;
import com.dangtin.cookbook.ui.base.BaseMVPFragmentWithDialog;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FoodFavoriteFragment extends BaseMVPFragmentWithDialog implements FoodFavoriteMVPView,
        SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;

    @BindView(R.id.rcvData)
    RecyclerView rcvData;

    @Inject
    FoodFavoritePresenter presenter;

    @Inject
    FoodFavoriteAdapter foodFavoriteAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_food_favorite, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getActivityComponent().inject(this);
        viewUnbind = ButterKnife.bind(this, view);
        presenter.initialView(this);

        swipeRefreshLayout.setColorSchemeColors(getResources().getColor(R.color.colorPrimary));
        swipeRefreshLayout.setOnRefreshListener(this);

        foodFavoriteAdapter.injectInto(rcvData);
        presenter.getListFood();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        presenter.destroyView();

        if (foodFavoriteAdapter != null) {
            foodFavoriteAdapter.release();
        }
    }

    @Override
    protected void initToolbar() {

    }

    @Override
    public void onRefresh() {
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onErrorCallApi(int code) {
        GlobalFuntion.showMessageError(getActivity(), code);
    }

    @Override
    public void updateListFood(ArrayList<Food> listFood) {
        foodFavoriteAdapter.setListData(listFood);
    }
}
