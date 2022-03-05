package com.cathaybk.lambda.optional;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class OptionalTest001 {

	public static void main(String[] args) {
		
		class Employee {
			String empNo;
			String empName;
			public Employee(String empNo, String empName) {
				super();
				this.empNo = empNo;
				this.empName = empName;
			}
			@Override
			public String toString() {
				return ReflectionToStringBuilder.toString(this, ToStringStyle.SIMPLE_STYLE);
			}
		}
		
		class Company {
			String companyId;
			String companyName;
			List<Employee> emps;
			@Override
			public String toString() {
				return ReflectionToStringBuilder.toString(this, ToStringStyle.SIMPLE_STYLE);
			}
		}
		
		Company company = new Company();
		company.companyId = "GG33445566";
		company.companyName = "ASUS";
//		company.emps = null;
		company.emps = Stream.of(
				new Employee("A111", "Roger"), 
				new Employee("A222", "Kelly"), 
				new Employee("A333", "Tommy")).collect(Collectors.toList());
		
//		System.out.println(company);
		
//		Optional.of(company).map(x->x.emps).get();
		
//		company = null;
		
		Map<String, Employee> eMap = Optional.ofNullable(company)
				.map(cc -> cc.emps)
				.get().parallelStream()
				.map(empList -> {
					return Map.of("EmpData", empList);
				}).findFirst().get();
		System.out.println("eMap" + eMap);
	}

}
