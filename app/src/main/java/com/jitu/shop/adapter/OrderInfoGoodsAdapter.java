package com.jitu.shop.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jitu.shop.R;
import com.jitu.shop.entity.OrderInfoEntity;
import com.jitu.shop.entity.OrderListEntity;
import com.jitu.shop.util.ImagUtil;
import com.jitu.shop.util.StringUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jacky on 2017/8/30.
 */
public class OrderInfoGoodsAdapter extends BaseAdapter {
    private List<OrderInfoEntity.ResultBean.TBOrderDetailsBean> list = new ArrayList<>();
    private Context context;
    private LayoutInflater mInflater = null;

    public OrderInfoGoodsAdapter(Context context, List<OrderInfoEntity.ResultBean.TBOrderDetailsBean> list) {
        this.list = list;
        this.context = context;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        //如果缓存convertView为空，则需要创建View
        if (convertView == null) {
            holder = new ViewHolder();
            //根据自定义的Item布局加载布局
            convertView = mInflater.inflate(R.layout.item_order_list_goodslist, null);
            holder.good_img = (ImageView) convertView.findViewById(R.id.iv_order_goods_list_pic);
            holder.good_name = (TextView) convertView.findViewById(R.id.tv_order_goods_list_name);
            holder.good_type = (TextView) convertView.findViewById(R.id.tv_order_goods_list_type);
            holder.good_price = (TextView) convertView.findViewById(R.id.tv_order_goods_list_price);
            holder.good_num = (TextView) convertView.findViewById(R.id.tv_order_goods_list_num);
            //将设置好的布局保存到缓存中，并将其设置在Tag里，以便后面方便取出Tag
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        //商品图片
        if (!StringUtil.isEmptyandnull(list.get(position).getMainImg()))
            ImagUtil.setnoerror(context, list.get(position).getMainImg(), holder.good_img);
        //名称
        holder.good_name.setText(StringUtil.isEmptyandnull(list.get(position).getProductName()) ? "未知" : list.get(position).getProductName());
        //价格
        String price = StringUtil.isEmptyandnull(list.get(position).getPcice()) ? "未知" : list.get(position).getPcice();
        holder.good_price.setText("¥ " + price);
        //数量
        holder.good_num.setText("x " + list.get(position).getNumber());
        //类别
        holder.good_type.setText(" " + list.get(position).getPname());
        return convertView;
    }

    private class ViewHolder {
        private ImageView good_img;
        private TextView good_name;
        private TextView good_type;
        private TextView good_price;
        private TextView good_num;
    }
}
