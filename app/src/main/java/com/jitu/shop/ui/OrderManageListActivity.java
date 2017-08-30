package com.jitu.shop.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jitu.shop.R;
import com.jitu.shop.adapter.MainMenuAdapter;
import com.jitu.shop.adapter.WelcomePagerAdapter;
import com.jitu.shop.base.BaseActivity;
import com.jitu.shop.ui.fragment.OrderListFiveFragment;
import com.jitu.shop.ui.fragment.OrderListFourFragment;
import com.jitu.shop.ui.fragment.OrderListOneFragment;
import com.jitu.shop.ui.fragment.OrderListSixFragment;
import com.jitu.shop.ui.fragment.OrderListThreeFragment;
import com.jitu.shop.ui.fragment.OrderListTwoFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.jpush.android.api.JPushInterface;

/**
 * Created by jacky on 2017/8/28.
 */
public class OrderManageListActivity extends BaseActivity {
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_submit)
    TextView tvSubmit;
    @BindView(R.id.tl_ordermanage_list)
    TabLayout tlOrdermanageList;
    @BindView(R.id.vp_order_list)
    ViewPager vpOrderList;
    private List<String> titles = new ArrayList<>();
    private List<Fragment> fragments = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTranslucentStatus();
        setContentView(R.layout.activity_ordermanage_list);
        ButterKnife.bind(this);
        initview();
        initdate();
    } @Override
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
        setText(tvTitle, "订单管理");
        titles.add("全部");
        titles.add("待付款");
        titles.add("待发货");
        titles.add("已发货");
        titles.add("待评价");
        titles.add("待售后");
        fragments.add(new OrderListOneFragment());
        fragments.add(new OrderListTwoFragment());
        fragments.add(new OrderListThreeFragment());
        fragments.add(new OrderListFourFragment());
        fragments.add(new OrderListFiveFragment());
        fragments.add(new OrderListSixFragment());
        WelcomePagerAdapter adapter = new WelcomePagerAdapter(getSupportFragmentManager(), fragments, titles);
        vpOrderList.setAdapter(adapter);
        vpOrderList.setOffscreenPageLimit(2);
        tlOrdermanageList.setupWithViewPager(vpOrderList);
        tlOrdermanageList.setTabMode(TabLayout.MODE_FIXED);
    }

    private void initdate() {
    }

    @OnClick({R.id.iv_back, R.id.vp_order_list})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
        }
    }
}
