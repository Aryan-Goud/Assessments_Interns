package com.controller;

import com.model.Hospital;
import com.model.Patient;
import com.services.HospitalService;
import com.services.PatientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "patient")
public class PatientController {
    @Autowired
    PatientService patientService;
    public static final Logger logger= LoggerFactory.getLogger(PatientService.class);

    @GetMapping
    public List<Patient> getPatient() {
        logger.info("Patient List");
        return patientService.getPName();
    }

    @PostMapping("/create")
    public Patient createPatient(@RequestBody Patient details){
        logger.info("create Patient is invoked {}");
        return patientService.create(details);
    }

    @GetMapping("/{id}")
    public Patient getLibraryId(@PathVariable("id") int id){
        logger.info("getPatientId is invoked:{}",id);
        return  patientService.getPId(id);
    }
    @PutMapping("/update")
    public Patient updatePatient(@RequestBody Patient patient)
    {
        return patientService.updatePatient(patient);
    }
    @DeleteMapping("/{id}")
    public Patient deletePatient(@PathVariable("id") int id){
        return patientService.deletePatient(id);
    }
}
