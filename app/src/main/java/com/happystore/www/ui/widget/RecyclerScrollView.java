package com.happystore.www.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.ScrollView;

public class RecyclerScrollView extends ScrollView {

    private int slop;
    private int touch;

    public RecyclerScrollView(Context context) {
        super(context);
        setSlop(context);
    }

    public RecyclerScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setSlop(context);
    }

    public RecyclerScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setSlop(context);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                touch = (int) ev.getRawY();
                break;
            case MotionEvent.ACTION_MOVE:
                if (Math.abs((int) ev.getRawY() - touch) > slop) return true;
                break;
        }

        return super.onInterceptTouchEvent(ev);
    }

    private void setSlop(Context context) {
        slop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

}
