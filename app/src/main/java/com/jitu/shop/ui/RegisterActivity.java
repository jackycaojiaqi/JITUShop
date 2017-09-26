package com.jitu.shop.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.jitu.shop.AppConstant;
import com.jitu.shop.R;
import com.jitu.shop.base.BaseActivity;
import com.jitu.shop.entity.BasePaserEntity;
import com.jitu.shop.entity.OnlyCodeEntity;
import com.jitu.shop.interfaces.MyCallBack;
import com.jitu.shop.util.NetClient;
import com.jitu.shop.util.SPUtil;
import com.jitu.shop.util.StringUtil;
import com.jitu.shop.widget.ClearableEditText;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.adapter.Call;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.HttpParams;
import com.lzy.okgo.model.Response;
import com.vondear.rxtools.view.RxToast;
import com.white.countdownbutton.CountDownButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jacky on 2017/9/25.
 */
public class RegisterActivity extends BaseActivity {
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_submit)
    TextView tvSubmit;
    @BindView(R.id.et_register_account)
    ClearableEditText etRegisterAccount;
    @BindView(R.id.et_register_code)
    ClearableEditText etRegisterCode;
    @BindView(R.id.cdb_register_time)
    CountDownButton cdbRegisterTime;
    @BindView(R.id.et_register_pass)
    ClearableEditText etRegisterPass;
    @BindView(R.id.btn_register_next)
    Button btnRegisterNext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acrivity_register);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.iv_back, R.id.cdb_register_time, R.id.btn_register_next})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.cdb_register_time:
                dogetCode();
                break;
            case R.id.btn_register_next:
                doregister();
                break;
        }
    }

    private void dogetCode() {
        String phone = etRegisterAccount.getText().toString();
        if (StringUtil.isEmptyandnull(phone)) {
            RxToast.error("手机号不能为空");
            return;
        }
        HttpParams params = new HttpParams();
        params.put("phone", phone);
        params.put("type", "1");

        NetClient.getInstance(OnlyCodeEntity.class).Get(context, AppConstant.URL_ADMINSENDCODE, params, new MyCallBack() {
            @Override
            public void onFailure(int code) {

            }

            @Override
            public void onResponse(Response object) {
                OnlyCodeEntity entity = (OnlyCodeEntity) object.body();
                if (entity.getErrorCode() == 0) {
                    RxToast.success("发送验证码成功");
                }
            }
        });
    }

    private void doregister() {
        String phone = etRegisterAccount.getText().toString();
        if (StringUtil.isEmptyandnull(phone)) {
            RxToast.error("手机号不能为空");
            return;
        }
        String code = etRegisterCode.getText().toString();
        if (StringUtil.isEmptyandnull(code)) {
            RxToast.error("验证码不能为空");
            return;
        }
        String pass = etRegisterPass.getText().toString();
        if (StringUtil.isEmptyandnull(pass) || pass.length() < 6) {
            RxToast.error("密码不符合规范");
            return;
        }
        HttpParams params = new HttpParams();
        params.put("account", phone);
        params.put("password", pass);
        params.put("passwordagain", pass);
        params.put("phone", phone);
        params.put("code", code);
        NetClient.getInstance(OnlyCodeEntity.class).Get(context, AppConstant.URL_ADMINSELLERREGISTER, params, new MyCallBack() {
            @Override
            public void onFailure(int code) {

            }

            @Override
            public void onResponse(Response object) {
                OnlyCodeEntity entity = (OnlyCodeEntity) object.body();
                if (entity.getErrorCode() == 0) {
                    RxToast.success("注册成功");
                    finish();
                }
            }
        });
    }
}
