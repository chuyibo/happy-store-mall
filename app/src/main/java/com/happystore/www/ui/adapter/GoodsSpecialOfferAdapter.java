package com.happystore.www.ui.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.happystore.www.R;
import com.happystore.www.entity.Goods;

import org.jetbrains.annotations.NotNull;

public class GoodsSpecialOfferAdapter extends BaseQuickAdapter<Goods, BaseViewHolder> {

    public GoodsSpecialOfferAdapter() {
        super(R.layout.item_goods_special_offer);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder holder, Goods item) {

    }
}
