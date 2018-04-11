/*
 * ******************************************************************************
 *  Copyright Ⓒ 2018. All rights reserved
 *  Author DangTin. Create on 2018/01/30
 * ******************************************************************************
 */

package com.dangtin.cookbook.ui.news;

import com.dangtin.cookbook.constant.FakeData;
import com.dangtin.cookbook.data.DataManager;
import com.dangtin.cookbook.data.models.News;
import com.dangtin.cookbook.ui.base.BasePresenter;

import java.util.ArrayList;

import javax.inject.Inject;

import retrofit2.Retrofit;

public class NewsPresenter extends BasePresenter<NewsMVPView> {

    @Inject
    public NewsPresenter(Retrofit mRetrofit, DataManager mDataManager) {
        super(mRetrofit, mDataManager);
    }

    @Override
    public void initialView(NewsMVPView mvpView) {
        super.initialView(mvpView);
    }

    public void getListNews() {
        getMvpView().updateListNews(FakeData.getListNews());
    }
}
