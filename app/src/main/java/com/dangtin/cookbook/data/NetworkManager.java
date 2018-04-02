/*
 * ******************************************************************************
 *  Copyright Ⓒ 2018. All rights reserved
 *  Author DangTin. Create on 2018/01/30
 * ******************************************************************************
 */

package com.dangtin.cookbook.data;

import com.dangtin.cookbook.data.models.Food;
import com.dangtin.cookbook.data.models.response.CategoryResponse;
import com.dangtin.cookbook.data.models.response.FoodResponse;
import com.dangtin.cookbook.data.networking.CookBookService;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;

@Singleton
public class NetworkManager {

    private final CookBookService mCookBookService;

    @Inject
    public NetworkManager(CookBookService cookBookService) {
        this.mCookBookService = cookBookService;
    }

    public Observable<FoodResponse> getFood(String token, int page) {
        return mCookBookService.getFood(token, page);
    }

    public Observable<CategoryResponse> getListCategory() {
        return mCookBookService.getListCategory();
    }
}
