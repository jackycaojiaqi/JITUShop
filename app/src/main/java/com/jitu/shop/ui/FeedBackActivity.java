package com.jitu.shop.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jitu.shop.AppConstant;
import com.jitu.shop.R;
import com.jitu.shop.adapter.MainMenuAdapter;
import com.jitu.shop.base.BaseActivity;
import com.jitu.shop.callback.JsonCallBack;
import com.jitu.shop.entity.FeedBackEntity;
import com.jitu.shop.entity.MainMenuEntity;
import com.jitu.shop.entity.OrderListEntity;
import com.jitu.shop.interfaces.MyCallBack;
import com.jitu.shop.util.DialogFactory;
import com.jitu.shop.util.NetClient;
import com.jitu.shop.util.SPUtil;
import com.jitu.shop.util.StringUtil;
import com.jitu.shop.util.ToastUtil;
import com.jitu.shop.widget.DividerItemDecoration;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.Response;
import com.socks.library.KLog;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.jpush.android.api.JPushInterface;

/**
 * Created by jacky on 2017/8/29.
 */
public class FeedBackActivity extends BaseActivity {
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_submit)
    TextView tvSubmit;
    @BindView(R.id.ll_feedback_talk)
    LinearLayout llFeedbackTalk;
    @BindView(R.id.ll_feedback_phone)
    LinearLayout llFeedbackPhone;
    @BindView(R.id.et_feedback_content)
    EditText etFeedbackContent;
    @BindView(R.id.btn_feedback_submit)
    Button btnFeedbackSubmit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTranslucentStatus();
        setContentView(R.layout.activity_feedback);
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

    @OnClick({R.id.iv_back, R.id.ll_feedback_talk, R.id.ll_feedback_phone, R.id.btn_feedback_submit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.ll_feedback_talk:
                break;
            case R.id.ll_feedback_phone:
                break;
            case R.id.btn_feedback_submit:
                String et_content = etFeedbackContent.getText().toString().trim();
                if (StringUtil.isEmptyandnull(et_content)) {
                    ToastUtil.show(context, "反馈内容不能为空");
                    return;
                }
                DialogFactory.showRequestDialog(context);
                Map<String, String> map = new HashMap<>();
                map.put("token", (String) SPUtil.get(context, AppConstant.TOKEN, ""));
                map.put("content", et_content);
                NetClient.getInstance(FeedBackEntity.class).Post(context, AppConstant.BASE_URL + AppConstant.URL_SUBMITNOTE, map, new MyCallBack() {
                    @Override
                    public void onResponse(Response object) {
                        DialogFactory.hideRequestDialog();
                        FeedBackEntity feedBackEntity = (FeedBackEntity)object.body();
                        if (feedBackEntity.getErrorCode()==0){
                            ToastUtil.show(context, "反馈成功");
                            finish();
                        }
                    }

                    @Override
                    public void onFailure(int code) {
                        DialogFactory.hideRequestDialog();
                    }
                });

                break;
        }
    }
}
