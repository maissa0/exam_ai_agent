package com.task_management.task_management.service;

import com.task_management.task_management.entity.Cl_Md_En;
import com.task_management.task_management.entity.Cl_Md_En_Key;

import java.util.List;
import java.util.Optional;

public interface ClMdEnService {
    Cl_Md_En save(Cl_Md_En clMdEn);

    List<Cl_Md_En> findAll();

    Optional<Cl_Md_En> findById(Cl_Md_En_Key id);

    Cl_Md_En update(Cl_Md_En clMdEn);

    void deleteById(Cl_Md_En_Key id);
}

