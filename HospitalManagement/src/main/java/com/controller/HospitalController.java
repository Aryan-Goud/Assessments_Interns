package com.controller;

import com.model.Hospital;
import com.services.HospitalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/hospital")
public class HospitalController {
    @Autowired
    HospitalService hospitalService;
    public static final Logger logger= LoggerFactory.getLogger(HospitalService.class);

    @GetMapping
    public List<Hospital> getHospital() {
        logger.info("Hospital List");
        return hospitalService.getHospName();
    }

    @PostMapping("/create")
    public Hospital createHospital(@RequestBody Hospital name){
        logger.info("create Hospital is invoked {}");
        return hospitalService.create(name);
    }

    @GetMapping("/{id}")
    public Hospital getHospId(@PathVariable("id") int id){
        logger.info("getHospId is invoked:{}",id);
        return  hospitalService.getHospId(id);
    }
    @PutMapping("/update")
    public Hospital updateHosp(@RequestBody Hospital hospital)
    {
        return hospitalService.updateHospital(hospital);
    }
    @DeleteMapping("/{id}")
    public Hospital deleteHosp(@PathVariable("id") int id){
        return hospitalService.deleteHospital(id);
    }

}
