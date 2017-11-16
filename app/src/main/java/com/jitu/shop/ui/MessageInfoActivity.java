package com.jitu.shop.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jitu.shop.AppConstant;
import com.jitu.shop.R;
import com.jitu.shop.base.BaseActivity;
import com.jitu.shop.entity.MessageEntity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jacky on 2017/11/14.
 */
public class MessageInfoActivity extends BaseActivity {
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_submit)
    TextView tvSubmit;
    @BindView(R.id.tv_message_info_title)
    TextView tvMessageInfoTitle;
    @BindView(R.id.tv_message_info_content)
    TextView tvMessageInfoContent;
    @BindView(R.id.tv_message_info_time)
    TextView tvMessageInfoTime;
    MessageEntity.ResultBean obj;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_info);
        ButterKnife.bind(this);
        obj = getIntent().getParcelableExtra(AppConstant.OBJECT);
        initView();
    }

    private void initView() {
        tvTitle.setText("消息详情");
        tvMessageInfoTitle.setText(obj.getCM_Title());
        tvMessageInfoContent.setText(obj.getCM_Content());
        tvMessageInfoTime.setText(obj.getCM_CreateTime());
    }

    @OnClick({R.id.iv_back, R.id.tv_submit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_submit:
                break;
        }
    }
}
