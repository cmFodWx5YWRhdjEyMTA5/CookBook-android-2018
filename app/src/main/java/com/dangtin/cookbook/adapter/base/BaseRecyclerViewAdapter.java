/*
 * ******************************************************************************
 *  Copyright Ⓒ 2017. All rights reserved
 *  Author DangTin. Create on 2018/04/01
 * ******************************************************************************
 */

package com.dangtin.cookbook.adapter.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.ButterKnife;

public abstract class BaseRecyclerViewAdapter  {


    public static abstract class BaseViewHolder<DATA> extends RecyclerView.ViewHolder {

        public BaseViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public abstract void bindData(Context context, DATA data, int position);
    }
}
