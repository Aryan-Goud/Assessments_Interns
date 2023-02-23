package com.services;

import com.model.Hospital;
import com.model.Patient;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PatientService {
    List<Patient> getPName();
    Patient getPId(int pId);
    Patient create(Patient name);
    Patient updatePatient(Patient name);
    Patient deletePatient(int pId);

}
