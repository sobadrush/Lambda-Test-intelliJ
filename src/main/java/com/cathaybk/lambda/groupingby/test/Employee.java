package com.cathaybk.lambda.groupingby.test;

import lombok.*;

import java.beans.ConstructorProperties;

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

    public static void main(String[] args) {
        EmployeeBuilder emp1 = Employee.builder().name("Roger").city("Taipei").salary(2200d);
        EmployeeBuilder emp2 = Employee.builder().name("Sam").city("USA").salary(2300d);
        EmployeeBuilder emp3 = Employee.builder().name("Kelly").city("Taipei").salary(2100d);
        EmployeeBuilder emp4 = Employee.builder().name("Tommy").city("Singapore").salary(2200d);
        EmployeeBuilder emp5 = Employee.builder().name("Joe").city("USA").salary(2800d);
        EmployeeBuilder emp6 = Employee.builder().name("Alice").city("Taipei").salary(3100d);
        EmployeeBuilder emp7 = Employee.builder().name("Britney").city("USA").salary(2300d);
        EmployeeBuilder emp8 = Employee.builder().name("Cindy").city("Taipei").salary(1800d);
        EmployeeBuilder emp9 = Employee.builder().name("Doge").city("Taipei").salary(1900d);
        EmployeeBuilder emp10 = Employee.builder().name("Ethan").city("Singapore").salary(2200d);
        System.out.println("emp1.build() = " + emp1.build());
    }

}
