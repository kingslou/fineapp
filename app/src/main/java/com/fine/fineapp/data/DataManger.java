package com.fine.fineapp.data;

import com.fine.fineapp.App;
import com.fine.fineapp.data.model.VersionInfo;

import rx.Observable;

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

}
