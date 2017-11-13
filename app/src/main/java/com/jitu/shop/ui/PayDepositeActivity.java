package com.jitu.shop.ui;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.alipay.sdk.app.PayTask;
import com.jitu.shop.AppConstant;
import com.jitu.shop.R;
import com.jitu.shop.base.BaseActivity;
import com.jitu.shop.util.ToastUtil;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.vondear.rxtools.interfaces.onRequestListener;
import com.vondear.rxtools.model.alipay.AliPayModel;
import com.vondear.rxtools.model.alipay.AliPayTools;
import com.vondear.rxtools.model.alipay.PayResult;
import com.vondear.rxtools.model.wechat.pay.WechatPayTools;
import com.vondear.rxtools.view.RxToast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.jpush.android.api.JPushInterface;

/**
 * Created by jacky on 2017/8/29.
 */
public class PayDepositeActivity extends BaseActivity {
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_submit)
    TextView tvSubmit;
    @BindView(R.id.tv_pay_amount)
    TextView tvPayAmount;
    @BindView(R.id.tv_pay_project_name)
    TextView tvPayProjectName;
    @BindView(R.id.tv_pay_getmoney_name)
    TextView tvPayGetmoneyName;
    @BindView(R.id.tv_pay_username)
    TextView tvPayUsername;
    @BindView(R.id.btn_pay_wechat)
    Button btnPayWechat;
    @BindView(R.id.btn_pay_zhifubao)
    Button btnPayZhifubao;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_deposite);
        ButterKnife.bind(this);
        api = WXAPIFactory.createWXAPI(this, AppConstant.WEICHAT_ID);
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

    final String orderInfo = " 123";   // 订单信息
    final int SDK_PAY_FLAG = 123;
    private IWXAPI api;

    @OnClick({R.id.iv_back, R.id.btn_pay_wechat, R.id.btn_pay_zhifubao})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.btn_pay_wechat:
                PayReq req = new PayReq();
                JSONObject json = null;
                try {
                    json = new JSONObject("12");
                    req.appId = json.getString("appid");
                    req.partnerId = json.getString("partnerid");
                    req.prepayId = json.getString("prepayid");
                    req.nonceStr = json.getString("noncestr");
                    req.timeStamp = json.getString("timestamp");
                    req.packageValue = json.getString("package");
                    req.sign = json.getString("sign");
                    req.extData = "app data"; // optional
                    api.sendReq(req);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                break;
            case R.id.btn_pay_zhifubao:
                Runnable payRunnable = new Runnable() {
                    @Override
                    public void run() {
                        PayTask alipay = new PayTask(PayDepositeActivity.this);
                        Map<String, String> result = alipay.payV2(orderInfo, true);
                        Message msg = new Message();
                        msg.what = SDK_PAY_FLAG;
                        msg.obj = result;
                        mHandler.sendMessage(msg);
                    }
                };
                // 必须异步调用
                Thread payThread = new Thread(payRunnable);
                payThread.start();
                break;
        }
    }

    private Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case SDK_PAY_FLAG: {
                    PayResult payResult = new PayResult((Map<String, String>) msg.obj);
                    String resultStatus = payResult.getResultStatus();
                    if (TextUtils.equals(resultStatus, "9000")) {
                        // 该笔订单是否真实支付成功，需要依赖服务端的异步通知。
                        RxToast.showToast(getString(R.string.pay_success));
                    } else {
                        // 该笔订单真实的支付结果，需要依赖服务端的异步通知。
                        RxToast.showToast(getString(R.string.pay_fail));
                    }
                    break;
                }

                default:
                    break;
            }
        }
    };
}
