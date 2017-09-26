package com.jitu.shop.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.jitu.shop.AppConstant;
import com.jitu.shop.R;
import com.jitu.shop.base.BaseActivity;
import com.jitu.shop.entity.OnlyCodeEntity;
import com.jitu.shop.interfaces.MyCallBack;
import com.jitu.shop.util.NetClient;
import com.jitu.shop.util.StringUtil;
import com.jitu.shop.widget.ClearableEditText;
import com.lzy.okgo.model.HttpParams;
import com.lzy.okgo.model.Response;
import com.vondear.rxtools.view.RxToast;
import com.white.countdownbutton.CountDownButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.jpush.android.api.JPushInterface;

/**
 * Created by jacky on 2017/8/28.
 */
public class ForgetPassActivity extends BaseActivity {
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_submit)
    TextView tvSubmit;
    @BindView(R.id.et_forget_account)
    ClearableEditText etForgetAccount;
    @BindView(R.id.et_forget_pass)
    ClearableEditText etForgetPass;
    @BindView(R.id.cdb_forget_time)
    CountDownButton cdbForgetTime;
    @BindView(R.id.btn_forgetpass_next)
    Button btnForgetpassNext;
    private String type;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgetpass);
        ButterKnife.bind(this);
        type = getIntent().getStringExtra(AppConstant.OBJECT);
        initview();
        initdate();
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
        setText(tvTitle, "重置密码");
    }

    private void initdate() {
    }

    @OnClick({R.id.iv_back, R.id.cdb_forget_time, R.id.btn_forgetpass_next})
    public void onViewClicked(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.cdb_forget_time:
                dogetCode();
                break;
            case R.id.btn_forgetpass_next:
                String phone = etForgetAccount.getText().toString();
                if (StringUtil.isEmptyandnull(phone)) {
                    RxToast.error("手机号不能为空");
                    return;
                }
                String code = etForgetPass.getText().toString();
                if (StringUtil.isEmptyandnull(code)) {
                    RxToast.error("验证码不能为空");
                    return;
                }

                intent = new Intent(context, ChangePassActivity.class);
                intent.putExtra(AppConstant.CODE, code);
                intent.putExtra(AppConstant.PHONE, phone);
                intent.putExtra(AppConstant.OBJECT, type);
                startActivity(intent);
                finish();
                break;
        }
    }

    private void dogetCode() {
        String phone = etForgetAccount.getText().toString();
        if (StringUtil.isEmptyandnull(phone)) {
            RxToast.error("手机号不能为空");
            return;
        }
        HttpParams params = new HttpParams();
        params.put("phone", phone);
        params.put("type", "2");

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

}
