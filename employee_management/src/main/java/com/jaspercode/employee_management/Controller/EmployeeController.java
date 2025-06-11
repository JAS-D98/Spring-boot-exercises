package com.jaspercode.employee_management.Controller;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jaspercode.employee_management.Dto.EmployeeDto;
import com.jaspercode.employee_management.Response.ResponseHandler;
import com.jaspercode.employee_management.Service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService=employeeService;
    }
    
    // add employee
    @PostMapping
    public ResponseEntity<EmployeeDto> addEmployee(@RequestBody EmployeeDto employeeDto){
        return new ResponseEntity<>(employeeService.createEmployee(employeeDto), HttpStatus.CREATED);
    }


    // Get all employees
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
        List<EmployeeDto> employees=employeeService.getAllEmployees();

        return ResponseEntity.ok(employees);
    }

    //get single employee
    @GetMapping("/{id}")
    public ResponseEntity<Object> getEmployeeById(@PathVariable String id){
        EmployeeDto employeeDto=employeeService.getEmployeeById(id);

        return ResponseHandler.responseBuilder("Messages received Successfully", true ,HttpStatus.OK, employeeDto);
    }
    

    // delete employee
    @DeleteMapping("{id}")
    public ResponseEntity<Object> deleteEmployee(@PathVariable String id){
        employeeService.deleteEmployee(id);

        return ResponseEntity.ok("Account Successfully deleted");
    }



}
