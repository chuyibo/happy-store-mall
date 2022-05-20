package com.happystore.www.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.databinding.DataBindingUtil;

import com.happystore.www.R;
import com.happystore.www.databinding.WidgetGlobalTitleBarBinding;

public class GlobalTitleBar extends RelativeLayout {
    WidgetGlobalTitleBarBinding db;
    private ChildViewClickListener childViewClickListener;

    public GlobalTitleBar(Context context) {
        this(context, null);
    }

    public GlobalTitleBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public GlobalTitleBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View view = LayoutInflater.from(context).inflate(R.layout.widget_global_title_bar,null);
        db = DataBindingUtil.bind(view);
        db.setView(this);
        addView(view);
    }

    public void clickBack(View view) {
        if(childViewClickListener != null)childViewClickListener.childViewClick(view);
    }

    public void setTitle(String name) {
        db.tvTitle.setText(name);
    }

    public void setChildViewClickListener(ChildViewClickListener childViewClickListener) {
        this.childViewClickListener = childViewClickListener;
    }

    public interface ChildViewClickListener {
        void childViewClick(View view);
    }

}
