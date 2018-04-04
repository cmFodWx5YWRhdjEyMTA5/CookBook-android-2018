/*
 * ******************************************************************************
 *  Copyright Ⓒ 2018. All rights reserved
 *  Author DangTin. Create on 2018/01/30
 * ******************************************************************************
 */

package com.dangtin.cookbook.ui.food;

import com.dangtin.cookbook.constant.FakeData;
import com.dangtin.cookbook.data.DataManager;
import com.dangtin.cookbook.ui.base.BasePresenter;

import javax.inject.Inject;

import retrofit2.Retrofit;

public class FoodPresenter extends BasePresenter<FoodMVPView> {

    @Inject
    public FoodPresenter(Retrofit mRetrofit, DataManager mDataManager) {
        super(mRetrofit, mDataManager);
    }

    @Override
    public void initialView(FoodMVPView mvpView) {
        super.initialView(mvpView);
    }

    public void getData() {
        getMvpView().updateListMaterialFood(FakeData.getListMaterialFood());
        getMvpView().updateListLevelDifficult(FakeData.getListLevelDifficult());
        getMvpView().updateListCategory(FakeData.getListCategory());
        getMvpView().updateListFood(FakeData.getListFood());
    }
}
