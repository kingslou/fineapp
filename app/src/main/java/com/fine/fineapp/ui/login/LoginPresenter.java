package com.fine.fineapp.ui.login;

import android.content.Intent;

import com.fine.fineapp.data.DataManger;
import com.fine.fineapp.data.model.Account;
import com.fine.fineapp.ui.Presenter;
import com.squareup.otto.Subscribe;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by YiMuTian on 2017/7/3.
 */

public class LoginPresenter implements Presenter<LoginMvpView> {

    private LoginMvpView mMvpView;
    private Subscription mSubscription;


    @Override
    public void attachView(LoginMvpView view) {
        this.mMvpView = view;
    }

    @Override
    public void detachView() {
        mMvpView = null;
        if (mSubscription != null) mSubscription.unsubscribe();
    }

    public void signIn(String name,String pwd){
        mMvpView.showProgress(true);
        mMvpView.setSignInButtonEnabled(false);
        //假设成功
        mSubscription = DataManger.getInstance().loginDb(name,pwd).subscribe(new Subscriber<Account>() {
            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable e) {
                mMvpView.showGeneralSignInError();
                mMvpView.showProgress(false);
                mMvpView.setSignInButtonEnabled(true);
            }

            @Override
            public void onNext(Account account) {
                //// TODO: 2017/7/3  cach Account
                mMvpView.onSignInSuccessful();
                mMvpView.setSignInButtonEnabled(true);
            }
        });

    }
}
