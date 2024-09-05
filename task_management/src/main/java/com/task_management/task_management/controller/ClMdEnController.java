package com.task_management.task_management.controller;

import com.task_management.task_management.entity.Cl_Md_En;
import com.task_management.task_management.entity.Cl_Md_En_Key;
import com.task_management.task_management.entity.Classe;
import com.task_management.task_management.entity.Employee;
import com.task_management.task_management.entity.Module;
import com.task_management.task_management.request.ClMdEnRequest;
import com.task_management.task_management.service.ClMdEnService;
import com.task_management.task_management.service.ClasseService;
import com.task_management.task_management.service.EmployeeService;
import com.task_management.task_management.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

        import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cl-md-en")
public class ClMdEnController {

    @Autowired
    private ClMdEnService clMdEnService;

    @Autowired
    private ClasseService classeService;

    @Autowired
    private ModuleService moduleService;

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<Cl_Md_En> createClMdEn(@RequestBody ClMdEnRequest clMdEnRequest) throws Exception {
        // Fetch Classe, Module, and Employee entities
        Classe classe = classeService.getClasseById(clMdEnRequest.getClasseId());
        Module module = moduleService.getModuleById(clMdEnRequest.getModuleId());
        Employee employee = employeeService.getEmployeeById(clMdEnRequest.getEmployeeId());

        // Check if any of the fetched entities are null
        if (classe == null || module == null || employee == null) {
            return ResponseEntity.badRequest().build();
        }

        // Initialize composite key
        Cl_Md_En_Key id = new Cl_Md_En_Key(clMdEnRequest.getClasseId(), clMdEnRequest.getModuleId(), clMdEnRequest.getEmployeeId());

        // Create and save the new Cl_Md_En entity
        Cl_Md_En clMdEn = new Cl_Md_En();
        clMdEn.setId(id);
        clMdEn.setClasse(classe);
        clMdEn.setModule(module);
        clMdEn.setEmployee(employee);

        Cl_Md_En createdClMdEn = clMdEnService.save(clMdEn);
        return ResponseEntity.ok(createdClMdEn);
    }


    @GetMapping
    public List<Cl_Md_En> getAllClMdEn() {
        return clMdEnService.findAll();
    }

    @GetMapping("/{classeId}/{moduleId}/{employeeId}")
    public ResponseEntity<Cl_Md_En> getClMdEnById(
            @PathVariable Integer classeId,
            @PathVariable Integer moduleId,
            @PathVariable Integer employeeId) {

        Cl_Md_En_Key id = new Cl_Md_En_Key(classeId, moduleId, employeeId);
        Optional<Cl_Md_En> clMdEn = clMdEnService.findById(id);
        return clMdEn.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{classeId}/{moduleId}/{employeeId}")
    public ResponseEntity<Cl_Md_En> updateClMdEn(
            @PathVariable Integer classeId,
            @PathVariable Integer moduleId,
            @PathVariable Integer employeeId,
            @RequestBody Cl_Md_En clMdEnDetails) {

        Cl_Md_En_Key id = new Cl_Md_En_Key(classeId, moduleId, employeeId);
        Optional<Cl_Md_En> existingClMdEn = clMdEnService.findById(id);

        if (existingClMdEn.isPresent()) {
            Cl_Md_En updatedClMdEn = existingClMdEn.get();
            updatedClMdEn.setClasse(clMdEnDetails.getClasse());
            updatedClMdEn.setModule(clMdEnDetails.getModule());
            updatedClMdEn.setEmployee(clMdEnDetails.getEmployee());

            clMdEnService.update(updatedClMdEn);
            return ResponseEntity.ok(updatedClMdEn);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{classeId}/{moduleId}/{employeeId}")
    public ResponseEntity<Void> deleteClMdEn(
            @PathVariable Integer classeId,
            @PathVariable Integer moduleId,
            @PathVariable Integer employeeId) {

        Cl_Md_En_Key id = new Cl_Md_En_Key(classeId, moduleId, employeeId);
        clMdEnService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
