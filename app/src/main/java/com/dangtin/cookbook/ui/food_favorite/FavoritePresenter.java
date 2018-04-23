/*
 * ******************************************************************************
 *  Copyright Ⓒ 2018. All rights reserved
 *  Author DangTin. Create on 2018/01/30
 * ******************************************************************************
 */

package com.dangtin.cookbook.ui.food_favorite;

import com.dangtin.cookbook.data.DataManager;
import com.dangtin.cookbook.ui.base.BasePresenter;

import javax.inject.Inject;

import retrofit2.Retrofit;

public class FavoritePresenter extends BasePresenter<FavoriteMVPView> {

    @Inject
    public FavoritePresenter(Retrofit mRetrofit, DataManager mDataManager) {
        super(mRetrofit, mDataManager);
    }

    @Override
    public void initialView(FavoriteMVPView mvpView) {
        super.initialView(mvpView);
    }
}
