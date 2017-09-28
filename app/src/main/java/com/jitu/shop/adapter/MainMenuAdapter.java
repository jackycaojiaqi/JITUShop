package com.jitu.shop.adapter;

import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jitu.shop.R;
import com.jitu.shop.entity.MainMenuEntity;

import java.util.List;

/**
 * 　　　　　　　　┏┓　　　┏┓
 * 　　　　　　　┏┛┻━━━┛┻┓
 * 　　　　　　　┃　　　　　　　┃
 * 　　　　　　　┃　　　━　　　┃
 * 　　　　　　　┃　＞　　　＜　┃
 * 　　　　　　　┃　　　　　　　┃
 * 　　　　　　　┃...　⌒　...　┃
 * 　　　　　　　┃　　　　　　　┃
 * 　　　　　　　┗━┓　　　┏━┛
 * 　　　　　　　　　┃　　　┃　Code is far away from bug with the animal protecting
 * 　　　　　　　　　┃　　　┃   神兽保佑,代码无bug
 * 　　　　　　　　　┃　　　┃
 * 　　　　　　　　　┃　　　┃
 * 　　　　　　　　　┃　　　┃
 * 　　　　　　　　　┃　　　┃
 * 　　　　　　　　　┃　　　┗━━━┓
 * 　　　　　　　　　┃　　　　　　　┣┓
 * 　　　　　　　　　┃　　　　　　　┏┛
 * 　　　　　　　　　┗┓┓┏━┳┓┏┛
 * 　　　　　　　　　　┃┫┫　┃┫┫
 * 　　　　　　　　　　┗┻┛　┗┻┛
 * ━━━━━━神兽出没━━━━━━
 * Created by jacky on 17/3/10.
 */
public class MainMenuAdapter extends BaseQuickAdapter<MainMenuEntity.ResultBean.MenusBean, BaseViewHolder> {
    private List<MainMenuEntity.ResultBean.MenusBean> list;

    public MainMenuAdapter(int layoutResId, List data) {
        super(layoutResId, data);
        list = data;
    }

    @Override
    protected void convert(BaseViewHolder helper, MainMenuEntity.ResultBean.MenusBean item) {
        if (item.getCM_MenuId() == 1) {
            helper.setImageResource(R.id.iv_main_menu_pic, R.drawable.home_btn_order_management);
        } else if (item.getCM_MenuId() == 2) {
            helper.setImageResource(R.id.iv_main_menu_pic, R.drawable.home_btn_commodity_management);
        } else if (item.getCM_MenuId() == 3) {
            helper.setImageResource(R.id.iv_main_menu_pic, R.drawable.home_btn_cash_withdrawal_management);
        } else if (item.getCM_MenuId() == 4) {
            helper.setImageResource(R.id.iv_main_menu_pic, R.drawable.home_btn_merchant_management);
        } else if (item.getCM_MenuId() == 5) {
            helper.setImageResource(R.id.iv_main_menu_pic, R.drawable.home_btn_management_profile);
        } else if (item.getCM_MenuId() == 6) {
            helper.setImageResource(R.id.iv_main_menu_pic, R.drawable.home_btn_message_management);
        }
        helper.setText(R.id.tv_main_menu_name, item.getCM_MenuName());
        if (item.is_show_spot()) {
            helper.getView(R.id.iv_red_spot).setVisibility(View.VISIBLE);
        } else {
            helper.getView(R.id.iv_red_spot).setVisibility(View.GONE);
        }
    }
}
