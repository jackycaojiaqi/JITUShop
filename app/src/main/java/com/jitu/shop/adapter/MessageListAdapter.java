package com.jitu.shop.adapter;

import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.github.lguipeng.library.animcheckbox.AnimCheckBox;
import com.jitu.shop.R;
import com.jitu.shop.entity.CommondityListEntity;
import com.jitu.shop.entity.MessageEntity;
import com.jitu.shop.util.ImagUtil;
import com.jitu.shop.util.StringUtil;

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
public class MessageListAdapter extends BaseQuickAdapter<MessageEntity.ResultBean, BaseViewHolder> {
    private List<MessageEntity.ResultBean> list = new ArrayList<>();
    private OrderListGoodsAdapter adapter;
    private boolean is_show_checkbox = false;

    public MessageListAdapter(int layoutResId, List data) {
        super(layoutResId, data);
        list = data;
    }


    @Override
    protected void convert(BaseViewHolder helper, final MessageEntity.ResultBean item) {
        helper.setText(R.id.tv_message_title, item.getCM_Title()).
                setText(R.id.tv_message_content, item.getCM_Content()).
                setText(R.id.tv_message_time, item.getCM_CreateTime());
    }
}
