package com.controller;

import com.model.Status;
import com.model.Status;
import com.service.StatusService;
import com.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("/status")
public class StatusController {
    @Autowired
    StatusService statusservice;
    @Autowired
    UserService userService;

    public static final Logger logger= LoggerFactory.getLogger(StatusController.class);

    @GetMapping("/display")
    public List<Status> getStatus() {
        logger.info("Status List");
        return statusservice.getStatus();
    }

    @PostMapping("/create")
    public Status  create(@RequestBody Status data){
        logger.info("create Status is invoked {}");
        return statusservice.create(data);
    }

    @GetMapping("/{id}")
    public Status getStatusId(@PathVariable("status_id") int id){
        logger.info("getStatusId is invoked:{}",id);
        return statusservice.getStatusId(id);
    }
    @PutMapping("/update")
    public Status updateStatus(@RequestBody Status st)
    {
        return statusservice.updateStatus(st);
    }
    @DeleteMapping("/{id}")
    public Status deleteStatus(@PathVariable("id") int id){
        return statusservice.deleteStatus(id);
    }

}
