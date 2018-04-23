/*
 * ******************************************************************************
 *  Copyright Ⓒ 2018. All rights reserved
 *  Author DangTin. Create on 2018/01/30
 * ******************************************************************************
 */

package com.dangtin.cookbook.ui.food_favorite.food_favorite;

import com.dangtin.cookbook.data.models.Food;
import com.dangtin.cookbook.ui.base.BaseScreenMvpView;

import java.util.ArrayList;

interface FoodFavoriteMVPView extends BaseScreenMvpView {

    void updateListFood(ArrayList<Food> listFood);
}
