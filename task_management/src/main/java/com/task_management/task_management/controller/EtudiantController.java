package com.task_management.task_management.controller;


import com.task_management.task_management.entity.Annee_scolaire;
import com.task_management.task_management.entity.Classe;
import com.task_management.task_management.entity.Etudiant;
import com.task_management.task_management.entity.Specialite;
import com.task_management.task_management.request.EtudiantRequest;
import com.task_management.task_management.service.ClasseService;
import com.task_management.task_management.service.EtudiantService;
import com.task_management.task_management.service.SpecialiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

        import java.util.List;

@RestController
@RequestMapping("/api/etudiants")
public class EtudiantController {

    @Autowired
    private EtudiantService etudiantService;

    @Autowired
    private ClasseService classeService;

    // Get all students
    @GetMapping
    public ResponseEntity<List<Etudiant>> getAllEtudiants() {
        List<Etudiant> etudiants = etudiantService.getAllEtudiants();
        return ResponseEntity.ok(etudiants);
    }

    // Get a specific student by ID
    @GetMapping("/{id}")
    public ResponseEntity<Etudiant> getEtudiantById(@PathVariable Integer id) {
        Etudiant etudiant = etudiantService.getEtudiantById(id);
        if (etudiant != null) {
            return ResponseEntity.ok(etudiant);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Create a new student
    @PostMapping
    public ResponseEntity<Etudiant> createEtudiant(@RequestBody EtudiantRequest etudiantRequest) {
        // Fetch Classe entity
        Classe classe = classeService.getClasseById(etudiantRequest.getClasseId());


        if (classe == null ) {
            return ResponseEntity.badRequest().build();
        }

        // Create and save the new Classe entity
        Etudiant etudiant = new Etudiant();
        etudiant.setNom(etudiantRequest.getNom());
        etudiant.setPrenom(etudiantRequest.getPrenom());
        etudiant.setClasse(classe);

        Etudiant createdEtudiant = etudiantService.createEtudiant(etudiant);
        return ResponseEntity.ok(createdEtudiant);
    }

    // Update an existing student
    @PutMapping("/{id}")
    public ResponseEntity<Etudiant> updateEtudiant(
            @PathVariable Integer id,
            @RequestBody Etudiant updatedEtudiant) {
        Etudiant etudiant = etudiantService.updateEtudiant(id, updatedEtudiant);
        if (etudiant != null) {
            return ResponseEntity.ok(etudiant);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a student by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEtudiant(@PathVariable Integer id) {
        etudiantService.deleteEtudiant(id);
        return ResponseEntity.noContent().build();
    }

    // Get students by class ID
    @GetMapping("/classe/{classeId}")
    public ResponseEntity<List<Etudiant>> getEtudiantsByClasse(@PathVariable Integer classeId) {
        List<Etudiant> etudiants = etudiantService.getEtudiantsByClasse(classeId);
        if (etudiants != null) {
            return ResponseEntity.ok(etudiants);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
