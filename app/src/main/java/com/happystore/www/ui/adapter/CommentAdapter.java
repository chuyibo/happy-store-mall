package com.happystore.www.ui.adapter;

import android.graphics.Color;
import android.view.View;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.fondesa.recyclerviewdivider.DividerBuilder;
import com.happystore.www.R;
import com.happystore.www.entity.Comment;
import com.xuexiang.xutil.display.DensityUtils;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class CommentAdapter extends BaseQuickAdapter<Comment, CommentAdapter.MyViewHolder> {

    public CommentAdapter() {
        super(R.layout.item_comment);
    }

    @Override
    protected void convert(@NotNull MyViewHolder holder, Comment item) {
        List<String> imageUrl = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            imageUrl.add("");
        }

        holder.commentImageAdapter.setNewInstance(imageUrl);
    }

    public class MyViewHolder extends BaseViewHolder {

        public RecyclerView rvImage;
        public CommentImageAdapter commentImageAdapter;

        public MyViewHolder(@NotNull View view) {
            super(view);
            rvImage = view.findViewById(R.id.rv_image);
            commentImageAdapter = new CommentImageAdapter();
            rvImage.setLayoutManager(new GridLayoutManager(getContext(),3));
            rvImage.setAdapter(commentImageAdapter);

            new DividerBuilder(getContext())
                    .color(Color.parseColor("#00000000"))
                    .size(DensityUtils.dip2px(6))
                    .build().addTo(rvImage);
        }
    }
}
