package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "patient")
public class Patient {
    @Id
    @Column(name = "p_id")
    private int pId;

    @Column(name = "p_name")
    private String pName;
    @Column(name = "p_disease")
    private String pDisease;
    @Column(name = "P_city")
    private String pCity;
    @Column(name = "p_contact")
    private String pContact;

    public int getpId() {
        return pId;
    }

    public String getpName() {
        return pName;
    }

    public String getpDisease() {
        return pDisease;
    }

    public String getpCity() {
        return pCity;
    }

    public String getpContact() {
        return pContact;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public void setpDisease(String pDisease) {
        this.pDisease = pDisease;
    }

    public void setpContact(String pContact) {
        this.pContact = pContact;
    }

    public void setpCity(String pCity) {
        this.pCity = pCity;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "pId=" + pId +
                ", pName='" + pName + '\'' +
                ", pDisease='" + pDisease + '\'' +
                ", pCity='" + pCity + '\'' +
                ", pContact=" + pContact +
                '}';
    }
    public Patient(){

    }
    public Patient(int pId,String pName,String pDisease,String pCity,String pContact)
    {
        this.pId=pId;
        this.pName=pName;
        this.pDisease=pDisease;
        this.pCity=pCity;
        this.pContact=pContact;
    }
}
