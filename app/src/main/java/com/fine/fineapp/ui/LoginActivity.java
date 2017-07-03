package com.fine.fineapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.fine.fineapp.R;
import com.fine.fineapp.data.bean.ATable;
import com.fine.fineapp.data.db.ServiceFactory;
import com.fine.fineapp.ui.base.BaseActivity;
import com.fine.fineapp.ui.login.LoginMvpView;
import com.fine.fineapp.ui.login.LoginPresenter;
import com.fine.fineapp.ui.tabmain.MainActivity;
import com.fine.fineapp.utils.DialogFactory;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by YiMuTian on 2017/7/3.
 */

public class LoginActivity extends BaseActivity implements LoginMvpView {

    private LoginPresenter loginPresenter;

    @BindView(R.id.btn_login)
    RelativeLayout btn_login;
    @BindView(R.id.edit_phone)
    EditText edit_phone;
    @BindView(R.id.edit_pwd)
    EditText edit_pwd;

    @Override
    protected int getContentLayoutResID() {
        return R.layout.activity_login;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @OnClick(R.id.btn_login)
    void clickBtn_login(){
        String accountName = edit_phone.getText().toString();
        String accountPwd = edit_pwd.getText().toString();
        if(TextUtils.isEmpty(accountName)||TextUtils.isEmpty(accountPwd)){
            return;
        }
        loginPresenter.signIn(accountName,accountPwd);
    }

    @Override
    public void initData() {
        super.initData();
        loginPresenter = new LoginPresenter();
        loginPresenter.attachView(this);
        List<ATable> aTableList = new ArrayList<>();
        for(int i=0;i<100;i++){
            ATable aTable = new ATable();
            aTable.setText("测试"+i);
            aTableList.add(aTable);
        }
        ServiceFactory.getAtableService().insertAtableData(aTableList);

        Toast.makeText(LoginActivity.this,"存储"+ServiceFactory.getAtableService().getAtableList().size()+"个",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onSignInSuccessful() {
        Intent intent = new Intent();
        intent.setClass(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void showProgress(boolean show) {
        if(show){
            DialogFactory.showProgressIndeterminateStyle(LoginActivity.this);
        }else{
            DialogFactory.hideLoading();
        }
    }

    @Override
    public void setSignInButtonEnabled(boolean enabled) {
        btn_login.setEnabled(enabled);
    }

    @Override
    public void showProfileNotFoundError(String accountName) {

    }

    @Override
    public void showGeneralSignInError() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        loginPresenter.detachView();
    }
}
