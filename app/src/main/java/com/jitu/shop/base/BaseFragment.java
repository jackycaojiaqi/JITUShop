package com.jitu.shop.base;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.TextView;



/**
 * Created by jacky on 17/3/23.
 */
public class BaseFragment extends Fragment {

    /**
     * 通过反射修改TabLayout Indicator的宽度（仅在Android 4.2及以上生效）
     */


    public void setAnimaAlpha(final View view) {
        view.setVisibility(View.VISIBLE);
        AlphaAnimation animation1 = new AlphaAnimation(1.0f, 0.0f);
        animation1.setDuration(30 * 1000);
        animation1.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                view.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        view.setAnimation(animation1);
        animation1.start();
    }


    private View view = null;//存储fragemnt的视图
    private int height = 180;//indicator高低
    public static boolean isIndicatorShow = true;//是否显示
    private boolean isShowing = false;//动画是否正在进行




    public void setText(TextView view, @NonNull String res) {
        view.setVisibility(View.VISIBLE);
        view.setText(res);
    }

    public void setText(TextView view, @NonNull int res) {
        view.setVisibility(View.VISIBLE);
        view.setText(res);
    }
}
