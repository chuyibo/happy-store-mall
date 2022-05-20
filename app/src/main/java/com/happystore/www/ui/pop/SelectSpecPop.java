package com.happystore.www.ui.pop;

import android.content.Context;
import android.view.Gravity;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.happystore.www.R;
import com.happystore.www.databinding.PopSelectSpecBinding;
import com.happystore.www.ui.adapter.SpecAdapter;
import com.happystore.www.utils.PriceUtils;

import razerdp.basepopup.BasePopupWindow;

public class SelectSpecPop extends BasePopupWindow {

    private final PopSelectSpecBinding db;
    private SpecAdapter specAdapter;

    public SelectSpecPop(Context context) {
        super(context);
        setContentView(R.layout.pop_select_spec);

        db = DataBindingUtil.bind(getContentView());

        PriceUtils.formatShoppingPrice(3.38,db.tvShoppingPrice);
        PriceUtils.formatMarketPrice(10.38,db.tvMarketPrice);
        initRecyclerView();
        setPopupGravity(Gravity.BOTTOM);
    }

    public void initRecyclerView() {
        specAdapter = new SpecAdapter();
        db.rvSpec.setLayoutManager(new LinearLayoutManager(getContext()));
        db.rvSpec.setAdapter(specAdapter);
    }

    @Override
    protected Animation onCreateDismissAnimation(int width, int height) {
        TranslateAnimation dismissAnimation = new TranslateAnimation(0, 0, 0, height);
        dismissAnimation.setDuration(200);
        dismissAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
//                db.viewBg.setBackgroundResource(R.color.transparent_00000000);
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
//                db.viewBg.setBackgroundResource(R.color.black_99000000);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        return showAnimation;
    }
}
