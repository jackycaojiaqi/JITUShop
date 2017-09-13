package com.jitu.shop.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jitu.shop.AppConstant;
import com.jitu.shop.R;
import com.jitu.shop.adapter.ClassifyListAdapter;
import com.jitu.shop.adapter.CommondityListAdapter;
import com.jitu.shop.base.BaseActivity;
import com.jitu.shop.entity.ClassifyEntity;
import com.jitu.shop.entity.CommondityListEntity;
import com.jitu.shop.interfaces.MyCallBack;
import com.jitu.shop.util.NetClient;
import com.jitu.shop.util.SPUtil;
import com.jitu.shop.widget.DividerItemDecoration;
import com.lzy.okgo.model.Response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jacky on 2017/9/1.
 */
public class ClassifyManageActivity extends BaseActivity {
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_submit)
    TextView tvSubmit;
    @BindView(R.id.srl_classify)
    SwipeRefreshLayout srlOrderList;
    @BindView(R.id.rv_classify)
    RecyclerView rvOrderList;
    private BaseQuickAdapter adapter;
    private List<ClassifyEntity.ResultBean> list_order = new ArrayList<>();
    private int date_type = 0;//0 首次加载数据  1、下拉刷新  2、上拉加载
    private int pagenum = 1;
    private int pagesize = 10;
    private String type = "0";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classifymanage);
        ButterKnife.bind(this);
        initview();
        initdate();
    }


    private void initview() {
        setText(tvTitle, "分类管理");
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
        adapter = new ClassifyListAdapter(R.layout.item_classifymanage, list_order);
        rvOrderList.setLayoutManager(new GridLayoutManager(context, 1));
        adapter.openLoadAnimation();
        adapter.bindToRecyclerView(rvOrderList);
        adapter.setEmptyView(R.layout.empty_view);
        rvOrderList.setAdapter(adapter);
//        //水平分割线
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
        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()) {
                    case R.id.iv_classsify_list_up:
                        break;
                    case R.id.iv_classsify_list_down:
                        break;
                    case R.id.iv_classsify_list_edit:
                        break;
                }
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
        Map<String, String> map = new HashMap<>();
        map.put("token", (String) SPUtil.get(context, AppConstant.TOKEN, ""));
        map.put("type", type);
        map.put("pagenum", String.valueOf(pagenum));
        map.put("pagesize", String.valueOf(pagesize));
        NetClient.getInstance(ClassifyEntity.class).Get(context, AppConstant.BASE_URL + AppConstant.URL_QUERYSHOPCLASSS, map, new MyCallBack() {
            @Override
            public void onFailure(int code) {
                srlOrderList.setRefreshing(false);
            }

            @Override
            public void onResponse(Response object) {
                srlOrderList.setRefreshing(false);
                ClassifyEntity entity = (ClassifyEntity) object.body();
                if (entity.getErrorCode() == 0) {
                    if (date_type == 0) {
                        adapter.setEnableLoadMore(true);
                        list_order.clear();
                        list_order = entity.getResult();
                        adapter.setNewData(list_order);
                    } else if (date_type == 1) {
                        list_order.clear();
                        adapter.setEnableLoadMore(true);
                        list_order = entity.getResult();
                        adapter.setNewData(list_order);
                    } else if (date_type == 2) {
                        if (entity.getResult().size() < 10) {//最后一页
                            list_order.addAll(entity.getResult());
                            adapter.notifyDataSetChanged();
                            adapter.loadMoreComplete();
                            adapter.loadMoreEnd();
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

    @OnClick({R.id.iv_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;

        }
    }
}
