/*
 * ******************************************************************************
 *  Copyright Ⓒ 2018. All rights reserved
 *  Author DangTin. Create on 2018/03/30
 * ******************************************************************************
 */

package com.dangtin.cookbook.ui.main;

import android.content.Context;

import com.dangtin.cookbook.constant.FakeData;
import com.dangtin.cookbook.data.DataManager;
import com.dangtin.cookbook.data.models.Category;
import com.dangtin.cookbook.data.models.Featured;
import com.dangtin.cookbook.data.models.HomeObject;
import com.dangtin.cookbook.ui.base.BasePresenter;

import java.util.ArrayList;

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

    public ArrayList<Category> getListCategory() {
        return FakeData.getListCategory();
    }

    public ArrayList<Featured> getListFeatured() {
        return FakeData.getListFeatured();
    }

    public void getListHomeObject(Context context) {
        getMvpView().updateListHomeObject(FakeData.getListHomeObject(context));
    }
}
