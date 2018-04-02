/*
 * ******************************************************************************
 *  Copyright Ⓒ 2018. All rights reserved
 *  Author DangTin. Create on 2018/01/30
 * ******************************************************************************
 */

package com.dangtin.cookbook.utils;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.graphics.drawable.VectorDrawableCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.widget.ImageView;

public class DrawableUtils {

    public static Drawable getTintDrawable(Drawable original, @ColorInt int color) {
        return getTintDrawable(original, color, true);
    }

    public static Drawable getTintDrawable(Drawable original, @ColorInt int color, boolean forceTint) {
        if (forceTint) {
            original.clearColorFilter();
            original.setColorFilter(color, PorterDuff.Mode.SRC_IN);
            original.invalidateSelf();
            return original;
        }
        Drawable wrapDrawable = DrawableCompat.wrap(original).mutate();
        DrawableCompat.setTint(wrapDrawable, color);
        return wrapDrawable;
    }

    /**
     * Update image view color with animation
     */
    public static void updateDrawableColor(final Context context, final Drawable drawable,
                                           final ImageView imageView, @ColorInt int fromColor,
                                           @ColorInt int toColor, final boolean forceTint) {
        ValueAnimator colorAnimation = ValueAnimator.ofObject(new ArgbEvaluator(), fromColor, toColor);
        colorAnimation.setDuration(150);
        colorAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animator) {
                imageView.setImageDrawable(getTintDrawable(drawable,
                        (Integer) animator.getAnimatedValue(), forceTint));
                imageView.requestLayout();
            }
        });
        colorAnimation.start();
    }

    /**
     * Return a tint drawable
     *
     * @param drawableRes
     * @param color
     * @param forceTint
     * @return
     */
    public static Drawable getTintDrawable(Context context, @DrawableRes int drawableRes, @ColorInt int color, boolean forceTint) {
        Drawable drawable = getDrawable(context, drawableRes);
        if (drawable == null) {
            return null;
        }
        if (forceTint) {
            drawable.clearColorFilter();
            drawable.setColorFilter(color, PorterDuff.Mode.SRC_IN);
            drawable.invalidateSelf();
            return drawable;
        }
        Drawable wrapDrawable = DrawableCompat.wrap(drawable).mutate();
        DrawableCompat.setTint(wrapDrawable, color);
        return wrapDrawable;
    }


    public static Drawable getDrawable(Context context, @DrawableRes int drawableRes) {
        if (drawableRes != 0) {
            try {
                return VectorDrawableCompat.create(context.getResources(), drawableRes, null);
            } catch (Resources.NotFoundException e) {
                return ContextCompat.getDrawable(context, drawableRes);
            }
        }
        return null;
    }
}
