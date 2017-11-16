package com.jitu.shop.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jitu.shop.AppConstant;
import com.jitu.shop.R;
import com.jitu.shop.adapter.CourierPeopleAdapter;
import com.jitu.shop.adapter.OrderListAdapter;
import com.jitu.shop.base.BaseActivity;
import com.jitu.shop.entity.BasePaserEntity;
import com.jitu.shop.entity.CourierPeopleEntity;
import com.jitu.shop.entity.OrderListEntity;
import com.jitu.shop.interfaces.MyCallBack;
import com.jitu.shop.util.DialogFactory;
import com.jitu.shop.util.NetClient;
import com.jitu.shop.util.SPUtil;
import com.jitu.shop.widget.DividerItemDecoration;
import com.lzy.okgo.model.HttpParams;
import com.lzy.okgo.model.Response;

import org.simple.eventbus.EventBus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jacky on 2017/9/13.
 */
public class DeliveryPickPeopleActity extends BaseActivity {
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_submit)
    TextView tvSubmit;
    @BindView(R.id.rv_pick_people)
    RecyclerView rvPickPeople;
    private BaseQuickAdapter adapter;

    private List<CourierPeopleEntity.ResultBean> list_people = new ArrayList<>();
    private String order_id = "";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deliver_pick_people);
        ButterKnife.bind(this);
        order_id = getIntent().getStringExtra(AppConstant.OBJECT);
        initview();
        initDate();
    }

    private void initview() {
        setText(tvTitle, "选择派单人员");

        //=========================recycleview配置
        adapter = new CourierPeopleAdapter(R.layout.item_courier_people, list_people);
        rvPickPeople.setLayoutManager(new LinearLayoutManager(context));
        adapter.bindToRecyclerView(rvPickPeople);
        adapter.disableLoadMoreIfNotFullPage();
        adapter.setEmptyView(R.layout.empty_view);
        rvPickPeople.setAdapter(adapter);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, final int position) {
                new MaterialDialog.Builder(context)
                        .content("确定选择\"" + list_people.get(position).getRealName() + "\"为配送员？")
                        .positiveText("确定")
                        .negativeText("取消")
                        .onPositive(new MaterialDialog.SingleButtonCallback() {
                            @Override
                            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                SureToDeliver(list_people.get(position).getID());
                                dialog.dismiss();
                            }
                        })
                        .onNegative(new MaterialDialog.SingleButtonCallback() {
                            @Override
                            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                dialog.dismiss();
                            }
                        }).show();
            }
        });
        //=========================recycleview配置结束
    }

    private void initDate() {
        DialogFactory.showRequestDialog(context);
        Map<String, String> map = new HashMap<>();
        map.put("token", (String) SPUtil.get(context, AppConstant.TOKEN, ""));
        NetClient.getInstance(CourierPeopleEntity.class).Get(context, AppConstant.URL_QueryCourier, map, new MyCallBack() {
            @Override
            public void onResponse(Response object) {
                DialogFactory.hideRequestDialog();
                CourierPeopleEntity obj = (CourierPeopleEntity) object.body();
                if (obj.getErrorCode() == 0) {
                    list_people = obj.getResult();
                    adapter.setNewData(list_people);
                }
            }

            @Override
            public void onFailure(int code) {
                DialogFactory.hideRequestDialog();
            }
        });
    }

    private void SureToDeliver(String courierid) {
        DialogFactory.showRequestDialog(context);
        HttpParams params = new HttpParams();
        params.put("token", (String) SPUtil.get(context, AppConstant.TOKEN, ""));
        params.put("orderid", order_id);
        params.put("type", "2");
        params.put("logisticsnum", "0");
        params.put("logisticsid", "0");
        params.put("courierid", courierid);
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

    @OnClick({R.id.iv_back, R.id.tv_submit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_submit:
                break;
        }
    }
}
