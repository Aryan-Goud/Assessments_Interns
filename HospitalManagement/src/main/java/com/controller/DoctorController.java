package com.controller;

import com.model.Doctor;
import com.services.DoctorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/doctor")
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    public static final Logger logger= LoggerFactory.getLogger(DoctorController.class);
    @GetMapping
    public List<Doctor> getLibrary() {
        logger.info("Doctor List");
        return doctorService.getDocName();
    }

    @PostMapping("/create")
    public Doctor createLibrary(@RequestBody Doctor name){
        logger.info("create Doctor is invoked {}");
        return doctorService.create(name);
    }

    @GetMapping("/{id}")
    public Doctor getLiraryId(@PathVariable("docId") int id){
        logger.info("getDoctorId is invoked:{}",id);
        return doctorService.getDocId(id);
    }
    @PutMapping("/update")
    public Doctor updateLibrary(@RequestBody Doctor doctor)
    {
        return doctorService.updateDoctor(doctor);
    }
    @DeleteMapping("/{id}")
    public Doctor deleteLibrary(@PathVariable("id") int id){
        return doctorService.deleteDoctor(id);
    }

}
