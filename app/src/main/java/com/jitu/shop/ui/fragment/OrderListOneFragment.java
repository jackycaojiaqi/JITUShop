package com.jitu.shop.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jitu.shop.AppConstant;
import com.jitu.shop.R;
import com.jitu.shop.adapter.OrderListAdapter;
import com.jitu.shop.entity.OrderListEntity;
import com.jitu.shop.interfaces.MyCallBack;
import com.jitu.shop.ui.AfterSaleActivity;
import com.jitu.shop.ui.DeliveryInfoActity;
import com.jitu.shop.ui.DeliveryPickPeopleActity;
import com.jitu.shop.ui.OrderInfoActivity;
import com.jitu.shop.util.DialogFactory;
import com.jitu.shop.util.NetClient;
import com.jitu.shop.util.SPUtil;
import com.jitu.shop.widget.DividerItemDecoration;
import com.jitu.shop.widget.ViewPagerFragment;
import com.lzy.okgo.model.Response;
import com.socks.library.KLog;

import org.simple.eventbus.EventBus;
import org.simple.eventbus.Subscriber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by jacky on 2017/7/11.
 */
public class OrderListOneFragment extends ViewPagerFragment {

    @BindView(R.id.rv_order_list)
    RecyclerView rvOrderList;
    @BindView(R.id.srl_order_list)
    SwipeRefreshLayout srlOrderList;
    Unbinder unbinder;
    @BindView(R.id.rll_order_content)
    RelativeLayout rllOrderContent;
    private Context context;
    private BaseQuickAdapter adapter;
    private List<OrderListEntity.ResultBean> list_order = new ArrayList<>();
    private int date_type = 0;//0 首次加载数据  1、下拉刷新  2、上拉加载
    private boolean hasDate = false;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmen_order_list_one, container, false);
        unbinder = ButterKnife.bind(this, view);
        EventBus.getDefault().register(this);
        return view;
    }

    private String type_code = "0";

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        context = getActivity();
        Bundle bundle = getArguments();
        String result = bundle.getString(AppConstant.TYPE);
        if (result.equals("1")) {
            type_code = "0";//全部
        } else if (result.equals("2")) {
            type_code = "1";//代付款
        } else if (result.equals("3")) {
            type_code = "10";//待发货
        } else if (result.equals("4")) {
            type_code = "15";//已发货
        } else if (result.equals("5")) {
            type_code = "20";//待售后
        }
        KLog.e(type_code);
        initview();
        if (getUserVisibleHint())
            initdate();
    }
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        //界面可见 并且控件已经找到 并且没有获取数据
        if (isVisibleToUser && isVisible()
                && rvOrderList != null && srlOrderList != null && adapter != null
                &&!hasDate) {
            initdate();
        }
    }

    private PopupWindow popupWindow;
    private int pos = -1;

    private void initview() {
        //设置下拉刷新
        srlOrderList.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                date_type = 1;
                pagenum = 1;
                initdate();
            }
        });
        srlOrderList.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public void onScrollChanged() {
                if (srlOrderList != null) {
                    srlOrderList.setEnabled(rvOrderList.getScrollY() == 0);
                }
            }
        });
        srlOrderList.setProgressViewOffset(true, 10, 100);
        //=========================recycleview配置
        adapter = new OrderListAdapter(R.layout.item_order_list, list_order);
        rvOrderList.setLayoutManager(new LinearLayoutManager(context));
        adapter.openLoadAnimation();
        adapter.bindToRecyclerView(rvOrderList);
        adapter.disableLoadMoreIfNotFullPage();
        adapter.setEmptyView(R.layout.empty_view);
        rvOrderList.setAdapter(adapter);
        //水平分割线
        rvOrderList.addItemDecoration(new DividerItemDecoration(
                context, DividerItemDecoration.HORIZONTAL_LIST, 10, getResources().getColor(R.color.gray_c)));
        rvOrderList.smoothScrollToPosition(0);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(context, OrderInfoActivity.class);
                intent.putExtra(AppConstant.OBJECT, list_order.get(position).getId());
                startActivity(intent);
            }
        });
        adapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        adapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                pagenum++;
                date_type = 2;
                initdate();
            }
        }); //=========================recycleview配置结束
        popupWindow = new PopupWindow(context);
        View contentView = LayoutInflater.from(context).inflate(
                R.layout.pop_pick_send_type, null);
        final PopupWindow popupWindow = new PopupWindow(contentView,
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        popupWindow.setTouchable(true);
        popupWindow.setBackgroundDrawable(getResources().getDrawable(
                R.color.transparent));
        TextView tv_kuaidi = (TextView) contentView.findViewById(R.id.tv_pop_kuaidi);
        TextView tv_paidan = (TextView) contentView.findViewById(R.id.tv_pop_paidan);
        tv_kuaidi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DeliveryInfoActity.class);
                intent.putExtra(AppConstant.OBJECT, list_order.get(pos).getId());
                startActivity(intent);
                popupWindow.dismiss();
            }
        });
        tv_paidan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DeliveryPickPeopleActity.class);
                intent.putExtra(AppConstant.OBJECT, list_order.get(pos).getId());
                startActivity(intent);
                popupWindow.dismiss();
            }
        });
        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                pos = position;
                //没有售后
                if (list_order.get(position).getCM_OrderServiceState() == 0) {
                    if (list_order.get(position).getStates() == 10) {
                        popupWindow.showAsDropDown(view);
                    }
                } else {//有售后
                    Intent intent = new Intent(context, AfterSaleActivity.class);
                    if (list_order.get(position).getCM_OrderServiceTpye() == 1) {
                        intent.putExtra(AppConstant.TYPE, "1");
                    } else if (list_order.get(position).getCM_OrderServiceTpye() == 2) {
                        intent.putExtra(AppConstant.TYPE, "2");
                    } else if (list_order.get(position).getCM_OrderServiceTpye() == 3) {
                        intent.putExtra(AppConstant.TYPE, "3");
                    }
                    intent.putExtra(AppConstant.OBJECT, list_order.get(position).getCM_ServiceId());
                    startActivity(intent);
                }
            }
        });
    }

    private int pagenum = 1;
    private int pagesize = 10;

    private void initdate() {
        DialogFactory.showRequestDialog(context);
        Map<String, String> map = new HashMap<>();
        map.put("token", (String) SPUtil.get(context, AppConstant.TOKEN, ""));
        map.put("pagenum", String.valueOf(pagenum));
        map.put("pagesize", String.valueOf(pagesize));
        map.put("state", type_code);
        NetClient.getInstance(OrderListEntity.class).Get(context, AppConstant.BASE_URL + AppConstant.URL_QUERYORDERS, map, new MyCallBack() {
            @Override
            public void onResponse(Response object) {
                DialogFactory.hideRequestDialog();
                srlOrderList.setRefreshing(false);
                OrderListEntity orderListEntity = (OrderListEntity) object.body();
                if (orderListEntity.getErrorCode() == 0) {
                    hasDate = true;
                    if (date_type == 0) {
                        list_order.clear();
                        list_order = orderListEntity.getResult();
                        adapter.setNewData(list_order);
                        if (orderListEntity.getResult().size() < 10) {
                            adapter.setEnableLoadMore(false);
                        }
                    } else if (date_type == 1) {
                        list_order.clear();
                        list_order = orderListEntity.getResult();
                        adapter.setNewData(list_order);
                        if (orderListEntity.getResult().size() < 10) {
                            adapter.setEnableLoadMore(false);
                        }
                    } else if (date_type == 2) {
                        if (orderListEntity.getResult().size() < 10) {//最后一页
                            list_order.addAll(orderListEntity.getResult());
                            adapter.notifyDataSetChanged();
                            adapter.loadMoreComplete();
                            adapter.setEnableLoadMore(false);
                        } else if (orderListEntity.getResult().size() >= 10) {//不是最后一页
                            list_order.addAll(orderListEntity.getResult());
                            adapter.notifyDataSetChanged();
                            adapter.loadMoreComplete();
                        }
                    }
                }
            }

            @Override
            public void onFailure(int code) {
                DialogFactory.hideRequestDialog();
                if (srlOrderList != null)
                    srlOrderList.setRefreshing(false);
            }
        });
    }

    @Subscriber(tag = "orderListFragment_Refresh")
    private void RefreshEvent(String obj) {
        initdate();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        EventBus.getDefault().unregister(this);
        unbinder.unbind();
    }
}
