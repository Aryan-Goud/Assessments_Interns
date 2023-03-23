package com.model;

import javax.persistence.*;

@Entity
@Table(name="statuscheck")
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "status_id")
    private int statId;

    @Column(name = "user_id")
    private int uId;

    @Column(name = "priority")
    private String priority;

    @Column(name = "progress")
    private String progress;
    @Column(name = "system_id")
    private int sysId;

    public int getSysId() {
        return sysId;
    }

    public void setSysId(int sysId) {
        this.sysId = sysId;
    }

    public int getStatId() {
        return statId;
    }

    public void setStatId(int statId) {
        this.statId = statId;
    }

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }

    public Status(int statId, int uId, String priority, String progress, int sysId) {
        this.statId = statId;
        this.uId = uId;
        this.priority = priority;
        this.progress = progress;
        this.sysId = sysId;
    }

    @Override
    public String toString() {
        return "Status{" +
                "statId=" + statId +
                ", uId='" + uId + '\'' +
                ", priority='" + priority + '\'' +
                ", progress='" + progress + '\'' +
                ", sysId='" + sysId + '\'' +
                '}';
    }

    public Status(){}
}
