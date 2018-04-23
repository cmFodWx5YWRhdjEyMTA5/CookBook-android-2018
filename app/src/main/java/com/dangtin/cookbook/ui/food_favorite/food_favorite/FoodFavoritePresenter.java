/*
 * ******************************************************************************
 *  Copyright Ⓒ 2018. All rights reserved
 *  Author DangTin. Create on 2018/01/30
 * ******************************************************************************
 */

package com.dangtin.cookbook.ui.food_favorite.food_favorite;

import com.dangtin.cookbook.constant.FakeData;
import com.dangtin.cookbook.data.DataManager;
import com.dangtin.cookbook.injection.PerActivity;
import com.dangtin.cookbook.ui.base.BasePresenter;

import javax.inject.Inject;

import retrofit2.Retrofit;

@PerActivity
public class FoodFavoritePresenter extends BasePresenter<FoodFavoriteMVPView> {

    @Inject
    public FoodFavoritePresenter(Retrofit mRetrofit, DataManager mDataManager) {
        super(mRetrofit, mDataManager);
    }

    @Override
    public void initialView(FoodFavoriteMVPView mvpView) {
        super.initialView(mvpView);
    }

    @Override
    public void destroyView() {
        super.destroyView();
    }

    public void getListFood() {
        getMvpView().updateListFood(FakeData.getListFood());
    }
}
