package com.task_management.task_management.controller;

import com.task_management.task_management.entity.Classe;
import com.task_management.task_management.entity.Etudiant;
import com.task_management.task_management.entity.Module;
import com.task_management.task_management.request.ExamenRequest;
import com.task_management.task_management.service.ModuleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task_management.task_management.entity.Examen;
import com.task_management.task_management.service.ExamenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

        import java.util.List;

@RestController
@RequestMapping("/api/examens")
public class ExamenController {

    @Autowired
    private ExamenService examenService;

    @Autowired
    private ModuleService moduleService;

    @GetMapping
    public List<Examen> getAllExamens() {
        return examenService.getAllExamens();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Examen> getExamenById(@PathVariable Integer id) {
        Examen examen = examenService.getExamenById(id);
        return ResponseEntity.ok(examen);
    }

    @PostMapping
    public ResponseEntity<Examen> createExamen(@RequestBody ExamenRequest examenRequest) throws Exception {
        // Fetch Classe entity
        Module module = moduleService.getModuleById(examenRequest.getModuleId());


        if (module == null ) {
            return ResponseEntity.badRequest().build();
        }

        // Create and save the new Classe entity
        Examen examen = new Examen();
        examen.setCategorie(examenRequest.getCategorie());
        examen.setLabel(examenRequest.getLabel());
        examen.setDate(examenRequest.getDate());
        examen.setModule(module);

        Examen createdExamen = examenService.createExamen(examen);
        return ResponseEntity.ok(createdExamen);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Examen> updateExamen(@PathVariable Integer id, @RequestBody Examen examenDetails) {
        Examen updatedExamen = examenService.updateExamen(id, examenDetails);
        return ResponseEntity.ok(updatedExamen);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExamen(@PathVariable Integer id) {
        examenService.deleteExamen(id);
        return ResponseEntity.noContent().build();
    }
}
