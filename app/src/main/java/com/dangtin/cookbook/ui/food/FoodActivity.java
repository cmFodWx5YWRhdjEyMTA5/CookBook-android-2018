/*
 * ******************************************************************************
 *  Copyright Ⓒ 2018. All rights reserved
 *  Author DangTin. Create on 2018/01/30
 * ******************************************************************************
 */

package com.dangtin.cookbook.ui.food;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

import com.dangtin.cookbook.R;
import com.dangtin.cookbook.adapter.LevelDifficultAdapter;
import com.dangtin.cookbook.adapter.MaterialFoodAdapter;
import com.dangtin.cookbook.adapter.food.FoodGridViewAdapter;
import com.dangtin.cookbook.constant.GlobalFuntion;
import com.dangtin.cookbook.data.models.Category;
import com.dangtin.cookbook.data.models.Food;
import com.dangtin.cookbook.data.models.LevelDifficult;
import com.dangtin.cookbook.data.models.MaterialFood;
import com.dangtin.cookbook.ui.base.BaseMVPDialogActivity;
import com.dangtin.cookbook.ui.widget.textview.RobotoRegularTextView;
import com.dangtin.cookbook.utils.StringUtil;
import com.wefika.flowlayout.FlowLayout;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FoodActivity extends BaseMVPDialogActivity implements FoodMVPView,
        SwipeRefreshLayout.OnRefreshListener, View.OnClickListener {

    @BindView(R.id.rcvData)
    public RecyclerView rcvData;

    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;

    @BindView(R.id.layout_category)
    FlowLayout flowLayoutCategory;

    @BindView(R.id.tvDataSearch)
    public TextView tvDataSearch;

    @BindView(R.id.rcvDataSearch)
    public RecyclerView rcvDataSearch;

    @BindView(R.id.rcvLevelDifficult)
    public RecyclerView rcvLevelDifficult;

    @Inject
    FoodPresenter presenter;

    @Inject
    MaterialFoodAdapter materialFoodAdapter;

    @Inject
    LevelDifficultAdapter levelDifficultAdapter;

    @Inject
    FoodGridViewAdapter foodGridViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getActivityComponent().inject(this);
        viewUnbind = ButterKnife.bind(this);
        presenter.initialView(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.food);

        swipeRefreshLayout.setColorSchemeColors(getResources().getColor(R.color.colorPrimary));
        swipeRefreshLayout.setOnRefreshListener(this);

        tvDataSearch.setText(getString(R.string.material_food));
        materialFoodAdapter.injectInto(rcvDataSearch);
        levelDifficultAdapter.injectInto(rcvLevelDifficult);
        foodGridViewAdapter.injectInto(rcvData);

        presenter.getData();
    }

    @Override
    protected boolean bindView() {
        return true;
    }

    @Override
    protected int addContextView() {
        return R.layout.activity_food;
    }

    @Override
    protected void onDestroy() {
        presenter.destroyView();
        if (materialFoodAdapter != null) {
            materialFoodAdapter.release();
        }

        if (levelDifficultAdapter != null) {
            levelDifficultAdapter.release();
        }

        if (foodGridViewAdapter != null) {
            foodGridViewAdapter.release();
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
    public void updateListMaterialFood(ArrayList<MaterialFood> listMaterialFood) {
        materialFoodAdapter.setListData(listMaterialFood);
    }

    @Override
    public void updateListLevelDifficult(ArrayList<LevelDifficult> listLevelDifficult) {
        levelDifficultAdapter.setListData(listLevelDifficult);
    }

    @Override
    public void updateListCategory(ArrayList<Category> listCategory) {
        listCategory.add(0, new Category(0, getString(R.string.all)));
        setLayoutCategory(listCategory, 0);
    }

    @Override
    public void updateListFood(ArrayList<Food> listFood) {
        foodGridViewAdapter.setListData(listFood);
    }

    private void setLayoutCategory(ArrayList<Category> listCategory, int categorySelected) {
        flowLayoutCategory.removeAllViews();
        if (listCategory != null && listCategory.size() > 0) {
            for (int i = 0; i < listCategory.size(); i++) {
                FlowLayout.LayoutParams params =
                        new FlowLayout.LayoutParams(FlowLayout.LayoutParams.WRAP_CONTENT,
                                FlowLayout.LayoutParams.WRAP_CONTENT);
                RobotoRegularTextView textView = new RobotoRegularTextView(this);
                textView.setLayoutParams(params);
                textView.setPadding(0, 10, 60, 10);
                textView.setId(listCategory.get(i).getId());
                if (listCategory.get(i).getId() == categorySelected) {
                    textView.setText(StringUtil.span(listCategory.get(i).getName()));
                    textView.setTextColor(getResources().getColor(R.color.colorPrimary));
                } else {
                    textView.setText(listCategory.get(i).getName());
                    textView.setTextColor(getResources().getColor(R.color.textColorSecondary));
                }
                textView.setTextSize(((int) getResources().getDimension(R.dimen.text_size_small) /
                        getResources().getDisplayMetrics().density));
                textView.setOnClickListener(this);
                flowLayoutCategory.addView(textView);
            }
        }
    }

    @Override
    public void onClick(View view) {

    }
}
