package com.model;

import javax.persistence.*;

@Entity
@Table(name="request")
public class RequestItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "req_id")
    private int s_no;
    @Column(name = "user_id")
    private int u_id;
    @Column(name = "req_name")
    private String reqname;
    @Column(name = "sys_id")
    private int sysid;
    @Column(name = "item")
    private String item;

    public int getS_no() {
        return s_no;
    }

    public void setS_no(int s_no) {
        this.s_no = s_no;
    }

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public String getReqname() {
        return reqname;
    }

    public void setReqname(String reqname) {
        this.reqname = reqname;
    }

    public int getSysid() {
        return sysid;
    }

    public void setSysid(int sysid) {
        this.sysid = sysid;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }
    @Override
    public String toString() {
        return "RequestItem{" +
                "s_no=" + s_no +
                ", u_id=" + u_id +
                ", reqname='" + reqname + '\'' +
                ", sysid=" + sysid +
                ", item='" + item + '\'' +
                '}';
    }

    public RequestItem(){

    }
    public RequestItem(int s_no, int u_id, String reqname, int sysid, String item) {
        this.s_no = s_no;
        this.u_id = u_id;
        this.reqname = reqname;
        this.sysid = sysid;
        this.item = item;
    }
}
