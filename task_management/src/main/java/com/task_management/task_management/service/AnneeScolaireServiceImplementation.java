package com.task_management.task_management.service;


import com.task_management.task_management.entity.Annee_scolaire;
import com.task_management.task_management.repo.AnneeScolaireRepository;
import com.task_management.task_management.service.AnneeScolaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnneeScolaireServiceImplementation implements AnneeScolaireService {

    @Autowired
    private AnneeScolaireRepository anneeScolaireRepository;

    @Override
    public List<Annee_scolaire> getAllAnneeScolaires() {
        return anneeScolaireRepository.findAll();
    }

    @Override
    public Annee_scolaire getAnneeScolaireById(Integer id) {
        Optional<Annee_scolaire> anneeScolaire = anneeScolaireRepository.findById(id);
        return anneeScolaire.orElse(null);
    }

    @Override
    public Annee_scolaire createAnneeScolaire(Annee_scolaire anneeScolaire) {
        // The startYear setter automatically calculates endYear
        return anneeScolaireRepository.save(anneeScolaire);
    }

    @Override
    public Annee_scolaire updateAnneeScolaire(Integer id, Annee_scolaire updatedAnneeScolaire) {
        Optional<Annee_scolaire> existingAnneeScolaire = anneeScolaireRepository.findById(id);
        if (existingAnneeScolaire.isPresent()) {
            Annee_scolaire anneeScolaire = existingAnneeScolaire.get();
            // Set the start year, which automatically sets the end year
            anneeScolaire.setStartYear(updatedAnneeScolaire.getStartYear());
            anneeScolaire.setClasses(updatedAnneeScolaire.getClasses());
            return anneeScolaireRepository.save(anneeScolaire);
        }
        return null;
    }

    @Override
    public void deleteAnneeScolaire(Integer id) {
        anneeScolaireRepository.deleteById(id);
    }
}
