package com.task_management.task_management.repo;

import com.task_management.task_management.entity.Examen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamenRepository extends JpaRepository<Examen, Integer> { }
