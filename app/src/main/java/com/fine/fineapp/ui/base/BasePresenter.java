package com.fine.fineapp.ui.base;

import com.fine.fineapp.ui.MvpView;
import com.fine.fineapp.ui.Presenter;

/**
 * Created by YiMuTian on 2017/7/2.
 */

public class BasePresenter<T extends MvpView> implements Presenter<T> {

    private T mMvpView;

    @Override
    public void attachView(T view) {
        mMvpView = view;
    }

    @Override
    public void detachView() {
        mMvpView = null;
    }

    public boolean isViewAttached() {
        return mMvpView != null;
    }

    public T getMvpView() {
        return mMvpView;
    }

    public void checkViewAttached() {
        if (!isViewAttached()) throw new MvpViewNotAttachedException();
    }

    public static class MvpViewNotAttachedException extends RuntimeException {
        public MvpViewNotAttachedException() {
            super("Please call Presenter.attachView(MvpView) before" +
                    " requesting data to the Presenter");
        }
    }
}
