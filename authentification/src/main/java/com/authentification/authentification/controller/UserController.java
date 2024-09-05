package com.authentification.authentification.controller;


import com.authentification.authentification.entity.User;
import com.authentification.authentification.service.UserService;
import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private  UserService userService;


    @GetMapping("/profile")
    public ResponseEntity<User> getUserProfile (@RequestHeader("Authorization") String jwt){
        User user = userService.getUserProfile(jwt);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }


    @GetMapping("/all")
    public ResponseEntity<List<User>> getUsers (@RequestHeader("Authorization") String jwt){
        List<User> user = userService.getAllUsers();
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
