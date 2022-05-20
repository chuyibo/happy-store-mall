package com.happystore.www.ui.fra;

import androidx.fragment.app.Fragment;

import com.happystore.www.R;
import com.happystore.www.databinding.FragmentMainHomeBinding;
import com.happystore.www.framework.viewmodel.ViewModelFragment;
import com.happystore.www.service.MainHomeVM;

import java.util.ArrayList;

public class MainHomeFragment extends ViewModelFragment<MainHomeVM, FragmentMainHomeBinding> {
    public String[] tabName = {"推荐","车品","运动","男装","食品","鞋包","百货","女装","水果","美妆","饰品"};

    public static MainHomeFragment newInstance() {
        MainHomeFragment fragment = new MainHomeFragment();
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_main_home;
    }

    @Override
    public void init() {
        initViewPage();
    }

    public void initViewPage() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(MainHomeRecommendFragment.newInstance());

        for (int i = 1; i < tabName.length; i++) {
            fragments.add(MainHomeCategoryFragment.newInstance());
        }

        db.tlTop.setViewPager(db.vp,tabName,getActivity(),fragments);
    }

    @Override
    public void initDataBinding() {
        db.setView(this);
    }
}
