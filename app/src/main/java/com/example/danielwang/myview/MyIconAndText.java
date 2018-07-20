package com.example.danielwang.myview;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * 图片和文字（点击只设置了图片的）
 * @author danielwang
 * @Description:
 * @date 2018/7/20 16:19
 */
public class MyIconAndText extends LinearLayout {

    private Context mContext;
    private Drawable mDefaultDawb;
    private Drawable mPressedDawb;
    private String mText;
    private ImageView mImageView;
    private TextView mTextView;
    private int mDefaultColor = getResources().getColor(R.color.colorAccent);
    private int mPressedColor = getResources().getColor(R.color.colorAccent);


    public MyIconAndText(Context context) {
        this(context, null);
    }

    public MyIconAndText(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        initAttri(context, attrs);
    }

    private void initAttri(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MyIconAndText);
        if (typedArray != null) {
            mDefaultDawb = typedArray.getDrawable(R.styleable.MyIconAndText_icon_default);
            mPressedDawb = typedArray.getDrawable(R.styleable.MyIconAndText_icon_pressed);
            mText = typedArray.getString(R.styleable.MyIconAndText_icon_text);
            mDefaultColor = typedArray.getColor(R.styleable.MyIconAndText_icon_text_defalult_color, getResources().getColor(R.color.colorAccent));
            mPressedColor = typedArray.getColor(R.styleable.MyIconAndText_icon_text_pressed_color, getResources().getColor(R.color.colorAccent));
        }
        initViews(context);
    }

    private void initViews(Context context) {
        setOrientation(LinearLayout.VERTICAL);
        setGravity(Gravity.CENTER);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        setLayoutParams(params);
        View view = LayoutInflater.from(context).inflate(R.layout.icon_text, this);
        mImageView = view.findViewById(R.id.iv_icon);
        mTextView = view.findViewById(R.id.tv_text);

        if (mImageView != null && mDefaultDawb != null && mPressedDawb != null) {
            mImageView.setImageDrawable(DrawableUtil.getStateListBgDrawable(mDefaultDawb, mPressedDawb));
        }

        if (mTextView != null && !TextUtils.isEmpty(mText)) {
            mTextView.setText(mText);
            mTextView.setTextColor(mDefaultColor);
        }

        mImageView.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int iAction = event.getAction();
                if (iAction == MotionEvent.ACTION_DOWN) {    // 按下
                    mTextView.setTextColor(mPressedColor);
                } else if (iAction == MotionEvent.ACTION_UP) {    // 弹起
                    mTextView.setTextColor(mDefaultColor);
                }
                return false;
            }
        });
    }
}
