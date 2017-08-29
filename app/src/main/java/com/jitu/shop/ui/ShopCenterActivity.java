package com.jitu.shop.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jitu.shop.R;
import com.jitu.shop.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

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
        setTranslucentStatus();
        setContentView(R.layout.activity_shopcenter);
        ButterKnife.bind(this);
        initview();
    }

    private void initview() {
        back(ivBack);
    }
}
