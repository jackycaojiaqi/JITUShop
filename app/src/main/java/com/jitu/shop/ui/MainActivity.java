package com.jitu.shop.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jitu.shop.AppConstant;
import com.jitu.shop.R;
import com.jitu.shop.adapter.MainMenuAdapter;
import com.jitu.shop.base.BaseActivity;
import com.jitu.shop.callback.JsonCallBack;
import com.jitu.shop.entity.BasePaserEntity;
import com.jitu.shop.entity.MainMenuEntity;
import com.jitu.shop.entity.StateEntity;
import com.jitu.shop.interfaces.MyCallBack;
import com.jitu.shop.util.GlideImageLoader;
import com.jitu.shop.util.LogUtil;
import com.jitu.shop.util.NetClient;
import com.jitu.shop.util.SPUtil;
import com.jitu.shop.util.ToastUtil;
import com.jitu.shop.widget.DividerItemDecoration;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.HttpParams;
import com.lzy.okgo.model.Response;
import com.socks.library.KLog;
import com.tencent.bugly.beta.Beta;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.jpush.android.api.JPushInterface;

public class MainActivity extends BaseActivity {
    @BindView(R.id.banner)
    Banner banner;
    @BindView(R.id.rv_main)
    RecyclerView rvMain;
    @BindView(R.id.iv_setting)
    ImageView ivSetting;
    @BindView(R.id.srl_main)
    SwipeRefreshLayout srlMain;
    private List<String> images = new ArrayList<>();
    private List<MainMenuEntity.ResultBean.MenusBean> list = new ArrayList<>();
    private List<MainMenuEntity.ResultBean.LoopsBean> list_loop = new ArrayList<>();
    private BaseQuickAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initview();
        initdate();
        JPushInterface.requestPermission(context);//请求权限
        JPushInterface.getAlias(context, 0);
        KLog.e("token:" + SPUtil.get(context, AppConstant.TOKEN, ""));
        Beta.checkUpgrade(false, false);
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
        srlMain.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                initdate();
            }
        });
        srlMain.setProgressViewOffset(true, 10, 100);
        //设置adapter
        adapter = new MainMenuAdapter(R.layout.item_main_menu, list);
        //设置布局管理器
        rvMain.setLayoutManager(new GridLayoutManager(context, 3));
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                switch (position) {
                    case 0:
                        startActivity(new Intent(context, OrderManageListActivity.class));
                        break;
                    case 1:
                        startActivity(new Intent(context, CommodityManageListActivity.class));
                        break;
                    case 2:
                        startActivity(new Intent(context, CashManageActivity.class));
                        break;
                    case 3:
                        startActivity(new Intent(context, ShopCenterActivity.class));
                        break;
                    case 4:
                        startActivity(new Intent(context, ShopInfoActivity.class));
                        break;
                    case 5:
                        startActivity(new Intent(context, MessageActivity.class));
                        break;
                }
            }
        });
        adapter.bindToRecyclerView(rvMain);
        rvMain.setAdapter(adapter);
        //水平分割线
        rvMain.addItemDecoration(new DividerItemDecoration(
                context, DividerItemDecoration.VERTICAL_LIST, 10, getResources().getColor(R.color.white)));
    }

    private void initdate() {
        OkGo.<MainMenuEntity>get(AppConstant.BASE_URL + AppConstant.URL_QUERYMENUS)
                .tag(this)
                .execute(new JsonCallBack<MainMenuEntity>(MainMenuEntity.class) {
                    @Override
                    public void onSuccess(Response<MainMenuEntity> response) {
                        initOtherDate();
                        srlMain.setRefreshing(false);
                        if (response.body().getErrorCode() == 0) {
                            if (response.body().getResult() != null)
                                if (response.body().getResult().getMenus() != null)
                                    if (response.body().getResult().getMenus().size() > 0) {
                                        list = response.body().getResult().getMenus();

                                        adapter.setNewData(list);
                                        list_loop.clear();
                                        images.clear();
                                        list_loop = response.body().getResult().getLoops();
                                        //===================设置轮播图
                                        for (int i = 0; i < list_loop.size(); i++) {
                                            images.add(AppConstant.IMAGPATH + list_loop.get(i).getCM_ImgPath());
                                        }
                                        banner.setImageLoader(new GlideImageLoader());
                                        banner.setImages(images);
                                        //banner设置方法全部调用完毕时最后调用
                                        banner.start();
                                        //=================轮播图结束

                                    }
                        } else {
                            ToastUtil.show(context, "账号密码错误");
                        }
                    }

                    @Override
                    public void onError(Response<MainMenuEntity> response) {
                        srlMain.setRefreshing(false);
                        super.onError(response);
                    }
                });
    }


    private void initOtherDate() {
        HttpParams params = new HttpParams();
        params.put("token", (String) SPUtil.get(context, AppConstant.TOKEN, ""));
        NetClient.getInstance(StateEntity.class).Get(context, AppConstant.URL_QUERYMYSTATE, params, new MyCallBack() {
            @Override
            public void onFailure(int code) {

            }

            @Override
            public void onResponse(Response object) {
                StateEntity result = (StateEntity) object.body();
                if (result != null) {
                    SPUtil.put(context, AppConstant.AUTH_STATE, result.getResult().getIspass());
                    SPUtil.put(context, AppConstant.UNPAY_STATE, result.getResult().getUnpaid());
                    SPUtil.put(context, AppConstant.UNDELIVER_STATE, result.getResult().getPiad());
                    SPUtil.put(context, AppConstant.DELIVERED_STATE, result.getResult().getShipped());
                    SPUtil.put(context, AppConstant.AFTERSALE_STATE, result.getResult().getCompleted());
                    SPUtil.put(context, AppConstant.MESSAGE_UNREAD_NUM, result.getResult().getNotice());
                    //未读消息大于0
                    if (list.size() > 5)
                        if ((int) SPUtil.get(context, AppConstant.MESSAGE_UNREAD_NUM, 0) > 0) {
                            list.get(5).setIs_show_spot(true);
                            adapter.notifyDataSetChanged();
                        }
                }
            }
        });
    }

    @OnClick({R.id.iv_setting, R.id.rv_main})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_setting:
                startActivity(new Intent(context, SettingActivity.class));
                break;
        }
    }

    //记录用户首次点击返回键的时间
    private long firstTime = 0;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            if (System.currentTimeMillis() - firstTime > 2000) {
                Toast.makeText(MainActivity.this, R.string.enter_twice_quite, Toast.LENGTH_SHORT).show();
                firstTime = System.currentTimeMillis();
            } else {
                finish();
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
