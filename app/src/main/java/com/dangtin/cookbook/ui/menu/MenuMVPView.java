/*
 * ******************************************************************************
 *  Copyright Ⓒ 2018. All rights reserved
 *  Author DangTin. Create on 2018/01/30
 * ******************************************************************************
 */

package com.dangtin.cookbook.ui.menu;

import com.dangtin.cookbook.data.models.LevelDifficult;
import com.dangtin.cookbook.data.models.Menu;
import com.dangtin.cookbook.data.models.QuantityFood;
import com.dangtin.cookbook.ui.base.BaseScreenMvpView;

import java.util.ArrayList;

interface MenuMVPView extends BaseScreenMvpView {

    void updateListQuantityFood(ArrayList<QuantityFood> listQuantityFood);

    void updateListLevelDifficult(ArrayList<LevelDifficult> listLevelDifficult);

    void updateListMenu(ArrayList<Menu> listMenu);
}
