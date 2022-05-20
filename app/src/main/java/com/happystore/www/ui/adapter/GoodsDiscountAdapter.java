package com.happystore.www.ui.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.happystore.www.R;
import com.happystore.www.entity.Goods;

import org.jetbrains.annotations.NotNull;

public class GoodsDiscountAdapter extends BaseQuickAdapter<Goods, BaseViewHolder> {

    public GoodsDiscountAdapter() {
        super(R.layout.item_goods_discount);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder holder, Goods goods) {

    }
}
