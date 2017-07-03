package com.app;

import java.io.IOException;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

public class MyClass extends DaoGenerator {

    public MyClass() throws IOException {
        super();
    }
    //文件生成的相对路径
    public static final String DAO_PATH = "./app/src-gen";
    //包名
    public static final String PACKAGE_NAME="com.fine.fineapp";
    //数据库版本号
    public static final int  VERSION_CODE = 1;
    //打印数据表
    public static final String TAB_DEPT = "ATable";


    public static void main(String[] args){
        Schema schema = new Schema(VERSION_CODE,"com.fine.fineapp.data.bean");
        schema.setDefaultJavaPackageDao(PACKAGE_NAME);
        schema.enableKeepSectionsByDefault();
        Entity tweet = schema.addEntity(TAB_DEPT);
        tweet.addLongProperty("guid").primaryKey().autoincrement();
        tweet.addStringProperty("text");
        tweet.addIntProperty("status");
        tweet.addStringProperty("bak1");
        tweet.addStringProperty("bak2");
        tweet.addDateProperty("createdAt");
        try {
            new DaoGenerator().generateAll(schema, DAO_PATH);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
