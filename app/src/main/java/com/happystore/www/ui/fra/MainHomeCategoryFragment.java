package com.happystore.www.ui.fra;

import android.graphics.drawable.Drawable;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.fondesa.recyclerviewdivider.Divider;
import com.fondesa.recyclerviewdivider.DividerBuilder;
import com.fondesa.recyclerviewdivider.Grid;
import com.fondesa.recyclerviewdivider.Side;
import com.fondesa.recyclerviewdivider.offset.DividerOffsetProvider;
import com.fondesa.recyclerviewdivider.size.SizeProvider;
import com.happystore.www.R;
import com.happystore.www.databinding.FragmentMainHomeCategoryBinding;
import com.happystore.www.entity.Category;
import com.happystore.www.entity.Goods;
import com.happystore.www.framework.viewmodel.ViewModelFragment;
import com.happystore.www.service.MainHomeCategoryVM;
import com.happystore.www.ui.act.CategoryGoodsActivity;
import com.happystore.www.ui.adapter.CategoryAdapter;
import com.happystore.www.ui.adapter.GoodsAdapter;
import com.xuexiang.xutil.display.DensityUtils;

import org.jetbrains.annotations.NotNull;

public class MainHomeCategoryFragment extends ViewModelFragment<MainHomeCategoryVM, FragmentMainHomeCategoryBinding> {

    public static MainHomeCategoryFragment newInstance() {
        MainHomeCategoryFragment fragment = new MainHomeCategoryFragment();
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_main_home_category;
    }

    @Override
    public void init() {
        initGoodsCategory();
        initGoods();
    }

    public void initGoodsCategory() {
        CategoryAdapter categoryAdapter = new CategoryAdapter();
        db.rvCategory.setAdapter(categoryAdapter);
        db.rvCategory.setLayoutManager(new GridLayoutManager(context,5));

        categoryAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(@NonNull @NotNull BaseQuickAdapter<?, ?> adapter, @NonNull @NotNull View view, int position) {
                CategoryGoodsActivity.start(context);
            }
        });

        new DividerBuilder(context)
                .color(getResources().getColor(R.color.transparent_00000000)).showSideDividers()
                .sizeProvider(new SizeProvider() {
                    @Override
                    public int getDividerSize(@NotNull Grid grid, @NotNull Divider divider, @NotNull Drawable drawable) {
                        if(divider.getOrientation().isVertical()) {
                            return DensityUtils.dip2px(16);
                        }
                        return DensityUtils.dip2px(8);
                    }
                }).showFirstDivider().showLastDivider()
                .build().addTo(db.rvCategory);

        for (int i = 0; i < 10; i++) {
            categoryAdapter.addData(new Category());
        }
        categoryAdapter.notifyDataSetChanged();
    }

    public void initGoods() {
        GoodsAdapter goodsAdapter = new GoodsAdapter();
        db.rvGoods.setLayoutManager(new GridLayoutManager(context,2));
        db.rvGoods.setAdapter(goodsAdapter);

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