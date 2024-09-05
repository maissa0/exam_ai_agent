package com.task_management.task_management.service;

import com.task_management.task_management.entity.Cl_Md_En;
import com.task_management.task_management.entity.Cl_Md_En_Key;
import com.task_management.task_management.repo.ClMdEnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClMdEnServiceImplementation implements ClMdEnService {

    @Autowired
    private ClMdEnRepository clMdEnRepository;

    @Override
    public Cl_Md_En save(Cl_Md_En clMdEn) {
        return clMdEnRepository.save(clMdEn);
    }

    @Override
    public List<Cl_Md_En> findAll() {
        return clMdEnRepository.findAll();
    }

    @Override
    public Optional<Cl_Md_En> findById(Cl_Md_En_Key id) {
        return clMdEnRepository.findById(id);
    }

    @Override
    public Cl_Md_En update(Cl_Md_En clMdEn) {
        return clMdEnRepository.save(clMdEn);  // Save method in JPA acts as both insert and update
    }

    @Override
    public void deleteById(Cl_Md_En_Key id) {
        clMdEnRepository.deleteById(id);
    }
}
