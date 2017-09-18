package com.jitu.shop.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jitu.shop.AppConstant;
import com.jitu.shop.R;
import com.jitu.shop.adapter.WelcomePagerAdapter;
import com.jitu.shop.base.BaseActivity;
import com.jitu.shop.entity.CommondityMessage;
import com.jitu.shop.entity.OrderListEntity;
import com.jitu.shop.interfaces.MyCallBack;
import com.jitu.shop.ui.fragment.CommodityListOneFragment;
import com.jitu.shop.util.NetClient;
import com.jitu.shop.util.SPUtil;
import com.lzy.okgo.model.Response;
import com.socks.library.KLog;
import com.vondear.rxtools.RxBarUtils;
import com.vondear.rxtools.view.dialog.RxDialog;
import com.vondear.rxtools.view.dialog.RxDialogSureCancel;

import org.simple.eventbus.EventBus;
import org.simple.eventbus.Subscriber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @BindView(R.id.cb_commondity_list_action)
    Button cbCommondityListAction;
    @BindView(R.id.tv_commondity_goods_action)
    TextView tvCommondityGoodsAction;
    @BindView(R.id.tv_commondity_goods_delete)
    TextView tvCommondityGoodsDelete;
    @BindView(R.id.ll_commondity_action)
    LinearLayout llCommondityAction;

    private List<String> titles = new ArrayList<>();
    private List<Fragment> fragments = new ArrayList<>();
    public static boolean is_1show_checkbox = false;
    public static boolean is_2show_checkbox = false;
    private int select_page = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commonditymanage_list);
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
        setText(tvTitle, "商品管理");
        titles.add("出售中");
        titles.add("已下架");
        CommodityListOneFragment fragment1 = new CommodityListOneFragment();
        Bundle bundle = new Bundle();
        bundle.putString(AppConstant.TYPE, "1");
        fragment1.setArguments(bundle);


        CommodityListOneFragment fragment2 = new CommodityListOneFragment();
        Bundle bundle2 = new Bundle();
        bundle2.putString(AppConstant.TYPE, "2");
        fragment2.setArguments(bundle2);

        fragments.add(fragment1);
        fragments.add(fragment2);
        WelcomePagerAdapter adapter = new WelcomePagerAdapter(getSupportFragmentManager(), fragments, titles);
        vpOrderList.setAdapter(adapter);
        tlOrdermanageList.setupWithViewPager(vpOrderList);
        tlOrdermanageList.setTabMode(TabLayout.MODE_FIXED);
        vpOrderList.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                select_page = position;
                if (position == 0) {
                    cbCommondityListAction.setText("批量下架");
                    tvCommondityGoodsAction.setText("下架");
                    tvCommondityGoodsDelete.setText("全部下架");
                } else {
                    cbCommondityListAction.setText("批量上架");
                    tvCommondityGoodsAction.setText("上架");
                    tvCommondityGoodsDelete.setText("删除");
                }
                //切换tab后需要  把状态置成false
                is_1show_checkbox = false;
                is_2show_checkbox = false;
                EventBus.getDefault().post(false, "checkbox_action");
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initdate() {
    }

    @OnClick({R.id.iv_back, R.id.vp_order_list, R.id.tv_commonditymanege_classify, R.id.cb_commondity_list_action
            , R.id.tv_commondity_goods_action, R.id.tv_commondity_goods_delete})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_commonditymanege_classify:
                startActivity(new Intent(context, ClassifyManageActivity.class));
                break;
            case R.id.cb_commondity_list_action:
                if (select_page == 0) {//下架
                    tvCommondityGoodsAction.setText("下架");
                    is_1show_checkbox = !is_1show_checkbox;
                    if (!is_1show_checkbox) {
                        llCommondityAction.setVisibility(View.GONE);
                    } else {
                        llCommondityAction.setVisibility(View.VISIBLE);
                    }
                    EventBus.getDefault().post(is_1show_checkbox, "checkbox_action");
                } else if (select_page == 1) {//上架
                    tvCommondityGoodsAction.setText("上架");
                    is_2show_checkbox = !is_2show_checkbox;
                    if (!is_2show_checkbox) {
                        llCommondityAction.setVisibility(View.GONE);
                    } else {
                        llCommondityAction.setVisibility(View.VISIBLE);
                    }
                    EventBus.getDefault().post(is_2show_checkbox, "checkbox_action");
                }
                switch (select_page) {
                    case 0:
                        if (!is_1show_checkbox) {
                            cbCommondityListAction.setText("批量下架");
                        } else {
                            cbCommondityListAction.setText("取消");
                        }
                        break;
                    case 1:
                        if (!is_2show_checkbox) {
                            cbCommondityListAction.setText("批量上架");
                        } else {
                            cbCommondityListAction.setText("取消");
                        }
                        break;
                }

                break;
            case R.id.tv_commondity_goods_action:
                EventBus.getDefault().post(select_page, "commondity_action_up_or_down");
                break;
            case R.id.tv_commondity_goods_delete:
                if (is_1show_checkbox) {
                    final RxDialogSureCancel rxDialogSureCancel = new RxDialogSureCancel(context);//提示弹窗
                    rxDialogSureCancel.setContent("确认下架全店商品？");
                    rxDialogSureCancel.getTvSure().setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            EventBus.getDefault().post(select_page, "commondity_action_delete");
                            rxDialogSureCancel.cancel();
                        }
                    });
                    rxDialogSureCancel.getTvCancel().setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            rxDialogSureCancel.cancel();
                        }
                    });
                    rxDialogSureCancel.show();
                } else if (is_2show_checkbox) {
                    final RxDialogSureCancel rxDialogSureCancel = new RxDialogSureCancel(context);//提示弹窗
                    rxDialogSureCancel.setContent("确认删除商品？");
                    rxDialogSureCancel.getTvSure().setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            EventBus.getDefault().post(select_page, "commondity_action_del_select");
                            rxDialogSureCancel.cancel();
                        }
                    });
                    rxDialogSureCancel.getTvCancel().setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            rxDialogSureCancel.cancel();
                        }
                    });
                    rxDialogSureCancel.show();
                }
                break;
        }
    }

    /**
     * 点击按钮，显示或隐藏checkbox，并记住状态
     * @param object
     */
    @Subscriber(tag = "invisible_view")
    private void invisible_view(String object) {
        llCommondityAction.setVisibility(View.GONE);
        if (select_page == 0) {//下架
            cbCommondityListAction.setText("批量下架");
            is_1show_checkbox = false;
        } else if (select_page == 1) {//上架
            cbCommondityListAction.setText("批量上架");
            is_2show_checkbox = false;
        }
    }

    /**
     * 下拉刷新后充值按钮状态
     * @param object
     */
    @Subscriber(tag = "refresh_button")
    private void refresh_button(String object) {
        if (select_page == 0) {//下架
            cbCommondityListAction.setText("批量下架");
        } else if (select_page == 1) {//上架
            cbCommondityListAction.setText("批量上架");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}