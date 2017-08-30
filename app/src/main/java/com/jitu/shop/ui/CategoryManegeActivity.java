package com.jitu.shop.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.jitu.shop.R;
import com.jitu.shop.base.BaseActivity;

import cn.jpush.android.api.JPushInterface;

/**
 * Created by jacky on 2017/8/30.
 */
public class CategoryManegeActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTranslucentStatus();
        setContentView(R.layout.ativity_categorymanage);
    }
    @Override
    protected void onResume() {
        super.onResume();
        JPushInterface.onResume(getApplicationContext());
    }

    @Override
    protected void onPause() {
        super.onPause();
        JPushInterface.onPause(getApplicationContext());
    }

}
