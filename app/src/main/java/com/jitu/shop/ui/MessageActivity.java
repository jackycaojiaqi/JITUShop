package com.jitu.shop.ui;

import android.content.Intent;
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
import com.jitu.shop.adapter.CommondityListAdapter;
import com.jitu.shop.adapter.MessageListAdapter;
import com.jitu.shop.base.BaseActivity;
import com.jitu.shop.entity.BasePaserEntity;
import com.jitu.shop.entity.CommondityListEntity;
import com.jitu.shop.entity.MessageEntity;
import com.jitu.shop.entity.OnlyCodeEntity;
import com.jitu.shop.interfaces.MyCallBack;
import com.jitu.shop.util.NetClient;
import com.jitu.shop.util.SPUtil;
import com.jitu.shop.widget.DividerItemDecoration;
import com.lzy.okgo.model.HttpParams;
import com.lzy.okgo.model.Response;
import com.socks.library.KLog;

import org.simple.eventbus.EventBus;
import org.simple.eventbus.Subscriber;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.jpush.android.api.JPushInterface;

/**
 * Created by jacky on 2017/8/29.
 */
public class MessageActivity extends BaseActivity {
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_submit)
    TextView tvSubmit;
    @BindView(R.id.rv_message)
    RecyclerView rvMessage;
    @BindView(R.id.srl_message)
    SwipeRefreshLayout srlMessage;

    private BaseQuickAdapter adapter;
    private List<MessageEntity.ResultBean> list_order = new ArrayList<>();
    private int date_type = 0;//0 首次加载数据  1、下拉刷新  2、上拉加载

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        initview();
        initdate();
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
        back(ivBack);
        setText(tvTitle, "消息");
        //设置下拉刷新
        srlMessage.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                date_type = 1;
                page_num = 1;
                initdate();
            }
        });
        srlMessage.setProgressViewOffset(true, 10, 100);
        //=========================recycleview配置
        adapter = new MessageListAdapter(R.layout.item_message_list, list_order);

        rvMessage.setLayoutManager(new GridLayoutManager(context, 1));
        adapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
        adapter.bindToRecyclerView(rvMessage);
        adapter.setEmptyView(R.layout.empty_view);
        adapter.disableLoadMoreIfNotFullPage();
        rvMessage.setAdapter(adapter);
//        rvMessage.addItemDecoration(new DividerGridItemDecoration(context));
        //水平分割线
        rvMessage.smoothScrollToPosition(0);
        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()) {
                    case R.id.content:
                        setMessageRead(list_order.get(position).getCM_NoticeId(), position);

                        Intent intent = new Intent(context, MessageInfoActivity.class);
                        intent.putExtra(AppConstant.OBJECT, list_order.get(position));
                        startActivity(intent);
                        break;
                    case R.id.right_menu_1:
                        del_message_by_id(list_order.get(position).getCM_NoticeId(), position);
                        break;
                }
            }
        });
        adapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                page_num++;
                date_type = 2;
                initdate();
            }
        }); //=========================recycleview配置结束
    }


    /**
     * 设置消息已读
     *
     * @param cm_noticeId
     */
    private void setMessageRead(int cm_noticeId, final int pos) {
        String url = AppConstant.BASE_URL + AppConstant.URL_SetNoticeState;
        HttpParams params = new HttpParams();
        params.put("token", (String) SPUtil.get(context, AppConstant.TOKEN, ""));
        params.put("noticeid", cm_noticeId);
        NetClient.getInstance(BasePaserEntity.class).Get(context, url, params, new MyCallBack() {

            @Override
            public void onResponse(Response object) {
                BasePaserEntity obj = (BasePaserEntity) object.body();
                if (obj.getErrorCode() == 0) {
                    list_order.get(pos).setCM_IsCheck(1);
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(int code) {

            }
        });

    }

    private int page_num = 1;
    private int pagesize = 10;

    private void initdate() {
        String url = AppConstant.BASE_URL + AppConstant.URL_QUERYNOTICES;
        HttpParams params = new HttpParams();
        params.put("token", (String) SPUtil.get(context, AppConstant.TOKEN, ""));
        params.put("pagenum", page_num);
        params.put("pagesize", pagesize);
        NetClient.getInstance(MessageEntity.class).Get(context, url, params, new MyCallBack() {
            @Override
            public void onFailure(int code) {
                if (srlMessage != null)
                    srlMessage.setRefreshing(false);
            }

            @Override
            public void onResponse(Response object) {
                srlMessage.setRefreshing(false);
                MessageEntity entity = (MessageEntity) object.body();
                if (entity.getErrorCode() == 0) {
                    if (entity.getErrorCode() == 0) {
                        if (date_type == 0) {

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
                            if (entity.getResult().size() < 10) {
                                adapter.setEnableLoadMore(false);
                            }
                            adapter.setNewData(list_order);
                        } else if (date_type == 2) {
                            if (entity.getResult().size() < 10) {//最后一页
                                list_order.addAll(entity.getResult());
                                adapter.notifyDataSetChanged();
                                adapter.loadMoreComplete();
                                adapter.setEnableLoadMore(false);
                            } else if (entity.getResult().size() >= 10) {//不是最后一页
                                list_order.addAll(entity.getResult());
                                adapter.notifyDataSetChanged();
                                adapter.loadMoreComplete();
                            }
                        }
                    }
                }

            }
        });
    }

    /**
     * 删除消息
     *
     * @param id
     * @param pos
     */
    private void del_message_by_id(int id, final int pos) {
        String url = AppConstant.BASE_URL + AppConstant.URL_DelNotice;
        HttpParams params = new HttpParams();
        params.put("token", (String) SPUtil.get(context, AppConstant.TOKEN, ""));
        params.put("noticeids", id);
        NetClient.getInstance(BasePaserEntity.class).Get(context, url, params, new MyCallBack() {

            @Override
            public void onResponse(Response object) {
                BasePaserEntity obj = (BasePaserEntity) object.body();
                if (obj.getErrorCode() == 0) {
                    list_order.remove(pos);
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(int code) {

            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
