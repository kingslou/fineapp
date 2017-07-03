package com.fine.fineapp.data.db;

import com.fine.fineapp.ATableDao;
import com.fine.fineapp.data.bean.ATable;

import java.util.List;

/**
 * Created by YiMuTian on 2017/7/3.
 */

public class ATabService {

    private static ATabService aTabService;
    private ATableDao aTableDao;
    private ATabService(){
        aTableDao = DbHelper.getInstance().getDaoSession().getATableDao();
    }

    public synchronized static ATabService getInstance(){
        if(aTabService==null){
            aTabService = new ATabService();
        }
        return aTabService;
    }

    public List<ATable> getAtableList(){
        return aTableDao.queryBuilder().list();
    }

    public void insertAtableData(List<ATable> aTableList){
       if(null!=aTableList){
           aTableDao.insertOrReplaceInTx(aTableList);
       }
    }

    public void clearAtable(){
        aTableDao.deleteAll();
    }

    public void updateAtable(ATable aTable){
        aTableDao.update(aTable);
    }

}
