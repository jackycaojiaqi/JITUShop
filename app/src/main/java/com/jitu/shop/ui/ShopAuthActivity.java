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
import com.bigkoo.pickerview.OptionsPickerView;
import com.google.gson.Gson;
import com.jitu.shop.AppConstant;
import com.jitu.shop.R;
import com.jitu.shop.base.BaseActivity;
import com.jitu.shop.entity.AuthInfoEntity;
import com.jitu.shop.entity.BasePaserEntity;
import com.jitu.shop.entity.CityEntity;
import com.jitu.shop.interfaces.MyCallBack;
import com.jitu.shop.interfaces.UriCallBack;
import com.jitu.shop.util.ImagUtil;
import com.jitu.shop.util.NetClient;
import com.jitu.shop.util.PhotoUtil;
import com.jitu.shop.util.SPUtil;
import com.jitu.shop.util.StringUtil;
import com.jitu.shop.util.ToastUtil;
import com.jitu.shop.widget.ClearableEditText;
import com.lzy.okgo.model.HttpParams;
import com.lzy.okgo.model.Response;
import com.socks.library.KLog;
import com.vondear.rxtools.RxImageUtils;
import com.vondear.rxtools.RxPhotoUtils;
import com.vondear.rxtools.view.dialog.RxDialogChooseImage;
import com.yalantis.ucrop.UCrop;
import com.yalantis.ucrop.UCropActivity;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

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
    @BindView(R.id.tv_auth_pick_addr)
    TextView tvAuthPickAddr;
    @BindView(R.id.rll_auth_pick_addr)
    RelativeLayout rllAuthPickAddr;

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
        initdate();
    }

    private ArrayList<String> options1Items = new ArrayList<>();
    private ArrayList<ArrayList<String>> options2Items = new ArrayList<>();
    private ArrayList<ArrayList<ArrayList<String>>> options3Items = new ArrayList<>();
    private CityEntity cityentity;

    private void initdate() {

        QueryAuthInfo();
        QueryAreaInfo();
    }

    private String img1, img2;

    private void QueryAuthInfo() {
        //=============================获取认证信息
        HttpParams params = new HttpParams();
        params.put("token", (String) SPUtil.get(context, AppConstant.TOKEN, ""));
        NetClient.getInstance(AuthInfoEntity.class).Get(context, AppConstant.BASE_URL + AppConstant.URL_ADMINAUTHINFO, params, new MyCallBack() {
            @Override
            public void onFailure(int code) {

            }

            @Override
            public void onResponse(Response object) {
                AuthInfoEntity authInfoEntity = (AuthInfoEntity) object.body();
                if (authInfoEntity.getResult() != null) {
                    //图片1
                    if (!StringUtil.isEmptyandnull(authInfoEntity.getResult().getCartimg())) {
                        img1 = authInfoEntity.getResult().getCartimg();
                        img1 = img1.substring(0, img1.length() - 1);
                        ImagUtil.setnocache(context, AppConstant.IMAGPATH + img1, ivCashauthPic1);
                    }
                    //图片2
                    if (!StringUtil.isEmptyandnull(authInfoEntity.getResult().getOtherimg())) {
                        img2 = authInfoEntity.getResult().getOtherimg();
                        img2 = img2.substring(0, img2.length() - 1);
                        ImagUtil.setnocache(context, AppConstant.IMAGPATH + img2, ivCashauthPic2);
                    }
                    //商家姓名
                    etCashauthUserName.setText(StringUtil.isEmptyandnull(authInfoEntity.getResult().getCreatUser()) ? "未知" : authInfoEntity.getResult().getCreatUser());
                    //商家电话
                    etCashauthShopPhone.setText(StringUtil.isEmptyandnull(authInfoEntity.getResult().getPhone()) ? "未知" : authInfoEntity.getResult().getPhone());
                    //店铺名称
                    etCashauthShopName.setText(StringUtil.isEmptyandnull(authInfoEntity.getResult().getShopName()) ? "未知" : authInfoEntity.getResult().getShopName());
                    //店铺地址
                    etCashauthAddress.setText(StringUtil.isEmptyandnull(authInfoEntity.getResult().getAddress()) ? "未知" : authInfoEntity.getResult().getAddress());
                    //省份名称
                    String addr = authInfoEntity.getResult().getProvincesname() + " " + authInfoEntity.getResult().getCityname() + " " + authInfoEntity.getResult().getRegionname();
                    tvAuthPickAddr.setText(addr);
                    province_id = authInfoEntity.getResult().getProvincesid();
                    provinces_name = authInfoEntity.getResult().getProvincesname();
                    city_id = authInfoEntity.getResult().getCityid();
                    city_name = authInfoEntity.getResult().getCityname();
                    region_id = authInfoEntity.getResult().getRegionid();
                    region_name = authInfoEntity.getResult().getRegionname();
                    //商家分类名称
                    String class_nam = authInfoEntity.getResult().getClassname();
                    tvCashauthCategory.setText(class_nam);
                    classid = authInfoEntity.getResult().getClassid();
                    class_name = authInfoEntity.getResult().getClassname();
                }
            }
        });
    }

    private void QueryAreaInfo() {
        //=============================获取地区信息
        HttpParams params = new HttpParams();
        params.put("token", (String) SPUtil.get(context, AppConstant.TOKEN, ""));
        NetClient.getInstance(CityEntity.class).Get(context, AppConstant.BASE_URL + AppConstant.URL_ADMINQUERYALLPATH, params, new MyCallBack() {
            @Override
            public void onFailure(int code) {
                ToastUtil.show(context, "获取地区信息失败");
            }

            @Override
            public void onResponse(Response object) {
                cityentity = (CityEntity) object.body();
                //=======================省市区3级联动数据解析
                options1Items.clear();
                options2Items.clear();
                options3Items.clear();
                for (int i = 0; i < cityentity.getResult().size(); i++) {//遍历省份
                    ArrayList<String> CityList = new ArrayList<>();//该省的城市列表（第二级）
                    ArrayList<ArrayList<String>> Province_AreaList = new ArrayList<>();//该省的所有地区列表（第三极）
                    options1Items.add(cityentity.getResult().get(i).getProvinceName());
                    for (int c = 0; c < cityentity.getResult().get(i).getTB_City().size(); c++) {//遍历该省份的所有城市
                        String CityName = cityentity.getResult().get(i).getTB_City().get(c).getCityName();
                        CityList.add(CityName);//添加城市
                        ArrayList<String> City_AreaList = new ArrayList<>();//该城市的所有地区列表
                        //如果无地区数据，建议添加空字符串，防止数据为null 导致三个选项长度不匹配造成崩溃
                        if (cityentity.getResult().get(i).getTB_City().get(c).getTB_Region() == null
                                || cityentity.getResult().get(i).getTB_City().get(c).getTB_Region().size() == 0) {
                            City_AreaList.add("");
                        } else {
                            for (int d = 0; d < cityentity.getResult().get(i).getTB_City().get(c).getTB_Region().size(); d++) {//该城市对应地区所有数据
                                String AreaName = cityentity.getResult().get(i).getTB_City().get(c).getTB_Region().get(d).getCountyName();
                                City_AreaList.add(AreaName);//添加该城市所有地区数据
                            }
                        }
                        Province_AreaList.add(City_AreaList);//添加该省所有地区数据
                    }
                    options2Items.add(CityList);
                    options3Items.add(Province_AreaList);
                }
            }
        });
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
        mLocationClient.startLocation();
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
                if (resultUri1 != null) {
                    RxImageUtils.showBigImageView(context, resultUri1);
                } else if (!StringUtil.isEmptyandnull(img1)) {
                    PhotoUtil.getUri(context, AppConstant.IMAGPATH + img1, new UriCallBack() {
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

                return false;
            }
        });
        ivCashauthPic2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (resultUri2 != null) {
                    RxImageUtils.showBigImageView(context, resultUri2);
                } else if (!StringUtil.isEmptyandnull(img2)) {
                    PhotoUtil.getUri(context, AppConstant.IMAGPATH + img2, new UriCallBack() {
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
                return false;
            }
        });
    }

    private int pic_type = 0;
    private int province_id = 0;
    private int city_id = 0;
    private int region_id = 0;
    private int classid = 0;
    private String provinces_name = "";
    private String city_name = "";
    private String region_name = "";
    private String class_name = "";

    @OnClick({R.id.iv_back, R.id.iv_cash_auth_pic1, R.id.iv_cash_auth_pic2, R.id.rll_cash_auth_category,
            R.id.btn_cash_auth_save, R.id.iv_cash_auth_address_ding, R.id.rll_auth_pick_addr})
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
                startActivityForResult(intent, REQUEST_SHOP_TYPE);
                break;
            case R.id.btn_cash_auth_save:
                String owner_name = etCashauthUserName.getText().toString().trim();
                String shop_name = etCashauthShopName.getText().toString().trim();
                String shop_phone = etCashauthShopPhone.getText().toString().trim();
                String shop_addr = etCashauthAddress.getText().toString().trim();
                if (StringUtil.isEmptyandnull(owner_name) || StringUtil.isEmptyandnull(shop_name)
                        || StringUtil.isEmptyandnull(shop_phone) || StringUtil.isEmptyandnull(shop_addr)) {
                    ToastUtil.show(context, "请填写完整信息");
                    return;
                }
                if (lat == 0 || lon == 0) {
                    ToastUtil.show(context, "定位失败，请检查定位权限是否开启");
                    return;
                }
                if (classid == 0) {
                    ToastUtil.show(context, "请选择店铺类型");
                    return;
                }
                if (province_id == 0 || city_id == 0 || region_id == 0) {
                    ToastUtil.show(context, "请选择省市区");
                    return;
                }
                Map<String, String> map = new HashMap<>();
                map.put("token", (String) SPUtil.get(context, AppConstant.TOKEN, ""));
                map.put("name", owner_name);
                map.put("phone", shop_phone);
                map.put("shopname", shop_name);
                map.put("address", shop_addr);
                map.put("provincesid", String.valueOf(province_id));
                map.put("provincesname", provinces_name);
                map.put("cityid", String.valueOf(city_id));
                map.put("cityname", city_name);
                map.put("regionid", String.valueOf(region_id));
                map.put("regionname", region_name);
                map.put("x", String.valueOf(lat));
                map.put("y", String.valueOf(lon));
                map.put("classid", String.valueOf(classid));//类目ID
                map.put("classname", class_name);//类目名称
                HttpParams httpParams = new HttpParams();
                if (resultUri1 != null)
                    httpParams.put("card", new File(RxPhotoUtils.getImageAbsolutePath(this, resultUri1)));//身份证
                if (resultUri2 != null)
                    httpParams.put("other", new File(RxPhotoUtils.getImageAbsolutePath(this, resultUri2)));//营业执照
                NetClient.getInstance(BasePaserEntity.class).Post(context, AppConstant.BASE_URL + AppConstant.URL_ADMINAUTHENTICATION, map, httpParams, new MyCallBack() {
                    @Override
                    public void onFailure(int code) {

                    }

                    @Override
                    public void onResponse(Response object) {
                        BasePaserEntity result = (BasePaserEntity) object.body();
                        if (result.getErrorCode() == 0) {
                            ToastUtil.show(context, "提交认证信息成功");
                            finish();
                        }

                    }
                });
                break;
            case R.id.iv_cash_auth_address_ding:
                mLocationClient.startLocation();
                break;
            case R.id.rll_auth_pick_addr:
                //条件选择器
                OptionsPickerView pvOptions = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3, View v) {
                        //返回的分别是三个级别的选中位置
                        if (cityentity != null) {
                            province_id = cityentity.getResult().get(options1).getProvinceID();
                            provinces_name = cityentity.getResult().get(options1).getProvinceName();
                            city_id = cityentity.getResult().get(options1).getTB_City().get(option2).getCityID();
                            city_name = cityentity.getResult().get(options1).getTB_City().get(option2).getCityName();
                            region_id = cityentity.getResult().get(options1).getTB_City().get(option2).getTB_Region().get(options3).getCountyID();
                            region_name = cityentity.getResult().get(options1).getTB_City().get(option2).getTB_Region().get(options3).getCountyName();

                            tvAuthPickAddr.setText(cityentity.getResult().get(options1).getProvinceName() + " "
                                    + cityentity.getResult().get(options1).getTB_City().get(option2).getCityName() + " "
                                    + cityentity.getResult().get(options1).getTB_City().get(option2).getTB_Region().get(options3).getCountyName());
                        }
                    }
                }).build();
                pvOptions.setPicker(options1Items, options2Items, options3Items);
                pvOptions.show();
                break;
        }
    }

    private void initDialogChooseImage() {
        RxDialogChooseImage dialogChooseImage = new RxDialogChooseImage(this);
        dialogChooseImage.show();
    }

    private Uri resultUri1, resultUri2;
    private final int REQUEST_SHOP_TYPE = 22;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case RxPhotoUtils.GET_IMAGE_FROM_PHONE://选择相册之后的处理
                if (resultCode == RESULT_OK) {
                    initUCrop(data.getData());
                }

                break;
            case RxPhotoUtils.GET_IMAGE_BY_CAMERA://选择照相机之后的处理
                if (resultCode == RESULT_OK) {
                    initUCrop(RxPhotoUtils.imageUriFromCamera);
                }

                break;

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
            case REQUEST_SHOP_TYPE:
                classid = data.getIntExtra(AppConstant.TYPE, 0);
                class_name = data.getStringExtra(AppConstant.USERNAME);
                tvCashauthCategory.setText(class_name);
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
                .withMaxResultSize(800, 800)
                .withOptions(options)
                .start(this);
    }

    private double lat = 0;
    private double lon = 0;
    private String province;

    @Override
    public void onLocationChanged(AMapLocation aMapLocation) {
        if (aMapLocation.getErrorCode() == 0) {
            lat = aMapLocation.getLatitude();
            lon = aMapLocation.getLongitude();
            province = aMapLocation.getProvince();
            SPUtil.put(context, AppConstant.LAT, lat);
            SPUtil.put(context, AppConstant.LON, lon);
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
