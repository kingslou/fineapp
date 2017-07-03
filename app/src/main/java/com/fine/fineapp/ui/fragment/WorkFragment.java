package com.fine.fineapp.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.fine.fineapp.R;
import com.fine.fineapp.data.model.WorkItem;
import com.fine.fineapp.ui.base.BaseAdapter;
import com.fine.fineapp.ui.base.BaseViewHolder;
import com.fine.fineapp.ui.base.OnItemClickListener;
import com.shizhefei.fragment.LazyFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by YiMuTian on 2017/7/3.
 */

public class WorkFragment extends LazyFragment {

    @BindView(R.id.recycleViewWork)
    RecyclerView mRecyclerView;

    private BaseAdapter baseAdapter;

    private List<WorkItem> workItemList = new ArrayList<>();

    @Override
    protected void onCreateViewLazy(Bundle savedInstanceState) {
        super.onCreateViewLazy(savedInstanceState);
        LayoutInflater inflater = LayoutInflater.from(getActivity());
        View view = inflater.inflate(R.layout.fragment_work, null);
        setContentView(view);
        ButterKnife.bind(this,view);
        for(int i=0;i<9;i++){
            WorkItem workItem = new WorkItem("测试"+i,"测试"+i,"sdfsd",i);
            workItemList.add(workItem);
        }

        initAdapter();
    }

    private void initAdapter(){

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        baseAdapter = new BaseAdapter() {
            @Override
            protected void onBindView(BaseViewHolder holder, int position) {
                WorkItem workItem = workItemList.get(position);
                ImageView mWorkIcon = holder.getView(R.id.image_work_icon);
                TextView mWorkName = holder.getView(R.id.text_work_name);
                mWorkName.setText(workItem.getWorkName());
                Glide.with(getActivity()).load(R.mipmap.work_item_application).into(mWorkIcon);
            }

            @Override
            protected int getLayoutID(int position) {
                return R.layout.cell_work_item;
            }

            @Override
            public int getItemCount() {
                return workItemList.size();
            }
        };
        mRecyclerView.setAdapter(baseAdapter);
        baseAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {

            }
        });
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
