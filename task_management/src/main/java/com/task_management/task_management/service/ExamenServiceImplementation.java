package com.task_management.task_management.service;

import com.task_management.task_management.entity.Examen;
import com.task_management.task_management.repo.ExamenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExamenServiceImplementation implements ExamenService {

    @Autowired
    private ExamenRepository examenRepository;

    @Override
    public List<Examen> getAllExamens() {
        return examenRepository.findAll();
    }

    @Override
    public Examen getExamenById(Integer id) {
        Optional<Examen> examen = examenRepository.findById(id);
        return examen.orElseThrow(() -> new RuntimeException("Examen not found with id " + id));
    }

    @Override
    public Examen createExamen(Examen examen) {
        return examenRepository.save(examen);
    }

    @Override
    public Examen updateExamen(Integer id, Examen examenDetails) {
        Examen examen = getExamenById(id); // Reuse method to fetch the existing entity

        // Update the examen entity with new details
        examen.setCategorie(examenDetails.getCategorie());
        examen.setLabel(examenDetails.getLabel());
        examen.setDate(examenDetails.getDate());
        examen.setNotes(examenDetails.getNotes());
        examen.setModule(examenDetails.getModule());

        return examenRepository.save(examen);
    }

    @Override
    public void deleteExamen(Integer id) {
        Examen examen = getExamenById(id); // Fetch the examen before deleting
        examenRepository.delete(examen);
    }
}
