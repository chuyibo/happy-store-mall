package com.happystore.www.ui.fra;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.fondesa.recyclerviewdivider.DividerBuilder;
import com.happystore.www.R;
import com.happystore.www.databinding.FragmentMainHomeRecommendBinding;
import com.happystore.www.entity.Goods;
import com.happystore.www.framework.viewmodel.ViewModelFragment;
import com.happystore.www.service.MainHomeRecommendVM;
import com.happystore.www.ui.act.GoodsDetailsActivity;
import com.happystore.www.ui.adapter.GoodsAdapter;
import com.happystore.www.ui.adapter.GoodsSpecialOfferAdapter;
import com.happystore.www.ui.adapter.GoodsDiscountAdapter;
import com.xuexiang.xutil.display.DensityUtils;

import org.jetbrains.annotations.NotNull;

public class MainHomeRecommendFragment extends ViewModelFragment<MainHomeRecommendVM, FragmentMainHomeRecommendBinding> {

    public static MainHomeRecommendFragment newInstance() {
        MainHomeRecommendFragment fragment = new MainHomeRecommendFragment();
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_main_home_recommend;
    }

    @Override
    public void init() {
        initGoodsSpecialOffer();
        initGoodsDiscount();
        initGoods();
    }

    // 特价商品
    public void initGoodsSpecialOffer() {
        GoodsSpecialOfferAdapter specialOfferAdapter = new GoodsSpecialOfferAdapter();
        db.rvGoodsSpecialOffer.setLayoutManager(new GridLayoutManager(context,4));
        db.rvGoodsSpecialOffer.setAdapter(specialOfferAdapter);

        new DividerBuilder(context)
                .size(DensityUtils.dip2px(8))
                .color(getResources().getColor(R.color.transparent_00000000)).showSideDividers()
                .build().addTo(db.rvGoodsSpecialOffer);

        for (int i = 0; i < 4; i++) {
            specialOfferAdapter.addData(new Goods());
        }
        specialOfferAdapter.notifyDataSetChanged();
    }

    // 打折商品
    public void initGoodsDiscount() {
        GoodsDiscountAdapter discountAdapter = new GoodsDiscountAdapter();
        db.rvGoodsDiscount.setLayoutManager(new GridLayoutManager(context,4));
        db.rvGoodsDiscount.setAdapter(discountAdapter);

        new DividerBuilder(context)
                .size(DensityUtils.dip2px(8))
                .color(getResources().getColor(R.color.transparent_00000000)).showSideDividers()
                .build().addTo(db.rvGoodsDiscount);

        for (int i = 0; i < 4; i++) {
            discountAdapter.addData(new Goods());
        }
        discountAdapter.notifyDataSetChanged();
    }

    // 推荐商品
    public void initGoods() {
        GoodsAdapter goodsAdapter = new GoodsAdapter();
        db.rvGoods.setLayoutManager(new GridLayoutManager(context,2));
        db.rvGoods.setAdapter(goodsAdapter);

        goodsAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(@NonNull @NotNull BaseQuickAdapter<?, ?> adapter, @NonNull @NotNull View view, int position) {
                GoodsDetailsActivity.start(context);
            }
        });

        new DividerBuilder(context)
                .size(DensityUtils.dip2px(8))
                .color(getResources().getColor(R.color.transparent_00000000)).showSideDividers()
                .showFirstDivider().showLastDivider()
                .build().addTo(db.rvGoods);

        for (int i = 0; i < 50; i++) {
            goodsAdapter.addData(new Goods());
        }
        goodsAdapter.notifyDataSetChanged();
    }

    @Override
    public void initDataBinding() {
        db.setView(this);
    }
}