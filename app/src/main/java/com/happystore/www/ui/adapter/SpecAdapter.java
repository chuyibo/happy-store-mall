package com.happystore.www.ui.adapter;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.happystore.www.R;
import com.happystore.www.entity.Spec;

import org.jetbrains.annotations.NotNull;

public class SpecAdapter extends BaseQuickAdapter<Spec, SpecAdapter.MyViewHolder> {

    public SpecAdapter() {
        super(R.layout.item_spec);
    }

    @Override
    protected void convert(@NotNull MyViewHolder holder, Spec item) {

    }


    public class MyViewHolder extends BaseViewHolder {
        public RecyclerView rvSpecValue;
        public SpecValueAdapter specValueAdapter;

        public MyViewHolder(@NotNull View view) {
            super(view);
            rvSpecValue = view.findViewById(R.id.rv_spec_value);
            specValueAdapter = new SpecValueAdapter();

//            FlexboxLayoutManager manager = new FlexboxLayoutManager(this, FlexDirection.ROW, FlexWrap.WRAP){
//
//                @Override
//                public boolean canScrollVertically() {
//
//                    return false;
//
//                }
//            };

            rvSpecValue.setAdapter(specValueAdapter);
        }
    }
}
