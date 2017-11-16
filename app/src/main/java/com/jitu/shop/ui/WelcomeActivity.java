package com.jitu.shop.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.jitu.shop.AppConstant;
import com.jitu.shop.R;
import com.jitu.shop.adapter.WelcomePagerAdapter;
import com.jitu.shop.base.BaseActivity;
import com.jitu.shop.ui.fragment.WelcomeOneFragment;
import com.jitu.shop.ui.fragment.WelcomeThreeFragment;
import com.jitu.shop.ui.fragment.WelcomeTwoFragment;
import com.jitu.shop.util.SPUtil;
import com.jitu.shop.util.StringUtil;
import com.jitu.shop.widget.NoScrollViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jacky on 2017/8/28.
 */
public class WelcomeActivity extends BaseActivity {
    @BindView(R.id.vp_welcome)
    NoScrollViewPager vpWelcome;
    @BindView(R.id.iv_welcome_spot1)
    ImageView ivWelcomeSpot1;
    @BindView(R.id.iv_welcome_spot2)
    ImageView ivWelcomeSpot2;
    private List<Fragment> fragments = new ArrayList<>();
    private List<String> titles = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        ButterKnife.bind((Activity) context);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (!StringUtil.isEmptyandnull((String) SPUtil.get(context, AppConstant.TOKEN, ""))) {
                            Intent intent = new Intent(context, MainActivity.class);
                            startActivity(intent);
                            finish();
                        } else {
                            initview();
                        }
                    }
                });
            }
        }, 2000);
    }

    private void initview() {
        fragments.add(new WelcomeOneFragment());
        fragments.add(new WelcomeTwoFragment());
        fragments.add(new WelcomeThreeFragment());
        WelcomePagerAdapter adapter = new WelcomePagerAdapter(getSupportFragmentManager(), fragments, titles);
        vpWelcome.setAdapter(adapter);
        vpWelcome.setOffscreenPageLimit(2);
        vpWelcome.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    ivWelcomeSpot1.setImageResource(R.drawable.spot_deep);
                    ivWelcomeSpot2.setImageResource(R.drawable.spot_dan);
                } else if (position == 1) {
                    ivWelcomeSpot1.setImageResource(R.drawable.spot_dan);
                    ivWelcomeSpot2.setImageResource(R.drawable.spot_deep);
                } else if (position == 2) {
                    vpWelcome.setNoScroll(true);
                    ivWelcomeSpot1.setVisibility(View.GONE);
                    ivWelcomeSpot2.setVisibility(View.GONE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
