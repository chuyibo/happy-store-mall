package com.happystore.www.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;

import com.xuexiang.xutil.display.BarUtils;
import com.xuexiang.xutil.display.DensityUtils;

public class StatusBarHeightSeize extends View {


    public StatusBarHeightSeize(Context context) {
        super(context);
    }

    public StatusBarHeightSeize(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public StatusBarHeightSeize(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int height = BarUtils.getStatusBarHeight();
        height = height + DensityUtils.dip2px(4);

        setMeasuredDimension(MeasureSpec.getSize(widthMeasureSpec),height);
    }
}
