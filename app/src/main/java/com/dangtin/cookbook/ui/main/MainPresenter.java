/*
 * ******************************************************************************
 *  Copyright Ⓒ 2018. All rights reserved
 *  Author DangTin. Create on 2018/03/30
 * ******************************************************************************
 */

package com.dangtin.cookbook.ui.main;

import com.dangtin.cookbook.data.DataManager;
import com.dangtin.cookbook.ui.base.BasePresenter;

import javax.inject.Inject;

import retrofit2.Retrofit;

public class MainPresenter extends BasePresenter<MainMVPView> {

    @Inject
    public MainPresenter(Retrofit mRetrofit, DataManager mDataManager) {
        super(mRetrofit, mDataManager);
    }

    @Override
    public void initialView(MainMVPView mvpView) {
        super.initialView(mvpView);
    }
}
