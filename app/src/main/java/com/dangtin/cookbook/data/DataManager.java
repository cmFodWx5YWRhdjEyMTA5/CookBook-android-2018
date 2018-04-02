/*
 * ******************************************************************************
 *  Copyright Ⓒ 2017. All rights reserved
 *  Author DangTin. Create on 2017/11/16
 * ******************************************************************************
 */

package com.dangtin.cookbook.data;

import com.dangtin.cookbook.data.models.Food;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;

@Singleton
public class DataManager {

    private final NetworkManager mNetworkManager;
    private final ParseManager mParseManager;

    @Inject
    public DataManager(NetworkManager networkManager, ParseManager parseManager) {
        this.mNetworkManager = networkManager;
        this.mParseManager = parseManager;
    }

    public NetworkManager getNetworkManager() {
        return mNetworkManager;
    }

    public ParseManager getParseManager() {
        return mParseManager;
    }

    public Observable<Food> getFood(String token, int page) {
        return getNetworkManager().getFood(token, page)
                .map(foodResponse -> getParseManager().parseFood(foodResponse));
    }
}
