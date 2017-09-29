package com.jitu.shop.adapter;

import android.os.Handler;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.github.lguipeng.library.animcheckbox.AnimCheckBox;
import com.guanaj.easyswipemenulibrary.EasySwipeMenuLayout;
import com.jitu.shop.R;
import com.jitu.shop.entity.BankCardListEntity;
import com.socks.library.KLog;

import org.simple.eventbus.EventBus;

import java.util.ArrayList;
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
public class CardListAdapter extends BaseQuickAdapter<BankCardListEntity.ResultBean, BaseViewHolder> {
    private List<BankCardListEntity.ResultBean> list = new ArrayList<>();
    private OrderListGoodsAdapter adapter;
    private boolean is_show_checkbox = false;

    public CardListAdapter(int layoutResId, List data) {
        super(layoutResId, data);
        list = data;
    }

    public void showAllCheckBox(boolean is_show_checkbox) {
        this.is_show_checkbox = is_show_checkbox;
        notifyDataSetChanged();
    }

    @Override
    protected void convert(final BaseViewHolder helper, final BankCardListEntity.ResultBean item) {
        String last_num = item.getCM_CardNum();
        if (last_num.length() > 5) {
            last_num = last_num.substring(last_num.length() - 4, last_num.length());
        }
        helper.setText(R.id.tv_card_name, "银行卡 **** **** 尾号 " + last_num);
        ((AnimCheckBox) helper.getView(R.id.cb_card)).setClickable(false);
        if (item.is_checked()) {
            ((AnimCheckBox) helper.getView(R.id.cb_card)).setChecked(true, true);
        } else {
            ((AnimCheckBox) helper.getView(R.id.cb_card)).setChecked(false, true);
        }

    }
}
