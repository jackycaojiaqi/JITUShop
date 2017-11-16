package com.jitu.shop.adapter;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jitu.shop.AppConstant;
import com.jitu.shop.R;
import com.jitu.shop.entity.OrderListEntity;
import com.jitu.shop.entity.ShopTypeEntity;
import com.jitu.shop.ui.OrdrInfoActivity;

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
public class ShopTypeAdapter extends BaseQuickAdapter<ShopTypeEntity.ResultBean, BaseViewHolder> {
    private List<ShopTypeEntity.ResultBean> list = new ArrayList<>();
    private OrderListGoodsAdapter adapter;
    View tipvView;

    public ShopTypeAdapter(int layoutResId, List data) {
        super(layoutResId, data);
        list = data;
    }

    @Override
    protected void convert(final BaseViewHolder helper, final ShopTypeEntity.ResultBean item) {
        helper.setText(R.id.tv_shop_type_name, item.getName() + " ");
        if (item.is_show_line()) {
            helper.getView(R.id.v_shop_type_line).setVisibility(View.VISIBLE);
        } else {
            helper.getView(R.id.v_shop_type_line).setVisibility(View.GONE);
        }

    }
}
