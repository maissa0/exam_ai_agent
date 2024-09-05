package com.task_management.task_management.service;

import com.task_management.task_management.entity.Classe;

import java.util.List;

public interface ClasseService {

    List<Classe> getAllClasses();
    Classe getClasseById(Integer id);
    Classe createClasse(Classe classe) throws Exception;
    Classe updateClasse(Integer id, Classe classe);
    void deleteClasse(Integer id);
}
