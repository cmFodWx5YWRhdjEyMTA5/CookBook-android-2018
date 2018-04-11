/*
 * ******************************************************************************
 *  Copyright Ⓒ 2018. All rights reserved
 *  Author DangTin. Create on 2018/01/30
 * ******************************************************************************
 */

package com.dangtin.cookbook.ui.main;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.dangtin.cookbook.R;
import com.dangtin.cookbook.adapter.CategoryAdapter;
import com.dangtin.cookbook.adapter.FeaturedPagerAdapter;
import com.dangtin.cookbook.adapter.ListHomeAdapter;
import com.dangtin.cookbook.constant.GlobalFuntion;
import com.dangtin.cookbook.data.models.HomeObject;
import com.dangtin.cookbook.ui.base.BaseMVPDialogActivity;
import com.dangtin.cookbook.ui.food.FoodActivity;
import com.dangtin.cookbook.ui.news.NewsActivity;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Optional;
import me.relex.circleindicator.CircleIndicator;


public class MainActivity extends BaseMVPDialogActivity implements MainMVPView,
        SwipeRefreshLayout.OnRefreshListener {

    @Inject
    MainPresenter presenter;

    private ActionBarDrawerToggle mToggle;

    @BindView(R.id.drawer_layout)
    public DrawerLayout mDrawerLayout;

    @BindView(R.id.nav_view)
    public NavigationView mNavigationView;

    @BindView(R.id.viewpager)
    public ViewPager mViewPage;

    @BindView(R.id.indicator)
    public CircleIndicator mIndicator;

    @BindView(R.id.rcvData)
    public RecyclerView rcvData;

    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;

    @Inject
    ListHomeAdapter listHomeAdapter;

    private ListView lvCategory;

    private static final long DELAY = 500;
    private static final long PERIOD = 3000;
    private Timer mTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getActivityComponent().inject(this);
        viewUnbind = ButterKnife.bind(this);
        presenter.initialView(this);

        initNavigationView();
        initData();

        swipeRefreshLayout.setColorSchemeColors(getResources().getColor(R.color.colorPrimary));
        swipeRefreshLayout.setOnRefreshListener(this);
    }

    @Override
    protected boolean bindView() {
        return true;
    }

    @Override
    protected int addContextView() {
        return R.layout.activity_main;
    }

    @Override
    protected void onDestroy() {
        presenter.destroyView();
        if (mTimer != null) {
            mTimer.cancel();
            mTimer = null;
        }
        if (listHomeAdapter != null) {
            listHomeAdapter.release();
        }
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.profile, menu);
        return true;
    }

    private void initNavigationView() {
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
                R.string.drawer_open, R.string.drawer_close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mDrawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {

            }

            @Override
            public void onDrawerOpened(@NonNull View drawerView) {
                GlobalFuntion.hideSoftKeyboard(MainActivity.this);
            }

            @Override
            public void onDrawerClosed(@NonNull View drawerView) {

            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });

        CategoryAdapter categoryAdapter = new CategoryAdapter(this, presenter.getListCategory());
        lvCategory = findViewById(R.id.lvCategory);
        lvCategory.setAdapter(categoryAdapter);
        lvCategory.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                GlobalFuntion.startActivity(MainActivity.this, FoodActivity.class);
            }
        });
    }

    private void initData() {
        // init list featured
        FeaturedPagerAdapter featuredPagerAdapter = new FeaturedPagerAdapter(this, presenter.getListFeatured());
        mViewPage.setAdapter(featuredPagerAdapter);
        mIndicator.setViewPager(mViewPage);
        featuredPagerAdapter.registerDataSetObserver(mIndicator.getDataSetObserver());

        if (presenter.getListFeatured() != null && presenter.getListFeatured().size() > 1) {
        /*After setting the adapter use the timer */
            if (mTimer == null)
                mTimer = new Timer();
            mTimer.schedule(new TimerTask() {
                @Override
                public void run() {
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        @Override
                        public void run() {
                            int item = mViewPage.getCurrentItem();
                            int totalItem = presenter.getListFeatured().size() - 1;
                            if (item < totalItem) {
                                item++;
                                mViewPage.setCurrentItem(item);
                            } else if (item == totalItem) {
                                mViewPage.setCurrentItem(0);
                            }
                        }
                    });

                }
            }, DELAY, PERIOD);
        }

        // init list home
        listHomeAdapter.injectInto(rcvData);
        presenter.getListHomeObject(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            showDialogLogout();
        }
    }

    private void showDialogLogout() {
        MaterialDialog materialDialog = new MaterialDialog.Builder(this)
                .title(getString(R.string.app_name))
                .content(getString(R.string.msg_exit_app))
                .positiveText(getString(R.string.action_ok))
                .onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        finish();
                    }
                })
                .negativeText(getString(R.string.action_cancel))
                .cancelable(false)
                .show();
    }

    @Override
    public void updateListHomeObject(ArrayList<HomeObject> listHomeObject) {
        listHomeAdapter.setData(listHomeObject);
    }

    @Override
    public void onRefresh() {
        swipeRefreshLayout.setRefreshing(false);
    }

    @Optional
    @OnClick({R.id.layout_news})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.layout_news:
                GlobalFuntion.startActivity(this, NewsActivity.class);
                break;
        }
    }
}
