/*
 * ******************************************************************************
 *  Copyright Ⓒ 2018. All rights reserved
 *  Author DangTin. Create on 2018/01/30
 * ******************************************************************************
 */

package com.dangtin.cookbook.ui.news;

import com.dangtin.cookbook.data.models.News;
import com.dangtin.cookbook.ui.base.BaseScreenMvpView;

import java.util.ArrayList;

interface NewsMVPView extends BaseScreenMvpView {

    void updateListNews(ArrayList<News> listNews);
}
