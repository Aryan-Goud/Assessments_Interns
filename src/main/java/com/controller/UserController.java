package com.controller;

import com.model.User;
import com.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("/users")
public class UserController {


@Autowired
UserService userService;

//    private final UserService userService;
//    @Autowired
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }
//    @GetMapping("/raisetickets")
//    public String showForm(Model model) {
//        model.addAttribute("user", new User());
//        return "raisetickets";
//    }
//    @PostMapping("/raisetickets")
//    public String submitForm(@ModelAttribute User user) {
//        userService.insert(user);
//        return "redirect:/raisetickets";
//    }

    public static final Logger logger= LoggerFactory.getLogger(UserController.class);
//    @GetMapping("/")
//    public String index(){
//        return "index";
//    }
    @GetMapping("/display")
    public List<User> getUser() {
        logger.info("User List");
        return userService.getusername();
    }

    @PostMapping("/create")
    public User createLibrary(@RequestBody User user){
        logger.info("create User is invoked {}");
        return userService.create(user);
    }

    @GetMapping("/{systemid}")
    public User getUserId(@PathVariable("systemid") int systemid){
        logger.info("getUserId is invoked:{}",systemid);
        System.out.println(userService.getusername());
        return userService.getUserId(systemid);
    }
    @PutMapping("/update")
    public User updateUser(@RequestBody User user)
    {
        return userService.updateUser(user);
    }
    @DeleteMapping("/{id}")
    public User deleteUser(@PathVariable("id") int id){
        return userService.deleteUser(id);
    }
}
