package com.happystore.www.framework.base;

import android.app.Activity;
import android.os.Bundle;
import android.view.WindowManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.gyf.immersionbar.ImmersionBar;
import com.happystore.www.R;
import com.hwangjr.rxbus.RxBus;

public abstract class BaseActivity<DB extends ViewDataBinding> extends AppCompatActivity {

    public Activity context;
    public DB db;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = DataBindingUtil.setContentView(this,getLayoutId());
        getWindow().setSoftInputMode((WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN));
        init();
        initDataBinding();
        initActionBar();
    }

    private void initActionBar() {
        ImmersionBar.with(this).statusBarDarkFont(true)
                .navigationBarDarkIcon(true)
                .navigationBarColor(R.color.white).init();
    }

    private void init() {
        context = this;
        RxBus.get().register(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        RxBus.get().unregister(this);
    }

    public abstract int getLayoutId();
    public abstract void initDataBinding();
}
