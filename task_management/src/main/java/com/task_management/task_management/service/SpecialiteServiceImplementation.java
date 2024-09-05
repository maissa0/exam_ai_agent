package com.task_management.task_management.service;

import com.task_management.task_management.entity.Specialite;
import com.task_management.task_management.repo.SpecialiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecialiteServiceImplementation implements SpecialiteService {

    @Autowired
    private SpecialiteRepository specialiteRepository;

    @Override
    public List<Specialite> getAllSpecialites() {
        List<Specialite> specialites = specialiteRepository.findAll();
        return specialites;
    }

    @Override
    public Specialite getSpecialiteById(Integer id) throws Exception {
        return specialiteRepository.findById(id).orElseThrow(()->new Exception("Specialite Not Found id"+id ));
    }

    @Override
    public Specialite createSpecialite(Specialite specialite, String requesterRole) throws Exception {

        if(!requesterRole.equals(("ADMIN"))){
            throw new Exception("only admin can create a speciality");
        }
        return specialiteRepository.save(specialite);
    }


    @Override
    public Specialite updateSpecialite(Integer id, Specialite specialite ,String requesterRole) throws Exception {

        Specialite existing_specialite = getSpecialiteById(id);

        if (specialite.getLabel()!=null && !requesterRole.equals(("ADMIN"))){
            existing_specialite.setLabel(specialite.getLabel());
        }
        return specialiteRepository.save(existing_specialite);
    }

    @Override
    public void deleteSpecialite(Integer id) throws Exception {

        getSpecialiteById(id);
        specialiteRepository.deleteById(id);
    }
}
