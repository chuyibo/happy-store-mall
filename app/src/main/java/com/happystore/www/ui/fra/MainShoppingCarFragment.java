package com.happystore.www.ui.fra;

import com.happystore.www.R;
import com.happystore.www.databinding.FragmentMainShoppingCarBinding;
import com.happystore.www.framework.viewmodel.ViewModelFragment;
import com.happystore.www.service.MainShoppingCarVM;

public class MainShoppingCarFragment extends ViewModelFragment<MainShoppingCarVM, FragmentMainShoppingCarBinding> {

    public static MainShoppingCarFragment newInstance() {
        MainShoppingCarFragment fragment = new MainShoppingCarFragment();
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_main_shopping_car;
    }

    @Override
    public void init() {

    }

    @Override
    public void initDataBinding() {

    }
}
