package com.task_management.task_management.service;


import com.task_management.task_management.entity.Employee;

import java.util.List;

public interface EmployeeService {
    Employee createEmployee(Employee employee);
    Employee updateEmployee(Integer id, Employee employee) throws Exception;
    Employee getEmployeeById(Integer id);
    List<Employee> getAllEmployees();
    void deleteEmployee(Integer id) throws Exception;
}
