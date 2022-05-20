package com.happystore.www.ui.act;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.GridLayoutManager;

import com.fondesa.recyclerviewdivider.DividerBuilder;
import com.happystore.www.R;
import com.happystore.www.databinding.ActivityCategoryGoodsBinding;
import com.happystore.www.entity.Goods;
import com.happystore.www.framework.viewmodel.ViewModelActivity;
import com.happystore.www.service.CategoryGoodsVM;
import com.happystore.www.ui.adapter.GoodsAdapter;
import com.happystore.www.ui.widget.GlobalTitleBar;
import com.xuexiang.xutil.display.DensityUtils;

public class CategoryGoodsActivity extends ViewModelActivity<CategoryGoodsVM, ActivityCategoryGoodsBinding> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initGoods();
        initTitle();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_category_goods;
    }

    @Override
    public void initDataBinding() {
        db.setView(this);
    }

    public static void start(Context context) {
        Intent intent = new Intent(context,CategoryGoodsActivity.class);
        context.startActivity(intent);
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

    private void initTitle() {
        db.title.setChildViewClickListener(new GlobalTitleBar.ChildViewClickListener() {
            @Override
            public void childViewClick(View view) {
                finish();
            }
        });
    }
}