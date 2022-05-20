package com.happystore.www.utils;

import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.widget.TextView;

import com.xuexiang.xutil.display.DensityUtils;

import java.text.DecimalFormat;

public class PriceUtils {

    public static void formatShoppingPrice(double price, TextView tv) {
        DecimalFormat df = new DecimalFormat("0.00");
        String formatPrice = "售价" + df.format(price);

        SpannableString spannableString = new SpannableString(formatPrice);
        AbsoluteSizeSpan sizeSpan1 = new AbsoluteSizeSpan(DensityUtils.sp2px(14));
        AbsoluteSizeSpan sizeSpan2 = new AbsoluteSizeSpan(DensityUtils.sp2px(28));

        spannableString.setSpan(sizeSpan1, 0, 2, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(sizeSpan2, 2, formatPrice.length(), Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        tv.setText(spannableString);
    }

    public static void formatMarketPrice(double price, TextView tv) {
        DecimalFormat df = new DecimalFormat("0.00");
        String formatPrice = "原价" + df.format(price);

        SpannableString spannableString = new SpannableString(formatPrice);
        AbsoluteSizeSpan sizeSpan1 = new AbsoluteSizeSpan(DensityUtils.sp2px(14));
        AbsoluteSizeSpan sizeSpan2 = new AbsoluteSizeSpan(DensityUtils.sp2px(14));

        spannableString.setSpan(sizeSpan1, 0, 2, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(sizeSpan2, 2, formatPrice.length(), Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        tv.setText(spannableString);
    }
}
