package com.task_management.task_management.controller;

import com.task_management.task_management.request.ClasseRequest;
import com.task_management.task_management.entity.Classe;
import com.task_management.task_management.entity.Specialite;
import com.task_management.task_management.entity.Annee_scolaire;
import com.task_management.task_management.service.ClasseService;
import com.task_management.task_management.service.SpecialiteService;
import com.task_management.task_management.service.AnneeScolaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/classes")
public class ClasseController {

    @Autowired
    private ClasseService classeService;

    @Autowired
    private SpecialiteService specialiteService;

    @Autowired
    private AnneeScolaireService anneeScolaireService;

    // Get all classes
    @GetMapping
    public ResponseEntity<List<Classe>> getAllClasses() {
        List<Classe> classes = classeService.getAllClasses();
        return ResponseEntity.ok(classes);
    }

    // Get a specific class by ID
    @GetMapping("/{id}")
    public ResponseEntity<Classe> getClasseById(@PathVariable Integer id) {
        Classe classe = classeService.getClasseById(id);
        if (classe != null) {
            return ResponseEntity.ok(classe);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Create a new class
    @PostMapping
    public ResponseEntity<Classe> createClasse(@RequestBody ClasseRequest classeRequest) throws Exception {
        // Fetch Specialite and Annee_scolaire entities
        Specialite specialite = specialiteService.getSpecialiteById(classeRequest.getSpecialiteId());
        Annee_scolaire anneeScolaire = anneeScolaireService.getAnneeScolaireById(classeRequest.getAnneeScolaireId());

        if (specialite == null || anneeScolaire == null) {
            return ResponseEntity.badRequest().build();
        }

        // Create and save the new Classe entity
        Classe classe = new Classe();
        classe.setName(classeRequest.getName());
        classe.setSpecialite(specialite);
        classe.setAnneeScolaire(anneeScolaire);

        Classe createdClasse = classeService.createClasse(classe);
        return ResponseEntity.ok(createdClasse);
    }

    // Update an existing class by ID
    @PutMapping("/{id}")
    public ResponseEntity<Classe> updateClasse(
            @PathVariable Integer id,
            @RequestBody ClasseRequest classeRequest) throws Exception {

        // Fetch Specialite and Annee_scolaire entities
        Specialite specialite = specialiteService.getSpecialiteById(classeRequest.getSpecialiteId());
        Annee_scolaire anneeScolaire = anneeScolaireService.getAnneeScolaireById(classeRequest.getAnneeScolaireId());

        if (specialite == null || anneeScolaire == null) {
            return ResponseEntity.badRequest().build();
        }

        // Update and save the Classe entity
        Classe updatedClasse = new Classe();
        updatedClasse.setId(id);
        updatedClasse.setName(classeRequest.getName());
        updatedClasse.setSpecialite(specialite);
        updatedClasse.setAnneeScolaire(anneeScolaire);

        Classe result = classeService.updateClasse(id, updatedClasse);
        if (result != null) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a class by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClasse(@PathVariable Integer id) {
        classeService.deleteClasse(id);
        return ResponseEntity.noContent().build();
    }
}
