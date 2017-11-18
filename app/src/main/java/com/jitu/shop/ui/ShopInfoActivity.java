package com.jitu.shop.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jitu.shop.AppConstant;
import com.jitu.shop.R;
import com.jitu.shop.base.BaseActivity;
import com.jitu.shop.entity.OnlyCodeEntity;
import com.jitu.shop.entity.ShopInfoEntity;
import com.jitu.shop.interfaces.MyCallBack;
import com.jitu.shop.util.DialogFactory;
import com.jitu.shop.util.NetClient;
import com.jitu.shop.util.SPUtil;
import com.jitu.shop.util.StringUtil;
import com.lzy.okgo.model.HttpParams;
import com.lzy.okgo.model.Response;

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
        DialogFactory.showRequestDialog(context);
        HttpParams params = new HttpParams();
        params.put("token", (String) SPUtil.get(context, AppConstant.TOKEN, ""));
        NetClient.getInstance(ShopInfoEntity.class).Get(context, AppConstant.URL_QUERYOPERATIONSTATUS, params, new MyCallBack() {
            @Override
            public void onFailure(int code) {
                DialogFactory.hideRequestDialog();
            }

            @Override
            public void onResponse(Response object) {
                DialogFactory.hideRequestDialog();
                ShopInfoEntity shopInfoEntity = (ShopInfoEntity) object.body();
                if (shopInfoEntity.getErrorCode() == 0) {
                    tvShopInfoVisitToday.setText(shopInfoEntity.getResult().getMouthordersun() + " ");//月订单
                    tvShopInfoAmountToday.setText(StringUtil.isEmptyandnull((String) shopInfoEntity.getResult().getDayturnover()) ? "0"
                            : (String) shopInfoEntity.getResult().getDayturnover());//今日营业额
                    tvShopInfoPayToday.setText(shopInfoEntity.getResult().getDayordernum() + " ");//今日订单数

                    tvShopInfoSaleMonth.setText(StringUtil.isEmptyandnull((String) shopInfoEntity.getResult().getMonthturnover()) ? "0"
                            : (String) shopInfoEntity.getResult().getMonthturnover());//本月营业额
                    tvShopInfoOnSales.setText("出售中的宝贝:" + shopInfoEntity.getResult().getSellersun() + " ");//上架中
                    tvShopInfoWaitForSales.setText("等待上架的宝贝:" + shopInfoEntity.getResult().getUnsellersun() + " ");//未上架
                    tvShopInfoOrderUndo.setText("未处理订单：" + shopInfoEntity.getResult().getNotshipped() + " ");//未处理订单
                }
            }
        });
    }

    @OnClick({R.id.iv_back, R.id.tv_submit, R.id.tv_shop_info_on_sales, R.id.tv_shop_info_wait_for_sales, R.id.tv_shop_info_order_undo, R.id.tv_shop_info_waitfor_reply})
    public void onViewClicked(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_submit://交易明细
                break;
            case R.id.tv_shop_info_on_sales:
                intent = new Intent(context, CommodityManageListActivity.class);
                intent.putExtra(AppConstant.TYPE, 0);
                startActivity(intent);
                finish();
                break;
            case R.id.tv_shop_info_wait_for_sales:
                intent = new Intent(context, CommodityManageListActivity.class);
                intent.putExtra(AppConstant.TYPE, 1);
                startActivity(intent);
                finish();
                break;
            case R.id.tv_shop_info_order_undo:
                intent = new Intent(context, OrderManageListActivity.class);
                intent.putExtra(AppConstant.PAGE, 2);
                startActivity(intent);
                finish();
                break;
            case R.id.tv_shop_info_waitfor_reply:
                break;
        }
    }
}
