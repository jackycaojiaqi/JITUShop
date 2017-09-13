package com.jitu.shop.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.jitu.shop.AppConstant;
import com.jitu.shop.R;
import com.jitu.shop.base.BaseActivity;
import com.jitu.shop.util.SPUtil;
import com.jitu.shop.widget.ClearableEditText;
import com.socks.library.KLog;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.jpush.android.api.JPushInterface;

/**
 * Created by jacky on 2017/8/29.
 */
public class ShopAuthActivity extends BaseActivity implements AMapLocationListener {
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_submit)
    TextView tvSubmit;
    @BindView(R.id.iv_cash_auth_pic1)
    ImageView ivCashauthPic1;
    @BindView(R.id.iv_cash_auth_pic2)
    ImageView ivCashauthPic2;
    @BindView(R.id.et_cash_auth_user_name)
    ClearableEditText etCashauthUserName;
    @BindView(R.id.et_cash_auth_shop_phone)
    ClearableEditText etCashauthShopPhone;
    @BindView(R.id.et_cash_auth_shop_name)
    ClearableEditText etCashauthShopName;
    @BindView(R.id.et_cash_auth_address)
    ClearableEditText etCashauthAddress;
    @BindView(R.id.tv_cash_auth_category)
    TextView tvCashauthCategory;
    @BindView(R.id.rll_cash_auth_category)
    RelativeLayout rllCashauthCategory;
    @BindView(R.id.btn_cash_auth_save)
    Button btnCashauthSave;
    @BindView(R.id.iv_cash_auth_address_ding)
    ImageView ivCashAuthAddressDing;

    //声明AMapLocationClient类对象
    public AMapLocationClient mLocationClient = null;
    public AMapLocationClientOption mLocationOption = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopauth);
        ButterKnife.bind(this);
        initview();
        initlocation();
    }

    private void initlocation() {
        //初始化定位
        mLocationClient = new AMapLocationClient(getApplicationContext());

        //设置定位回调监听
        mLocationClient.setLocationListener(this);
        mLocationOption = new AMapLocationClientOption();
        mLocationOption.setOnceLocation(true);
        mLocationOption.setOnceLocationLatest(true);
        mLocationOption.setNeedAddress(true);
        mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        mLocationClient.setLocationOption(mLocationOption);
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
        setText(tvTitle, "实体认证");
    }

    @OnClick({R.id.iv_back, R.id.iv_cash_auth_pic1, R.id.iv_cash_auth_pic2, R.id.rll_cash_auth_category,
            R.id.btn_cash_auth_save, R.id.iv_cash_auth_address_ding})
    public void onViewClicked(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.iv_cash_auth_pic1:
                break;
            case R.id.iv_cash_auth_pic2:
                break;
            case R.id.rll_cash_auth_category:
                intent = new Intent(context, CheckShopTypeActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_cash_auth_save:
                break;
            case R.id.iv_cash_auth_address_ding:
                mLocationClient.startLocation();
                break;
        }
    }


    @Override
    public void onLocationChanged(AMapLocation aMapLocation) {
        if (aMapLocation.getErrorCode() == 0) {
            SPUtil.put(context, AppConstant.LAT, aMapLocation.getLatitude());
            SPUtil.put(context, AppConstant.LON, aMapLocation.getLatitude());
            etCashauthAddress.setText(aMapLocation.getAddress());
            //可在其中解析amapLocation获取相应内容。
        } else {
            //定位失败时，可通过ErrCode（错误码）信息来确定失败的原因，errInfo是错误信息，详见错误码表。
            KLog.e("location Error, ErrCode:"
                    + aMapLocation.getErrorCode() + ", errInfo:"
                    + aMapLocation.getErrorInfo());
        }
    }
}
