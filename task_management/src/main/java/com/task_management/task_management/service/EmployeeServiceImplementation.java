package com.task_management.task_management.service;


import com.task_management.task_management.entity.Employee;
import com.task_management.task_management.repo.EmployeeRepository;
import com.task_management.task_management.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImplementation implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Integer id, Employee employee) throws Exception {
        Optional<Employee> existingEmployee = employeeRepository.findById(id);
        if (existingEmployee.isPresent()) {
            Employee updatedEmployee = existingEmployee.get();
            updatedEmployee.setNom(employee.getNom());
            updatedEmployee.setPrenom(employee.getPrenom());
            updatedEmployee.setDateDeNaissance(employee.getDateDeNaissance());
            updatedEmployee.setNumero(employee.getNumero());
            return employeeRepository.save(updatedEmployee);
        } else {
            throw new Exception("Employee not found");
        }
    }

    @Override
    public Employee getEmployeeById(Integer id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public void deleteEmployee(Integer id) throws Exception {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
        } else {
            throw new Exception("Employee not found");
        }
    }
}