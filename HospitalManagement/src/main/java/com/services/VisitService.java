package com.services;

import com.model.Hospital;
import com.model.Visit;

import java.util.List;

public interface VisitService {
    List<Visit> getVisits();
    Visit getVisitId(int vId);
    Visit create(Visit name);
    Visit updateVisit(Visit visit);
    Visit deleteVisit(int vId);
}
