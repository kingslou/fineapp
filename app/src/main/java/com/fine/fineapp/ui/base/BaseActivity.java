package com.fine.fineapp.ui.base;

import android.annotation.TargetApi;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.afollestad.materialdialogs.MaterialDialog;
import com.fine.fineapp.R;

import butterknife.ButterKnife;

/**
 * Created by YiMuTian on 2017/7/2.
 */

public abstract class BaseActivity extends AppCompatActivity {

    private MaterialDialog materialDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getContentLayoutResID() != -1) {
            setContentView(getContentLayoutResID());
        }
        ButterKnife.bind(this);;

        initData();
        // Some init work for widgets
        initView();
    }

    public void initData() {

    }

    public void initView() {

    }

    // Set R.layout.xml for every child Activity
    @LayoutRes
    protected abstract int getContentLayoutResID();

    @TargetApi(Build.VERSION_CODES.M)
    public void requestPermissionsSafely(String[] permissions, int requestCode) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(permissions, requestCode);
        }
    }

    @TargetApi(Build.VERSION_CODES.M)
    public boolean hasPermission(String permission) {
        return Build.VERSION.SDK_INT < Build.VERSION_CODES.M ||
                checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED;
    }

    // launch other child fragment. need by Some Activities.
    protected void launchFragment(Fragment newFragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        // 将 fragment_container View 中的内容替换为此 Fragment ，
        // 然后将该事务添加到返回堆栈，以便用户可以向后导航
        transaction.replace(R.id.fragment_container, newFragment);
        transaction.addToBackStack(null);

        // 执行事务
        transaction.commit();
    }

    protected void launchFragmentWithTag(Fragment newFragment, String tag) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        // 将 fragment_container View 中的内容替换为此 Fragment ，
        // 然后将该事务添加到返回堆栈，以便用户可以向后导航
        transaction.replace(R.id.fragment_container, newFragment, tag);
        transaction.addToBackStack(null);
        // 执行事务
        transaction.commit();
    }

    public void setToolbar(Toolbar toolbar) {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
