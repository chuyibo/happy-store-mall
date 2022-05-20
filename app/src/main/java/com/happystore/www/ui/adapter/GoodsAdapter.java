package com.happystore.www.ui.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.happystore.www.R;
import com.happystore.www.entity.Goods;

import org.jetbrains.annotations.NotNull;

public class GoodsAdapter extends BaseQuickAdapter<Goods, BaseViewHolder> {

    public GoodsAdapter() {
        super(R.layout.item_goods);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder holder, Goods item) {

    }
}
