package com.jitu.shop.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.library.BandCardEditText;
import com.jitu.shop.AppConstant;
import com.jitu.shop.R;
import com.jitu.shop.base.BaseActivity;
import com.jitu.shop.entity.BasePaserEntity;
import com.jitu.shop.interfaces.MyCallBack;
import com.jitu.shop.util.DialogFactory;
import com.jitu.shop.util.NetClient;
import com.jitu.shop.util.SPUtil;
import com.jitu.shop.util.StringUtil;
import com.jitu.shop.util.ToastUtil;
import com.jitu.shop.widget.BankEditText;
import com.jitu.shop.widget.ClearableEditText;
import com.lzy.okgo.model.HttpParams;
import com.lzy.okgo.model.Response;
import com.socks.library.KLog;
import com.vondear.rxtools.view.RxToast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jacky on 2017/9/25.
 */
public class AddCardActivity extends BaseActivity {
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_submit)
    TextView tvSubmit;
    @BindView(R.id.et_card_num)
    BankEditText etCardNum;
    @BindView(R.id.et_card_name)
    EditText etCardName;
    @BindView(R.id.et_card_bank)
    EditText etCardBank;
    @BindView(R.id.et_card_address)
    EditText etCardAddress;
    @BindView(R.id.btn_binding)
    Button btnBindingCard;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_card);
        ButterKnife.bind(this);
        initview();
    }

    private void initview() {
        setText(tvTitle, "绑定银行卡");
        etCardNum.setBankCardListener(new BandCardEditText.BankCardListener() {
            @Override
            public void success(String name) {
                etCardBank.setText(name + " ");
            }

            @Override
            public void failure() {

            }
        });
    }

    @OnClick({R.id.iv_back, R.id.btn_binding})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.btn_binding:
                DialogFactory.showRequestDialog(context);
                String card_num = etCardNum.getText().toString().trim();
                if (StringUtil.isEmptyandnull(card_num) || card_num.length() < 17) {
                    RxToast.error("银行卡错误");
                    return;
                }
                card_num = card_num.replace(" ", "");
                String bank_name = etCardBank.getText().toString().trim();
                if (StringUtil.isEmptyandnull(bank_name)) {
                    RxToast.error("银行名不能为空");
                }
                String bank_address = etCardAddress.getText().toString().trim();
                if (StringUtil.isEmptyandnull(bank_address)) {
                    RxToast.error("银行名开户地址不能为空");
                }
                String name = etCardName.getText().toString().trim();
                if (StringUtil.isEmptyandnull(name)) {
                    RxToast.error("持卡人姓名不能为空");
                }

                HttpParams params = new HttpParams();
                params.put("token", (String) SPUtil.get(context, AppConstant.TOKEN, ""));
                params.put("cardnum", card_num);
                params.put("bankname", bank_name);
                params.put("bankaddress", bank_address);
                params.put("name", name);
                NetClient.getInstance(BasePaserEntity.class).Get(context, AppConstant.URL_BINDCARD, params, new MyCallBack() {
                    @Override
                    public void onFailure(int code) {
                        DialogFactory.hideRequestDialog();
                    }

                    @Override
                    public void onResponse(Response object) {
                        DialogFactory.hideRequestDialog();
                        BasePaserEntity entity = (BasePaserEntity) object.body();
                        if (entity.getErrorCode() == 0) {
                            RxToast.success("添加成功");
                            finish();
                        }
                    }
                });
                break;
        }
    }
}
