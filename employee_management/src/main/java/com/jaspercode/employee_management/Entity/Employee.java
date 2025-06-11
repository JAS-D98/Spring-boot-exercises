package com.jaspercode.employee_management.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="employee_table")
@Entity
public class Employee {
    
   @Id
   @GeneratedValue(strategy = GenerationType.UUID)
   public String id;

   @Column(name="employee_name")
   public String employeeName;
   @Column(name="employee_department")
   public String employeeDepartment;
   @Column(name="employeeSalary")
   public Double employeeSalary;
}
