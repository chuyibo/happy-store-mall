package com.happystore.www.ui.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.happystore.www.R;
import com.happystore.www.entity.SpecValue;

import org.jetbrains.annotations.NotNull;

public class SpecValueAdapter extends BaseQuickAdapter<SpecValue, BaseViewHolder> {

    public SpecValueAdapter() {
        super(R.layout.item_spec_value);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder holder, SpecValue item) {

    }
}
