package com.happystore.www.ui.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.happystore.www.R;
import com.happystore.www.entity.ImgBanner;
import com.youth.banner.adapter.BannerAdapter;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ImageAdapter extends BannerAdapter<ImgBanner, ImageAdapter.BannerViewHolder> {

    public ImageAdapter(List<ImgBanner> datas) {
        super(datas);
    }

    @Override
    public BannerViewHolder onCreateHolder(ViewGroup parent, int viewType) {
        ImageView imageView = new ImageView(parent.getContext());
        //注意，必须设置为match_parent，这个是viewpager2强制要求的
        imageView.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return new BannerViewHolder(imageView);
    }

    @Override
    public void onBindView(BannerViewHolder holder, ImgBanner data, int position, int size) {
        holder.imageView.setImageResource(R.mipmap.bg_goods2);
    }

    class BannerViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public BannerViewHolder(@NonNull @NotNull ImageView view) {
            super(view);
            this.imageView = view;
        }
    }
}
