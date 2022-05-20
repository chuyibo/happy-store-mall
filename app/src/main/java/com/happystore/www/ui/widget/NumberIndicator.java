package com.happystore.www.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;

import com.xuexiang.xutil.display.DensityUtils;
import com.youth.banner.indicator.BaseIndicator;

public class NumberIndicator extends BaseIndicator {
    private int width;
    private int height;
    private int radius;

    public NumberIndicator(Context context) {
        this(context, null);
    }

    public NumberIndicator(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public NumberIndicator(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint.setTextSize(DensityUtils.dip2px(12));
        mPaint.setTextAlign(Paint.Align.CENTER);
        width = (int) DensityUtils.dip2px(45);
        height = (int) DensityUtils.dip2px(20);
        radius = (int) DensityUtils.dip2px(50);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int count = config.getIndicatorSize();
        if (count <= 1) {
            return;
        }
        setMeasuredDimension(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int count = config.getIndicatorSize();
        if (count <= 1) {
            return;
        }

        RectF rectF = new RectF(0, 0, width, height);
        mPaint.setColor(Color.parseColor("#70000000"));
        canvas.drawRoundRect(rectF, radius, radius, mPaint);

        String text = config.getCurrentPosition() + 1 + "/" + count;
        mPaint.setColor(Color.WHITE);
        canvas.drawText(text, width / 2, (float) (height * 0.7), mPaint);

    }

}
