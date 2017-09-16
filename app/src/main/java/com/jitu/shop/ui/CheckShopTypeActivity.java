package com.jitu.shop.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jitu.shop.AppConstant;
import com.jitu.shop.R;
import com.jitu.shop.adapter.OrderListAdapter;
import com.jitu.shop.adapter.ShopTypeAdapter;
import com.jitu.shop.base.BaseActivity;
import com.jitu.shop.entity.ShopTypeEntity;
import com.jitu.shop.interfaces.MyCallBack;
import com.jitu.shop.util.DialogFactory;
import com.jitu.shop.util.NetClient;
import com.jitu.shop.util.ToastUtil;
import com.jitu.shop.widget.DividerItemDecoration;
import com.lzy.okgo.model.HttpParams;
import com.lzy.okgo.model.Response;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jacky on 2017/9/13.
 */
public class CheckShopTypeActivity extends BaseActivity {
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_submit)
    TextView tvSubmit;
    @BindView(R.id.rv_shop_type_left)
    RecyclerView rvShopTypeLeft;
    @BindView(R.id.rv_shop_type_right)
    RecyclerView rvShopTypeRight;
    private BaseQuickAdapter adapter_parent;
    private BaseQuickAdapter adapter_sub;
    private List<ShopTypeEntity.ResultBean> list = new ArrayList<>();
    private List<ShopTypeEntity.ResultBean> list_sub = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layoutactivity_check_shop_type);
        ButterKnife.bind(this);
        initview();
        initdate_1();
    }

    private String shop_type_name1 = "";

    private void initview() {
        setText(tvTitle, "类目选择");
        //=========================recycleview配置
        adapter_parent = new ShopTypeAdapter(R.layout.item_shop_type, list);
        rvShopTypeLeft.setLayoutManager(new GridLayoutManager(context, 1));
        adapter_parent.openLoadAnimation();
        adapter_parent.bindToRecyclerView(rvShopTypeLeft);
        adapter_parent.setEmptyView(R.layout.empty_view);
        rvShopTypeLeft.setAdapter(adapter_parent);
        rvShopTypeLeft.smoothScrollToPosition(0);
        adapter_parent.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                for (int i = 0; i < list.size(); i++) {
                    list.get(i).setIs_show_line(false);
                }
                list.get(position).setIs_show_line(true);
                adapter_parent.notifyDataSetChanged();
                initdate_2(list.get(position).getId());
                shop_type_name1 = list.get(position).getName();
            }
        });
        //=========================recycleview配置
        adapter_sub = new ShopTypeAdapter(R.layout.item_shop_type, list_sub);
        rvShopTypeRight.setLayoutManager(new GridLayoutManager(context, 1));
        adapter_sub.openLoadAnimation();
        adapter_sub.bindToRecyclerView(rvShopTypeRight);
        adapter_sub.setEmptyView(R.layout.empty_view);
        rvShopTypeRight.setAdapter(adapter_sub);
        rvShopTypeRight.smoothScrollToPosition(0);
        adapter_sub.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                for (int i = 0; i < list_sub.size(); i++) {
                    list_sub.get(i).setIs_show_line(false);
                }
                list_sub.get(position).setIs_show_line(true);
                adapter_sub.notifyDataSetChanged();
                Intent intent = new Intent();
                String name = shop_type_name1 + " " + list_sub.get(position).getName();
                intent.putExtra(AppConstant.USERNAME, name);
                intent.putExtra(AppConstant.TYPE, list_sub.get(position).getId());
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    //左边列表数据获取
    private void initdate_1() {
        HttpParams httpParams = new HttpParams();
        httpParams.put("type", "1");
        httpParams.put("pid", "0");
        NetClient.getInstance(ShopTypeEntity.class).Get(context, AppConstant.BASE_URL + AppConstant.URL_ADMINQUERYINDUSTRIES, httpParams, new MyCallBack() {
            @Override
            public void onFailure(int code) {
                ToastUtil.show(context, "error_code:" + code);
            }

            @Override
            public void onResponse(Response object) {
                ShopTypeEntity shopTypeEntity = (ShopTypeEntity) object.body();
                list = shopTypeEntity.getResult();
                if (list.size() > 0) {
                    shop_type_name1 = list.get(0).getName();
                    list.get(0).setIs_show_line(true);
                    initdate_2(list.get(0).getId());
                }
                adapter_parent.setNewData(list);
            }
        });
    }
    //右边列表数据获取
    private void initdate_2(int pid) {
        DialogFactory.showRequestDialog(context);
        HttpParams httpParams = new HttpParams();
        httpParams.put("type", "2");
        httpParams.put("pid", pid);
        NetClient.getInstance(ShopTypeEntity.class).Get(context, AppConstant.BASE_URL + AppConstant.URL_ADMINQUERYINDUSTRIES, httpParams, new MyCallBack() {
            @Override
            public void onFailure(int code) {
                DialogFactory.hideRequestDialog();
                ToastUtil.show(context, "error_code:" + code);
            }

            @Override
            public void onResponse(Response object) {
                DialogFactory.hideRequestDialog();
                ShopTypeEntity shopTypeEntity = (ShopTypeEntity) object.body();
                list_sub = shopTypeEntity.getResult();
                if (list_sub.size() > 0) {
                    list_sub.get(0).setIs_show_line(true);
                }
                adapter_sub.setNewData(list_sub);
            }
        });
    }

    @OnClick({R.id.iv_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
        }
    }
}
