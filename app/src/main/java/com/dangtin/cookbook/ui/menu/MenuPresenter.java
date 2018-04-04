/*
 * ******************************************************************************
 *  Copyright Ⓒ 2018. All rights reserved
 *  Author DangTin. Create on 2018/01/30
 * ******************************************************************************
 */

package com.dangtin.cookbook.ui.menu;

import com.dangtin.cookbook.constant.FakeData;
import com.dangtin.cookbook.data.DataManager;
import com.dangtin.cookbook.ui.base.BasePresenter;

import javax.inject.Inject;

import retrofit2.Retrofit;

public class MenuPresenter extends BasePresenter<MenuMVPView> {

    @Inject
    public MenuPresenter(Retrofit mRetrofit, DataManager mDataManager) {
        super(mRetrofit, mDataManager);
    }

    @Override
    public void initialView(MenuMVPView mvpView) {
        super.initialView(mvpView);
    }

    public void getData() {
        getMvpView().updateListQuantityFood(FakeData.getListQuantityFood());
        getMvpView().updateListLevelDifficult(FakeData.getListLevelDifficult());
        getMvpView().updateListMenu(FakeData.getListMenu());
    }
}
