package com.jitu.shop.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
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
import com.jitu.shop.base.BaseFragment;
import com.jitu.shop.entity.OrderListEntity;
import com.jitu.shop.interfaces.MyCallBack;
import com.jitu.shop.ui.AfterSaleActivity;
import com.jitu.shop.ui.DeliveryInfoActity;
import com.jitu.shop.ui.DeliveryPickPeopleActity;
import com.jitu.shop.ui.OrdrInfoActivity;
import com.jitu.shop.util.NetClient;
import com.jitu.shop.util.SPUtil;
import com.jitu.shop.widget.DividerItemDecoration;
import com.lzy.okgo.model.Response;
import com.socks.library.KLog;
import com.vondear.rxtools.view.tooltips.RxToolTip;
import com.vondear.rxtools.view.tooltips.RxToolTipsManager;

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
public class OrderListOneFragment extends BaseFragment {

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

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmen_order_list_one, container, false);
        unbinder = ButterKnife.bind(this, view);
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
        initdate();
    }

    private PopupWindow popupWindow;

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
        rvOrderList.setLayoutManager(new GridLayoutManager(context, 1));
        adapter.openLoadAnimation();
        adapter.bindToRecyclerView(rvOrderList);
        adapter.setEmptyView(R.layout.empty_view);
        rvOrderList.setAdapter(adapter);
        //水平分割线
        rvOrderList.addItemDecoration(new DividerItemDecoration(
                context, DividerItemDecoration.HORIZONTAL_LIST, 10, getResources().getColor(R.color.gray_c)));
        rvOrderList.smoothScrollToPosition(0);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(context, OrdrInfoActivity.class);
                intent.putExtra(AppConstant.OBJECT, list_order.get(position).getOrderCode());
                startActivity(intent);
            }
        });
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
                startActivity(intent);
                popupWindow.dismiss();
            }
        });
        tv_paidan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, DeliveryPickPeopleActity.class);
                startActivity(intent);
                popupWindow.dismiss();
            }
        });
        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                if (type_code.equals("0")) {//全部
                    popupWindow.showAsDropDown(view);
                } else if (type_code.equals("1")) {//代付款

                } else if (type_code.equals("10")) {//待发货
                    popupWindow.showAsDropDown(view);
                } else if (type_code.equals("15")) {//已发货

                } else if (type_code.equals("20")) {//售后
                    Intent intent = new Intent(context, AfterSaleActivity.class);
                    intent.putExtra(AppConstant.OBJECT, "");
                    startActivity(intent);
                }


            }
        });



    }

    private int pagenum = 1;
    private int pagesize = 10;

    private void initdate() {

        Map<String, String> map = new HashMap<>();
        map.put("token", (String) SPUtil.get(getActivity(), AppConstant.TOKEN, ""));
        map.put("pagenum", String.valueOf(pagenum));
        map.put("pagesize", String.valueOf(pagesize));
        map.put("state", type_code);
        NetClient.getInstance(OrderListEntity.class).Get(context, AppConstant.BASE_URL + AppConstant.URL_QUERYORDERS, map, new MyCallBack() {
            @Override
            public void onResponse(Response object) {
                srlOrderList.setRefreshing(false);
                OrderListEntity orderListEntity = (OrderListEntity) object.body();
                if (orderListEntity.getErrorCode() == 0) {
                    if (date_type == 0) {
                        adapter.setEnableLoadMore(true);
                        list_order.clear();
                        list_order = orderListEntity.getResult();
                        adapter.setNewData(list_order);
                    } else if (date_type == 1) {
                        list_order.clear();
                        adapter.setEnableLoadMore(true);
                        list_order = orderListEntity.getResult();
                        adapter.setNewData(list_order);
                    } else if (date_type == 2) {
                        if (orderListEntity.getResult().size() < 10) {//最后一页
                            list_order.addAll(orderListEntity.getResult());
                            adapter.notifyDataSetChanged();
                            adapter.loadMoreComplete();
                            adapter.loadMoreEnd();
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
                if (srlOrderList != null)
                    srlOrderList.setRefreshing(false);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
