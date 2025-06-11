package com.jaspercode.employee_management.Service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

import com.jaspercode.employee_management.Dto.EmployeeDto;
import com.jaspercode.employee_management.Entity.Employee;
import com.jaspercode.employee_management.Exception.EmployeeException;
import com.jaspercode.employee_management.Mapper.EmployeeMapper;
import com.jaspercode.employee_management.Repository.EmployeeRepository;
import com.jaspercode.employee_management.Service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository=employeeRepository;
    }

    // create employee
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto){
        
        Employee employee=EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee=employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    // get employee by id
    @Override
    public EmployeeDto getEmployeeById(String id){
        Employee employee=employeeRepository.findById(id).orElseThrow(()->new EmployeeException("Employee does not exist"));
        
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    // get all employees
    @Override
    public List<EmployeeDto> getAllEmployees(){

        List<Employee> employees=employeeRepository.findAll();

        return employees.stream().map((employee)-> EmployeeMapper.mapToEmployeeDto(employee)).collect(Collectors.toList());
    }

    //update employee
    @Override
    public EmployeeDto updateEmployee(String id, EmployeeDto employeeDto){

        Employee employee=employeeRepository.findById(id).orElseThrow(()-> new EmployeeException("Employee not found"));

        employee.setEmployeeName(employeeDto.employeeName());
        employee.setEmployeeDepartment(employeeDto.employeeDepartment());
        employee.setEmployeeSalary(employeeDto.employeeSalary());

        Employee updateEmployee=employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(updateEmployee);

    }

    // delete employee by id
    @Override
    public void deleteEmployee(String id){

        employeeRepository.findById(id).orElseThrow(()-> new EmployeeException("Employee not found"));

        employeeRepository.deleteById(id);

    }
}
