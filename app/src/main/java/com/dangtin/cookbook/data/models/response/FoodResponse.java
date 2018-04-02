/*
 * ******************************************************************************
 *  Copyright Ⓒ 2018. All rights reserved
 *  Author DangTin. Create on 2018/01/30
 * ******************************************************************************
 */

package com.dangtin.cookbook.data.models.response;

import com.dangtin.cookbook.data.models.Food;
import com.google.gson.annotations.SerializedName;

public class FoodResponse {

    @SerializedName("data")
    private Food food;

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }
}
