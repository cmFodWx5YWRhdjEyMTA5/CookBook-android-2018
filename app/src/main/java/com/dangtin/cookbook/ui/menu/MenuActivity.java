/*
 * ******************************************************************************
 *  Copyright Ⓒ 2018. All rights reserved
 *  Author DangTin. Create on 2018/01/30
 * ******************************************************************************
 */

package com.dangtin.cookbook.ui.menu;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.widget.TextView;

import com.dangtin.cookbook.R;
import com.dangtin.cookbook.adapter.LevelDifficultAdapter;
import com.dangtin.cookbook.adapter.QuantityFoodAdapter;
import com.dangtin.cookbook.adapter.menu.MenuVerticalAdapter;
import com.dangtin.cookbook.constant.GlobalFuntion;
import com.dangtin.cookbook.data.models.LevelDifficult;
import com.dangtin.cookbook.data.models.QuantityFood;
import com.dangtin.cookbook.ui.base.BaseMVPDialogActivity;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MenuActivity extends BaseMVPDialogActivity implements MenuMVPView,
        SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.tvDataSearch)
    public TextView tvDataSearch;

    @BindView(R.id.rcvDataSearch)
    public RecyclerView rcvDataSearch;

    @BindView(R.id.rcvLevelDifficult)
    public RecyclerView rcvLevelDifficult;

    @BindView(R.id.rcvData)
    public RecyclerView rcvData;

    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;

    @Inject
    MenuPresenter presenter;

    @Inject
    QuantityFoodAdapter quantityFoodAdapter;

    @Inject
    LevelDifficultAdapter levelDifficultAdapter;

    @Inject
    MenuVerticalAdapter menuVerticalAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getActivityComponent().inject(this);
        viewUnbind = ButterKnife.bind(this);
        presenter.initialView(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.menu);

        swipeRefreshLayout.setColorSchemeColors(getResources().getColor(R.color.colorPrimary));
        swipeRefreshLayout.setOnRefreshListener(this);

        tvDataSearch.setText(getString(R.string.quantity_food));
        quantityFoodAdapter.injectInto(rcvDataSearch);
        levelDifficultAdapter.injectInto(rcvLevelDifficult);
        menuVerticalAdapter.injectInto(rcvData);

        presenter.getData();
    }

    @Override
    protected boolean bindView() {
        return true;
    }

    @Override
    protected int addContextView() {
        return R.layout.activity_menu;
    }

    @Override
    protected void onDestroy() {
        presenter.destroyView();

        if (quantityFoodAdapter != null) {
            quantityFoodAdapter.release();
        }

        if (levelDifficultAdapter != null) {
            levelDifficultAdapter.release();
        }

        if (menuVerticalAdapter != null) {
            menuVerticalAdapter.release();
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
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return true;
    }

    @Override
    public void onRefresh() {
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void updateListQuantityFood(ArrayList<QuantityFood> listQuantityFood) {
        quantityFoodAdapter.setListData(listQuantityFood);
    }

    @Override
    public void updateListLevelDifficult(ArrayList<LevelDifficult> listLevelDifficult) {
        levelDifficultAdapter.setListData(listLevelDifficult);
    }

    @Override
    public void updateListMenu(ArrayList<com.dangtin.cookbook.data.models.Menu> listMenu) {
        menuVerticalAdapter.setListData(listMenu);
    }
}
