package com.jitu.shop.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jitu.shop.AppConstant;
import com.jitu.shop.R;
import com.jitu.shop.base.BaseActivity;
import com.jitu.shop.entity.BasePaserEntity;
import com.jitu.shop.interfaces.MyCallBack;
import com.jitu.shop.util.NetClient;
import com.jitu.shop.util.SPUtil;
import com.lzy.okgo.model.HttpParams;
import com.lzy.okgo.model.Response;

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
    private String service_id;
    private String service_type = "0";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_sale);
        ButterKnife.bind(this);
        service_id = getIntent().getStringExtra(AppConstant.OBJECT);
        service_type = getIntent().getStringExtra(AppConstant.TYPE);
        initview();
        initDate();
    }

    private void initDate() {
        HttpParams params = new HttpParams();
        params.put("token", (String) SPUtil.get(context, AppConstant.TOKEN, ""));
        params.put("serviceid", service_id);
        NetClient.getInstance(BasePaserEntity.class).Get(context, AppConstant.URL_QueryServiceDetails, params, new MyCallBack() {
            @Override
            public void onResponse(Response object) {

            }

            @Override
            public void onFailure(int code) {

            }
        });
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
