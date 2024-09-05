package com.task_management.task_management.service;


import com.task_management.task_management.entity.Classe;
import com.task_management.task_management.entity.Specialite;
import com.task_management.task_management.entity.Annee_scolaire;
import com.task_management.task_management.repo.ClasseRepository;
import com.task_management.task_management.service.ClasseService;
import com.task_management.task_management.service.SpecialiteService;
import com.task_management.task_management.service.AnneeScolaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

    @Service
    public class ClasseServiceImplementation implements ClasseService {
        @Autowired
        private ClasseRepository classeRepository;

        @Autowired
        private SpecialiteService specialiteService;

        @Autowired
        private AnneeScolaireService anneeScolaireService;

        @Override
        public List<Classe> getAllClasses() {
            return classeRepository.findAll();
        }

        @Override
        public Classe getClasseById(Integer id) {
            Optional<Classe> classe = classeRepository.findById(id);
            return classe.orElse(null);
        }

        @Override
        public Classe createClasse(Classe classe) throws Exception {
            // Fetch and set Specialite and Annee_scolaire
            Specialite specialite = classe.getSpecialite();
            Annee_scolaire anneeScolaire = classe.getAnneeScolaire();

            if (specialite != null && anneeScolaire != null) {
                // Ensure that the provided entities are valid
                if (specialiteService.getSpecialiteById(specialite.getId()) == null ||
                        anneeScolaireService.getAnneeScolaireById(anneeScolaire.getId()) == null) {
                    return null; // Invalid Specialite or Annee_scolaire
                }
            }

            return classeRepository.save(classe);
        }

        @Override
        public Classe updateClasse(Integer id, Classe updatedClasse) {
            Optional<Classe> existingClasse = classeRepository.findById(id);
            if (existingClasse.isPresent()) {
                Classe classe = existingClasse.get();
                classe.setName(updatedClasse.getName());
                classe.setSpecialite(updatedClasse.getSpecialite());
                classe.setAnneeScolaire(updatedClasse.getAnneeScolaire());
                // You may want to handle updating associated entities if necessary
                return classeRepository.save(classe);
            }
            return null;
        }

        @Override
        public void deleteClasse(Integer id) {
            classeRepository.deleteById(id);
        }
    }

