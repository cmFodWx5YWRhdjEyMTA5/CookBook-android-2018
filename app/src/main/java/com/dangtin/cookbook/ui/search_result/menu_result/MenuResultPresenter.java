/*
 * ******************************************************************************
 *  Copyright Ⓒ 2018. All rights reserved
 *  Author DangTin. Create on 2018/01/30
 * ******************************************************************************
 */

package com.dangtin.cookbook.ui.search_result.menu_result;

import com.dangtin.cookbook.constant.FakeData;
import com.dangtin.cookbook.data.DataManager;
import com.dangtin.cookbook.injection.PerActivity;
import com.dangtin.cookbook.ui.base.BasePresenter;

import javax.inject.Inject;

import retrofit2.Retrofit;

@PerActivity
public class MenuResultPresenter extends BasePresenter<MenuResultMVPView> {

    @Inject
    public MenuResultPresenter(Retrofit mRetrofit, DataManager mDataManager) {
        super(mRetrofit, mDataManager);
    }

    @Override
    public void initialView(MenuResultMVPView mvpView) {
        super.initialView(mvpView);
    }

    @Override
    public void destroyView() {
        super.destroyView();
    }

    public void getListMenuResult() {
        getMvpView().updateListMenu(FakeData.getListMenu());
    }
}
