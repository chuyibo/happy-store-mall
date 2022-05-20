package com.happystore.www.ui.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.happystore.www.R;

import org.jetbrains.annotations.NotNull;

public class CommentImageAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    public CommentImageAdapter() {
        super(R.layout.item_comment_image);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder holder, String item) {

    }
}
