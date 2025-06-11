package com.jaspercode.employee_management.Service;

import java.util.List;

import com.jaspercode.employee_management.Dto.EmployeeDto;

public interface EmployeeService {

    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(String id);

    List<EmployeeDto> getAllEmployees();

    EmployeeDto updateEmployee(String id,EmployeeDto employeeDto);

    void deleteEmployee(String id);

}

