package com.happystore.www.ui.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.happystore.www.R;
import com.happystore.www.entity.SpecImageValue;

import org.jetbrains.annotations.NotNull;

public class SpecValueImageAdapter extends BaseQuickAdapter<SpecImageValue, BaseViewHolder> {

    public SpecValueImageAdapter() {
        super(R.layout.item_image_spec_value);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder holder, SpecImageValue item) {

    }
}
