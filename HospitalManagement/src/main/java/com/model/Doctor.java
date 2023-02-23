package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "doctor")
public class Doctor {
    @Id
    @Column(name = "doc_id")
    private int docId;

    @Column(name = "doc_name")
    private String docName;
    @Column(name = "doc_spec")
    private String docSpec;

    public int getDocId() {
        return docId;
    }

    public String getDocName() {
        return docName;
    }

    public String getDocSpec() {
        return docSpec;
    }

    public void setDocId(int docId) {
        this.docId = docId;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public void setDocSpec(String docSpec) {
        this.docSpec = docSpec;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "docId=" + docId +
                ", docName=" + docName +
                ", docSpec=" + docSpec +
                '}';
    }
    public Doctor(){

    }
    public Doctor(int docId,String docName,String docSpec){
        this.docId=docId;
        this.docName=docName;
        this.docSpec=docSpec;
    }

}
