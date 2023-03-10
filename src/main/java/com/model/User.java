package com.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="usercomplain")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int s_no;

    @Column(name = "user_name")
    private String name;

    @Column(name = "user_email")
    private String email;

    @Column(name = "user_phno")
    private String phone;

    @Column(name = "sys_id")
    private int  systemid;
    @Column(name = "ops")
    private String  os;
    @Column(name="issue")
    private String complaints;

    public int getS_no() {
        return s_no;
    }

    public void setS_no(int s_no) {
        this.s_no = s_no;
    }

    public String getUserName() {
        return name;
    }

    public void setUserName(String name) {
        this.name = name;
    }

    public String getUserEmail() {
        return email;
    }

    public void setUserEmail(String email) {
        this.email = email;
    }

    public String getUserPh() {
        return phone;
    }

    public void setUserPh(String phone) {
        this.phone = phone;
    }

    public int getSystemID() {
        return systemid;
    }

    public void setSystemID(int systemid) {
        this.systemid = systemid;
    }

    public String getOps() {
        return os;
    }

    public void setOps(String os) {
        this.os = os;
    }

    public String getIssues() {
        return complaints;
    }

    public void setIssues(String complaints) {
        this.complaints = complaints;
    }

    @Override
    public String toString() {
        return "User{" +
                "s_no=" + s_no +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", systemid='" + systemid + '\'' +
                ", os='" + os + '\'' +
                ", complaints='" + complaints + '\'' +
                '}';
    }

    public User(int s_no, String name, String email, String phone, int systemid, String os, String complaints) {
        super();
        this.s_no = s_no;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.systemid = systemid;
        this.os = os;
        this.complaints = complaints;
    }

    public User() {

    }
}
