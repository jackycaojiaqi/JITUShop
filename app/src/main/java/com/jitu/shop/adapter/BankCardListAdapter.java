package com.jitu.shop.adapter;

import android.view.View;

import com.chad.library.adapter.base.BaseItemDraggableAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.guanaj.easyswipemenulibrary.EasySwipeMenuLayout;
import com.jitu.shop.R;
import com.jitu.shop.entity.BankCardListEntity;
import com.vondear.rxtools.view.RxToast;

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
public class BankCardListAdapter extends BaseQuickAdapter<BankCardListEntity.ResultBean, BaseViewHolder> {
    private List<BankCardListEntity.ResultBean> list = new ArrayList<>();
    private OrderListGoodsAdapter adapter;
    private boolean is_show_checkbox = false;

    public BankCardListAdapter(int layoutResId, List data) {
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
        helper.setText(R.id.tv_bank_card_name, item.getCM_BankName())
                .setText(R.id.tv_bank_card_last4_num, last_num);

        helper.getView(R.id.right_menu_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(item.getCM_Id(), "remove_position");
                EasySwipeMenuLayout easySwipeMenuLayout = helper.getView(R.id.es);
                easySwipeMenuLayout.resetStatus();
            }
        });
    }
}
