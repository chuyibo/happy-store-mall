package com.happystore.www.ui.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.happystore.www.R;
import com.happystore.www.entity.Address;

import org.jetbrains.annotations.NotNull;

public class SelectAddressAdapter extends BaseQuickAdapter<Address, BaseViewHolder> {

    public SelectAddressAdapter() {
        super(R.layout.item_select_address);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder holder, Address item) {
        if(item.isSelect()) {
            holder.setTextColorRes(R.id.tv_address,R.color.red_d81e06);
            holder.setTextColorRes(R.id.tv_name,R.color.red_d81e06);
            holder.setTextColorRes(R.id.tv_phone,R.color.red_d81e06);
            holder.setImageResource(R.id.iv_address,R.mipmap.ic_address_red);
        } else {
            holder.setTextColorRes(R.id.tv_address,R.color.gray_999999);
            holder.setTextColorRes(R.id.tv_name,R.color.gray_999999);
            holder.setTextColorRes(R.id.tv_phone,R.color.gray_999999);
            holder.setImageResource(R.id.iv_address,R.mipmap.ic_address_gray);
        }
    }
}
