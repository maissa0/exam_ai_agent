package com.task_management.task_management.service;

import com.task_management.task_management.entity.Module;
import java.util.List;

public interface ModuleService {

    List<Module> getAllModules();
    Module getModuleById(Integer id) throws Exception;
    Module createModule(Module module/*, String requesterRole*/) throws Exception;
    Module updateModule(Integer id, Module module/*, String requesterRole*/) throws Exception;
    void deleteModule(Integer id) throws Exception;
}
