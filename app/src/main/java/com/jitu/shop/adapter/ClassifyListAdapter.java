package com.jitu.shop.adapter;

import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.github.lguipeng.library.animcheckbox.AnimCheckBox;
import com.jitu.shop.R;
import com.jitu.shop.entity.ClassifyEntity;
import com.jitu.shop.entity.CommondityListEntity;
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
public class ClassifyListAdapter extends BaseQuickAdapter<ClassifyEntity.ResultBean, BaseViewHolder> {
    private List<ClassifyEntity.ResultBean> list = new ArrayList<>();
    private OrderListGoodsAdapter adapter;
    private boolean is_show_checkbox = false;

    public ClassifyListAdapter(int layoutResId, List data) {
        super(layoutResId, data);
        list = data;
    }

    public void showAllCheckBox(boolean is_show_checkbox) {
        KLog.e(is_show_checkbox);
        this.is_show_checkbox = is_show_checkbox;
        notifyDataSetChanged();
    }

    @Override
    protected void convert(BaseViewHolder helper, final ClassifyEntity.ResultBean item) {
        //分类名称
        helper.setText(R.id.tv_classsifi_name, item.getName());
        helper.addOnClickListener(R.id.iv_classsify_list_down)
                .addOnClickListener(R.id.iv_classsify_list_up)
                .addOnClickListener(R.id.iv_classsify_list_edit);

    }
}
