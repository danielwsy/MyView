package com.example.danielwang.myview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

/**
 * 按钮点触效果（减少XML文件的创建）
 *
 * @author danielwang
 * @Description:
 * @date 2018/7/20 15:45
 */
public class MyIcon extends AppCompatImageView {

    private Context mContext;
    private Drawable mDefaultDawb;
    private Drawable mPressedDawb;
    private boolean mClickAbled;

    public MyIcon(Context context) {
        this(context, null);
    }

    public MyIcon(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        initAttri(context, attrs);
    }

    private void initAttri(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MyIcon);
        if (typedArray != null) {
            mDefaultDawb = typedArray.getDrawable(R.styleable.MyIcon_my_icon_default);
            mPressedDawb = typedArray.getDrawable(R.styleable.MyIcon_my_icon_pressed);
            mClickAbled = typedArray.getBoolean(R.styleable.MyIcon_my_icon_clickabled, true);
        }

        if (mDefaultDawb != null && mPressedDawb != null) {
            setImageDrawable(DrawableUtil.getStateListBgDrawable(mDefaultDawb, mPressedDawb));
        }
        setClickable(mClickAbled);
    }

}
