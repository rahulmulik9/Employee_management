package com.Rahul_Employee.Employee.management.service;

import com.Rahul_Employee.Employee.management.entity.EmployeeEntity;
import com.Rahul_Employee.Employee.management.model.Employee;
import com.Rahul_Employee.Employee.management.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee createEmployee(Employee employee) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        BeanUtils.copyProperties(employee, employeeEntity);
        employeeRepository.save(employeeEntity);
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<EmployeeEntity> employeeEntityList = employeeRepository.findAll();


        List<Employee> employeeList = employeeEntityList
                .stream()
                .map(emp -> new Employee(emp.getId(), emp.getFirstName(), emp.getLastName(), emp.getEmailId()))
                .collect(Collectors.toList());
        return employeeList;
    }

    @Override
    public Boolean deletEmployee(Long id) {
        EmployeeEntity employee = employeeRepository.findById(id).get();
        employeeRepository.delete(employee);

        try {
            EmployeeEntity employee1 = employeeRepository.findById(id).get();

            if (employee.getId() == id) {
                return false;
            }
        } catch (Exception e) {
            return true;
        }
        return true;
    }

    @Override
    public Employee getEmployeeById(Long id) {
        EmployeeEntity employee = employeeRepository.findById(id).get();
        Employee employee1 = new Employee();
        BeanUtils.copyProperties(employee, employee1);
        return employee1;
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        EmployeeEntity employeeEntity = employeeRepository.findById(id).get();

        employeeEntity.setEmailId(employee.getEmailId());
        employeeEntity.setFirstName(employee.getFirstName());
        employeeEntity.setLastName(employee.getLastName());
        employeeRepository.save(employeeEntity);
        return employee;


    }


}
