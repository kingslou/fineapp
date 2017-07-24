package com.fine.fineapp.ui.work;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.fine.fineapp.R;
import com.fine.fineapp.data.DummyContent;
import com.fine.fineapp.ui.base.BaseActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import butterknife.BindView;

/**
 * Created by YiMuTian on 2017/7/17.
 */

public class WorkContentActivity extends BaseActivity {


    @BindView(R.id.quote)
    TextView quote;

    @BindView(R.id.author)
    TextView author;

    @BindView(R.id.backdrop)
    ImageView backdropImg;

    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbar;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private DummyContent.DummyItem dummyItem;

    @Override
    protected int getContentLayoutResID() {
        return R.layout.activity_work_content;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void initView() {
        super.initView();
        collapsingToolbar.setTitle(dummyItem.title);
        author.setText(dummyItem.author);
        quote.setText(dummyItem.content);
        setToolbar(toolbar);
    }

    @Override
    public void initData() {
        super.initData();
        Intent intent = getIntent();
        if(intent!=null){
            Toast.makeText(this, "sss"+intent.getExtras().getString("key"), Toast.LENGTH_SHORT).show();
        }
        String index = intent.getExtras().getString("key");
        dummyItem = DummyContent.ITEM_MAP.get(index);
        loadBackdrop();
    }

    private void loadBackdrop() {
        Glide.with(this).load(dummyItem.photoId).centerCrop().into(backdropImg);
    }

}
