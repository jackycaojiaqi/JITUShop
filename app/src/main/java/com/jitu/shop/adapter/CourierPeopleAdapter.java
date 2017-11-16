package com.jitu.shop.adapter;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jitu.shop.AppConstant;
import com.jitu.shop.R;
import com.jitu.shop.entity.CourierPeopleEntity;

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
public class CourierPeopleAdapter extends BaseQuickAdapter<CourierPeopleEntity.ResultBean, BaseViewHolder> {
    private List<CourierPeopleEntity.ResultBean> list = new ArrayList<>();
    private OrderListGoodsAdapter adapter;
    View tipvView;

    public CourierPeopleAdapter(int layoutResId, List data) {
        super(layoutResId, data);
        list = data;
    }

    @Override
    protected void convert(final BaseViewHolder helper, final CourierPeopleEntity.ResultBean item) {
        helper.setText(R.id.tv_courier_name, "姓名：" + item.getRealName())
                .setText(R.id.tv_courier_phone, "电话：" + item.getMobile())
                .setText(R.id.tv_courier_id, "身份证：" + item.getCardNo());
    }
}
