package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hospital")
public class Hospital {
    @Id
    @Column(name = "hosId")
    private int hosId;

    @Column(name = "hosp_name")
    private String hospName;
    @Column(name = "hosp_city")
    private String hospCity;
    @Column(name = "hosp_contact")
    private String hospContact;

    public int getHosId() {
        return hosId;
    }

    public String getHospName() {
        return hospName;
    }

    public String getHospCity() {
        return hospCity;
    }

    public String getHospContact() {
        return hospContact;
    }

    public void setHosId(int hosId) {
        this.hosId = hosId;
    }

    public void setHospName(String hospName) {
        this.hospName = hospName;
    }

    public void setHospCity(String hospCity) {
        this.hospCity = hospCity;
    }

    public void setHospContact(String hospContact) {
        this.hospContact = hospContact;
    }

    @Override
    public String toString() {
        return "Hospital{" +
                "hosId=" + hosId +
                ", hospName='" + hospName + '\'' +
                ", hospCity='" + hospCity + '\'' +
                ", hospContact='" + hospContact + '\'' +
                '}';
    }
    public Hospital(){

    }
    public Hospital(int hosId,String hospName,String hospCity,String hospContact){
        this.hosId=hosId;
        this.hospName=hospName;
        this.hospCity=hospCity;
        this.hospContact=hospContact;
    }
}
