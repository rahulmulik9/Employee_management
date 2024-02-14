package com.Rahul_Employee.Employee.management.repository;

import com.Rahul_Employee.Employee.management.entity.EmployeeEntity;
import com.Rahul_Employee.Employee.management.service.EmployeeService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {



}
