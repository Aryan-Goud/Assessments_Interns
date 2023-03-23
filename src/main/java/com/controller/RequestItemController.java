package com.controller;

import com.model.RequestItem;
import com.model.User;
import com.service.RequestService;
import com.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/request")
public class RequestItemController {
    @Autowired
    RequestService requestService;
    @Autowired
    UserService userService;
//    RequestItem requestItem= requestService.getReqId(userService.getUserId());
    
    public static final Logger logger= LoggerFactory.getLogger(RequestItemController.class);
    @GetMapping("/display")
    public List<RequestItem> getUser() {
        logger.info("Request List");
        return requestService.getReqname();
    }

    @PostMapping("/create")
    public RequestItem  createUser(@RequestBody RequestItem data){
        logger.info("create Request is invoked {}");
        return requestService.create(data);
    }

    @GetMapping("/{id}")
    public RequestItem getUserId(@PathVariable("req_id") int id){
        logger.info("getReqId is invoked:{}",id);
        return requestService.getReqId(id);
    }
    @PutMapping("/update")
    public RequestItem updateUser(@RequestBody RequestItem req)
    {
        return requestService.updateReq(req);
    }
    @DeleteMapping("/{id}")
    public RequestItem deleteUser(@PathVariable("id") int id){
        return requestService.deleteReq(id);
    }

}
