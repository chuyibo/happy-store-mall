package com.happystore.www.ui.fra;

import com.happystore.www.R;
import com.happystore.www.databinding.FragmentMainUserCenterBinding;
import com.happystore.www.framework.viewmodel.ViewModelFragment;
import com.happystore.www.service.MainUserCenterVM;

public class MainUserCenterFragment extends ViewModelFragment<MainUserCenterVM, FragmentMainUserCenterBinding> {

    public static MainUserCenterFragment newInstance() {
        MainUserCenterFragment fragment = new MainUserCenterFragment();
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_main_user_center;
    }

    @Override
    public void init() {

    }

    @Override
    public void initDataBinding() {

    }
}
