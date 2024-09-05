package com.task_management.task_management.service;

import com.task_management.task_management.entity.Etudiant;

import java.util.List;

public interface EtudiantService {

    List<Etudiant> getAllEtudiants();
    Etudiant getEtudiantById(Integer id);
    Etudiant createEtudiant(Etudiant etudiant);
    Etudiant updateEtudiant(Integer id, Etudiant etudiant);
    void deleteEtudiant(Integer id);
    List<Etudiant> getEtudiantsByClasse(Integer classeId);
}
