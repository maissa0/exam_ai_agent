package com.task_management.task_management.repo;


import com.task_management.task_management.entity.Classe;
import com.task_management.task_management.entity.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Integer> {

    List<Etudiant> findByClasse(Classe classe);
}

