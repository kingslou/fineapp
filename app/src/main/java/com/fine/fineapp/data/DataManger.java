package com.fine.fineapp.data;

import com.fine.fineapp.App;
import com.fine.fineapp.data.db.ServiceFactory;
import com.fine.fineapp.data.model.Account;
import com.fine.fineapp.data.model.VersionInfo;

import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by YiMuTian on 2017/7/2.
 */

public class DataManger {

    private static ApiService apiService;
    private static final DataManger dataManger = new DataManger();

    private DataManger(){
    }

    public static DataManger getInstance(){
        return dataManger;
    }

    public static ApiService provideApiService(){
        if(apiService == null){
            apiService = ApiService.Factory.makeApiService(App.getAppInstance());
        }
        return apiService;
    }

    public Observable<VersionInfo> getVersionInfo(){
        return provideApiService().getVersionInfo();
    }

    public Observable<Account> loginDb(String name,String pwd){
        final Observable<Account> observable = Observable.create(new Observable.OnSubscribe<Account>() {
            @Override
            public void call(Subscriber<? super Account> subscriber) {
                Account account = new Account();
                account.setAccountName("test");
                subscriber.onNext(account);
                subscriber.onCompleted();
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        return observable;
    }
}
