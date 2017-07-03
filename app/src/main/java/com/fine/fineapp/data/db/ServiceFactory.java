package com.fine.fineapp.data.db;

/**
 * Created by YiMuTian on 2017/7/3.
 */

public class ServiceFactory {

    private static final ServiceFactory instance = new ServiceFactory();

    private ServiceFactory(){

    }

    public static ServiceFactory getInstance(){
        return instance;
    }


    public static ATabService getAtableService(){
        return ATabService.getInstance();
    }


}
