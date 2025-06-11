package com.jaspercode.employee_management.Mapper;

import com.jaspercode.employee_management.Dto.EmployeeDto;
import com.jaspercode.employee_management.Entity.Employee;

public class EmployeeMapper {
    
    public static Employee mapToEmployee(EmployeeDto employeeDto){

        Employee employee=new Employee(
            employeeDto.id(),
            employeeDto.employeeName(),
            employeeDto.employeeDepartment(),
            employeeDto.employeeSalary()
        );

        return employee;
    }

    public static EmployeeDto mapToEmployeeDto(Employee employee){

        EmployeeDto employeeDto= new EmployeeDto(
            employee.getId(),
            employee.getEmployeeName(),
            employee.getEmployeeDepartment(),
            employee.getEmployeeSalary()
        );

        return employeeDto;
    }
}
