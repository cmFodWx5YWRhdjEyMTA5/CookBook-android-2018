/*
 * ******************************************************************************
 *  Copyright Ⓒ 2017. All rights reserved
 *  Author DangTin. Create on 2011/11/22
 * ******************************************************************************
 */

package com.dangtin.cookbook.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dangtin.cookbook.R;
import com.dangtin.cookbook.adapter.base.BaseRecyclerViewAdapter;
import com.dangtin.cookbook.adapter.base.Releasable;
import com.dangtin.cookbook.adapter.food.FoodGridViewAdapter;
import com.dangtin.cookbook.adapter.food.FoodHorizontalAdapter;
import com.dangtin.cookbook.adapter.menu.MenuVerticalAdapter;
import com.dangtin.cookbook.constant.GlobalFuntion;
import com.dangtin.cookbook.data.models.HomeObject;
import com.dangtin.cookbook.injection.ActivityContext;
import com.dangtin.cookbook.ui.food.FoodActivity;
import com.dangtin.cookbook.ui.menu.MenuActivity;
import com.dangtin.cookbook.utils.ListDecorator;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.NativeExpressAdView;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;

public class ListHomeAdapter extends RecyclerView.Adapter<BaseRecyclerViewAdapter.BaseViewHolder>
        implements Releasable {

    private Context context;
    private ArrayList<HomeObject> listHomeObject;

    @Inject
    public ListHomeAdapter(@ActivityContext Context context) {
        this.context = context;
    }

    @Override
    public BaseRecyclerViewAdapter.BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        BaseRecyclerViewAdapter.BaseViewHolder viewHolder = null;
        switch (viewType) {
            case HomeObject.TYPE_MENU_LATEST:
                viewHolder = MenuLatestViewHolder.create(parent);
                break;

            case HomeObject.TYPE_FOOD_LATEST:
                viewHolder = FoodLatestViewHolder.create(parent);
                break;

            case HomeObject.TYPE_CATEGORY:
                viewHolder = FoodOfCategoryViewHolder.create(parent);
                break;

            case HomeObject.TYPE_ADMOB:
                viewHolder = AdmobViewHolder.create(parent);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(BaseRecyclerViewAdapter.BaseViewHolder holder, int position) {
        holder.bindData(context, listHomeObject.get(position), position);
    }

    @Override
    public int getItemCount() {
        return null == listHomeObject ? 0 : listHomeObject.size();
    }

    @Override
    public int getItemViewType(int position) {
        return listHomeObject.get(position).getType();
    }

    public void setData(ArrayList<HomeObject> list) {
        this.listHomeObject = list;
        notifyDataSetChanged();
    }

    public void injectInto(RecyclerView recyclerView) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setFocusable(false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(this);
        recyclerView.addItemDecoration(new ListDecorator());
    }

    @Override
    public void release() {
        context = null;
    }

    public static class MenuLatestViewHolder extends BaseRecyclerViewAdapter.BaseViewHolder<HomeObject> {

        @BindView(R.id.tvTitle)
        TextView tvTitle;

        @BindView(R.id.tvSeeAll)
        TextView tvSeeAll;

        @BindView(R.id.rcvData)
        RecyclerView rcvData;

        private MenuVerticalAdapter menuVerticalAdapter;

        public MenuLatestViewHolder(View itemView) {
            super(itemView);
        }

        public static MenuLatestViewHolder create(ViewGroup parent) {
            return new MenuLatestViewHolder(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_list_menu_latest, parent, false));
        }

        @Override
        public void bindData(Context context, HomeObject homeObject, int position) {
            tvTitle.setText(homeObject.getTitle());

            menuVerticalAdapter = new MenuVerticalAdapter(context);
            menuVerticalAdapter.injectInto(rcvData);
            menuVerticalAdapter.setListData(homeObject.getListMenu());

            tvSeeAll.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    GlobalFuntion.startActivity(context, MenuActivity.class);
                }
            });
        }
    }

    public static class FoodLatestViewHolder extends BaseRecyclerViewAdapter.BaseViewHolder<HomeObject> {

        @BindView(R.id.tvTitle)
        TextView tvTitle;

        @BindView(R.id.tvSeeAll)
        TextView tvSeeAll;

        @BindView(R.id.rcvData)
        RecyclerView rcvData;

        private FoodGridViewAdapter foodGridViewAdapter;

        public FoodLatestViewHolder(View itemView) {
            super(itemView);
        }

        public static FoodLatestViewHolder create(ViewGroup parent) {
            return new FoodLatestViewHolder(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_list_food_latest, parent, false));
        }

        @Override
        public void bindData(Context context, HomeObject homeObject, int position) {
            tvTitle.setText(homeObject.getTitle());

            foodGridViewAdapter = new FoodGridViewAdapter(context);
            foodGridViewAdapter.injectInto(rcvData);
            foodGridViewAdapter.setListData(homeObject.getListFood());

            tvSeeAll.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    GlobalFuntion.startActivity(context, FoodActivity.class);
                }
            });
        }
    }

    public static class FoodOfCategoryViewHolder extends BaseRecyclerViewAdapter.BaseViewHolder<HomeObject> {

        @BindView(R.id.tvTitle)
        TextView tvTitle;

        @BindView(R.id.tvSeeAll)
        TextView tvSeeAll;

        @BindView(R.id.rcvData)
        RecyclerView rcvData;

        private FoodHorizontalAdapter foodHorizontalAdapter;

        public FoodOfCategoryViewHolder(View itemView) {
            super(itemView);
        }

        public static FoodOfCategoryViewHolder create(ViewGroup parent) {
            return new FoodOfCategoryViewHolder(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_list_food_of_category, parent, false));
        }

        @Override
        public void bindData(Context context, HomeObject homeObject, int position) {
            tvTitle.setText(homeObject.getTitle());

            foodHorizontalAdapter = new FoodHorizontalAdapter(context);
            foodHorizontalAdapter.injectInto(rcvData);
            foodHorizontalAdapter.setListData(homeObject.getListFood());

            tvSeeAll.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    GlobalFuntion.startActivity(context, FoodActivity.class);
                }
            });
        }
    }

    public static class AdmobViewHolder extends BaseRecyclerViewAdapter.BaseViewHolder<HomeObject> {

        @BindView(R.id.adView)
        NativeExpressAdView mAdView;

        public AdmobViewHolder(View itemView) {
            super(itemView);
        }

        public static AdmobViewHolder create(ViewGroup parent) {
            return new AdmobViewHolder(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_admob_native_ads, parent, false));
        }

        @Override
        public void bindData(Context context, HomeObject homeObject, int position) {
            mAdView.loadAd(new AdRequest.Builder().addTestDevice("9627BCEB017A685585C8DA95CB56DACF").build());
        }
    }
}
