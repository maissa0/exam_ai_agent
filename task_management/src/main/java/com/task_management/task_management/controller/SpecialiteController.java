package com.task_management.task_management.controller;


import com.task_management.task_management.Dto.UserDto;
import com.task_management.task_management.entity.Specialite;
import com.task_management.task_management.service.SpecialiteService;
import com.task_management.task_management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/specialities")
public class SpecialiteController {

    @Autowired
    private SpecialiteService specialiteService;

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public ResponseEntity<Specialite> addSpecialite(@RequestBody Specialite specialite,
                                                    @RequestHeader("Authorization") String jwt) throws Exception {

        UserDto user = userService.getUserProfile(jwt);
        Specialite createdSpec = specialiteService.createSpecialite(specialite,user.getRole());
                return new ResponseEntity<>(createdSpec, HttpStatus.CREATED);
    }

    @GetMapping("/all_specialites")
    public ResponseEntity<List<Specialite>> getAllSpecialite(/*@RequestHeader("Authorization") String jwt*/) throws Exception {

       // UserDto user = userService.getUserProfile(jwt);
        List<Specialite> Specs = specialiteService.getAllSpecialites();
        return new ResponseEntity<>(Specs, HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Specialite> updateSpec(
            @PathVariable int id,@RequestBody Specialite spec,@RequestHeader("Authorization") String jwt) throws Exception {
        UserDto user = userService.getUserProfile(jwt);
        Specialite specs=specialiteService.updateSpecialite(id,spec,user.getRole());

        return new ResponseEntity<>(specs, HttpStatus.OK);

    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteSpecialite(@PathVariable int id) throws Exception {
        specialiteService.deleteSpecialite(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
