package com.cathaybk.lambda.groupingby.test;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author RogerLo
 * @date 2022/5/14
 */
@Data
@Builder
public class Employee {

    private String name;
    private String city;
    private double salary;
    private BigDecimal yearSalary;

    public static void main(String[] args) {
        EmployeeBuilder emp1 = Employee.builder().name("Roger").city("Taipei").salary(2200d).yearSalary(BigDecimal.valueOf(120L));
        EmployeeBuilder emp2 = Employee.builder().name("Sam").city("USA").salary(2300d).yearSalary(BigDecimal.valueOf(150L));
        EmployeeBuilder emp3 = Employee.builder().name("Kelly").city("Taipei").salary(2100d).yearSalary(BigDecimal.valueOf(100L));
        EmployeeBuilder emp4 = Employee.builder().name("Tommy").city("Singapore").salary(2200d).yearSalary(BigDecimal.valueOf(130L));
        EmployeeBuilder emp5 = Employee.builder().name("Joe").city("USA").salary(2800d).yearSalary(BigDecimal.valueOf(170L));
        EmployeeBuilder emp6 = Employee.builder().name("Alice").city("Taipei").salary(3100d).yearSalary(BigDecimal.valueOf(110L));
        EmployeeBuilder emp7 = Employee.builder().name("Britney").city("USA").salary(2300d).yearSalary(BigDecimal.valueOf(190L));
        EmployeeBuilder emp8 = Employee.builder().name("Cindy").city("Taipei").salary(1800d).yearSalary(BigDecimal.valueOf(90L));
        EmployeeBuilder emp9 = Employee.builder().name("Doge").city("Taipei").salary(1900d).yearSalary(BigDecimal.valueOf(70L));
        EmployeeBuilder emp10 = Employee.builder().name("Ethan").city("Singapore").salary(2200d).yearSalary(BigDecimal.valueOf(180L));
        System.out.println("emp1.build() = " + emp1.build());
    }

}
