package com.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "visit")
public class Visit {
    @Id
    @Column(name = "visit_id")
    private int visitId;

    @Column(name = "visit_date")
    private Date visitDate;

//    @Column(name = "hosId")
//    private int hospId;
//
//    @Column(name = "doc_id")
//    private int docId;
//
//    @Column(name = "p_id")
//    private int pId;

    @OneToOne
    @JoinColumn(name = "doc_id")
    private Doctor doctor;

    @OneToOne
    @JoinColumn(name = "hosId")
    private Hospital hospital;

    @OneToOne
    @JoinColumn(name = "p_id")
    private Patient patient;
//
////    public int getHospId() {
////        return hospId;
////    }
////
////    public void setHospId(int hospId) {
////        this.hospId = hospId;
////    }
////
////    public int getDocId() {
////        return docId;
////    }
////
////    public void setDocId(int docId) {
////        this.docId = docId;
////    }
////
////    public int getpId() {
////        return pId;
////    }
////
////    public void setpId(int pId) {
////        this.pId = pId;
////    }
//
//    public void setDoctor(Doctor doctor) {
//        this.doctor = doctor;
//    }
//
//    public void setHospital(Hospital hospital) {
//        this.hospital = hospital;
//    }
//
//    public void setPatient(Patient patient) {
//        this.patient = patient;
//    }
//
//    public int getVisitId() {
//        return visitId;
//    }
//
//    public Date getVisitDate() {
//        return visitDate;
//    }
//
////    public int getHospital() {
////        return hospId;
////    }
////
////    public int getPatient() {
////        return pId;
////    }
////
////    public int getDoctor() {
////        return docId;
////    }
//
//    public void setVisitId(int visitId) {
//        this.visitId = visitId;
//    }
//
//    public void setVisitDate(Date visitDate) {
//        this.visitDate = visitDate;
//    }
//
//
//    public void setHospital(int hospId) {
//        this.hospId = hospId;
//    }
//
//    public void setDoctor(int docId) {
//        this.docId = docId;
//    }
//
//    public void setPatient(int pId) {
//        this.pId = pId;
//    }
//
//
//    @Override
//    public String toString() {
//        return "Visit{" +
//                "visitId=" + visitId +
//                ", visitDate=" + visitDate +
//                ", hospital=" + hospId +
//                ", doctor=" + docId +
//                ", patient=" + pId +
//                '}';
//    }


    @Override
    public String toString() {
        return "Visit{" +
                "visitId=" + visitId +
                ", visitDate=" + visitDate +
                ", doctor=" + doctor +
                ", hospital=" + hospital +
                ", patient=" + patient +
                '}';
    }

    public int getVisitId() {
        return visitId;
    }

    public void setVisitId(int visitId) {
        this.visitId = visitId;
    }

    public Date getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Visit(){

    }
    public Visit(int visitId,Date visitDate,int hosId,int docId,int pId){
        this.visitId=visitId;
        this.visitDate=visitDate;
//        this.hospId=hosId;
//        this.docId=docId;
//        this.pId=pId;
    }
}
