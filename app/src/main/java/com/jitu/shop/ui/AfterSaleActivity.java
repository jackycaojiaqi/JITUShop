package com.jitu.shop.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.jitu.shop.AppConstant;
import com.jitu.shop.R;
import com.jitu.shop.base.BaseActivity;
import com.jitu.shop.entity.AfterSaleInfoEntity;
import com.jitu.shop.entity.BasePaserEntity;
import com.jitu.shop.interfaces.MyCallBack;
import com.jitu.shop.interfaces.UriCallBack;
import com.jitu.shop.util.DialogFactory;
import com.jitu.shop.util.ImagUtil;
import com.jitu.shop.util.NetClient;
import com.jitu.shop.util.PhotoUtil;
import com.jitu.shop.util.SPUtil;
import com.jitu.shop.util.StringUtil;
import com.jitu.shop.util.ToastUtil;
import com.lzy.okgo.model.HttpParams;
import com.lzy.okgo.model.Response;
import com.vondear.rxtools.RxImageUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jacky on 2017/9/14.
 */
public class AfterSaleActivity extends BaseActivity {
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_submit)
    TextView tvSubmit;
    @BindView(R.id.tv_after_sale_name)
    TextView tvAfterSaleName;
    @BindView(R.id.tv_after_sale_phone)
    TextView tvAfterSalePhone;
    @BindView(R.id.tv_after_sale_order_id)
    TextView tvAfterSaleOrderId;
    @BindView(R.id.tv_after_sale_addr)
    TextView tvAfterSaleAddr;
    @BindView(R.id.tv_after_sale_deliver_price)
    TextView tvAfterSaleDeliverPrice;
    @BindView(R.id.tv_after_sale_refund_num)
    TextView tvAfterSaleRefundNum;
    @BindView(R.id.tv_after_sale_refund_price)
    TextView tvAfterSaleRefundPrice;
    @BindView(R.id.tv_after_sale_reason)
    TextView tvAfterSaleReason;
    @BindView(R.id.tv_after_sale_require)
    TextView tvAfterSaleRequire;
    @BindView(R.id.tv_after_sale_goods_state)
    TextView tvAfterSaleGoodsState;
    @BindView(R.id.tv_after_sale_other)
    TextView tvAfterSaleOther;
    @BindView(R.id.tv_after_sale_action1)
    TextView tvAfterSaleAction1;
    @BindView(R.id.tv_after_sale_action2)
    TextView tvAfterSaleAction2;
    @BindView(R.id.ll_commondity_action)
    LinearLayout llCommondityAction;
    @BindView(R.id.iv_after_sale_goods_pic1)
    ImageView ivAfterSaleGoodsPic1;
    @BindView(R.id.iv_after_sale_goods_pic2)
    ImageView ivAfterSaleGoodsPic2;
    @BindView(R.id.iv_after_sale_goods_pic3)
    ImageView ivAfterSaleGoodsPic3;
    @BindView(R.id.rll_after_sale_state)
    RelativeLayout rllAfterSaleState;
    private String service_id;
    private String service_type = "0";
    private AfterSaleInfoEntity obj;
    private String[] list_img;
    private int CM_CirculationState = 0;//0没有流转，1买家寄回商品，2商家收到商品，3商家寄出更换商品，4买家收到商品，5退款，6完成

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_sale);
        ButterKnife.bind(this);
        service_id = getIntent().getStringExtra(AppConstant.OBJECT);
        service_type = getIntent().getStringExtra(AppConstant.TYPE);
        initview();
        initDate();
    }

    private void initview() {
        setText(tvTitle, "售后处理");
    }

    private void initDate() {
        DialogFactory.showRequestDialog(context);
        HttpParams params = new HttpParams();
        params.put("token", (String) SPUtil.get(context, AppConstant.TOKEN, ""));
        params.put("serviceid", service_id);
        NetClient.getInstance(AfterSaleInfoEntity.class).Get(context, AppConstant.URL_QueryAfterSalesProcess, params, new MyCallBack() {
            @Override
            public void onResponse(Response object) {
                DialogFactory.hideRequestDialog();
                obj = (AfterSaleInfoEntity) object.body();
                if (obj.getErrorCode() == 0) {
                    //订单流转状态
                    CM_CirculationState = obj.getResult().getCM_CirculationState();
//                    if (CM_CirculationState != 0) {
//                        rllAfterSaleState.setVisibility(View.VISIBLE);
//                        if (CM_CirculationState == 1) {
//                            tvAfterSaleGoodsState.setText("买家寄回商品");
//                        } else if (CM_CirculationState == 2) {
//                            tvAfterSaleGoodsState.setText("商家收到商品");
//                        } else if (CM_CirculationState == 3) {
//                            tvAfterSaleGoodsState.setText("商家寄出更换商品");
//                        } else if (CM_CirculationState == 4) {
//                            tvAfterSaleGoodsState.setText("买家收到商品");
//                        } else if (CM_CirculationState == 5) {
//                            tvAfterSaleGoodsState.setText("退款");
//                        } else if (CM_CirculationState == 6) {
//                            tvAfterSaleGoodsState.setText("完成");
//                        }
//                    }
                    //收货人
                    tvAfterSaleName.setText(obj.getResult().getConsignee() + " ");
                    //电话
                    tvAfterSalePhone.setText(obj.getResult().getPhone() + " ");
                    //订单编号
                    tvAfterSaleOrderId.setText(obj.getResult().getCM_OrderId() + " ");
                    //地址
                    tvAfterSaleAddr.setText(obj.getResult().getAddr() + " ");
                    //运费
                    tvAfterSaleDeliverPrice.setText("¥" + obj.getResult().getCM_SendMoney());
                    //退款编号
                    tvAfterSaleRefundNum.setText(obj.getResult().getCM_ServiceId() + " ");
                    //退款金额
                    tvAfterSaleRefundPrice.setText("¥" + obj.getResult().getAmount());
                    //原因
                    tvAfterSaleReason.setText(obj.getResult().getCM_Reason() + " ");
                    //要求
                    if (service_type.equals("1")) {
                        tvAfterSaleRequire.setText("退款");
                    } else if (service_type.equals("2")) {
                        tvAfterSaleRequire.setText("退货退款");
                    } else if (service_type.equals("3")) {
                        tvAfterSaleRequire.setText("换货");
                    }
                    //说明
                    tvAfterSaleOther.setText(obj.getResult().getCM_Reason() + " ");
                    //说明图片
                    String img_paths = obj.getResult().getCM_ImgPath();
                    if (!StringUtil.isEmptyandnull(img_paths)) {
                        list_img = img_paths.split("\\|");
                        for (int i = 0; i < list_img.length; i++) {
                            if (i == 0)
                                ImagUtil.setRound(context, AppConstant.IMAGPATH + list_img[i], ivAfterSaleGoodsPic1, 5);
                            else if (i == 1)
                                ImagUtil.setRound(context, AppConstant.IMAGPATH + list_img[i], ivAfterSaleGoodsPic2, 5);
                            else if (i == 2)
                                ImagUtil.setRound(context, AppConstant.IMAGPATH + list_img[i], ivAfterSaleGoodsPic3, 5);
                        }
                    }
                }
            }

            @Override
            public void onFailure(int code) {
                DialogFactory.hideRequestDialog();
            }
        });
    }


    @OnClick({R.id.iv_back, R.id.tv_after_sale_phone, R.id.tv_after_sale_action1, R.id.tv_after_sale_action2
            , R.id.iv_after_sale_goods_pic1, R.id.iv_after_sale_goods_pic2, R.id.iv_after_sale_goods_pic3})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_after_sale_phone:
                if (!StringUtil.isEmptyandnull(obj.getResult().getPhone())) {
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + obj.getResult().getPhone()));
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }
                break;
            case R.id.tv_after_sale_action1:
                new MaterialDialog.Builder(this)
                        .content("确定同意该售后申请？")
                        .positiveText("确定")
                        .negativeText("取消")
                        .onPositive(new MaterialDialog.SingleButtonCallback() {
                            @Override
                            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                agreeAfterSale(service_type);
                            }
                        })
                        .onNegative(new MaterialDialog.SingleButtonCallback() {
                            @Override
                            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                dialog.dismiss();
                            }
                        }).show();

                break;
            case R.id.tv_after_sale_action2:
                new MaterialDialog.Builder(this)
                        .content("确定不同意该售后申请？")
                        .positiveText("确定")
                        .negativeText("取消")
                        .onPositive(new MaterialDialog.SingleButtonCallback() {
                            @Override
                            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                dontAgree();
                            }
                        })
                        .onNegative(new MaterialDialog.SingleButtonCallback() {
                            @Override
                            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                dialog.dismiss();
                            }
                        }).show();

                break;
            case R.id.iv_after_sale_goods_pic1:
                if (list_img.length > 1)
                    showBigImg(AppConstant.IMAGPATH + list_img[0]);
                break;
            case R.id.iv_after_sale_goods_pic2:
                if (list_img.length >= 2)
                    showBigImg(AppConstant.IMAGPATH + list_img[1]);
                break;
            case R.id.iv_after_sale_goods_pic3:
                if (list_img.length >= 3)
                    showBigImg(AppConstant.IMAGPATH + list_img[2]);
                break;
        }
    }

    /**
     * 同意售后
     *
     * @param service_type 根据type区分售后类型  1、退款    2、3 退货退款 和换货
     */
    private void agreeAfterSale(final String service_type) {
        DialogFactory.showRequestDialog(context);
        String url = "";
        HttpParams params = new HttpParams();
        if (service_type.equals("2") || service_type.equals("3")) {
            url = AppConstant.URL_AgreeService;
            params.put("token", (String) SPUtil.get(context, AppConstant.TOKEN, ""));
            params.put("serviceid", service_id);
            params.put("remark", " ");
        } else if (service_type.equals("1")) {
            url = AppConstant.URL_Refund;
            params.put("token", (String) SPUtil.get(context, AppConstant.TOKEN, ""));
            params.put("serviceid", service_id);
        }
        NetClient.getInstance(BasePaserEntity.class).Get(context, url, params, new MyCallBack() {
            @Override
            public void onResponse(Response object) {
                DialogFactory.hideRequestDialog();
                BasePaserEntity obj = (BasePaserEntity) object.body();
                if (obj.getErrorCode() == 0) {
                    ToastUtil.show(context, "操作成功");
                    //如果是退货退款，先调用 service_type=2 再调用 service_type =1 UI款
                    if (service_type.equals("2")) {
                        agreeAfterSale("1");
                    } else {
                        finish();
                    }
                }
            }

            @Override
            public void onFailure(int code) {
                DialogFactory.hideRequestDialog();
            }
        });
    }

    /**
     * 状态为可以取消的时候，关闭售后
     */
    private void dontAgree() {
        DialogFactory.showRequestDialog(context);
        HttpParams params = new HttpParams();
        params.put("token", (String) SPUtil.get(context, AppConstant.TOKEN, ""));
        params.put("serviceid", service_id);
        params.put("remark", " ");
        NetClient.getInstance(BasePaserEntity.class).Get(context, AppConstant.URL_CloseService, params, new MyCallBack() {
            @Override
            public void onResponse(Response object) {
                DialogFactory.hideRequestDialog();
                BasePaserEntity obj = (BasePaserEntity) object.body();
                if (obj.getErrorCode() == 0) {
                    ToastUtil.show(context, "关闭售后成功");
                    finish();
                }
            }

            @Override
            public void onFailure(int code) {
                DialogFactory.hideRequestDialog();
            }
        });

    }

    /**
     * 显示大图
     *
     * @param s
     */
    private void showBigImg(String s) {
        PhotoUtil.getUri(context, s, new UriCallBack() {
            @Override
            public void onResponse(final Uri uri) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        RxImageUtils.showBigImageView(context, uri);
                    }
                });
            }
        });
    }
}
