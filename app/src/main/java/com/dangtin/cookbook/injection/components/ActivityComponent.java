/*
 * ******************************************************************************
 *  Copyright Ⓒ 2018. All rights reserved
 *  Author DangTin. Create on 2018/01/30
 * ******************************************************************************
 */

package com.dangtin.cookbook.injection.components;

import com.dangtin.cookbook.injection.modules.ActivityModule;
import com.dangtin.cookbook.ui.food.FoodActivity;
import com.dangtin.cookbook.ui.main.MainActivity;
import com.dangtin.cookbook.ui.menu.MenuActivity;
import com.dangtin.cookbook.ui.news.NewsActivity;
import com.dangtin.cookbook.ui.search.SearchActivity;
import com.dangtin.cookbook.ui.search_result.SearchResultActivity;
import com.dangtin.cookbook.ui.search_result.food_result.FoodResultFragment;
import com.dangtin.cookbook.ui.search_result.menu_result.MenuResultFragment;
import com.dangtin.cookbook.ui.splash.SplashActivity;

import dagger.Subcomponent;

@Subcomponent(modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(SplashActivity loginActivity);

    void inject(MainActivity mainActivity);

    void inject(MenuActivity menuActivity);

    void inject(FoodActivity foodActivity);

    void inject(SearchActivity searchActivity);

    void inject(SearchResultActivity searchResultActivity);

    void inject(NewsActivity newsActivity);

    void inject(MenuResultFragment menuResultFragment);

    void inject(FoodResultFragment foodResultFragment);
}
