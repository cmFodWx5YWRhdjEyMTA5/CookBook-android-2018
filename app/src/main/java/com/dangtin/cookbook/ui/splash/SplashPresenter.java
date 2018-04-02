/*
 * ******************************************************************************
 *  Copyright Ⓒ 2018. All rights reserved
 *  Author DangTin. Create on 2018/01/30
 * ******************************************************************************
 */

package com.dangtin.cookbook.ui.splash;

import android.util.Log;

import com.dangtin.cookbook.data.DataManager;
import com.dangtin.cookbook.data.models.response.CategoryResponse;
import com.dangtin.cookbook.ui.base.BasePresenter;

import javax.inject.Inject;

import retrofit2.Retrofit;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class SplashPresenter extends BasePresenter<SplashMVPView> {

    @Inject
    public SplashPresenter(Retrofit mRetrofit, DataManager mDataManager) {
        super(mRetrofit, mDataManager);
    }

    @Override
    public void initialView(SplashMVPView mvpView) {
        super.initialView(mvpView);
    }

    /*public void getListCategory(boolean showProgress, boolean showDialogNoNetwork) {
        if (!isConnectToInternet()) {
            if (showDialogNoNetwork) notifyNoNetwork();
        } else {
            if (showProgress) getMvpView().showProgressDialog(true);
            mDataManager.getNetworkManager().getListCategory()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<CategoryResponse>() {
                        @Override
                        public void onCompleted() {
                            if (showProgress) getMvpView().showProgressDialog(false);
                        }

                        @Override
                        public void onError(Throwable e) {
                            if (showProgress) getMvpView().showProgressDialog(false);
                            getMvpView().onErrorCallApi(getErrorFromHttp(e).getCode());
                        }

                        @Override
                        public void onNext(CategoryResponse categoryResponse) {
                            if (categoryResponse != null) {
                                Log.e("List size", categoryResponse.getListCategory().size() + "");
                            }
                        }
                    });
        }
    }*/
}
