package com.task_management.task_management.controller;


import com.task_management.task_management.Dto.UserDto;
import com.task_management.task_management.entity.Module;
import com.task_management.task_management.service.ModuleService;
import com.task_management.task_management.service.SpecialiteService;
import com.task_management.task_management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Modules")
public class ModuleController {

    @Autowired
    private ModuleService moduleService;



    @PostMapping("/add")
    public ResponseEntity<Module> addModule(@RequestBody Module module) throws Exception {

        Module createdModule = moduleService.createModule(module);
        return new ResponseEntity<>(createdModule, HttpStatus.CREATED);
    }

    @GetMapping("/all_Modules")
    public ResponseEntity<List<Module>> getAllModule(/*@RequestHeader("Authorization") String jwt*/) throws Exception {

        // UserDto user = userService.getUserProfile(jwt);
        List<Module> Specs = moduleService.getAllModules();
        return new ResponseEntity<>(Specs, HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Module> updateModule(
            @PathVariable int id,@RequestBody Module spec/*,@RequestHeader("Authorization") String jwt*/) throws Exception {
       // UserDto user = userService.getUserProfile(jwt);
        Module modules=moduleService.updateModule(id,spec);

        return new ResponseEntity<>(modules, HttpStatus.OK);

    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteModule(@PathVariable int id) throws Exception {
        moduleService.deleteModule(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
