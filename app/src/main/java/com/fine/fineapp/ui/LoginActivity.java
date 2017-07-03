package com.fine.fineapp.ui;

import android.os.Bundle;

import com.fine.fineapp.R;
import com.fine.fineapp.ui.base.BaseActivity;

/**
 * Created by YiMuTian on 2017/7/3.
 */

public class LoginActivity extends BaseActivity {

    @Override
    protected int getContentLayoutResID() {
        return R.layout.activity_login;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
    }

}
