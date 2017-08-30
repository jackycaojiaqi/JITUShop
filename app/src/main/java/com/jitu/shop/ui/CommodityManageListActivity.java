package com.jitu.shop.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jitu.shop.R;
import com.jitu.shop.adapter.WelcomePagerAdapter;
import com.jitu.shop.base.BaseActivity;
import com.jitu.shop.ui.fragment.CommodityListOneFragment;
import com.jitu.shop.ui.fragment.CommodityListThreeFragment;
import com.jitu.shop.ui.fragment.CommodityListTwoFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.jpush.android.api.JPushInterface;

/**
 * Created by jacky on 2017/8/28.
 */
public class CommodityManageListActivity extends BaseActivity {
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
    @BindView(R.id.tv_commonditymanege_classify)
    TextView tvCommonditymanegeClassify;
    private List<String> titles = new ArrayList<>();
    private List<Fragment> fragments = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTranslucentStatus();
        setContentView(R.layout.activity_commonditymanage_list);
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
        setText(tvTitle, "商品管理");
        titles.add("出售中");
        titles.add("已售完");
        titles.add("已下架");
        fragments.add(new CommodityListOneFragment());
        fragments.add(new CommodityListTwoFragment());
        fragments.add(new CommodityListThreeFragment());
        WelcomePagerAdapter adapter = new WelcomePagerAdapter(getSupportFragmentManager(), fragments, titles);
        vpOrderList.setAdapter(adapter);
        vpOrderList.setOffscreenPageLimit(2);
        tlOrdermanageList.setupWithViewPager(vpOrderList);
        tlOrdermanageList.setTabMode(TabLayout.MODE_FIXED);
    }

    private void initdate() {
    }

    @OnClick({R.id.iv_back, R.id.vp_order_list, R.id.tv_commonditymanege_classify})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_commonditymanege_classify:
                startActivity(new Intent(context,CategoryManegeActivity.class));
                break;
        }
    }
}