package com.jitu.shop.util;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.jitu.shop.R;
import com.jitu.shop.widget.GlideTransform.GlideCircleTransform;
import com.jitu.shop.widget.GlideTransform.GlideRoundTransform;

import java.io.File;


/**
 * Created by jacky on 2017/7/20.
 */
public class ImagUtil {
    public static void set(Context context, String url, View view) {
        Glide.with(context).load(url).error(R.drawable.ic_no_pic).placeholder(R.drawable.ic_no_pic).centerCrop().into((ImageView) view);
    }

    public static void setnocache(Context context, String url, View view) {
        Glide.with(context).load(url).error(R.drawable.ic_no_pic).centerCrop().placeholder(R.drawable.ic_no_pic).skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.NONE).into((ImageView) view);
    }

    public static void setnoerror(Context context, String url, View view) {
        Glide.with(context).load(url).centerCrop().into((ImageView) view);
    }

    public static void setwithbg(Context context, String url, View view) {
        Glide.with(context).load(url).centerCrop().error(R.drawable.ic_no_pic).placeholder(R.drawable.ic_no_pic).into((ImageView) view);
    }

    public static void set(Context context, Drawable url, View view) {
        Glide.with(context).load(url).error(R.drawable.ic_no_pic).centerCrop().placeholder(R.drawable.ic_no_pic).into((ImageView) view);
    }

    public static void set(Context context, File url, View view) {
        Glide.with(context).load(url).error(R.drawable.ic_no_pic).centerCrop().placeholder(R.drawable.ic_no_pic).into((ImageView) view);
    }

    public static void set(Context context, Uri url, View view) {
        Glide.with(context).load(url).error(R.drawable.ic_no_pic).centerCrop().placeholder(R.drawable.ic_no_pic).into((ImageView) view);
    }

    public static void setRound(Context context, String url, View view, int round) {
        Glide.with(context).load(url).error(R.drawable.ic_no_pic).transform(new CenterCrop(context), new GlideRoundTransform(context, 5)).into((ImageView) view);
    }

    public static void setCircle(Context context, String url, View view) {
        Glide.with(context).load(url).error(R.drawable.ic_no_pic).transform(new CenterCrop(context), new GlideCircleTransform(context)).placeholder(R.drawable.ic_no_pic).into((ImageView) view);
    }

    public static void destroy(Context context) {
        Glide.with(context).onDestroy();
    }
}
