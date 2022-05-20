package com.happystore.www.ui.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.happystore.www.R;
import com.happystore.www.entity.Category;

import org.jetbrains.annotations.NotNull;

public class CategoryAdapter extends BaseQuickAdapter<Category, BaseViewHolder> {

    public CategoryAdapter() {
        super(R.layout.item_category);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder holder, Category item) {

    }
}
