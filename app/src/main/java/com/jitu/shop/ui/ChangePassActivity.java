package com.jitu.shop.ui;

import android.content.pm.ProviderInfo;
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
import com.jitu.shop.entity.OnlyCodeEntity;
import com.jitu.shop.interfaces.MyCallBack;
import com.jitu.shop.util.NetClient;
import com.jitu.shop.util.SPUtil;
import com.jitu.shop.util.StringUtil;
import com.jitu.shop.util.ToastUtil;
import com.jitu.shop.widget.ClearableEditText;
import com.jitu.shop.widget.DividerItemDecoration;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.HttpParams;
import com.lzy.okgo.model.Response;
import com.vondear.rxtools.view.RxToast;

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
    private String phone, code, type;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_pass);
        ButterKnife.bind(this);
        phone = getIntent().getStringExtra(AppConstant.PHONE);
        code = getIntent().getStringExtra(AppConstant.CODE);
        type = getIntent().getStringExtra(AppConstant.OBJECT);
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
                String pass = etChangepassPass.getText().toString().trim();
                String pass_again = etChangepassPassNew.getText().toString().trim();
                if (StringUtil.isEmptyandnull(pass)) {
                    RxToast.error("密不能为空");
                    return;
                }
                if (!pass.equals(pass_again)) {
                    RxToast.error("两次密码不一致");
                    return;
                }
                if (StringUtil.isEmptyandnull(phone))//无需手机的修改密码，传token
                {
                    HttpParams httpParams = new HttpParams();
                    httpParams.put("token", (String) SPUtil.get(context, AppConstant.TOKEN, ""));
                    httpParams.put("password", pass);
                    httpParams.put("againpassword", pass_again);
                    NetClient.getInstance(OnlyCodeEntity.class).Get(context, AppConstant.URL_ADMINREVICEPASSWORD, httpParams, new MyCallBack() {
                        @Override
                        public void onFailure(int code) {

                        }

                        @Override
                        public void onResponse(Response object) {
                            OnlyCodeEntity entity = (OnlyCodeEntity) object.body();
                            if (entity.getErrorCode() == 0) {
                                RxToast.success("修改密码成功");
                                finish();
                            }
                        }
                    });
                } else {//需手机的修改密码，不传token
                    HttpParams httpParams = new HttpParams();
                    httpParams.put("phone", phone);
                    httpParams.put("password", pass);
                    httpParams.put("againpassword", pass_again);
                    httpParams.put("code", code);
                    NetClient.getInstance(OnlyCodeEntity.class).Get(context, AppConstant.URL_ADMINREVICEPASSWORD_, httpParams, new MyCallBack() {
                        @Override
                        public void onFailure(int code) {

                        }

                        @Override
                        public void onResponse(Response object) {
                            OnlyCodeEntity entity = (OnlyCodeEntity) object.body();
                            if (entity.getErrorCode() == 0) {
                                RxToast.success("修改密码成功");
                                finish();
                            }
                        }
                    });
                }
                break;
        }
    }
}
