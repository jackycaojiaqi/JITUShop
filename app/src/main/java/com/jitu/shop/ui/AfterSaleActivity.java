package com.jitu.shop.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jitu.shop.R;
import com.jitu.shop.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jacky on 2017/9/14.
 */
public class AfterSaleActivity extends BaseActivity {
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_submit)
    TextView tvSubmit;
    @BindView(R.id.tv_after_sale_name)
    TextView tvAfterSaleName;
    @BindView(R.id.tv_after_sale_phone)
    TextView tvAfterSalePhone;
    @BindView(R.id.tv_after_sale_order_id)
    TextView tvAfterSaleOrderId;
    @BindView(R.id.tv_after_sale_price)
    TextView tvAfterSalePrice;
    @BindView(R.id.tv_after_sale_deliver_price)
    TextView tvAfterSaleDeliverPrice;
    @BindView(R.id.tv_after_sale_refund_num)
    TextView tvAfterSaleRefundNum;
    @BindView(R.id.tv_after_sale_refund_price)
    TextView tvAfterSaleRefundPrice;
    @BindView(R.id.tv_after_sale_reason)
    TextView tvAfterSaleReason;
    @BindView(R.id.tv_after_sale_require)
    TextView tvAfterSaleRequire;
    @BindView(R.id.tv_after_sale_goods_state)
    TextView tvAfterSaleGoodsState;
    @BindView(R.id.tv_after_sale_other)
    TextView tvAfterSaleOther;
    @BindView(R.id.tv_after_sale_action1)
    TextView tvAfterSaleAction1;
    @BindView(R.id.tv_after_sale_action2)
    TextView tvAfterSaleAction2;
    @BindView(R.id.ll_commondity_action)
    LinearLayout llCommondityAction;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_sale);
        ButterKnife.bind(this);
        initview();
    }

    private void initview() {
        setText(tvTitle, "售后服务");
    }

    @OnClick({R.id.iv_back, R.id.tv_after_sale_phone, R.id.tv_after_sale_action1, R.id.tv_after_sale_action2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_after_sale_phone:
                break;
            case R.id.tv_after_sale_action1:
                break;
            case R.id.tv_after_sale_action2:
                break;
        }
    }
}
