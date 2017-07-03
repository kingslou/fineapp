package com.fine.fineapp.utils;

import android.app.Activity;
import android.content.DialogInterface;

import com.afollestad.materialdialogs.MaterialDialog;
import com.fine.fineapp.R;

/**
 * Created by YiMuTian on 2017/7/3.
 */

public class DialogFactory {

    private static MaterialDialog mDialog;


    public static void showLoading(Activity activity) {
        showProgressDialog(R.string.str_please_wait,activity);
    }


    public static void showLoading(int strId,Activity activity) {
        showProgressDialog(strId,activity);
    }


    public static void hideLoading() {
        if (mDialog != null) {
            mDialog.dismiss();
        }
    }

    public static void showDialog(String message,Activity activity){
        mDialog = new MaterialDialog.Builder(activity)
                .content(message)
                .title("提示")
                .negativeText("取消")
                .positiveText("确定")
                .show();
    }

    public static void showProgressIndeterminateStyle(Activity activity){
        mDialog =new MaterialDialog.Builder(activity)
                .title("加载中")
                .content("请稍后")
                .progress(true, 0)
                .progressIndeterminateStyle(true)
                .show();
    }

    public static void showProgressDialog(int strId, Activity activity) {
        if(mDialog!=null&&mDialog.isShowing()){
            return;
        }
        if (!activity.isFinishing()) {
            mDialog = new MaterialDialog.Builder(activity)
                    //.title(R.string.progress_dialog)
                    .content(strId)
                    .progress(true, 0)
                    .dismissListener(new DialogInterface.OnDismissListener() {
                        @Override
                        public void onDismiss(DialogInterface dialog) {
                            mDialog = null;
                        }
                    }).show();
        }
    }

}
