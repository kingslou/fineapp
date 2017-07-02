package com.fine.fineapp.ui;

/**
 * Created by YiMuTian on 2017/7/2.
 */

public interface Presenter<V extends MvpView> {

    void attachView(V view);

    void detachView();
}
