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
import com.jitu.shop.ui.OrdrInfoActivity;
import com.jitu.shop.util.ImagUtil;
import com.jitu.shop.util.StringUtil;
import com.socks.library.KLog;
import com.vondear.rxtools.view.tooltips.RxToolTip;
import com.vondear.rxtools.view.tooltips.RxToolTipsManager;

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
    RxToolTipsManager mRxToolTipsManager;
    RxToolTip.Builder builder;
    View tipvView;
    public OrderListAdapter(int layoutResId, List data) {
        super(layoutResId, data);
        list = data;
    }

    @Override
    protected void convert(final BaseViewHolder helper, final OrderListEntity.ResultBean item) {
        //（0全部,1刚下单，10已付款，15已发货，20已收货，30申请退款，33已经退货，35没有退货）
        helper.setText(R.id.tv_order_list_order_num, "订单编号：" + item.getOrderCode());
        if (item.getStates() == 1) {
            helper.setText(R.id.tv_order_list_order_state, "刚下单");
        } else if (item.getStates() == 10) {
            helper.setText(R.id.tv_order_list_order_state, "已付款");
        } else if (item.getStates() == 15) {
            helper.setText(R.id.tv_order_list_order_state, "已发货");
        } else if (item.getStates() == 20) {
            helper.setText(R.id.tv_order_list_order_state, "已收货");
        } else if (item.getStates() == 30) {
            helper.setText(R.id.tv_order_list_order_state, "申请退款");
        } else if (item.getStates() == 33) {
            helper.setText(R.id.tv_order_list_order_state, "已经退货");
        } else if (item.getStates() == 35) {
            helper.setText(R.id.tv_order_list_order_state, "没有退货");
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
                    intent.putExtra(AppConstant.OBJECT, item.getOrderCode());
                    mContext.startActivity(intent);
                }
            });
        }
    }
}
