package com.task_management.task_management.controller;


import com.task_management.task_management.entity.Annee_scolaire;
import com.task_management.task_management.service.AnneeScolaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

        import java.util.List;

@RestController
@RequestMapping("/api/annee-scolaire")
public class AnneeScolaireController {

    @Autowired
    private AnneeScolaireService anneeScolaireService;

    // Get all Annee_scolaires
    @GetMapping("/all")
    public ResponseEntity<List<Annee_scolaire>> getAllAnneeScolaires() {
        List<Annee_scolaire> anneeScolaires = anneeScolaireService.getAllAnneeScolaires();
        return ResponseEntity.ok(anneeScolaires);
    }

    // Get a specific Annee_scolaire by ID
    @GetMapping("/annee/{id}")
    public ResponseEntity<Annee_scolaire> getAnneeScolaireById(@PathVariable Integer id) {
        Annee_scolaire anneeScolaire = anneeScolaireService.getAnneeScolaireById(id);
        if (anneeScolaire != null) {
            return ResponseEntity.ok(anneeScolaire);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Create a new Annee_scolaire
    @PostMapping("/add")
    public ResponseEntity<Annee_scolaire> createAnneeScolaire(@RequestBody Annee_scolaire anneeScolaire) {
        Annee_scolaire createdAnneeScolaire = anneeScolaireService.createAnneeScolaire(anneeScolaire);
        return ResponseEntity.ok(createdAnneeScolaire);
    }

    // Update an existing Annee_scolaire by ID
    @PutMapping("/anneeUpdate/{id}")
    public ResponseEntity<Annee_scolaire> updateAnneeScolaire(
            @PathVariable Integer id,
            @RequestBody Annee_scolaire updatedAnneeScolaire) {
        Annee_scolaire updated = anneeScolaireService.updateAnneeScolaire(id, updatedAnneeScolaire);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete an Annee_scolaire by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteAnneeScolaire(@PathVariable Integer id) {
        anneeScolaireService.deleteAnneeScolaire(id);
        return ResponseEntity.noContent().build();
    }
}
