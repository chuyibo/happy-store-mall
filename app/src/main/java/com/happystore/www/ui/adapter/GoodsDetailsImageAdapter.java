package com.happystore.www.ui.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.happystore.www.R;

import org.jetbrains.annotations.NotNull;

public class GoodsDetailsImageAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    public GoodsDetailsImageAdapter() {
        super(R.layout.item_goods_details_image);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder holder, String item) {

    }
}
