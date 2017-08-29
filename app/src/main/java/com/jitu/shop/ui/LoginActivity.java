package com.jitu.shop.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.FrameLayout;

import com.jitu.shop.R;
import com.jitu.shop.base.BaseActivity;
import com.jitu.shop.ui.fragment.WelcomeThreeFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jacky on 2017/8/28.
 */
public class LoginActivity extends BaseActivity {
    @BindView(R.id.fl_login)
    FrameLayout flLogin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTranslucentStatus();
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        initview();
    }

    private void initview() {
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_login, new WelcomeThreeFragment()).commit();
    }
}
