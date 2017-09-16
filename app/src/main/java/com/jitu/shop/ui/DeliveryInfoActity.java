package com.jitu.shop.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jaredrummler.materialspinner.MaterialSpinner;
import com.jitu.shop.AppConstant;
import com.jitu.shop.R;
import com.jitu.shop.base.BaseActivity;
import com.jitu.shop.util.StringUtil;
import com.jitu.shop.util.ToastUtil;
import com.jitu.shop.widget.ClearableEditText;
import com.vondear.rxtools.RxActivityUtils;
import com.vondear.rxtools.activity.ActivityScanerCode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.github.xudaojie.qrcodelib.CaptureActivity;

/**
 * Created by jacky on 2017/9/13.
 */
public class DeliveryInfoActity extends BaseActivity {
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_submit)
    TextView tvSubmit;
    @BindView(R.id.md_spinner)
    MaterialSpinner spinner;
    @BindView(R.id.et_deliver_code)
    ClearableEditText etDeliverCode;
    @BindView(R.id.iv_deliver_code_qr)
    ImageView ivDeliverCodeQr;
    private List<String> list_type = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deliveryinfo);
        ButterKnife.bind(this);
        initview();
        initdate();
    }

    private void initdate() {
        list_type.add("申通快递");
        list_type.add("顺丰快递");
        list_type.add("圆通快递");
        list_type.add("韵达快递");
        list_type.add("中通快递");
        list_type.add("天天快递");
        list_type.add("优速快递");
        list_type.add("EMS");
        list_type.add("其他");
        spinner.setItems(list_type);
        spinner.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<String>() {
            @Override
            public void onItemSelected(MaterialSpinner view, int position, long id, String item) {
                ToastUtil.show(context, item);
            }
        });
    }

    private void initview() {

        setText(tvTitle, "填写快递单");

    }

    private int RESULT_QR = 0x13;

    @OnClick({R.id.iv_back, R.id.iv_deliver_code_qr})
    public void onViewClicked(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.iv_deliver_code_qr:
                intent = new Intent(context, CaptureActivity.class);
                startActivityForResult(intent, RESULT_QR);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == RESULT_QR) {
                String qr_code = data.getStringExtra("result");
                if (!StringUtil.isEmptyandnull(qr_code)) {
                    etDeliverCode.setText(qr_code);
                }
            }
        }
    }
}
