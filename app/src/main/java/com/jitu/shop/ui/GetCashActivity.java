package com.jitu.shop.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jitu.shop.AppConstant;
import com.jitu.shop.R;
import com.jitu.shop.adapter.BankCardListAdapter;
import com.jitu.shop.adapter.CardListAdapter;
import com.jitu.shop.base.BaseActivity;
import com.jitu.shop.entity.BankCardListEntity;
import com.jitu.shop.entity.GetCashHistoryEntity;
import com.jitu.shop.entity.OnlyCodeEntity;
import com.jitu.shop.interfaces.MyCallBack;
import com.jitu.shop.util.NetClient;
import com.jitu.shop.util.SPUtil;
import com.jitu.shop.util.StringUtil;
import com.jitu.shop.widget.ClearableEditText;
import com.lzy.okgo.model.HttpParams;
import com.lzy.okgo.model.Response;
import com.socks.library.KLog;
import com.vondear.rxtools.view.RxToast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.jpush.android.api.JPushInterface;

/**
 * Created by jacky on 2017/8/29.
 */
public class GetCashActivity extends BaseActivity {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_submit)
    TextView tvSubmit;

    @BindView(R.id.et_getcash_money)
    ClearableEditText etGetcashMoney;
    @BindView(R.id.btn_getcash_sure)
    Button btnGetcashSure;
    @BindView(R.id.rv_getcash)
    RecyclerView rvGetcash;
    private CardListAdapter adapter;
    private List<BankCardListEntity.ResultBean> list = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getcash);
        ButterKnife.bind(this);
        initview();
        initdate();
    }

    @Override
    protected void onResume() {
        super.onResume();
        JPushInterface.onResume(getApplicationContext());
    }

    private void initview() {
        setText(tvTitle, "提现");
        //=========================recycleview配置
        adapter = new CardListAdapter(R.layout.item_card_list, list);
        rvGetcash.setLayoutManager(new LinearLayoutManager(context));
        adapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
        adapter.bindToRecyclerView(rvGetcash);
        adapter.setEmptyView(R.layout.empty_view);
        rvGetcash.setAdapter(adapter);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                for (int i = 0; i < list.size(); i++) {
                    if (i == position)
                        list.get(i).setIs_checked(true);
                    else
                        list.get(i).setIs_checked(false);

                    adapter.notifyDataSetChanged();
                }
            }
        });
        //=========================recycleview配置结束
    }

    private void initdate() {
        HttpParams params = new HttpParams();
        params.put("token", (String) SPUtil.get(context, AppConstant.TOKEN, ""));
        NetClient.getInstance(BankCardListEntity.class).Get(context, AppConstant.URL_QUERYMYCARD, params, new MyCallBack() {
            @Override
            public void onFailure(int code) {

            }

            @Override
            public void onResponse(Response object) {
                BankCardListEntity bankCardListEntity = (BankCardListEntity) object.body();
                if (bankCardListEntity.getErrorCode() == 0) {
                    list = bankCardListEntity.getResult();
                    adapter.setNewData(list);
                }
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        JPushInterface.onPause(getApplicationContext());
    }

    private int card_id = 0;
    private double cash_num = 0;

    @OnClick({R.id.iv_back, R.id.btn_getcash_sure})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.btn_getcash_sure:
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).is_checked()) {
                        card_id = list.get(i).getCM_Id();
                    }
                }
                String money = etGetcashMoney.getText().toString().trim();
                if (StringUtil.isEmptyandnull(money)){
                    RxToast.error("请输入提现金额");
                    return;
                }
                cash_num = Double.parseDouble(money);
                if (card_id == 0) {
                    RxToast.error("请先选择银行卡");
                    return;
                }
                requireCash(card_id, cash_num);
                break;
        }
    }

    private void requireCash(int card_id, double money) {
        HttpParams params = new HttpParams();
        params.put("token", (String) SPUtil.get(context, AppConstant.TOKEN, ""));
        params.put("money", money);
        params.put("cardid", card_id);
        NetClient.getInstance(OnlyCodeEntity.class).Get(context, AppConstant.URL_PRESENTAPPLICATION, params, new MyCallBack() {
            @Override
            public void onFailure(int code) {

            }

            @Override
            public void onResponse(Response object) {
                OnlyCodeEntity bankCardListEntity = (OnlyCodeEntity) object.body();
                if (bankCardListEntity.getErrorCode() == 0) {
                    RxToast.success("申请提现成功！");
                    finish();
                }
            }
        });
    }
}
