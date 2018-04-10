/*
 * ******************************************************************************
 *  Copyright Ⓒ 2018. All rights reserved
 *  Author DangTin. Create on 2018/01/30
 * ******************************************************************************
 */

package com.dangtin.cookbook.ui.search_result;

import com.dangtin.cookbook.data.DataManager;
import com.dangtin.cookbook.ui.base.BasePresenter;

import javax.inject.Inject;

import retrofit2.Retrofit;

public class SearchResultPresenter extends BasePresenter<SearchResultMVPView> {

    @Inject
    public SearchResultPresenter(Retrofit mRetrofit, DataManager mDataManager) {
        super(mRetrofit, mDataManager);
    }

    @Override
    public void initialView(SearchResultMVPView mvpView) {
        super.initialView(mvpView);
    }
}
