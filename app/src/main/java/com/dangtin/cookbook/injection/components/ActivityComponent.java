/*
 * ******************************************************************************
 *  Copyright Ⓒ 2018. All rights reserved
 *  Author DangTin. Create on 2018/01/30
 * ******************************************************************************
 */

package com.dangtin.cookbook.injection.components;

import com.dangtin.cookbook.injection.modules.ActivityModule;
import com.dangtin.cookbook.ui.main.MainActivity;
import com.dangtin.cookbook.ui.splash.SplashActivity;

import dagger.Subcomponent;

@Subcomponent(modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(SplashActivity loginActivity);

    void inject(MainActivity mainActivity);
}
