package com.task_management.task_management.service;

import com.task_management.task_management.entity.Specialite;

import java.util.List;

public interface SpecialiteService {

    List<Specialite> getAllSpecialites();
    Specialite getSpecialiteById(Integer id) throws Exception;
    Specialite createSpecialite(Specialite specialite,String requesterRole) throws Exception;
    Specialite updateSpecialite(Integer id, Specialite specialite,String requesterRole) throws Exception;
    void deleteSpecialite(Integer id) throws Exception;
}
