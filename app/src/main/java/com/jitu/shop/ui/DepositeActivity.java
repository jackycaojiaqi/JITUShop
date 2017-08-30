package com.jitu.shop.ui;

import android.content.Intent;
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
import cn.jpush.android.api.JPushInterface;

/**
 * Created by jacky on 2017/8/29.
 */
public class DepositeActivity extends BaseActivity {
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_submit)
    TextView tvSubmit;
    @BindView(R.id.rll_deposite_goto)
    RelativeLayout rllDepositeGoto;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTranslucentStatus();
        setContentView(R.layout.activity_deposite);
        ButterKnife.bind(this);
        initview();
    } @Override
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
        setText(tvTitle,"交纳保证金");
    }

    @OnClick({R.id.iv_back, R.id.rll_deposite_goto})
    public void onViewClicked(View view) {
        Intent intent ;
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.rll_deposite_goto:
                intent = new Intent(context,PayDepositeActivity.class);
                startActivity(intent);
                break;
        }
    }
}
