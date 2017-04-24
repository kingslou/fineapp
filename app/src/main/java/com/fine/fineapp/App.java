package com.fine.fineapp;

import android.app.Application;

/**
 * Created by YiMuTian on 2017/4/25.
 */

public class App extends Application {

    private App application;
    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
    }

    public App getAppInstance(){
        return application;
    }
}
