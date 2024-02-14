package com.Rahul_Employee.Employee.management.service;

import com.Rahul_Employee.Employee.management.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee createEmployee(Employee employee);

    List<Employee> getAllEmployees();


    Boolean deletEmployee(Long id);


    Employee getEmployeeById(Long id);

    Employee updateEmployee(Long id, Employee employee);
}
