package com.fine.fineapp;

import android.app.Application;

/**
 * Created by YiMuTian on 2017/4/25.
 */

public class App extends Application {

    private static App application;
    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
    }

    public static App getAppInstance(){
        return application;
    }
}
