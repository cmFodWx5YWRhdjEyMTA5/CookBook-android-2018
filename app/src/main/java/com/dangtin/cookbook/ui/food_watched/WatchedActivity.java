/*
 * ******************************************************************************
 *  Copyright Ⓒ 2018. All rights reserved
 *  Author DangTin. Create on 2018/01/30
 * ******************************************************************************
 */

package com.dangtin.cookbook.ui.food_watched;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.dangtin.cookbook.R;
import com.dangtin.cookbook.constant.GlobalFuntion;
import com.dangtin.cookbook.ui.base.BaseMVPDialogActivity;
import com.dangtin.cookbook.ui.food_favorite.food_favorite.FoodFavoriteFragment;
import com.dangtin.cookbook.ui.food_favorite.menu_favorite.MenuFavoriteFragment;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WatchedActivity extends BaseMVPDialogActivity implements WatchedMVPView {

    @BindView(R.id.tab_layout)
    TabLayout tabLayout;

    @BindView(R.id.view_pagger)
    ViewPager viewPager;

    @Inject
    WatchedPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getActivityComponent().inject(this);
        viewUnbind = ButterKnife.bind(this);
        presenter.initialView(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getString(R.string.liked));

        initTabLayout();
    }

    @Override
    protected boolean bindView() {
        return true;
    }

    @Override
    protected int addContextView() {
        return R.layout.layout_tab;
    }

    @Override
    protected void onDestroy() {
        presenter.destroyView();
        super.onDestroy();
    }

    @Override
    public void showNoNetworkAlert() {
        showAlert(getString(R.string.error_not_connect_to_internet));
    }

    @Override
    public void onErrorCallApi(int code) {
        GlobalFuntion.showMessageError(this, code);
    }

    private void initTabLayout() {
        viewPager.setAdapter(new TabViewPaggerAdapter(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);
        viewPager.setCurrentItem(0);
        viewPager.setOffscreenPageLimit(2);
    }

    private class TabViewPaggerAdapter extends FragmentPagerAdapter {
        String[] titles = getResources().getStringArray(R.array.tabs_menu_and_food);

        public TabViewPaggerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new MenuFavoriteFragment();
                case 1:
                    return new FoodFavoriteFragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }
    }
}
