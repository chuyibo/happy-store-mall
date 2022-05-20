package com.happystore.www.ui.act;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.fondesa.recyclerviewdivider.DividerBuilder;
import com.happystore.www.R;
import com.happystore.www.databinding.ActivityGoodsDetailsBinding;
import com.happystore.www.entity.Comment;
import com.happystore.www.entity.ImgBanner;
import com.happystore.www.framework.viewmodel.ViewModelActivity;
import com.happystore.www.service.GoodsDetailsVM;
import com.happystore.www.ui.adapter.CommentAdapter;
import com.happystore.www.ui.adapter.GoodsDetailsImageAdapter;
import com.happystore.www.ui.adapter.ImageAdapter;
import com.happystore.www.ui.pop.SelectAddressPop;
import com.happystore.www.ui.pop.SelectSpecPop;
import com.happystore.www.ui.widget.NumberIndicator;
import com.happystore.www.utils.PriceUtils;
import com.noober.background.drawable.DrawableCreator;
import com.xuexiang.xutil.display.DensityUtils;

import java.util.ArrayList;
import java.util.List;

public class GoodsDetailsActivity extends ViewModelActivity<GoodsDetailsVM, ActivityGoodsDetailsBinding> {

    private SelectAddressPop selectAddressPop;
    private SelectSpecPop selectSpecPop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initBanner();
        initComment();
        initDetails();
        initPop();

        PriceUtils.formatShoppingPrice(3.38,db.tvShoppingPrice);
        PriceUtils.formatMarketPrice(10.38,db.tvMarketPrice);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            initScrollListener();
        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_goods_details;
    }

    public void initBanner() {
        List<ImgBanner> imgBannerList = new ArrayList<>();
        ImageAdapter imageAdapter = new ImageAdapter(imgBannerList);
        db.banner.setAdapter(imageAdapter);
        db.banner.setIndicator(new NumberIndicator(context));

        for (int i = 0; i < 10; i++) {
            imgBannerList.add(new ImgBanner());
        }
        imageAdapter.notifyDataSetChanged();
    }

    public void initComment() {
        CommentAdapter commentAdapter = new CommentAdapter();
        db.rvComment.setLayoutManager(new LinearLayoutManager(context));
        db.rvComment.setAdapter(commentAdapter);

        for (int i = 0; i < 2; i++) {
            commentAdapter.addData(new Comment());
        }
        commentAdapter.notifyDataSetChanged();

        new DividerBuilder(context)
                .size(DensityUtils.dip2px((float) 0.2))
                .showFirstDivider().showLastDivider()
                .insets(DensityUtils.dip2px(12),DensityUtils.dip2px(12))
                .color(Color.parseColor("#f0f0f0"))
                .build().addTo(db.rvComment);
    }

    public void initDetails() {
        GoodsDetailsImageAdapter detailsImageAdapter = new GoodsDetailsImageAdapter();
        db.rvDetails.setLayoutManager(new LinearLayoutManager(context));
        db.rvDetails.setAdapter(detailsImageAdapter);

        for (int i = 0; i < 10; i++) {
            detailsImageAdapter.getData().add("");
        }
        detailsImageAdapter.notifyDataSetChanged();
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void initScrollListener() {
        db.sv.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                changeTitleStatus(scrollY);
            }
        });
    }

    public void initPop() {
        selectAddressPop = new SelectAddressPop(context);
        selectSpecPop = new SelectSpecPop(context);
    }

    public void changeTitleStatus(int scroll) {
        if(scroll > 50) {
            db.llTitle.setBackgroundResource(R.color.white_ffffff);
            db.tvTitle.setVisibility(View.VISIBLE);

            Drawable drawable = new DrawableCreator.Builder().setCornersRadius(DensityUtils.dip2px(100))
                    .setSolidColor(getResources().getColor(R.color.white_ffffff))
                    .build();
            db.rlBack.setBackground(drawable);
            db.ivBackBlack.setVisibility(View.VISIBLE);
            db.ivBackWhite.setVisibility(View.GONE);
        } else {
            db.llTitle.setBackgroundResource(R.color.transparent_00000000);
            db.tvTitle.setVisibility(View.GONE);

            Drawable drawableBlack = new DrawableCreator.Builder().setCornersRadius(DensityUtils.dip2px(100))
                    .setSolidColor(getResources().getColor(R.color.black_99000000))
                    .build();
            db.rlBack.setBackground(drawableBlack);
            db.ivBackBlack.setVisibility(View.GONE);
            db.ivBackWhite.setVisibility(View.VISIBLE);
        }
    }

    public void selectAddress(View view) {
        selectAddressPop.showPopupWindow();
    }

    public void selectSpec(View view) {
        selectSpecPop.showPopupWindow();
    }

    @Override
    public void initDataBinding() {
        db.setView(this);
    }

    public static void start(Context context) {
        Intent intent = new Intent(context,GoodsDetailsActivity.class);
        context.startActivity(intent);
    }
}