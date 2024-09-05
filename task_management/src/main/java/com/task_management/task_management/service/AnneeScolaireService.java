package com.task_management.task_management.service;

import com.task_management.task_management.entity.Annee_scolaire;

import java.util.List;

public interface AnneeScolaireService {

    List<Annee_scolaire> getAllAnneeScolaires();
    Annee_scolaire getAnneeScolaireById(Integer id);
    Annee_scolaire createAnneeScolaire(Annee_scolaire anneeScolaire);
    Annee_scolaire updateAnneeScolaire(Integer id, Annee_scolaire anneeScolaire);
    void deleteAnneeScolaire(Integer id);
}
