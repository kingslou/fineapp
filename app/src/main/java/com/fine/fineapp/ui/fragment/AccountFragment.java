package com.fine.fineapp.ui.fragment;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.fine.fineapp.R;
import com.shizhefei.fragment.LazyFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by YiMuTian on 2017/7/3.
 */

public class AccountFragment extends LazyFragment {
    public static final String INTENT_STRING_TABNAME = "intent_String_tabname";
    public static final String INTENT_INT_INDEX = "intent_int_index";
    private String tabName;
    private int index;

    @BindView(R.id.text_main)
    TextView textView;
    @Override
    protected void onCreateViewLazy(Bundle savedInstanceState) {
        super.onCreateViewLazy(savedInstanceState);
        LayoutInflater flater = LayoutInflater.from(getActivity());
        View view = flater.inflate(R.layout.activity_main, null);
        setContentView(view);
        ButterKnife.bind(this,view);
        Resources res = getResources();

        Bundle bundle = getArguments();
        tabName = bundle.getString(INTENT_STRING_TABNAME);
        index = bundle.getInt(INTENT_INT_INDEX);
        textView.setText(tabName);
        Log.d("cccc", "Fragment 将要创建View " + this);

    }

    @Override
    protected void onResumeLazy() {
        super.onResumeLazy();
        Log.d("cccc", "Fragment所在的Activity onResume, onResumeLazy " + this);
    }

    @Override
    protected void onFragmentStartLazy() {
        super.onFragmentStartLazy();
        Log.d("cccc", "Fragment 显示 " + this);
    }

    @Override
    protected void onFragmentStopLazy() {
        super.onFragmentStopLazy();
        Log.d("cccc", "Fragment 掩藏 " + this);
    }

    @Override
    protected void onPauseLazy() {
        super.onPauseLazy();
        Log.d("cccc", "Fragment所在的Activity onPause, onPauseLazy " + this);
    }

    @Override
    protected void onDestroyViewLazy() {
        super.onDestroyViewLazy();
        Log.d("cccc", "Fragment View将被销毁 " + this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("cccc", "Fragment 所在的Activity onDestroy " + this);
    }


}