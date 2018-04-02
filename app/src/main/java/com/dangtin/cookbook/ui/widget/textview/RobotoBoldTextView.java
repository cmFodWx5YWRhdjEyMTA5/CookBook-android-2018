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

public class RobotoBoldTextView extends AppCompatTextView {
    public RobotoBoldTextView(Context context) {
        super(context);
        setFont();
    }

    public RobotoBoldTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setFont();
    }

    public RobotoBoldTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setFont();
    }


    private void setFont() {
        Typeface textViewTypeface = Utils.getRobotoBoldTypeFace(getContext());
        setTypeface(textViewTypeface);
    }
}
