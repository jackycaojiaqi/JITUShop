package com.jitu.shop.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.jitu.shop.App;
import com.jitu.shop.AppConstant;
import com.jitu.shop.R;
import com.jitu.shop.base.BaseFragment;
import com.jitu.shop.callback.JsonCallBack;
import com.jitu.shop.entity.LoginEntity;
import com.jitu.shop.ui.ForgetPassActivity;
import com.jitu.shop.ui.MainActivity;
import com.jitu.shop.util.DialogFactory;
import com.jitu.shop.util.SPUtil;
import com.jitu.shop.util.ScreenUtils;
import com.jitu.shop.util.StringUtil;
import com.jitu.shop.util.ToastUtil;
import com.jitu.shop.widget.ClearableEditText;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.Response;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


/**
 * Created by jacky on 2017/7/11.
 */
public class WelcomeThreeFragment extends BaseFragment {

    @BindView(R.id.et_login_account)
    ClearableEditText etLoginAccount;
    @BindView(R.id.et_login_pass)
    ClearableEditText etLoginPass;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.tv_login_forget_pass)
    TextView tvLoginForgetPass;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmen_welcome_three, container, false);
        unbinder = ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.btn_login, R.id.tv_login_forget_pass})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                String et_phone = etLoginAccount.getText().toString().trim();
                String et_pass = etLoginPass.getText().toString().trim();

                if (StringUtil.isEmptyandnull(et_phone)) {
                    ToastUtil.show(getActivity(), "账号不能为空");
                    return;
                }
                if (StringUtil.isEmptyandnull(et_pass)) {
                    ToastUtil.show(getActivity(), "密码不能为空");
                    return;
                }
                DialogFactory.showRequestDialog(getActivity());
                OkGo.<LoginEntity>get(AppConstant.BASE_URL + AppConstant.URL_ADMINLOGIN)
                        .tag(this)
                        .params("account", et_phone)
                        .params("password", et_pass)
                        .execute(new JsonCallBack<LoginEntity>(LoginEntity.class) {
                            @Override
                            public void onSuccess(Response<LoginEntity> response) {
                                DialogFactory.hideRequestDialog();
                                if (response.body().getErrorCode() == 0) {
                                    if (StringUtil.isEmptyandnull(response.body().getToken())) {
                                        ToastUtil.show(getActivity(), "登录失败，请重试");
                                        return;
                                    }
                                    SPUtil.put(getActivity(), AppConstant.TOKEN, response.body().getToken());
                                    Intent intent = new Intent(getActivity(), MainActivity.class);
                                    startActivity(intent);
                                    getActivity().finish();
                                } else {

                                    ToastUtil.show(getActivity(), "账号密码错误");
                                }

                            }

                            @Override
                            public void onError(Response<LoginEntity> response) {
                                DialogFactory.hideRequestDialog();
                                super.onError(response);
                            }
                        });
                break;
            case R.id.tv_login_forget_pass:
                Intent intent = new Intent(getActivity(), ForgetPassActivity.class);
                intent.putExtra(AppConstant.OBJECT, "form_login");
                startActivity(intent);
                break;
        }
    }
}
