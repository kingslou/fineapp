package com.fine.fineapp.ui.login;

import android.content.Intent;

import com.fine.fineapp.ui.MvpView;

/**
 * Created by YiMuTian on 2017/7/3.
 */

public interface LoginMvpView extends MvpView {
    void onSignInSuccessful();

    void showProgress(boolean show);

    void setSignInButtonEnabled(boolean enabled);

    void showProfileNotFoundError(String accountName);

    void showGeneralSignInError();

}
