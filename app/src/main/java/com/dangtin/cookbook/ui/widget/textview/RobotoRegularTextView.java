/*
 * ******************************************************************************
 *  Copyright Ⓒ 2018. All rights reserved
 *  Author DangTin. Create on 2018/01/30
 * ******************************************************************************
 */

package com.dangtin.cookbook.ui.widget.textview;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

import com.dangtin.cookbook.utils.Utils;

public class RobotoRegularTextView extends AppCompatTextView {
    public RobotoRegularTextView(Context context) {
        super(context);
        setFont();
    }

    public RobotoRegularTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setFont();
    }

    public RobotoRegularTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setFont();
    }


    private void setFont() {
        Typeface textViewTypeface = Utils.getRobotoRegularTypeFace(getContext());
        setTypeface(textViewTypeface);
    }
}
