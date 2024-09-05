package com.task_management.task_management.controller;


import com.task_management.task_management.entity.Specialite;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {

    @GetMapping("/specialities")
    public ResponseEntity<String> getAllSpecialite(){


        return new ResponseEntity<>("Welcome to Specialite Service", HttpStatus.CREATED);
    }
}
