package com.controller;

import com.model.Visit;
import com.services.VisitService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/visit")
public class VisitController {
    @Autowired
    VisitService visitService;
    public static final Logger logger = LoggerFactory.getLogger(VisitController.class);

    @GetMapping
    public List<Visit> getVisit() {
        logger.info("Visit List");
        return visitService.getVisits();
    }

    @PostMapping("/create")
    public Visit createVisit(@RequestBody Visit details) {
        logger.info("create Visit is invoked {} ", details);
        return visitService.create(details);
    }

    @GetMapping("/{id}")
    public Visit getVisitId(@PathVariable("id") int id) {
        logger.info("getVisitId is invoked:{}", id);
        return visitService.getVisitId(id);
    }

    @PutMapping("/update")
    public Visit updateLibrary(@RequestBody Visit visit) {
        return visitService.updateVisit(visit);
    }

    @DeleteMapping("/{id}")
    public Visit deleteLibrary(@PathVariable("id") int id) {
        return visitService.deleteVisit(id);
    }
}
