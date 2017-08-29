package com.jitu.shop.ui;

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

/**
 * Created by jacky on 2017/8/29.
 */
public class CashManageActivity extends BaseActivity {
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_submit)
    TextView tvSubmit;
    @BindView(R.id.tv_cash_manage_money_left)
    TextView tvCashManageMoneyLeft;
    @BindView(R.id.rll_cash_manage)
    RelativeLayout rllCashManage;
    @BindView(R.id.tv_cash_manage_money_totle)
    TextView tvCashManageMoneyTotle;
    @BindView(R.id.tv_cash_manage_money_doing)
    TextView tvCashManageMoneyDoing;
    @BindView(R.id.tv_cash_manage_money_get)
    TextView tvCashManageMoneyGet;
    @BindView(R.id.tv_cash_manage_get_amount)
    TextView tvCashManageGetAmount;
    @BindView(R.id.rll_cash_manage_detail)
    RelativeLayout rllCashManageDetail;
    @BindView(R.id.tv_cash_manage_card)
    TextView tvCashManageCard;
    @BindView(R.id.rll_cash_manage_card)
    RelativeLayout rllCashManageCard;
    @BindView(R.id.tv_cash_manage_zhifubao)
    TextView tvCashManageZhifubao;
    @BindView(R.id.rll_cash_manage_zhifubao)
    RelativeLayout rllCashManageZhifubao;
    @BindView(R.id.tv_cash_manage_weixin)
    TextView tvCashManageWeixin;
    @BindView(R.id.rll_cash_manage_weixin)
    RelativeLayout rllCashManageWeixin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTranslucentStatus();
        setContentView(R.layout.activity_cashmanage);
        ButterKnife.bind(this);
        initview();
        initdate();
    }

    private void initview() {
        setText(tvTitle,"提现管理");

    }

    private void initdate() {
    }

    @OnClick({R.id.iv_back, R.id.rll_cash_manage, R.id.rll_cash_manage_detail, R.id.rll_cash_manage_card, R.id.rll_cash_manage_zhifubao, R.id.rll_cash_manage_weixin})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.rll_cash_manage:
                break;
            case R.id.rll_cash_manage_detail:
                break;
            case R.id.rll_cash_manage_card:
                break;
            case R.id.rll_cash_manage_zhifubao:
                break;
            case R.id.rll_cash_manage_weixin:
                break;
        }
    }
}
