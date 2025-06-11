package com.jaspercode.employee_management.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jaspercode.employee_management.Entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, String>{
}
