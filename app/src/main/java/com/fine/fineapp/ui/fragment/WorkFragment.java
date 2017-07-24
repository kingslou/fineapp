package com.fine.fineapp.ui.fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.fine.fineapp.R;
import com.fine.fineapp.data.DummyContent;
import com.fine.fineapp.data.model.WorkItem;
import com.fine.fineapp.ui.base.BaseAdapter;
import com.fine.fineapp.ui.base.BaseViewHolder;
import com.fine.fineapp.ui.base.OnItemClickListener;
import com.fine.fineapp.ui.work.WorkContentActivity;
import com.google.gson.Gson;
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
        initAdapter();
    }

    private void initAdapter(){

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        baseAdapter = new BaseAdapter() {
            @Override
            protected void onBindView(BaseViewHolder holder, int position) {
                DummyContent.DummyItem workItem = DummyContent.ITEMS.get(position);
                final ImageView mWorkIcon = holder.getView(R.id.image_work_icon);
                TextView mWorkName = holder.getView(R.id.text_work_name);
                mWorkName.setText(workItem.author);
                Glide.with(getActivity()).load(workItem.photoId).asBitmap().fitCenter().into(new BitmapImageViewTarget(mWorkIcon){
                    @Override
                    protected void setResource(Bitmap resource) {
                        super.setResource(resource);
                        RoundedBitmapDrawable circularBitmapDrawable = RoundedBitmapDrawableFactory.create(getActivity().getResources(), resource);
                        circularBitmapDrawable.setCircular(true);
                        mWorkIcon.setImageDrawable(circularBitmapDrawable);
                    }
                });
            }

            @Override
            protected int getLayoutID(int position) {
                return R.layout.cell_work_item;
            }

            @Override
            public int getItemCount() {
                return DummyContent.ITEMS.size();
            }
        };
        mRecyclerView.setAdapter(baseAdapter);
        baseAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent();
                intent.putExtra("key",DummyContent.ITEMS.get(position).id);
                intent.setClass(getActivity(), WorkContentActivity.class);
                startActivity(intent);
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
