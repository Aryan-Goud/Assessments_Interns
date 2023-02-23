package com.services;

import com.model.Doctor;
import com.model.Hospital;

import java.util.List;

public interface HospitalService {
    List<Hospital> getHospName();
    Hospital getHospId(int hosId);
    Hospital create(Hospital name);
    Hospital updateHospital(Hospital name);
    Hospital deleteHospital(int hosId);
}
