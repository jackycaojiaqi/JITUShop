package com.jitu.shop.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jitu.shop.AppConstant;
import com.jitu.shop.R;
import com.jitu.shop.adapter.MainMenuAdapter;
import com.jitu.shop.base.BaseActivity;
import com.jitu.shop.callback.JsonCallBack;
import com.jitu.shop.entity.ChangePassEntity;
import com.jitu.shop.entity.MainMenuEntity;
import com.jitu.shop.util.ToastUtil;
import com.jitu.shop.widget.ClearableEditText;
import com.jitu.shop.widget.DividerItemDecoration;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.Response;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.jpush.android.api.JPushInterface;

/**
 * Created by jacky on 2017/8/28.
 */
public class ChangePassActivity extends BaseActivity {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_submit)
    TextView tvSubmit;
    @BindView(R.id.et_changepass_pass)
    ClearableEditText etChangepassPass;
    @BindView(R.id.et_changepass_pass_new)
    ClearableEditText etChangepassPassNew;
    @BindView(R.id.btn_changepass_next)
    Button btnChangepassNext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_pass);
        ButterKnife.bind(this);
        intview();
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

    private void intview() {
        setText(tvTitle, "修改登录密码");
    }

    @OnClick({R.id.iv_back, R.id.btn_changepass_next})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.btn_changepass_next:
//                OkGo.<ChangePassEntity>get(AppConstant.BASE_URL + AppConstant.URL_ADMINREVICEPASSWORD)
//                        .tag(this)
//                        .execute(new JsonCallBack<ChangePassEntity>(ChangePassEntity.class) {
//                            @Override
//                            public void onSuccess(Response<ChangePassEntity> response) {
//
//                            }
//
//                            @Override
//                            public void onError(Response<ChangePassEntity> response) {
//                                super.onError(response);
//                            }
//                        });
                finish();
                break;
        }
    }
}
