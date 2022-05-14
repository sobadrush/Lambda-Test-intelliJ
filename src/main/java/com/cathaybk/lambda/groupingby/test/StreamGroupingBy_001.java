package com.cathaybk.lambda.groupingby.test;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author RogerLo
 * @date 2022/5/14
 */
public class StreamGroupingBy_001 {

    public static List<Employee> EMP_LIST;

    static {
        Employee.EmployeeBuilder emp1 = Employee.builder().name("Roger").city("Taipei").salary(2200d);
        Employee.EmployeeBuilder emp2 = Employee.builder().name("Sam").city("USA").salary(2300d);
        Employee.EmployeeBuilder emp3 = Employee.builder().name("Kelly").city("Taipei").salary(2100d);
        Employee.EmployeeBuilder emp4 = Employee.builder().name("Tommy").city("Singapore").salary(2200d);
        Employee.EmployeeBuilder emp5 = Employee.builder().name("Joe").city("USA").salary(2800d);
        Employee.EmployeeBuilder emp6 = Employee.builder().name("Alice").city("Taipei").salary(3100d);
        Employee.EmployeeBuilder emp7 = Employee.builder().name("Britney").city("USA").salary(2300d);
        Employee.EmployeeBuilder emp8 = Employee.builder().name("Cindy").city("Taipei").salary(1800d);
        Employee.EmployeeBuilder emp9 = Employee.builder().name("Doge").city("Taipei").salary(1900d);
        Employee.EmployeeBuilder emp10 = Employee.builder().name("Ethan").city("Singapore").salary(2200d);
        EMP_LIST = Stream.of(emp1.build(), emp2.build(), emp3.build(), emp4.build(), emp5.build(),
                        emp6.build(), emp7.build(), emp8.build(), emp9.build(), emp10.build())
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println("EMP_LIST = " + EMP_LIST);
        Map<String, List<Employee>> empGroup =
                EMP_LIST.parallelStream()
                        .collect(Collectors.groupingBy(Employee::getCity));
        System.out.println("empGroup = " + empGroup);
        System.out.println("================================");
        System.out.println("empGroup.get('Singapore') = " + empGroup.get("Singapore"));
    }

}
