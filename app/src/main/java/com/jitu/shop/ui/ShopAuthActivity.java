package com.jitu.shop.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jitu.shop.R;
import com.jitu.shop.base.BaseActivity;
import com.jitu.shop.widget.ClearableEditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.jpush.android.api.JPushInterface;

/**
 * Created by jacky on 2017/8/29.
 */
public class ShopAuthActivity extends BaseActivity {
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_submit)
    TextView tvSubmit;
    @BindView(R.id.iv_cash_auth_pic1)
    ImageView ivCashauthPic1;
    @BindView(R.id.iv_cash_auth_pic2)
    ImageView ivCashauthPic2;
    @BindView(R.id.et_cash_auth_user_name)
    ClearableEditText etCashauthUserName;
    @BindView(R.id.et_cash_auth_shop_phone)
    ClearableEditText etCashauthShopPhone;
    @BindView(R.id.et_cash_auth_shop_name)
    ClearableEditText etCashauthShopName;
    @BindView(R.id.et_cash_auth_address)
    ClearableEditText etCashauthAddress;
    @BindView(R.id.tv_cash_auth_category)
    TextView tvCashauthCategory;
    @BindView(R.id.rll_cash_auth_category)
    RelativeLayout rllCashauthCategory;
    @BindView(R.id.btn_cash_auth_save)
    Button btnCashauthSave;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTranslucentStatus();
        setContentView(R.layout.activity_shopauth);
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
        setText(tvTitle,"实体认证");
    }

    @OnClick({R.id.iv_back, R.id.iv_cash_auth_pic1, R.id.iv_cash_auth_pic2, R.id.rll_cash_auth_category, R.id.btn_cash_auth_save})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.iv_cash_auth_pic1:
                break;
            case R.id.iv_cash_auth_pic2:
                break;
            case R.id.rll_cash_auth_category:
                break;
            case R.id.btn_cash_auth_save:
                break;
        }
    }
}
