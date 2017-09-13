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
import com.jitu.shop.entity.FeedBackEntity;
import com.jitu.shop.util.SPUtil;
import com.tencent.bugly.beta.Beta;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.jpush.android.api.JPushInterface;

/**
 * Created by jacky on 2017/8/28.
 */
public class SettingActivity extends BaseActivity {
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_submit)
    TextView tvSubmit;
    @BindView(R.id.tv_setting_quit)
    TextView tvSettingQuit;
    @BindView(R.id.rll_setting_change_pass)
    RelativeLayout rllSettingChangePass;
    @BindView(R.id.rll_setting_about_us)
    RelativeLayout rllSettingAboutUs;
    @BindView(R.id.rll_setting_feedback)
    RelativeLayout rllSettingFeedback;
    @BindView(R.id.rll_setting_check_update)
    RelativeLayout rllSettingCheckUpdate;
    @BindView(R.id.rll_setting_new_message)
    RelativeLayout rllSettingNewMessage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
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
        setText(tvTitle, "设置");
    }

    @OnClick({R.id.iv_back, R.id.tv_setting_quit,
            R.id.rll_setting_change_pass, R.id.rll_setting_about_us, R.id.rll_setting_feedback,
            R.id.rll_setting_check_update, R.id.rll_setting_new_message})
    public void onViewClicked(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_setting_quit:
                intent = new Intent(context, LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
                SPUtil.clear(context);
                break;
            case R.id.rll_setting_change_pass:
                break;
            case R.id.rll_setting_about_us:
                break;
            case R.id.rll_setting_feedback:
                intent = new Intent(context, FeedBackActivity.class);
                startActivity(intent);
                break;
            case R.id.rll_setting_check_update:
                Beta.checkUpgrade();
                break;
            case R.id.rll_setting_new_message:
                break;
        }
    }

}
