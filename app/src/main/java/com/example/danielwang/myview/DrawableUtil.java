package com.example.danielwang.myview;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;

/**
 * @author danielwang
 * @Description:
 * @date 2018/7/20 16:10
 */
public class DrawableUtil {

    public static StateListDrawable getStateListBgDrawable( Drawable dDefault, Drawable dPressed) {
        StateListDrawable drawable = new StateListDrawable();
        drawable.addState(new int[] { android.R.attr.state_selected }, dPressed);
        drawable.addState(new int[] { android.R.attr.state_pressed }, dPressed);
        drawable.addState(new int[] { android.R.attr.state_enabled }, dDefault);
        drawable.addState(new int[] {}, dDefault);
        return drawable;
    }

    public static ColorStateList createColorStateList(String selected, String pressed, String normal) {
        int[] colors = new int[] { Color.parseColor(selected), Color.parseColor(pressed), Color.parseColor(normal) };
        int[][] states = new int[3][];
        states[0] = new int[] { android.R.attr.state_selected};
        states[1] = new int[] { android.R.attr.state_pressed};
        states[2] = new int[] {};
        ColorStateList colorList = new ColorStateList(states, colors);
        return colorList;
    }
}
