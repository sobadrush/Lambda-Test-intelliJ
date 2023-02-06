package com.cathaybk.lambda.groupingby.test;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author RogerLo
 * @date 2023/2/4
 */
public class StreamGroupingBy_BigDecimal_001 {

    private List<Employee> EMP_LIST = null;


    private static <T extends Employee> List<T> genEmpList(Supplier<List<T>> supplier) {
        return supplier.get();
    }

    public static void main(String[] args) {
        List<Employee> employees = StreamGroupingBy_BigDecimal_001.genEmpList(() -> {
            Employee.EmployeeBuilder emp1 = Employee.builder().name("Roger").city("Taipei").salary(2200d).yearSalary(BigDecimal.valueOf(120L));
            Employee.EmployeeBuilder emp2 = Employee.builder().name("Sam").city("USA").salary(2300d).yearSalary(BigDecimal.valueOf(150L));
            Employee.EmployeeBuilder emp3 = Employee.builder().name("Kelly").city("Taipei").salary(2100d).yearSalary(BigDecimal.valueOf(100L));
            Employee.EmployeeBuilder emp4 = Employee.builder().name("Tommy").city("Singapore").salary(2200d).yearSalary(BigDecimal.valueOf(130L));
            Employee.EmployeeBuilder emp5 = Employee.builder().name("Joe").city("USA").salary(2800d).yearSalary(BigDecimal.valueOf(170L));
            Employee.EmployeeBuilder emp6 = Employee.builder().name("Alice").city("Taipei").salary(3100d).yearSalary(BigDecimal.valueOf(110L));
            Employee.EmployeeBuilder emp7 = Employee.builder().name("Britney").city("USA").salary(2300d).yearSalary(BigDecimal.valueOf(190L));
            Employee.EmployeeBuilder emp8 = Employee.builder().name("Cindy").city("Taipei").salary(1800d).yearSalary(BigDecimal.valueOf(90L));
            Employee.EmployeeBuilder emp9 = Employee.builder().name("Doge").city("Taipei").salary(1900d).yearSalary(BigDecimal.valueOf(70L));
            Employee.EmployeeBuilder emp10 = Employee.builder().name("Ethan").city("Singapore").salary(2200d).yearSalary(BigDecimal.valueOf(180L));
            return Stream.of(emp1.build(), emp2.build(), emp3.build(), emp4.build(), emp5.build(),
                            emp6.build(), emp7.build(), emp8.build(), emp9.build(), emp10.build())
                    .collect(Collectors.toList());
        });
        // System.out.println("employees = " + employees);

        Map<String, BigDecimal> groupingResult = employees.parallelStream().collect(
                Collectors.groupingBy(Employee::getCity,
                    Collectors.reducing(
                         BigDecimal.ZERO /*identity*/,
                        (Employee x) -> x.getYearSalary() /*mapper*/,
                        (bigDecimal_1, bigDecimal_2) -> bigDecimal_1.add(bigDecimal_2)
                    ) /*BinaryOperator*/)
        );
        System.err.println("groupingResult = " + groupingResult);

        // Map<String, BigDecimal> groupingResult = employees.parallelStream()
        //         .collect(Collectors.groupingBy(Employee::getCity))
        //         .entrySet().parallelStream()
        //         .collect(Collectors.toMap(entry -> entry.getKey() /*keyMapper*/, entry -> {
        //             return entry.getValue().parallelStream()
        //                     .map(Employee::getYearSalary)
        //                     .reduce(BigDecimal.ZERO, (bigDecimal_1, bigDecimal_2) -> bigDecimal_1.add(bigDecimal_2)); /*valueMapper*/
        //         }));
        // System.err.println("groupingResult = " + groupingResult);
    }

}
