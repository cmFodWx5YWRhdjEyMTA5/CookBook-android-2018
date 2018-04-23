/*
 * ******************************************************************************
 *  Copyright Ⓒ 2018. All rights reserved
 *  Author DangTin. Create on 2018/01/30
 * ******************************************************************************
 */

package com.dangtin.cookbook.ui.food_favorite.menu_favorite;

import com.dangtin.cookbook.data.models.Menu;
import com.dangtin.cookbook.ui.base.BaseScreenMvpView;

import java.util.ArrayList;

interface MenuFavoriteMVPView extends BaseScreenMvpView {

    void updateListMenu(ArrayList<Menu> listMenu);
}
