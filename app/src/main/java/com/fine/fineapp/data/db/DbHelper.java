package com.fine.fineapp.data.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.fine.fineapp.App;
import com.fine.fineapp.DaoMaster;
import com.fine.fineapp.DaoSession;

/***
 * 数据库帮助类
 */
public class DbHelper {

    private static DbHelper instance;
    private DaoSession daoSession;
    private DaoMaster daoMaster;
    private SQLiteDatabase db;

    public synchronized static DbHelper getInstance() {
        if(instance == null) {
            instance = new DbHelper();
        }
        return instance;
    }

    public DbHelper() {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(App.getAppInstance(), "ieasyDb", null);
        db = devOpenHelper.getWritableDatabase();
        daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }

    public DaoMaster getDaoMaster() {
        return daoMaster;
    }
}
