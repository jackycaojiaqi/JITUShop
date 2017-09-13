package com.jitu.shop.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jitu.shop.R;
import com.jitu.shop.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jacky on 2017/9/13.
 */
public class ShopInfoActivity extends BaseActivity {
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_submit)
    TextView tvSubmit;
    @BindView(R.id.tv_shop_info_sale_month)
    TextView tvShopInfoSaleMonth;
    @BindView(R.id.tv_shop_info_visit_today)
    TextView tvShopInfoVisitToday;
    @BindView(R.id.tv_shop_info_pay_today)
    TextView tvShopInfoPayToday;
    @BindView(R.id.tv_shop_info_amount_today)
    TextView tvShopInfoAmountToday;
    @BindView(R.id.tv_shop_info_on_sales)
    TextView tvShopInfoOnSales;
    @BindView(R.id.tv_shop_info_wait_for_sales)
    TextView tvShopInfoWaitForSales;
    @BindView(R.id.tv_shop_info_order_undo)
    TextView tvShopInfoOrderUndo;
    @BindView(R.id.tv_shop_info_waitfor_evaluate)
    TextView tvShopInfoWaitforEvaluate;
    @BindView(R.id.tv_shop_info_waitfor_reply)
    TextView tvShopInfoWaitforReply;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_info);
        ButterKnife.bind(this);
        initview();
        initdate();
    }


    private void initview() {
    }

    private void initdate() {
    }

    @OnClick({R.id.iv_back, R.id.tv_submit, R.id.tv_shop_info_on_sales, R.id.tv_shop_info_wait_for_sales, R.id.tv_shop_info_order_undo, R.id.tv_shop_info_waitfor_evaluate, R.id.tv_shop_info_waitfor_reply})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_submit://交易明细
                break;
            case R.id.tv_shop_info_on_sales:
                break;
            case R.id.tv_shop_info_wait_for_sales:
                break;
            case R.id.tv_shop_info_order_undo:
                break;
            case R.id.tv_shop_info_waitfor_evaluate:
                break;
            case R.id.tv_shop_info_waitfor_reply:
                break;
        }
    }
}
