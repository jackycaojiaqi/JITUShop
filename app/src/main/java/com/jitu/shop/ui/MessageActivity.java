package com.jitu.shop.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.jitu.shop.R;
import com.jitu.shop.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jacky on 2017/8/29.
 */
public class MessageActivity extends BaseActivity {
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_submit)
    TextView tvSubmit;
    @BindView(R.id.rv_message)
    RecyclerView rvMessage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTranslucentStatus();
        setContentView(R.layout.activity_message);
        ButterKnife.bind(this);
        initview();
    }

    private void initview() {
        back(ivBack);
        setText(tvTitle, "消息");
    }
}
