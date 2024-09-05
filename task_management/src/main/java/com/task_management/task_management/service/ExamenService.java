package com.task_management.task_management.service;

import com.task_management.task_management.entity.Examen;

import java.util.List;

public interface ExamenService {
    List<Examen> getAllExamens();
    Examen getExamenById(Integer id);
    Examen createExamen(Examen examen);
    Examen updateExamen(Integer id, Examen examen);
    void deleteExamen(Integer id);
}
