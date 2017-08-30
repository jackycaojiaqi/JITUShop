package com.jitu.shop.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.lguipeng.library.animcheckbox.AnimCheckBox;
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
public class GetCashActivity extends BaseActivity {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_submit)
    TextView tvSubmit;
    @BindView(R.id.cb_weichat)
    AnimCheckBox cbWeichat;
    @BindView(R.id.cb_zhifubao)
    AnimCheckBox cbZhifubao;
    @BindView(R.id.cb_yinhangka)
    AnimCheckBox cbYinhangka;
    @BindView(R.id.et_getcash_money)
    ClearableEditText etGetcashMoney;
    @BindView(R.id.btn_getcash_sure)
    Button btnGetcashSure;
    private int cash_type = 1;//1、微信  2、支付宝 3、银行卡

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTranslucentStatus();
        setContentView(R.layout.activity_getcash);
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
        setText(tvTitle, "提现");
        cbWeichat.setOnCheckedChangeListener(new AnimCheckBox.OnCheckedChangeListener() {
            @Override
            public void onChange(AnimCheckBox animCheckBox, boolean b) {
                if (b) {
                    cash_type = 1;
                    cbWeichat.setChecked(true, true);
                    cbZhifubao.setChecked(false, true);
                    cbYinhangka.setChecked(false, true);
                } else {
                    cash_type = 0;
                    cbWeichat.setChecked(false, true);
                }

            }
        });
        cbZhifubao.setOnCheckedChangeListener(new AnimCheckBox.OnCheckedChangeListener() {
            @Override
            public void onChange(AnimCheckBox animCheckBox, boolean b) {
                if (b) {
                    cash_type = 2;
                    cbWeichat.setChecked(false, true);
                    cbZhifubao.setChecked(true, true);
                    cbYinhangka.setChecked(false, true);
                } else {
                    cash_type = 0;
                    cbZhifubao.setChecked(false, true);
                }
            }
        });
        cbYinhangka.setOnCheckedChangeListener(new AnimCheckBox.OnCheckedChangeListener() {
            @Override
            public void onChange(AnimCheckBox animCheckBox, boolean b) {
                if (b) {
                    cash_type = 3;
                    cbWeichat.setChecked(false, true);
                    cbZhifubao.setChecked(false, true);
                    cbYinhangka.setChecked(true, true);
                } else {
                    cash_type = 0;
                    cbYinhangka.setChecked(false, true);
                }
            }
        });
    }

    @OnClick({R.id.iv_back, R.id.btn_getcash_sure})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.btn_getcash_sure:
                break;
        }
    }
}
