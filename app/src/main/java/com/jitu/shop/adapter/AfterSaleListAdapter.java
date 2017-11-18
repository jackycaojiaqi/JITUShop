package com.jitu.shop.adapter;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jitu.shop.AppConstant;
import com.jitu.shop.R;
import com.jitu.shop.entity.AfterSaleEntity;
import com.jitu.shop.ui.AfterSaleActivity;

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
public class AfterSaleListAdapter extends BaseQuickAdapter<AfterSaleEntity.ResultBean, BaseViewHolder> {
    private List<AfterSaleEntity.ResultBean> list = new ArrayList<>();
    private AfterSaleListGoodsAdapter adapter;
    View tipvView;

    public AfterSaleListAdapter(int layoutResId, List data) {
        super(layoutResId, data);
        list = data;
    }

    @Override
    protected void convert(final BaseViewHolder helper, final AfterSaleEntity.ResultBean item) {
        //（0全部,1刚下单，10已付款，15已发货，20已收货，30申请退款，33已经退货，35没有退货）
        helper.setText(R.id.tv_order_list_order_num, "售后编号：" + item.getCM_ServiceId());
        if (item.getCM_State() == 1) {
            //type:1退款，2退货退款,3换货
            if (item.getCM_Type() == 1) {
                helper.setText(R.id.tv_order_list_order_state, "退款");
                helper.setText(R.id.tv_order_list_action, "退款");
            } else if (item.getCM_Type() == 2) {
                helper.setText(R.id.tv_order_list_order_state, "退货退款");
                helper.setText(R.id.tv_order_list_action, "退货退款");
            } else if (item.getCM_Type() == 3) {
                helper.setText(R.id.tv_order_list_order_state, "换货");
                helper.setText(R.id.tv_order_list_action, "换货");
            }
            helper.getView(R.id.tv_order_list_action).setVisibility(View.VISIBLE);
            helper.getView(R.id.tv_order_list_action2).setVisibility(View.GONE);
        }

        //添加按钮监听
        helper.addOnClickListener(R.id.tv_order_list_action);

        //隐藏布局价格
        helper.getView(R.id.tv_order_list_goods_price).setVisibility(View.GONE);
        //售后原因
        helper.setText(R.id.tv_order_list_goods_count, " " + item.getCM_Reason());
        //商品详细列表
        adapter = new AfterSaleListGoodsAdapter(mContext, item.getTB_Details());
        if (item.getTB_Details() != null) {

            ((ListView) helper.getView(R.id.lv_order_list)).setAdapter(adapter);
            ((ListView) helper.getView(R.id.lv_order_list)).setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(mContext, AfterSaleActivity.class);
                    intent.putExtra(AppConstant.OBJECT, item.getCM_ServiceId());
                    intent.putExtra(AppConstant.TYPE, item.getCM_Type());
                    mContext.startActivity(intent);
                }
            });
        }
    }
}
