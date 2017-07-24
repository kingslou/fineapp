package com.fine.fineapp.ui.view;

import android.content.Context;
import android.support.v4.widget.NestedScrollView;
import android.util.AttributeSet;

/**
 * Created by YiMuTian on 2017/7/17.
 */

public class NestedScrollViewX extends NestedScrollView {

    private OnScrollViewListener mOnScrollViewListener;

    public NestedScrollViewX(Context context) {
        super(context);
    }
    public NestedScrollViewX(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    public NestedScrollViewX(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }
    public interface OnScrollViewListener {
        void onScrollChanged(NestedScrollViewX v, int l, int t, int oldl, int oldt);
    }
    public void setOnScrollViewListener(OnScrollViewListener l) {
        this.mOnScrollViewListener = l;
    }
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        mOnScrollViewListener.onScrollChanged(this, l, t, oldl, oldt);
        super.onScrollChanged(l, t, oldl, oldt);
    }
}
