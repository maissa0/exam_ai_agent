package com.task_management.task_management.service;

import com.task_management.task_management.entity.Module;
import com.task_management.task_management.entity.Specialite;
import com.task_management.task_management.repo.ModuleRepository;
import com.task_management.task_management.repo.SpecialiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModuleServiceImplementation implements ModuleService {

    @Autowired
    private ModuleRepository moduleRepository;

    @Override
    public List<Module> getAllModules() {
        List<Module> modules = moduleRepository.findAll();
        return modules;
    }

    @Override
    public Module getModuleById(Integer id) throws Exception {
        return moduleRepository.findById(id).orElseThrow(()->new Exception("Module Not Found id"+id ));
    }




    @Override
    public Module createModule(Module module/*, String requesterRole*/) throws Exception{
        //if(!requesterRole.equals(("ADMIN"))){
          //  throw new Exception("only admin can create a Module");
        //}
        return moduleRepository.save(module);
    }

    @Override
    public Module updateModule(Integer id, Module module/*, String requesterRole*/) throws Exception {
        Module existing_module = getModuleById(id);

        //if (module.getName()!=null && !requesterRole.equals(("ADMIN"))){
          //  existing_module.setName(module.getName());
        //}
        return moduleRepository.save(existing_module);
    }

    @Override
    public void deleteModule(Integer id) throws Exception {
        getModuleById(id);
        moduleRepository.deleteById(id);
    }


}
