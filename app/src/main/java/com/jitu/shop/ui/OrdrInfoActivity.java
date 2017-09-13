package com.jitu.shop.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.jitu.shop.AppConstant;
import com.jitu.shop.R;
import com.jitu.shop.adapter.OrderInfoGoodsAdapter;
import com.jitu.shop.adapter.OrderListGoodsAdapter;
import com.jitu.shop.base.BaseActivity;
import com.jitu.shop.entity.OrderInfoEntity;
import com.jitu.shop.interfaces.MyCallBack;
import com.jitu.shop.util.DialogFactory;
import com.jitu.shop.util.NetClient;
import com.jitu.shop.util.SPUtil;
import com.jitu.shop.util.StringUtil;
import com.jitu.shop.widget.MyListView;
import com.lzy.okgo.model.Response;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jacky on 2017/9/1.
 */
public class OrdrInfoActivity extends BaseActivity {
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_submit)
    TextView tvSubmit;
    @BindView(R.id.tv_order_info_ordernum)
    TextView tvOrderInfoOrdernum;
    @BindView(R.id.tv_order_info_time)
    TextView tvOrderInfoTime;
    @BindView(R.id.tv_order_info_state)
    TextView tvOrderInfoState;
    @BindView(R.id.tv_order_info_leavemessage)
    TextView tvOrderInfoLeavemessage;
    @BindView(R.id.tv_order_info_price)
    TextView tvOrderInfoPrice;
    @BindView(R.id.tv_order_info_name)
    TextView tvOrderInfoName;
    @BindView(R.id.tv_order_info_phone)
    TextView tvOrderInfoPhone;
    @BindView(R.id.tv_order_info_address)
    TextView tvOrderInfoAddress;
    @BindView(R.id.lv_order_info_gooslist)
    MyListView lvOrderInfoGooslist;
    @BindView(R.id.tv_order_info_action)
    Button tvOrderInfoAction;

    @BindView(R.id.sv_order_info)
    ScrollView svOrderInfo;
    private String order_code;
    private OrderInfoGoodsAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_info);
        ButterKnife.bind(this);
        order_code = getIntent().getStringExtra(AppConstant.OBJECT);
        initview();
        initdate();
    }


    private void initview() {
        setText(tvTitle, "订单详情");
    }

    private OrderInfoEntity oderinfo;

    private void initdate() {
        DialogFactory.showRequestDialog(context);
        Map<String, String> map = new HashMap<>();
        map.put("token", (String) SPUtil.get(context, AppConstant.TOKEN, ""));
        map.put("ordercode", order_code);
        NetClient.getInstance(OrderInfoEntity.class).Get(context, AppConstant.BASE_URL + AppConstant.URL_QUERYORDERDETAILS, map, new MyCallBack() {
            @Override
            public void onFailure(int code) {
                DialogFactory.hideRequestDialog();
            }
            @Override
            public void onResponse(Response object) {
                DialogFactory.hideRequestDialog();
                oderinfo = (OrderInfoEntity) object.body();
                if (oderinfo.getErrorCode() == 0) {
                    //订单号
                    tvOrderInfoOrdernum.setText("订单号：" + oderinfo.getResult().getOrderCode());
                    //下单时间
                    String time = oderinfo.getResult().getCreatTime();
                    try {
                        time = time.substring(0, 10);
                        tvOrderInfoTime.setText(time + "");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    //订单状态
                    if (oderinfo.getResult().getStates() == 1) {
                        tvOrderInfoState.setText("刚下单");
                    } else if (oderinfo.getResult().getStates() == 10) {
                        tvOrderInfoState.setText("已付款");
                    } else if (oderinfo.getResult().getStates() == 15) {
                        tvOrderInfoState.setText("已发货");
                    } else if (oderinfo.getResult().getStates() == 20) {
                        tvOrderInfoState.setText("已收货");
                    } else if (oderinfo.getResult().getStates() == 30) {
                        tvOrderInfoState.setText("申请退款");
                    } else if (oderinfo.getResult().getStates() == 33) {
                        tvOrderInfoState.setText("已经退货");
                    } else if (oderinfo.getResult().getStates() == 35) {
                        tvOrderInfoState.setText("没有退货");
                    }
                    //订单留言
                    tvOrderInfoLeavemessage.setText(oderinfo.getResult().getMemNote() + " ");
                    //订单总额
                    tvOrderInfoPrice.setText("¥ " + oderinfo.getResult().getAmount());
                    //收货人名字
                    tvOrderInfoName.setText(StringUtil.isEmptyandnull(oderinfo.getResult().getConsignee()) ? "未知" : oderinfo.getResult().getConsignee());
                    //收货人电话
                    tvOrderInfoPhone.setText(StringUtil.isEmptyandnull(oderinfo.getResult().getPhone()) ? "未知" : oderinfo.getResult().getPhone());
                    //收货人地址
                    tvOrderInfoAddress.setText(StringUtil.isEmptyandnull(oderinfo.getResult().getAddr()) ? "未知" : oderinfo.getResult().getAddr());
                    //商品列表
                    adapter = new OrderInfoGoodsAdapter(context, oderinfo.getResult().getTB_OrderDetails());
                    lvOrderInfoGooslist.setAdapter(adapter);

                    tvOrderInfoPhone.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (!StringUtil.isEmptyandnull(oderinfo.getResult().getPhone())) {
                                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + oderinfo.getResult().getPhone()));
                                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(intent);
                            }
                        }
                    });
                }
            }
        });
        svOrderInfo.smoothScrollTo(0, 0);
    }

    @OnClick({R.id.iv_back, R.id.tv_order_info_phone, R.id.tv_order_info_action})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_order_info_phone:
                break;
            case R.id.tv_order_info_action:
                break;
        }
    }
}
