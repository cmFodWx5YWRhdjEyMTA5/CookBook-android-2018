/*
 * ******************************************************************************
 *  Copyright Ⓒ 2018. All rights reserved
 *  Author DangTin. Create on 2018/01/30
 * ******************************************************************************
 */

package com.dangtin.cookbook.ui.search;

import com.dangtin.cookbook.data.models.KeywordHot;
import com.dangtin.cookbook.data.models.SearchHistory;
import com.dangtin.cookbook.ui.base.BaseScreenMvpView;

import java.util.ArrayList;

interface SearchMVPView extends BaseScreenMvpView {

    void updateListKeywordHot(ArrayList<KeywordHot> listKeywordHot);

    void updateListSearchHistory(ArrayList<SearchHistory> listSearchHistory);
}
