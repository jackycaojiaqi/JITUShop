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
import com.jitu.shop.entity.MainMenuEntity;
import com.jitu.shop.entity.OrderListEntity;
import com.jitu.shop.ui.AfterSaleActivity;
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
public class OrderListAdapter extends BaseQuickAdapter<OrderListEntity.ResultBean, BaseViewHolder> {
    private List<OrderListEntity.ResultBean> list = new ArrayList<>();
    private OrderListGoodsAdapter adapter;
    View tipvView;

    public OrderListAdapter(int layoutResId, List data) {
        super(layoutResId, data);
        list = data;
    }

    @Override
    protected void convert(final BaseViewHolder helper, final OrderListEntity.ResultBean item) {
        //（0全部,1刚下单，10已付款，15已发货，20已收货，30申请退款，33已经退货，35没有退货）
        helper.setText(R.id.tv_order_list_order_num, "订单编号：" + item.getId());
        if (item.getStates() == 1) {
            helper.setText(R.id.tv_order_list_order_state, "刚下单");
            helper.getView(R.id.tv_order_list_action).setVisibility(View.GONE);
            helper.getView(R.id.tv_order_list_action2).setVisibility(View.GONE);
        } else if (item.getStates() == 10) {
            helper.setText(R.id.tv_order_list_order_state, "已付款");
            helper.getView(R.id.tv_order_list_action).setVisibility(View.VISIBLE);
            ((TextView) helper.getView(R.id.tv_order_list_action)).setText("发货");
            helper.getView(R.id.tv_order_list_action2).setVisibility(View.GONE);
        } else if (item.getStates() == 15) {
            helper.setText(R.id.tv_order_list_order_state, "已发货");
            helper.getView(R.id.tv_order_list_action).setVisibility(View.GONE);
            helper.getView(R.id.tv_order_list_action2).setVisibility(View.GONE);
        } else if (item.getStates() == 20) {
            helper.setText(R.id.tv_order_list_order_state, "已收货");
            helper.getView(R.id.tv_order_list_action).setVisibility(View.GONE);
            helper.getView(R.id.tv_order_list_action2).setVisibility(View.GONE);
        }

        final LinearLayout linearLayout = helper.getView(R.id.ll_order_parent);
        //添加按钮监听
        helper.addOnClickListener(R.id.tv_order_list_action);

        //价格
        helper.setText(R.id.tv_order_list_goods_price, "¥" + item.getAmount());
        //商品详细列表
        adapter = new OrderListGoodsAdapter(mContext, item.getTB_List());
        if (item.getTB_List() != null) {
            //商品共计几件
            helper.setText(R.id.tv_order_list_goods_count, "商品共计" + item.getTB_List().size() + "件");
            ((ListView) helper.getView(R.id.lv_order_list)).setAdapter(adapter);
            ((ListView) helper.getView(R.id.lv_order_list)).setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(mContext, OrdrInfoActivity.class);
                    intent.putExtra(AppConstant.OBJECT, item.getId());
                    mContext.startActivity(intent);
                }
            });
        }
        //处理售后
        if (item.getCM_OrderServiceState() != 0) {
            helper.getView(R.id.tv_order_list_action).setVisibility(View.VISIBLE);
            helper.getView(R.id.tv_order_list_action2).setVisibility(View.GONE);
            //type:1退款，2退货退款,3换货
            if (item.getCM_OrderServiceTpye() == 1) {
                ((TextView) helper.getView(R.id.tv_order_list_action)).setText("退款");
            } else if (item.getCM_OrderServiceTpye() == 2) {
                ((TextView) helper.getView(R.id.tv_order_list_action)).setText("退货退款");
            } else if (item.getCM_OrderServiceTpye() == 3) {
                ((TextView) helper.getView(R.id.tv_order_list_action)).setText("换货");
            }
        }
    }
}
