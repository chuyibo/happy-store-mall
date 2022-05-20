package com.happystore.www.ui.fra;

import com.happystore.www.R;
import com.happystore.www.databinding.FragmentMainMsgBinding;
import com.happystore.www.framework.viewmodel.ViewModelFragment;
import com.happystore.www.service.MainMsgVM;

public class MainMsgFragment extends ViewModelFragment<MainMsgVM, FragmentMainMsgBinding> {

    public static MainMsgFragment newInstance() {
        MainMsgFragment fragment = new MainMsgFragment();
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_main_msg;
    }

    @Override
    public void init() {

    }

    @Override
    public void initDataBinding() {

    }
}
