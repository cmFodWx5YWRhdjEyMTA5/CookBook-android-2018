/*
 * ******************************************************************************
 *  Copyright Ⓒ 2017. All rights reserved
 *  Author DangTin. Create on 2018/04/10
 * ******************************************************************************
 */

package com.dangtin.cookbook.ui.widget.views;

import android.content.Context;
import android.graphics.Typeface;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.view.ViewGroup;

public class CustomTabLayout extends TabLayout {
    public CustomTabLayout(Context context) {
        super(context);
    }

    public CustomTabLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomTabLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void setupWithViewPager(ViewPager viewPager) {
        super.setupWithViewPager(viewPager);
        Typeface mTypeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/Roboto-Medium.ttf");
        if (mTypeface != null) {
            this.removeAllTabs();
            ViewGroup slidingTabStrip = (ViewGroup) getChildAt(0);
            PagerAdapter adapter = viewPager.getAdapter();
            for (int i = 0, count = adapter.getCount(); i < count; i++) {
                Tab tab = this.newTab();
                this.addTab(tab.setText(adapter.getPageTitle(i)));
                AppCompatTextView view = (AppCompatTextView) ((ViewGroup) slidingTabStrip.getChildAt(i)).getChildAt(1);
                view.setTypeface(mTypeface, Typeface.NORMAL);
            }
        }
    }
}
