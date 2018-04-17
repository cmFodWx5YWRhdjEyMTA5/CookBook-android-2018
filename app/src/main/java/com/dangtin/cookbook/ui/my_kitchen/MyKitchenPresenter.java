/*
 * ******************************************************************************
 *  Copyright Ⓒ 2018. All rights reserved
 *  Author DangTin. Create on 2018/01/30
 * ******************************************************************************
 */

package com.dangtin.cookbook.ui.my_kitchen;

import com.dangtin.cookbook.data.DataManager;
import com.dangtin.cookbook.ui.base.BasePresenter;

import javax.inject.Inject;

import retrofit2.Retrofit;

public class MyKitchenPresenter extends BasePresenter<MyKitchenMVPView> {

    @Inject
    public MyKitchenPresenter(Retrofit mRetrofit, DataManager mDataManager) {
        super(mRetrofit, mDataManager);
    }

    @Override
    public void initialView(MyKitchenMVPView mvpView) {
        super.initialView(mvpView);
    }
}
