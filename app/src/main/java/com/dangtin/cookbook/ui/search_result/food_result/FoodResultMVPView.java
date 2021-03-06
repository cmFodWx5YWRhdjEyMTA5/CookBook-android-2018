/*
 * ******************************************************************************
 *  Copyright Ⓒ 2018. All rights reserved
 *  Author DangTin. Create on 2018/01/30
 * ******************************************************************************
 */

package com.dangtin.cookbook.ui.search_result.food_result;

import com.dangtin.cookbook.data.models.Food;
import com.dangtin.cookbook.ui.base.BaseScreenMvpView;

import java.util.ArrayList;

interface FoodResultMVPView extends BaseScreenMvpView {

    void updateListFood(ArrayList<Food> listFood);
}
