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

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.jitu.shop.AppConstant;
import com.jitu.shop.R;
import com.jitu.shop.adapter.CommondityListAdapter;
import com.jitu.shop.adapter.OrderListAdapter;
import com.jitu.shop.base.BaseFragment;
import com.jitu.shop.entity.BasePaserEntity;
import com.jitu.shop.entity.BatchReleaseEntity;
import com.jitu.shop.entity.CommondityListEntity;
import com.jitu.shop.entity.OrderListEntity;
import com.jitu.shop.interfaces.MyCallBack;
import com.jitu.shop.ui.CommodityManageListActivity;
import com.jitu.shop.ui.OrdrInfoActivity;
import com.jitu.shop.util.DialogFactory;
import com.jitu.shop.util.NetClient;
import com.jitu.shop.util.SPUtil;
import com.jitu.shop.util.StringUtil;
import com.jitu.shop.util.ToastUtil;
import com.jitu.shop.widget.DividerGridItemDecoration;
import com.jitu.shop.widget.DividerItemDecoration;
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
public class CommodityListOneFragment extends BaseFragment {

    @BindView(R.id.rv_order_list)
    RecyclerView rvOrderList;
    @BindView(R.id.srl_order_list)
    SwipeRefreshLayout srlOrderList;
    Unbinder unbinder;
    private CommondityListAdapter adapter;
    private List<CommondityListEntity.ResultBean> list_order = new ArrayList<>();
    private int date_type = 0;//0 首次加载数据  1、下拉刷新  2、上拉加载
    private Context context;
    private int pagenum = 1;
    private int pagesize = 10;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmen_order_list_one, container, false);
        unbinder = ButterKnife.bind(this, view);
        context = getActivity();
        EventBus.getDefault().register(this);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initview();
        initdate();
    }

    private void initview() {
        //设置下拉刷新
        srlOrderList.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                date_type = 1;
                pagenum = 1;
                initdate();
                adapter.showAllCheckBox(false);
                //下拉刷新后充值列表显示状态
                CommodityManageListActivity.is_1show_checkbox = false;
                EventBus.getDefault().post("refresh_button", "refresh_button");

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
        adapter = new CommondityListAdapter(R.layout.item_commondity_list, list_order);

        rvOrderList.setLayoutManager(new GridLayoutManager(context, 1));
        adapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        adapter.bindToRecyclerView(rvOrderList);
        adapter.setEmptyView(R.layout.empty_view);
        rvOrderList.setAdapter(adapter);
//        rvOrderList.addItemDecoration(new DividerGridItemDecoration(context));
        //水平分割线
        rvOrderList.addItemDecoration(new DividerItemDecoration(
                context, DividerItemDecoration.HORIZONTAL_LIST, 1, getResources().getColor(R.color.gray_c)));
        rvOrderList.smoothScrollToPosition(0);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
//                Intent intent = new Intent(context, OrdrInfoActivity.class);
//                intent.putExtra(AppConstant.OBJECT, list_order.get(position).get());
//                startActivity(intent);
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
    }

    private void initdate() {
        KLog.e("===========");
        DialogFactory.showRequestDialog(context);
        Map<String, String> map = new HashMap<>();
        map.put("token", (String) SPUtil.get(context, AppConstant.TOKEN, ""));
        map.put("type", "2");
        map.put("pagenum", String.valueOf(pagenum));
        map.put("pagesize", String.valueOf(pagesize));
        NetClient.getInstance(CommondityListEntity.class).Get(getActivity(), AppConstant.BASE_URL + AppConstant.URL_QUERYPRODUCTS, map, new MyCallBack() {
            @Override
            public void onFailure(int code) {
                DialogFactory.hideRequestDialog();
                if (srlOrderList != null)
                    srlOrderList.setRefreshing(false);
            }

            @Override
            public void onResponse(Response object) {
                DialogFactory.hideRequestDialog();
                srlOrderList.setRefreshing(false);
                CommondityListEntity entity = (CommondityListEntity) object.body();
                if (entity.getErrorCode() == 0) {
                    if (date_type == 0) {
                        adapter.setEnableLoadMore(true);
                        list_order.clear();
                        list_order = entity.getResult();
                        adapter.setNewData(list_order);
                        if (entity.getResult().size() < 10) {
                            adapter.setEnableLoadMore(false);
                        }
                    } else if (date_type == 1) {
                        list_order.clear();
                        adapter.setEnableLoadMore(true);
                        list_order = entity.getResult();
                        adapter.setNewData(list_order);
                        if (entity.getResult().size() < 10) {
                            adapter.setEnableLoadMore(false);
                        }
                    } else if (date_type == 2) {
                        if (entity.getResult().size() < 10) {//最后一页
                            adapter.setEnableLoadMore(false);
                            list_order.addAll(entity.getResult());
                            adapter.notifyDataSetChanged();
                            adapter.loadMoreComplete();
                        } else if (entity.getResult().size() >= 10) {//不是最后一页
                            list_order.addAll(entity.getResult());
                            adapter.notifyDataSetChanged();
                            adapter.loadMoreComplete();
                        }
                    }
                }
            }
        });
    }

    private String ids = " ";

    private void doGoodsAction(String action_type) {//0上架，1下架，2全店下架，3删除
        ids = "";
        BatchReleaseEntity batchReleaseEntity = new BatchReleaseEntity();
        List<BatchReleaseEntity.ProductidsBean> list_date = new ArrayList<>();
        DialogFactory.showRequestDialog(context);
        //不是全店下架都要拼接ids
        if (!action_type.equals("2")) {
            for (CommondityListEntity.ResultBean resultBean : list_order) {
                List<BatchReleaseEntity.ProductidsBean.SkusBean> list_sku = new ArrayList<>();
                boolean has_pro_id = false;
                BatchReleaseEntity.ProductidsBean obj = new BatchReleaseEntity.ProductidsBean();
                BatchReleaseEntity.ProductidsBean.SkusBean obj_sku = new BatchReleaseEntity.ProductidsBean.SkusBean();
                //被选中的商品
                if (resultBean.isIs_check()) {
                    //没有sku
                    if (resultBean.getSkuid() == 0) {
                        obj.setProductid(resultBean.getId());
                        obj.setCount(String.valueOf(resultBean.getInventory()));
                        obj_sku.setInventory("0");
                        obj_sku.setSkuid("0");
                        list_sku.add(obj_sku);
                        obj.setSkus(list_sku);
                        for (BatchReleaseEntity.ProductidsBean productidsBean : list_date) {
                            if (productidsBean.getProductid().equals(resultBean.getId())) {
                                has_pro_id = true;
                            }
                        }
                        if (!has_pro_id) {
                            list_date.add(obj);
                        }
                    } else {//有sku
                        obj.setProductid(resultBean.getId());
                        obj.setCount("0");
                        obj_sku.setSkuid(String.valueOf(resultBean.getSkuid()));
                        obj_sku.setInventory(String.valueOf(resultBean.getSkuinventory()));
                        list_sku.add(obj_sku);
                        obj.setSkus(list_sku);
                        for (BatchReleaseEntity.ProductidsBean productidsBean : list_date) {
                            if (productidsBean.getProductid().equals(resultBean.getId())) {
                                BatchReleaseEntity.ProductidsBean.SkusBean obj_sku2 = new BatchReleaseEntity.ProductidsBean.SkusBean();
                                obj_sku2.setSkuid(String.valueOf(resultBean.getSkuid()));
                                obj_sku2.setInventory(String.valueOf(resultBean.getSkuinventory()));
                                productidsBean.getSkus().add(obj_sku2);
                                has_pro_id = true;
                            }
                        }
                        if (!has_pro_id) {
                            list_date.add(obj);
                        }
                    }

                }
            }
            batchReleaseEntity.setProductids(list_date);
            ids = new Gson().toJson(batchReleaseEntity);
            if (ids.length() <= 0) {
                ToastUtil.show(context, "请至少选择一种商品");
                return;
            }
        }
        KLog.e(action_type + " " + ids);
        Map<String, String> map = new HashMap<>();
        map.put("token", (String) SPUtil.get(getActivity(), AppConstant.TOKEN, ""));
        map.put("json", ids);
        map.put("type", action_type);
        NetClient.getInstance(BasePaserEntity.class).Post(context, AppConstant.BASE_URL + AppConstant.URL_BATCHRELEASE, map, new MyCallBack() {
            @Override
            public void onResponse(Response object) {
                DialogFactory.hideRequestDialog();
                BasePaserEntity entity = (BasePaserEntity) object.body();
                if (entity.getErrorCode() == 0) {
                    ToastUtil.show(context, "操作成功");
                    pagenum = 1;
                    date_type = 0;
                    initdate();
                    //重置布局状态
                    EventBus.getDefault().post("invisible_view", "invisible_view");
                    adapter.showAllCheckBox(false);
                }
            }

            @Override
            public void onFailure(int code) {
                DialogFactory.hideRequestDialog();
                srlOrderList.setRefreshing(false);
            }
        });
    }

    @Subscriber(tag = "checkbox_action")
    private void checkbox_action(boolean is_show) {
        adapter.showAllCheckBox(is_show);
    }

    @Subscriber(tag = "commondity_action_one_down")
    private void commondity_action_up_or_down(int object) {
        doGoodsAction("1");
    }

    /**
     * 全店下架
     *
     * @param object
     */
    @Subscriber(tag = "commondity_action_delete")
    private void commondity_action_delete(int object) {
        doGoodsAction("3");
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        // 注册对象
        EventBus.getDefault().unregister(this);
        unbinder.unbind();
    }
}
