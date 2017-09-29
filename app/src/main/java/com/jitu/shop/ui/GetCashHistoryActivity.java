package com.jitu.shop.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jitu.shop.AppConstant;
import com.jitu.shop.R;
import com.jitu.shop.adapter.GetCashHistoryAdapter;
import com.jitu.shop.base.BaseActivity;
import com.jitu.shop.entity.CommondityListEntity;
import com.jitu.shop.entity.GetCashHistoryEntity;
import com.jitu.shop.interfaces.MyCallBack;
import com.jitu.shop.util.NetClient;
import com.jitu.shop.util.SPUtil;
import com.lzy.okgo.model.HttpParams;
import com.lzy.okgo.model.Response;

import org.simple.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.jpush.android.api.JPushInterface;

/**
 * Created by jacky on 2017/8/29.
 */
public class GetCashHistoryActivity extends BaseActivity {

    @BindView(R.id.rv_getcash_history)
    RecyclerView rvGetcash;
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_submit)
    TextView tvSubmit;
    @BindView(R.id.srl_getcash_history)
    SwipeRefreshLayout srlGetcashHistory;
    private int cash_type = 1;//1、微信  2、支付宝 3、银行卡
    private GetCashHistoryAdapter adapter;
    private List<GetCashHistoryEntity.ResultBean> list = new ArrayList<>();
    private int pagesize = 10;
    private int page_num = 1;
    private int date_type = 0;//0 首次加载数据  1、下拉刷新  2、上拉加载

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getcash_history);
        ButterKnife.bind(this);
        initview();
        initdate();
    }

    @Override
    protected void onResume() {
        super.onResume();
        JPushInterface.onResume(getApplicationContext());
    }

    private void initview() {
        //设置下拉刷新
        srlGetcashHistory.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                date_type = 1;
                page_num = 1;
                initdate();
                adapter.showAllCheckBox(false);
            }
        });
        srlGetcashHistory.setProgressViewOffset(true, 10, 100);
        setText(tvTitle, "提现记录");
        //=========================recycleview配置
        adapter = new GetCashHistoryAdapter(R.layout.item_get_cash_history, list);
        rvGetcash.setLayoutManager(new LinearLayoutManager(context));
        adapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
        adapter.bindToRecyclerView(rvGetcash);
        adapter.setEmptyView(R.layout.empty_view);
        rvGetcash.setAdapter(adapter);
        adapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                page_num++;
                date_type = 2;
                initdate();
            }
        });
        //=========================recycleview配置结束
    }

    private void initdate() {
        HttpParams params = new HttpParams();
        params.put("token", (String) SPUtil.get(context, AppConstant.TOKEN, ""));
        params.put("type", "0");
        params.put("pagenum", page_num);
        params.put("pagesize", pagesize);
        NetClient.getInstance(GetCashHistoryEntity.class).Get(context, AppConstant.URL_QUERYPRESENTAPPLICATION, params, new MyCallBack() {
            @Override
            public void onFailure(int code) {
                if (srlGetcashHistory != null)
                    srlGetcashHistory.setRefreshing(false);
            }

            @Override
            public void onResponse(Response object) {
                srlGetcashHistory.setRefreshing(false);
                GetCashHistoryEntity entity = (GetCashHistoryEntity) object.body();
                if (entity.getErrorCode() == 0) {
                    if (date_type == 0) {
                        adapter.setEnableLoadMore(true);
                        list.clear();
                        list = entity.getResult();
                        adapter.setNewData(list);
                    } else if (date_type == 1) {
                        list.clear();
                        adapter.setEnableLoadMore(true);
                        list = entity.getResult();
                        adapter.setNewData(list);
                    } else if (date_type == 2) {
                        if (entity.getResult().size() < 10) {//最后一页
                            list.addAll(entity.getResult());
                            adapter.notifyDataSetChanged();
                            adapter.loadMoreComplete();
                            adapter.setEnableLoadMore(false);
                        } else if (entity.getResult().size() >= 10) {//不是最后一页
                            list.addAll(entity.getResult());
                            adapter.notifyDataSetChanged();
                            adapter.loadMoreComplete();
                        }
                    }
                }
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        JPushInterface.onPause(getApplicationContext());
    }

    private int card_id = 0;
    private double cash_num = 0;

    @OnClick({R.id.iv_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
        }
    }

}
