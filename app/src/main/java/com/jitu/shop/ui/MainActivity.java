package com.jitu.shop.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jitu.shop.AppConstant;
import com.jitu.shop.R;
import com.jitu.shop.adapter.MainMenuAdapter;
import com.jitu.shop.base.BaseActivity;
import com.jitu.shop.callback.JsonCallBack;
import com.jitu.shop.entity.LoginEntity;
import com.jitu.shop.entity.MainMenuEntity;
import com.jitu.shop.util.GlideImageLoader;
import com.jitu.shop.util.SPUtil;
import com.jitu.shop.util.ToastUtil;
import com.jitu.shop.widget.DividerItemDecoration;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.Response;
import com.socks.library.KLog;
import com.tencent.bugly.Bugly;
import com.tencent.bugly.beta.Beta;
import com.vondear.rxtools.RxBarUtils;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.jpush.android.api.JPushInterface;

public class MainActivity extends BaseActivity {
    @BindView(R.id.banner)
    Banner banner;
    @BindView(R.id.rv_main)
    RecyclerView rvMain;
    private List<String> images = new ArrayList<>();
    private BaseQuickAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initview();
        initdate();
        JPushInterface.requestPermission(context);//请求权限
        String id = JPushInterface.getRegistrationID(context);
        Beta.checkUpgrade();
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
        images.add("http://imgsrc.baidu.com/imgad/pic/item/267f9e2f07082838b5168c32b299a9014c08f1f9.jpg");
        images.add("http://pic62.nipic.com/file/20150319/12632424_132215178296_2.jpg");
        images.add("http://pic49.nipic.com/file/20140927/19617624_230415502002_2.jpg");
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        banner.setImages(images);
        //banner设置方法全部调用完毕时最后调用
        banner.start();
    }

    private void initdate() {
        OkGo.<MainMenuEntity>get(AppConstant.BASE_URL + AppConstant.URL_QUERYMENUS)
                .tag(this)
                .execute(new JsonCallBack<MainMenuEntity>(MainMenuEntity.class) {
                    @Override
                    public void onSuccess(Response<MainMenuEntity> response) {
                        if (response.body().getErrorCode() == 0) {
                            if (response.body().getResult().getTable().size() > 0) {
                                adapter = new MainMenuAdapter(R.layout.item_main_menu, response.body().getResult().getTable());
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
                                                startActivity(new Intent(context, MessageActivity.class));
                                                break;
                                            case 5:
                                                startActivity(new Intent(context, SettingActivity.class));
                                                break;
                                        }
                                    }
                                });
                                adapter.bindToRecyclerView(rvMain);
                                adapter.setEmptyView(R.layout.empty_view);
                                rvMain.setAdapter(adapter);
                                //水平分割线
                                rvMain.addItemDecoration(new DividerItemDecoration(
                                        context, DividerItemDecoration.VERTICAL_LIST, 10, getResources().getColor(R.color.white)));
                            }
                        } else {
                            ToastUtil.show(context, "账号密码错误");
                        }
                    }

                    @Override
                    public void onError(Response<MainMenuEntity> response) {
                        super.onError(response);
                    }
                });
    }
}
