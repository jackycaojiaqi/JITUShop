package com.jitu.shop.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.github.lguipeng.library.animcheckbox.AnimCheckBox;
import com.jitu.shop.R;
import com.jitu.shop.entity.BankCardListEntity;
import com.jitu.shop.entity.GetCashHistoryEntity;

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
public class GetCashHistoryAdapter extends BaseQuickAdapter<GetCashHistoryEntity.ResultBean, BaseViewHolder> {
    private List<GetCashHistoryEntity.ResultBean> list = new ArrayList<>();
    private OrderListGoodsAdapter adapter;
    private boolean is_show_checkbox = false;

    public GetCashHistoryAdapter(int layoutResId, List data) {
        super(layoutResId, data);
        list = data;
    }

    public void showAllCheckBox(boolean is_show_checkbox) {
        this.is_show_checkbox = is_show_checkbox;
        notifyDataSetChanged();
    }

    @Override
    protected void convert(final BaseViewHolder helper, final GetCashHistoryEntity.ResultBean item) {
        String time = item.getCM_CreateTime().substring(0, 10);
        String time_detail = item.getCM_CreateTime().substring(11, 16);

        String last_4 = item.getCM_CardNum().substring(item.getCM_CardNum().length() - 4, item.getCM_CardNum().length());
        helper.setText(R.id.tv_get_cash_time, time)
                .setText(R.id.tv_get_cash_time_detail, time_detail)
                .setText(R.id.tv_get_cash_money, "+" + item.getCM_Money())
                .setText(R.id.tv_get_cash_name_and_last_4, item.getCM_BankName() + "尾号（" + last_4 + ")");
    }
}
