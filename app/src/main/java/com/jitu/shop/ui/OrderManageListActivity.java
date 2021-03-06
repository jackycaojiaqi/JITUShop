package com.jitu.shop.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jitu.shop.AppConstant;
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
    private int show_page = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ordermanage_list);
        ButterKnife.bind(this);
        show_page = getIntent().getIntExtra(AppConstant.PAGE, 0);
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
        setText(tvTitle, "订单管理");
        titles.add("全部");
        titles.add("待付款");
        titles.add("待发货");
        titles.add("已发货");
        titles.add("已收货");
        titles.add("待售后");
        OrderListOneFragment fragment1 = new OrderListOneFragment();
        Bundle bundle = new Bundle();
        bundle.putString(AppConstant.TYPE, "1");
        fragment1.setArguments(bundle);

        OrderListTwoFragment fragment2 = new OrderListTwoFragment();
        Bundle bundle2 = new Bundle();
        bundle2.putString(AppConstant.TYPE, "2");
        fragment2.setArguments(bundle2);

        OrderListThreeFragment fragment3 = new OrderListThreeFragment();
        Bundle bundle3 = new Bundle();
        bundle3.putString(AppConstant.TYPE, "3");
        fragment3.setArguments(bundle3);

        OrderListFourFragment fragment4 = new OrderListFourFragment();
        Bundle bundle4 = new Bundle();
        bundle4.putString(AppConstant.TYPE, "4");
        fragment4.setArguments(bundle4);

        OrderListFiveFragment fragment5 = new OrderListFiveFragment();
        Bundle bundle5 = new Bundle();
        bundle5.putString(AppConstant.TYPE, "5");
        fragment5.setArguments(bundle5);

        OrderListSixFragment fragment6 = new OrderListSixFragment();
        Bundle bundle6 = new Bundle();
        bundle6.putString(AppConstant.TYPE, "6");
        fragment6.setArguments(bundle6);
        vpOrderList.setOffscreenPageLimit(5);
        fragments.add(fragment1);
        fragments.add(fragment2);
        fragments.add(fragment3);
        fragments.add(fragment4);
        fragments.add(fragment5);
        fragments.add(fragment6);
        WelcomePagerAdapter adapter = new WelcomePagerAdapter(getSupportFragmentManager(), fragments, titles);
        vpOrderList.setAdapter(adapter);
        tlOrdermanageList.setupWithViewPager(vpOrderList);
        tlOrdermanageList.setTabMode(TabLayout.MODE_FIXED);
        vpOrderList.setCurrentItem(show_page);
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
