package com.jitu.shop.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
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
import com.jitu.shop.util.ImagUtil;
import com.jitu.shop.util.SPUtil;
import com.jitu.shop.widget.ClearableEditText;
import com.socks.library.KLog;
import com.vondear.rxtools.RxImageUtils;
import com.vondear.rxtools.RxPhotoUtils;
import com.vondear.rxtools.view.dialog.RxDialogChooseImage;
import com.yalantis.ucrop.UCrop;
import com.yalantis.ucrop.UCropActivity;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.jpush.android.api.JPushInterface;
import jp.wasabeef.glide.transformations.CropCircleTransformation;

import static com.vondear.rxtools.view.dialog.RxDialogChooseImage.LayoutType.TITLE;

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
        ivCashauthPic1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (resultUri1 != null)
                    RxImageUtils.showBigImageView(context, resultUri1);
                return false;
            }
        });
        ivCashauthPic2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (resultUri1 != null)
                    RxImageUtils.showBigImageView(context, resultUri2);
                return false;
            }
        });
    }

    private int pic_type = 0;

    @OnClick({R.id.iv_back, R.id.iv_cash_auth_pic1, R.id.iv_cash_auth_pic2, R.id.rll_cash_auth_category,
            R.id.btn_cash_auth_save, R.id.iv_cash_auth_address_ding})
    public void onViewClicked(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.iv_cash_auth_pic1:
                pic_type = 1;
                initDialogChooseImage();
                break;
            case R.id.iv_cash_auth_pic2:
                pic_type = 2;
                initDialogChooseImage();
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

    private void initDialogChooseImage() {
        RxDialogChooseImage dialogChooseImage = new RxDialogChooseImage(this);
        dialogChooseImage.show();
    }

    private Uri resultUri1, resultUri2;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case RxPhotoUtils.GET_IMAGE_FROM_PHONE://选择相册之后的处理
                if (resultCode == RESULT_OK) {
//                    RxPhotoUtils.cropImage(ShopAuthActivity.this, data.getData());// 裁剪图片
                    initUCrop(data.getData());
                }

                break;
            case RxPhotoUtils.GET_IMAGE_BY_CAMERA://选择照相机之后的处理
                if (resultCode == RESULT_OK) {
//                    RxPhotoUtils.cropImage(ShopAuthActivity.this, RxPhotoUtils.imageUriFromCamera);// 裁剪图片
                    initUCrop(RxPhotoUtils.imageUriFromCamera);
                }

                break;
//            case RxPhotoUtils.CROP_IMAGE://普通裁剪后的处理
//                if (pic_type == 1) {
//                    Glide.with(context).
//                            load(RxPhotoUtils.cropImageUri).
//                            diskCacheStrategy(DiskCacheStrategy.RESULT).
//                            placeholder(R.drawable.ic_no_pic).
//                            priority(Priority.HIGH).
//                            error(R.drawable.ic_no_pic).
//                            dontAnimate().
//                            into(ivCashauthPic1);
//                } else {
//                    Glide.with(context).
//                            load(RxPhotoUtils.cropImageUri).
//                            diskCacheStrategy(DiskCacheStrategy.RESULT).
//                            placeholder(R.drawable.ic_no_pic).
//                            priority(Priority.HIGH).
//                            error(R.drawable.ic_no_pic).
//                            dontAnimate().
//                            into(ivCashauthPic2);
//                }
//                break;

            case UCrop.REQUEST_CROP://UCrop裁剪之后的处理
                if (resultCode == RESULT_OK) {

                    if (pic_type == 1) {
                        resultUri1 = UCrop.getOutput(data);
                        roadImageView(resultUri1, ivCashauthPic1);
                    } else if (pic_type == 2) {
                        resultUri2 = UCrop.getOutput(data);
                        roadImageView(resultUri2, ivCashauthPic2);
                    }
                } else if (resultCode == UCrop.RESULT_ERROR) {
                    final Throwable cropError = UCrop.getError(data);
                    cropError.printStackTrace();
                }
                break;
            case UCrop.RESULT_ERROR://UCrop裁剪错误之后的处理
                final Throwable cropError = UCrop.getError(data);
                cropError.printStackTrace();
                break;
            default:
                break;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    //从Uri中加载图片 并将其转化成File文件返回
    private File roadImageView(Uri uri, ImageView imageView) {
        ImagUtil.set(context, uri, imageView);
        return (new File(RxPhotoUtils.getImageAbsolutePath(this, uri)));
    }

    private void initUCrop(Uri uri) {
        //Uri destinationUri = RxPhotoUtils.createImagePathUri(this);

        SimpleDateFormat timeFormatter = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.CHINA);
        long time = System.currentTimeMillis();
        String imageName = timeFormatter.format(new Date(time));

        Uri destinationUri = Uri.fromFile(new File(getCacheDir(), imageName + ".jpg"));

        UCrop.Options options = new UCrop.Options();
        //设置裁剪图片可操作的手势
        options.setAllowedGestures(UCropActivity.SCALE, UCropActivity.ROTATE, UCropActivity.ALL);
        //设置隐藏底部容器，默认显示
        //options.setHideBottomControls(true);
        //设置toolbar颜色
        options.setToolbarColor(ActivityCompat.getColor(this, R.color.colorPrimary));
        //设置状态栏颜色
        options.setStatusBarColor(ActivityCompat.getColor(this, R.color.colorPrimaryDark));

        //开始设置
        //设置最大缩放比例
        options.setMaxScaleMultiplier(5);
        //设置图片在切换比例时的动画
        options.setImageToCropBoundsAnimDuration(666);
        //设置裁剪窗口是否为椭圆
//        options.setOvalDimmedLayer(true);
        //设置是否展示矩形裁剪框
//        options.setShowCropFrame(false);
        //设置裁剪框横竖线的宽度
//        options.setCropGridStrokeWidth(20);
        //设置裁剪框横竖线的颜色
//        options.setCropGridColor(Color.GREEN);
        //设置竖线的数量
//        options.setCropGridColumnCount(2);
        //设置横线的数量
//        options.setCropGridRowCount(1);

        UCrop.of(uri, destinationUri)
                .withAspectRatio(1, 1)
                .withMaxResultSize(1000, 1000)
                .withOptions(options)
                .start(this);
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
