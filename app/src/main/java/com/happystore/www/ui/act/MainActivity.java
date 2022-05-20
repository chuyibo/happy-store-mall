package com.happystore.www.ui.act;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import com.flyco.tablayout.listener.CustomTabEntity;
import com.happystore.www.R;
import com.happystore.www.databinding.ActivityMainBinding;
import com.happystore.www.entity.HomeTab;
import com.happystore.www.framework.base.BaseActivity;
import com.happystore.www.ui.fra.MainHomeFragment;
import com.happystore.www.ui.fra.MainMsgFragment;
import com.happystore.www.ui.fra.MainShoppingCarFragment;
import com.happystore.www.ui.fra.MainUserCenterFragment;
import com.happystore.www.utils.ListBuilderUtils;

import java.util.ArrayList;

public class MainActivity extends BaseActivity<ActivityMainBinding> {

    private ArrayList<CustomTabEntity> bottomTabList = new ArrayList<>();

    private String[] bottomTabName   = {"首页", "消息", "购物车", "我的"};
    private int[] bottomIconSelect   = {R.mipmap.ic_home_select, R.mipmap.ic_msg_select, R.mipmap.ic_shopping_car_select, R.mipmap.ic_user_center_select};
    private int[] bottomIconUnSelect = {R.mipmap.ic_home_unselect, R.mipmap.ic_msg_unselect, R.mipmap.ic_shopping_car_unselect, R.mipmap.ic_user_center_unselect};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initBottomNavigation();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initDataBinding() {
        db.setView(this);
    }

    // 初始化底部导航栏
    private void initBottomNavigation() {
        for (int i = 0; i < bottomTabName.length; i++) {
            bottomTabList.add(new HomeTab(bottomTabName[i], bottomIconSelect[i], bottomIconUnSelect[i]));
        }

        ArrayList<Fragment> fragmentList = ListBuilderUtils.build(Fragment.class).add(MainHomeFragment.newInstance())
                .add(MainMsgFragment.newInstance())
                .add(MainShoppingCarFragment.newInstance()).add(MainUserCenterFragment.newInstance()).get();

        db.tlBottom.setTabData(bottomTabList,this,R.id.fl,fragmentList);

        db.tlBottom.showMsg(1,1000);
        db.tlBottom.setMsgMargin(1,-8,0);
        db.tlBottom.showMsg(2,1000);
        db.tlBottom.setMsgMargin(2,-8,0);
    }
}