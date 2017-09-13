package com.jitu.shop.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jitu.shop.R;
import com.jitu.shop.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.jpush.android.api.JPushInterface;

/**
 * Created by jacky on 2017/8/29.
 */
public class ShopCenterActivity extends BaseActivity {
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_shop_center_cash_deposit)
    TextView tvShopCenterCashDeposit;
    @BindView(R.id.rll_shop_center_cash_deposit)
    RelativeLayout rllShopCenterCashDeposit;
    @BindView(R.id.tv_shop_center_auth)
    TextView tvShopCenterAuth;
    @BindView(R.id.rll_shop_center_auth)
    RelativeLayout rllShopCenterAuth;
    @BindView(R.id.rll_shop_center_about_us)
    RelativeLayout rllShopCenterAboutUs;
    @BindView(R.id.rll_shop_center_help_feedback)
    RelativeLayout rllShopCenterHelpFeedback;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopcenter);
        ButterKnife.bind(this);
        initview();
    }

    @Override
    protected void onResume() {
        super.onResume();
        JPushInterface.onResume(getApplicationContext());
    }

    @Override
    protected void onPause() {
        super.onPause();
        JPushInterface.onPause(getApplicationContext());
    }

    private void initview() {
        back(ivBack);
        back(ivBack);
    }

    @OnClick({R.id.rll_shop_center_cash_deposit, R.id.rll_shop_center_auth, R.id.rll_shop_center_about_us, R.id.rll_shop_center_help_feedback})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rll_shop_center_cash_deposit:
                startActivity(new Intent(context, DepositeActivity.class));
                break;
            case R.id.rll_shop_center_auth:
                startActivity(new Intent(context, ShopAuthActivity.class));
                break;
            case R.id.rll_shop_center_about_us:
                break;
            case R.id.rll_shop_center_help_feedback:
                startActivity(new Intent(context, FeedBackActivity.class));
                break;
        }
    }
}
