/*
 * ******************************************************************************
 *  Copyright Ⓒ 2018. All rights reserved
 *  Author DangTin. Create on 2018/03/30
 * ******************************************************************************
 */

package com.dangtin.cookbook.ui.main;

import com.dangtin.cookbook.data.models.HomeObject;
import com.dangtin.cookbook.ui.base.BaseScreenMvpView;

import java.util.ArrayList;

interface MainMVPView extends BaseScreenMvpView {

    void updateListHomeObject(ArrayList<HomeObject> listHomeObject);
}
