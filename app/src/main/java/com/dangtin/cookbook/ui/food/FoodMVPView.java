/*
 * ******************************************************************************
 *  Copyright Ⓒ 2018. All rights reserved
 *  Author DangTin. Create on 2018/01/30
 * ******************************************************************************
 */

package com.dangtin.cookbook.ui.food;

import com.dangtin.cookbook.data.models.Category;
import com.dangtin.cookbook.data.models.Food;
import com.dangtin.cookbook.data.models.LevelDifficult;
import com.dangtin.cookbook.data.models.MaterialFood;
import com.dangtin.cookbook.data.models.Menu;
import com.dangtin.cookbook.data.models.QuantityFood;
import com.dangtin.cookbook.ui.base.BaseScreenMvpView;

import java.util.ArrayList;

interface FoodMVPView extends BaseScreenMvpView {

    void updateListMaterialFood(ArrayList<MaterialFood> listMaterialFood);

    void updateListLevelDifficult(ArrayList<LevelDifficult> listLevelDifficult);

    void updateListCategory(ArrayList<Category> listCategory);

    void updateListFood(ArrayList<Food> listFood);
}
