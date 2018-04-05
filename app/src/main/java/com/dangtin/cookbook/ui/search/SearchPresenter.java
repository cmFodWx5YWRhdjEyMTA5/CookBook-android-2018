/*
 * ******************************************************************************
 *  Copyright Ⓒ 2018. All rights reserved
 *  Author DangTin. Create on 2018/01/30
 * ******************************************************************************
 */

package com.dangtin.cookbook.ui.search;

import com.dangtin.cookbook.constant.FakeData;
import com.dangtin.cookbook.data.DataManager;
import com.dangtin.cookbook.ui.base.BasePresenter;

import javax.inject.Inject;

import retrofit2.Retrofit;

public class SearchPresenter extends BasePresenter<SearchMVPView> {

    @Inject
    public SearchPresenter(Retrofit mRetrofit, DataManager mDataManager) {
        super(mRetrofit, mDataManager);
    }

    @Override
    public void initialView(SearchMVPView mvpView) {
        super.initialView(mvpView);
    }

    public void loadData() {
        getMvpView().updateListKeywordHot(FakeData.getListKeywordHot());
        getMvpView().updateListSearchHistory(FakeData.getListSearchHistory());
    }
}
