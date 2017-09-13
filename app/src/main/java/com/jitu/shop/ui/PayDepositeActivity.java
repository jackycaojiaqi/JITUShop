package com.jitu.shop.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
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
public class PayDepositeActivity extends BaseActivity {
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_submit)
    TextView tvSubmit;
    @BindView(R.id.tv_pay_amount)
    TextView tvPayAmount;
    @BindView(R.id.tv_pay_project_name)
    TextView tvPayProjectName;
    @BindView(R.id.tv_pay_getmoney_name)
    TextView tvPayGetmoneyName;
    @BindView(R.id.tv_pay_username)
    TextView tvPayUsername;
    @BindView(R.id.btn_pay_wechat)
    Button btnPayWechat;
    @BindView(R.id.btn_pay_zhifubao)
    Button btnPayZhifubao;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_deposite);
        ButterKnife.bind(this);
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

    @OnClick({R.id.iv_back, R.id.btn_pay_wechat, R.id.btn_pay_zhifubao})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.btn_pay_wechat:
                break;
            case R.id.btn_pay_zhifubao:
                break;
        }
    }
}
