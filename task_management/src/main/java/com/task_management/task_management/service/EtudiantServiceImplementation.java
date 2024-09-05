package com.task_management.task_management.service;


import com.task_management.task_management.entity.Classe;
import com.task_management.task_management.entity.Etudiant;
import com.task_management.task_management.repo.ClasseRepository;
import com.task_management.task_management.repo.EtudiantRepository;
import com.task_management.task_management.service.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtudiantServiceImplementation implements EtudiantService {

    @Autowired
    private EtudiantRepository etudiantRepository;

    @Autowired
    private ClasseRepository classeRepository;

    @Override
    public List<Etudiant> getAllEtudiants() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant getEtudiantById(Integer id) {
        return etudiantRepository.findById(id).orElse(null);
    }

    @Override
    public Etudiant createEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    @Override
    public Etudiant updateEtudiant(Integer id, Etudiant updatedEtudiant) {
        return etudiantRepository.findById(id).map(etudiant -> {
            etudiant.setNom(updatedEtudiant.getNom());
            etudiant.setPrenom(updatedEtudiant.getPrenom());
            etudiant.setClasse(updatedEtudiant.getClasse());
            return etudiantRepository.save(etudiant);
        }).orElse(null);
    }

    @Override
    public void deleteEtudiant(Integer id) {
        etudiantRepository.deleteById(id);
    }

    @Override
    public List<Etudiant> getEtudiantsByClasse(Integer classeId) {
        Classe classe = classeRepository.findById(classeId).orElse(null);
        if (classe != null) {
            return etudiantRepository.findByClasse(classe);
        } else {
            return null;
        }
    }
}
