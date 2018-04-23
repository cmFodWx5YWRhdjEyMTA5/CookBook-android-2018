/*
 * ******************************************************************************
 *  Copyright Ⓒ 2018. All rights reserved
 *  Author DangTin. Create on 2018/01/30
 * ******************************************************************************
 */

package com.dangtin.cookbook.ui.food_watched;

import com.dangtin.cookbook.data.DataManager;
import com.dangtin.cookbook.ui.base.BasePresenter;

import javax.inject.Inject;

import retrofit2.Retrofit;

public class WatchedPresenter extends BasePresenter<WatchedMVPView> {

    @Inject
    public WatchedPresenter(Retrofit mRetrofit, DataManager mDataManager) {
        super(mRetrofit, mDataManager);
    }

    @Override
    public void initialView(WatchedMVPView mvpView) {
        super.initialView(mvpView);
    }
}
