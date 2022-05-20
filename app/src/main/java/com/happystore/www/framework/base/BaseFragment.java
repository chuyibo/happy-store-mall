package com.happystore.www.framework.base;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;

import com.gyf.immersionbar.ImmersionBar;
import com.happystore.www.R;
import com.hwangjr.rxbus.RxBus;

public abstract class BaseFragment<DB extends ViewDataBinding> extends Fragment {

    public DB       db;

    public View     view;
    public Activity context;
    public int      isInit = 0;// 0 未初始化 1 初始化

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context  = getActivity();
        RxBus.get().register(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        if(view == null) {
            db   = DataBindingUtil.inflate(inflater,getLayoutId(),container,false);
            view = db.getRoot();
            isInit = 1;
            initDataBinding();
            init();
            initActionBar();
        } else {
            ViewGroup parent = (ViewGroup) view.getParent();
            if(null != parent) parent.removeView(view);
            isInit = 0;
        }
        return view;
    }

    private void initActionBar() {
        ImmersionBar.with(this).statusBarDarkFont(true)
                .navigationBarDarkIcon(true)
                .navigationBarColor(R.color.white).init();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        RxBus.get().unregister(this);
    }

    public abstract int getLayoutId();

    public abstract void init();
    public abstract void initDataBinding();
}
