package com.services;

import com.model.Doctor;

import java.util.List;

public interface DoctorService {
    List<Doctor> getDocName();
    Doctor getDocId(int docId);
    Doctor create(Doctor name);
    Doctor updateDoctor(Doctor name);
    Doctor deleteDoctor(int docId);

}
