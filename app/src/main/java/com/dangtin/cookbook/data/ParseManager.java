/*
 * ******************************************************************************
 *  Copyright Ⓒ 2018. All rights reserved
 *  Author DangTin. Create on 2018/01/30
 * ******************************************************************************
 */

package com.dangtin.cookbook.data;

import com.dangtin.cookbook.data.models.Food;
import com.dangtin.cookbook.data.models.response.FoodResponse;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ParseManager {

    private final NetworkManager mNetworkManager;

    @Inject
    public ParseManager(NetworkManager networkManager) {
        this.mNetworkManager = networkManager;
    }

    public NetworkManager getNetworkManager() {
        return mNetworkManager;
    }

    public Food parseFood(FoodResponse foodResponse) {
        Food food = new Food();
        if (foodResponse != null) {
            food = foodResponse.getFood();
        }
        return food;
    }
}
