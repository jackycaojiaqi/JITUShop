package com.jitu.shop.adapter;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.github.lguipeng.library.animcheckbox.AnimCheckBox;
import com.jitu.shop.AppConstant;
import com.jitu.shop.R;
import com.jitu.shop.entity.CommondityListEntity;
import com.jitu.shop.entity.OrderListEntity;
import com.jitu.shop.ui.OrdrInfoActivity;
import com.jitu.shop.util.ImagUtil;
import com.jitu.shop.util.StringUtil;
import com.socks.library.KLog;

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
public class CommondityListAdapter extends BaseQuickAdapter<CommondityListEntity.ResultBean, BaseViewHolder> {
    private List<CommondityListEntity.ResultBean> list = new ArrayList<>();
    private OrderListGoodsAdapter adapter;
    private boolean is_show_checkbox = false;

    public CommondityListAdapter(int layoutResId, List data) {
        super(layoutResId, data);
        list = data;
    }

    public void showAllCheckBox(boolean is_show_checkbox) {
        this.is_show_checkbox = is_show_checkbox;
        notifyDataSetChanged();
    }

    @Override
    protected void convert(BaseViewHolder helper, final CommondityListEntity.ResultBean item) {
        //图片
        if (!StringUtil.isEmptyandnull(item.getMainImg())) {
            ImagUtil.setnoerror(mContext, item.getMainImg(), helper.getView(R.id.iv_commondity_list_pic));
        }
        helper.setText(R.id.tv_commondity_list_good_detail, StringUtil.isEmptyandnull(item.getPackingName()) ? "未知" : item.getPackingName())
                .setText(R.id.tv_commondity_list_goods_price,"¥ " +String.valueOf(item.getSales()))
                .setText(R.id.tv_commondity_list_warehouse_num,"库存"+ item.getInventory() + " ")
                .setText(R.id.tv_commondity_list_sale_num, "销量："+item.getSellernum())
                .setText(R.id.tv_commondity_list_goods_num, "货号:" + item.getpCode());//
        if (is_show_checkbox) {
            helper.getView(R.id.cb_commondity).setVisibility(View.VISIBLE);
        } else {
            helper.getView(R.id.cb_commondity).setVisibility(View.GONE);
        }
        ((AnimCheckBox) helper.getView(R.id.cb_commondity)).setOnCheckedChangeListener(new AnimCheckBox.OnCheckedChangeListener() {
            @Override
            public void onChange(AnimCheckBox animCheckBox, boolean b) {
                item.setIs_check(b);
            }
        });
        if (item.is_check()) {
            ((AnimCheckBox) helper.getView(R.id.cb_commondity)).setChecked(true, false);
        } else {
            ((AnimCheckBox) helper.getView(R.id.cb_commondity)).setChecked(false, false);
        }

    }
}
