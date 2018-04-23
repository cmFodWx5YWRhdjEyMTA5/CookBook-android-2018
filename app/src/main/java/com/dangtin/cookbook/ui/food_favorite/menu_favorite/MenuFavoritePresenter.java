/*
 * ******************************************************************************
 *  Copyright Ⓒ 2018. All rights reserved
 *  Author DangTin. Create on 2018/01/30
 * ******************************************************************************
 */

package com.dangtin.cookbook.ui.food_favorite.menu_favorite;

import com.dangtin.cookbook.constant.FakeData;
import com.dangtin.cookbook.data.DataManager;
import com.dangtin.cookbook.injection.PerActivity;
import com.dangtin.cookbook.ui.base.BasePresenter;

import javax.inject.Inject;

import retrofit2.Retrofit;

@PerActivity
public class MenuFavoritePresenter extends BasePresenter<MenuFavoriteMVPView> {

    @Inject
    public MenuFavoritePresenter(Retrofit mRetrofit, DataManager mDataManager) {
        super(mRetrofit, mDataManager);
    }

    @Override
    public void initialView(MenuFavoriteMVPView mvpView) {
        super.initialView(mvpView);
    }

    @Override
    public void destroyView() {
        super.destroyView();
    }

    public void getListMenu() {
        getMvpView().updateListMenu(FakeData.getListMenu());
    }
}
