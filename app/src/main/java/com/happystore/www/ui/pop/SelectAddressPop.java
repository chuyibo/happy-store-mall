package com.happystore.www.ui.pop;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.fondesa.recyclerviewdivider.DividerBuilder;
import com.happystore.www.R;
import com.happystore.www.databinding.PopSelectAddressBinding;
import com.happystore.www.entity.Address;
import com.happystore.www.ui.adapter.SelectAddressAdapter;
import com.xuexiang.xutil.display.DensityUtils;

import razerdp.basepopup.BasePopupWindow;
import razerdp.util.animation.AnimationHelper;
import razerdp.util.animation.TranslationConfig;

public class SelectAddressPop extends BasePopupWindow {

    private final PopSelectAddressBinding db;

    public SelectAddressPop(Context context) {
        super(context);
        setContentView(R.layout.pop_select_address);
        db = DataBindingUtil.bind(getContentView());
        setBackgroundColor(getContext().getResources().getColor(R.color.transparent_00000000));

        initRecyclerView();
        setPopupGravity(Gravity.BOTTOM);
    }

    public void initRecyclerView() {
        SelectAddressAdapter selectAddressAdapter = new SelectAddressAdapter();
        db.rlSelectAdd.setLayoutManager(new LinearLayoutManager(getContext()));
        db.rlSelectAdd.setAdapter(selectAddressAdapter);

        new DividerBuilder(getContext())
                .size(DensityUtils.dip2px(24))
                .color(getContext().getResources().getColor(R.color.transparent_00000000))
                .showLastDivider()
                .build().addTo(db.rlSelectAdd);

        Address address = new Address();
        address.setSelect(true);
        selectAddressAdapter.addData(address);
        for (int i = 0; i < 10; i++) {
            selectAddressAdapter.addData(new Address());
        }
        selectAddressAdapter.notifyDataSetChanged();
    }

    @Override
    protected Animation onCreateDismissAnimation(int width, int height) {
        TranslateAnimation dismissAnimation = new TranslateAnimation(0, 0, 0, height);
        dismissAnimation.setDuration(200);
        dismissAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                db.viewBg.setBackgroundResource(R.color.transparent_00000000);
            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        return dismissAnimation;
    }

    @Override
    protected Animation onCreateShowAnimation(int width, int height) {
        TranslateAnimation showAnimation = new TranslateAnimation(0, 0, height, 0);
        showAnimation.setDuration(200);
        showAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                db.viewBg.setBackgroundResource(R.color.black_99000000);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        return showAnimation;
    }
}
