package com.fine.fineapp.data.model;

/**
 * Created by YiMuTian on 2017/7/3.
 */

public class WorkItem {
    private String workId;
    private String workName;
    private String workType;
    private int    workSeq;

    @Override
    public String toString() {
        return "WorkItem{" +
                "workId='" + workId + '\'' +
                ", workName='" + workName + '\'' +
                ", workType='" + workType + '\'' +
                ", workSeq=" + workSeq +
                '}';
    }

    public WorkItem(String workId, String workName, String workType, int workSeq) {
        this.workId = workId;
        this.workName = workName;
        this.workType = workType;
        this.workSeq = workSeq;
    }

    public String getWorkId() {
        return workId;
    }

    public void setWorkId(String workId) {
        this.workId = workId;
    }

    public String getWorkName() {
        return workName;
    }

    public void setWorkName(String workName) {
        this.workName = workName;
    }

    public String getWorkType() {
        return workType;
    }

    public void setWorkType(String workType) {
        this.workType = workType;
    }

    public int getWorkSeq() {
        return workSeq;
    }

    public void setWorkSeq(int workSeq) {
        this.workSeq = workSeq;
    }
}
