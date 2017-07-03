package com.fine.fineapp.ui;

import android.os.Bundle;
import android.widget.Toast;

import com.fine.fineapp.R;
import com.fine.fineapp.data.bean.ATable;
import com.fine.fineapp.data.db.ServiceFactory;
import com.fine.fineapp.ui.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

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
//        initView();
//        initData();
    }

    @Override
    public void initData() {
        super.initData();
        List<ATable> aTableList = new ArrayList<>();
        for(int i=0;i<100;i++){
            ATable aTable = new ATable();
            aTable.setText("测试"+i);
            aTableList.add(aTable);
        }
        ServiceFactory.getAtableService().insertAtableData(aTableList);

        Toast.makeText(LoginActivity.this,"存储"+ServiceFactory.getAtableService().getAtableList().size()+"个",Toast.LENGTH_LONG).show();
    }
}
