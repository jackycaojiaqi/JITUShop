package com.jitu.shop.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.jaredrummler.materialspinner.MaterialSpinner;
import com.jitu.shop.AppConstant;
import com.jitu.shop.R;
import com.jitu.shop.base.BaseActivity;
import com.jitu.shop.entity.BasePaserEntity;
import com.jitu.shop.entity.DeliverCompanyEntity;
import com.jitu.shop.interfaces.MyCallBack;
import com.jitu.shop.util.DialogFactory;
import com.jitu.shop.util.NetClient;
import com.jitu.shop.util.SPUtil;
import com.jitu.shop.util.StringUtil;
import com.jitu.shop.widget.ClearableEditText;
import com.lzy.okgo.model.HttpParams;
import com.lzy.okgo.model.Response;
import com.vondear.rxtools.view.RxToast;

import org.simple.eventbus.EventBus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @BindView(R.id.btn_sure_to_deliver)
    Button btnSureToDeliver;
    private List<String> list_type = new ArrayList<>();

    private List<DeliverCompanyEntity.ResultBean> list_people = new ArrayList<>();
    private int deliver_id = 0;
    private String order_id = "";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deliveryinfo);
        ButterKnife.bind(this);
        order_id = getIntent().getStringExtra(AppConstant.OBJECT);
        initview();
        initdate();
    }

    private void initdate() {

        DialogFactory.showRequestDialog(context);
        Map<String, String> map = new HashMap<>();
        map.put("token", (String) SPUtil.get(context, AppConstant.TOKEN, ""));
        NetClient.getInstance(DeliverCompanyEntity.class).Get(context, AppConstant.URL_QueryLogistics, map, new MyCallBack() {
            @Override
            public void onResponse(Response object) {
                DialogFactory.hideRequestDialog();
                DeliverCompanyEntity obj = (DeliverCompanyEntity) object.body();
                if (obj.getErrorCode() == 0) {
                    list_people = obj.getResult();
                    for (DeliverCompanyEntity.ResultBean list_person : list_people) {
                        list_type.add(list_person.getCM_Name());
                        spinner.setItems(list_type);
                        spinner.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<String>() {
                            @Override
                            public void onItemSelected(MaterialSpinner view, int position, long id, String item) {
                                for (DeliverCompanyEntity.ResultBean list_person : list_people) {
                                    if (list_person.getCM_Name().equals(item)) {
                                        deliver_id = list_person.getCM_LogisticsId();
                                    }
                                }

                            }
                        });
                    }
                }
            }

            @Override
            public void onFailure(int code) {
                DialogFactory.hideRequestDialog();
            }
        });


    }

    private void initview() {

        setText(tvTitle, "填写快递单");

    }

    private int RESULT_QR = 0x13;

    @OnClick({R.id.iv_back, R.id.iv_deliver_code_qr, R.id.btn_sure_to_deliver})
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
            case R.id.btn_sure_to_deliver:
                String deliver_code = etDeliverCode.getText().toString().trim();
                if (deliver_id == 0) {
                    RxToast.info("请选择快递公司");
                }
                if (StringUtil.isEmptyandnull(deliver_code)) {
                    RxToast.info("请输入快递单号");
                }
                SureToDeliver(deliver_code, deliver_id);
                break;
        }
    }

    private void SureToDeliver(String deliver_code, int deliver_id) {

        DialogFactory.showRequestDialog(context);
        HttpParams params = new HttpParams();
        params.put("token", (String) SPUtil.get(context, AppConstant.TOKEN, ""));
        params.put("orderid", order_id);
        params.put("type", "1");
        params.put("logisticsnum", deliver_code);
        params.put("logisticsid", deliver_id);
        params.put("courierid", "0");
        NetClient.getInstance(BasePaserEntity.class).Get(context, AppConstant.URL_DeliverGoods, params, new MyCallBack() {
            @Override
            public void onResponse(Response object) {
                DialogFactory.hideRequestDialog();
                BasePaserEntity obj = new BasePaserEntity();
                if (obj.getErrorCode() == 0) {
                    EventBus.getDefault().post("orderListFragment_Refresh", "orderListFragment_Refresh");
                    finish();
                }
            }

            @Override
            public void onFailure(int code) {
                DialogFactory.hideRequestDialog();
            }
        });
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
