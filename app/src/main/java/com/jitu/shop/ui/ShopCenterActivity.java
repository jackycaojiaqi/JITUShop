package com.jitu.shop.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jitu.shop.AppConstant;
import com.jitu.shop.R;
import com.jitu.shop.base.BaseActivity;
import com.jitu.shop.entity.ShopCenterEntity;
import com.jitu.shop.interfaces.MyCallBack;
import com.jitu.shop.util.DialogFactory;
import com.jitu.shop.util.ImagUtil;
import com.jitu.shop.util.NetClient;
import com.jitu.shop.util.SPUtil;
import com.jitu.shop.util.StringUtil;
import com.lzy.okgo.model.HttpParams;
import com.lzy.okgo.model.Response;
import com.socks.library.KLog;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.jpush.android.api.JPushInterface;
import de.hdodenhof.circleimageview.CircleImageView;

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
    @BindView(R.id.iv_shop_center_logo)
    CircleImageView ivShopCenterLogo;
    @BindView(R.id.tv_shop_center_name)
    TextView tvShopCenterName;
    @BindView(R.id.tv_shop_center_detail)
    TextView tvShopCenterDetail;

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
        initdate();
        JPushInterface.onResume(getApplicationContext());
    }

    @Override
    protected void onPause() {
        super.onPause();
        JPushInterface.onPause(getApplicationContext());
    }

    private void initview() {
        back(ivBack);
    }

    private int auth_state = -1;
    private int pay_state = -1;

    private void initdate() {
        DialogFactory.showRequestDialog(context);
        HttpParams params = new HttpParams();
        params.put("token", (String) SPUtil.get(context, AppConstant.TOKEN, ""));
        NetClient.getInstance(ShopCenterEntity.class).Get(context, AppConstant.URL_QUERYSHOPINFO, params, new MyCallBack() {
            @Override
            public void onFailure(int code) {
                DialogFactory.hideRequestDialog();

            }

            @Override
            public void onResponse(Response object) {
                DialogFactory.hideRequestDialog();
                ShopCenterEntity shop_entity = (ShopCenterEntity) object.body();
                if (shop_entity.getErrorCode() == 0) {
                    KLog.e(AppConstant.IMAGPATH + shop_entity.getResult().getLogo());
                    Glide.with(context).load(AppConstant.IMAGPATH + shop_entity.getResult().getLogo()).into(ivShopCenterLogo);
                    tvShopCenterName.setText(shop_entity.getResult().getShopName() + " ");
                    tvShopCenterDetail.setText((StringUtil.isEmptyandnull(shop_entity.getResult().getWorktimeBegin()) ? "未知" :
                            shop_entity.getResult().getWorktimeBegin()) + "--" + (StringUtil.isEmptyandnull(shop_entity.getResult().getWorktimeEnd()) ? "未知" :
                            shop_entity.getResult().getWorktimeEnd()));
                    if (shop_entity.getResult().getIspay() == 0) {
                        pay_state = 0;
                        tvShopCenterCashDeposit.setText("未交纳");
                    } else if (shop_entity.getResult().getIspay() == 1) {
                        tvShopCenterCashDeposit.setText("已交纳");
                        pay_state = 1;
                    }
                    if (shop_entity.getResult().getIspass() == 0) {
                        auth_state = 0;
                        tvShopCenterAuth.setText("未认证");
                    } else if (shop_entity.getResult().getIspass() == 1) {
                        auth_state = 1;
                        tvShopCenterAuth.setText("审核中");
                    } else if (shop_entity.getResult().getIspass() == 2) {
                        auth_state = 2;
                        tvShopCenterAuth.setText("认证通过");
                    } else if (shop_entity.getResult().getIspass() == 3) {
                        auth_state = 3;
                        tvShopCenterAuth.setText("审核驳回");
                    }
                }
            }
        });
    }

    @OnClick({R.id.rll_shop_center_cash_deposit, R.id.rll_shop_center_auth, R.id.rll_shop_center_about_us, R.id.rll_shop_center_help_feedback})
    public void onViewClicked(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.rll_shop_center_cash_deposit:
                intent = new Intent(context, DepositeActivity.class);
                intent.putExtra(AppConstant.TYPE, pay_state);
                startActivity(intent);
                break;
            case R.id.rll_shop_center_auth:
                intent = new Intent(context, ShopAuthActivity.class);
                intent.putExtra(AppConstant.TYPE, auth_state);
                startActivity(intent);
                break;
            case R.id.rll_shop_center_about_us:
                break;
            case R.id.rll_shop_center_help_feedback:
                startActivity(new Intent(context, FeedBackActivity.class));
                break;
        }
    }
}
