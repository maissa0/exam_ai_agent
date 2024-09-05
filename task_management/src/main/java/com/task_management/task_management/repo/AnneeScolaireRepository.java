package com.task_management.task_management.repo;

import com.task_management.task_management.entity.Annee_scolaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnneeScolaireRepository extends JpaRepository<Annee_scolaire, Integer> { }
