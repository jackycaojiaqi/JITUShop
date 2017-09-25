package com.jitu.shop.ui;

import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.callback.ItemDragAndSwipeCallback;
import com.chad.library.adapter.base.listener.OnItemSwipeListener;
import com.jitu.shop.AppConstant;
import com.jitu.shop.R;
import com.jitu.shop.adapter.BankCardListAdapter;
import com.jitu.shop.adapter.CommondityListAdapter;
import com.jitu.shop.base.BaseActivity;
import com.jitu.shop.entity.BankCardListEntity;
import com.jitu.shop.entity.BasePaserEntity;
import com.jitu.shop.entity.CommondityListEntity;
import com.jitu.shop.interfaces.MyCallBack;
import com.jitu.shop.util.NetClient;
import com.jitu.shop.util.SPUtil;
import com.jitu.shop.util.ScreenUtils;
import com.jitu.shop.widget.DividerItemDecoration;
import com.jitu.shop.widget.MyListView;
import com.lzy.okgo.model.HttpParams;
import com.lzy.okgo.model.Response;
import com.vondear.rxtools.view.RxToast;
import com.yanzhenjie.recyclerview.swipe.SwipeItemClickListener;
import com.yanzhenjie.recyclerview.swipe.SwipeMenu;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuCreator;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuItem;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.jpush.android.api.JPushInterface;

/**
 * Created by jacky on 2017/8/29.
 */
public class CashManageActivity extends BaseActivity {
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_submit)
    TextView tvSubmit;
    @BindView(R.id.tv_cash_manage_money_left)
    TextView tvCashManageMoneyLeft;
    @BindView(R.id.rll_cash_manage)
    RelativeLayout rllCashManage;
    @BindView(R.id.tv_cash_manage_money_totle)
    TextView tvCashManageMoneyTotle;
    @BindView(R.id.tv_cash_manage_money_doing)
    TextView tvCashManageMoneyDoing;
    @BindView(R.id.tv_cash_manage_money_get)
    TextView tvCashManageMoneyGet;
    @BindView(R.id.tv_cash_manage_get_amount)
    TextView tvCashManageGetAmount;
    @BindView(R.id.rll_cash_manage_detail)
    RelativeLayout rllCashManageDetail;
    @BindView(R.id.tv_cash_manage_card)
    TextView tvCashManageCard;
    @BindView(R.id.rll_cash_manage_card)
    RelativeLayout rllCashManageCard;
    @BindView(R.id.lv_cash_cards)
    RecyclerView lvCashCards;
    @BindView(R.id.rll_cash_add_card)
    RelativeLayout rllCashAddCard;
    @BindView(R.id.ll_cash_card_list)
    LinearLayout llCashCardList;
    private BankCardListAdapter adapter;
    private List<BankCardListEntity.ResultBean> list = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cashmanage);
        ButterKnife.bind(this);
        initview();
    }

    @Override
    protected void onResume() {
        super.onResume();
        initdate();
        JPushInterface.onResume(getApplicationContext());
    }

    @Override
    protected void onPause() {
        super.onPause();
        JPushInterface.onPause(getApplicationContext());
    }

    private void initview() {
        setText(tvTitle, "提现管理");
        //=========================recycleview配置
        adapter = new BankCardListAdapter(R.layout.item_bank_card_list, list);
        lvCashCards.setLayoutManager(new LinearLayoutManager(context));
        adapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
        adapter.enableSwipeItem();

        ItemDragAndSwipeCallback itemDragAndSwipeCallback = new ItemDragAndSwipeCallback(adapter);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(itemDragAndSwipeCallback);
        itemTouchHelper.attachToRecyclerView(lvCashCards);
        // 开启滑动删除
        adapter.enableSwipeItem();
        adapter.setOnItemSwipeListener(onItemSwipeListener);
        // 设置监听器。
//        lvCashCards.setSwipeMenuCreator(mSwipeMenuCreator);
//        lvCashCards.setItemViewSwipeEnabled(true); // 开启滑动删除。
//        lvCashCards.setNestedScrollingEnabled(false);
//        lvCashCards.setSwipeItemClickListener(new SwipeItemClickListener() {
//            @Override
//            public void onItemClick(View view, int position) {
//                RxToast.success("position:" + position);
//            }
//        });
        adapter.bindToRecyclerView(lvCashCards);
        adapter.setEmptyView(R.layout.empty_view);
        lvCashCards.setAdapter(adapter);
        //=========================recycleview配置结束
    }
    OnItemSwipeListener onItemSwipeListener = new OnItemSwipeListener() {
        @Override
        public void onItemSwipeStart(RecyclerView.ViewHolder viewHolder, int pos) {}
        @Override
        public void clearView(RecyclerView.ViewHolder viewHolder, int pos) {}
        @Override
        public void onItemSwiped(RecyclerView.ViewHolder viewHolder, int pos) {
            RxToast.success("position:" + pos);
        }

        @Override
        public void onItemSwipeMoving(Canvas canvas, RecyclerView.ViewHolder viewHolder, float dX, float dY, boolean isCurrentlyActive) {

        }
    };

    // 创建菜单：
    SwipeMenuCreator mSwipeMenuCreator = new SwipeMenuCreator() {
        @Override
        public void onCreateMenu(SwipeMenu leftMenu, SwipeMenu rightMenu, int viewType) {

            SwipeMenuItem deleteItem = new SwipeMenuItem(context);
            deleteItem.setText("删除");
            deleteItem.setBackground(getResources().getDrawable(R.color.white));
            deleteItem.setTextColor(Color.RED);
            deleteItem.setWidth(ScreenUtils.dp2Px(context, 50));
            deleteItem.setHeight(ScreenUtils.dp2Px(context, 50));
            // 各种文字和图标属性设置。
            rightMenu.addMenuItem(deleteItem); // 在Item右侧添加一个菜单。

            // 注意：哪边不想要菜单，那么不要添加即可。
        }
    };

    private void initdate() {
        HttpParams params = new HttpParams();
        params.put("token", (String) SPUtil.get(context, AppConstant.TOKEN, ""));
        NetClient.getInstance(BankCardListEntity.class).Get(context, AppConstant.URL_QUERYMYCARD, params, new MyCallBack() {
            @Override
            public void onFailure(int code) {

            }

            @Override
            public void onResponse(Response object) {
                BankCardListEntity bankCardListEntity = (BankCardListEntity) object.body();
                if (bankCardListEntity.getErrorCode() == 0) {
                    list = bankCardListEntity.getResult();
                    adapter.setNewData(list);
                }
            }
        });

    }

    @OnClick({R.id.iv_back, R.id.rll_cash_manage, R.id.rll_cash_manage_detail, R.id.rll_cash_manage_card,
            R.id.rll_cash_add_card})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.rll_cash_manage:
                startActivity(new Intent(context, GetCashActivity.class));
                break;
            case R.id.rll_cash_manage_detail:
                startActivity(new Intent(context, AddCardActivity.class));
                break;
            case R.id.rll_cash_manage_card:
                startActivity(new Intent(context, AddCardActivity.class));
                break;
            case R.id.rll_cash_add_card:
                break;
        }
    }
}
