package com.cathaybk.lambda.methodReference;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestStaticMethodCall {

	static class Emp {
		String name;

		public Emp(String name) {
			super();
			this.name = name;
		}
		@Override
		public String toString() {
			return this.name;
		}
	}
	
	public static void showEmpName(Emp emp) {
		System.out.println(emp.name);
	}
	public void showEmpNameNonStatic(Emp emp) {
		System.out.println(emp.name);
	}
	
	public static void main(String[] args) {
		List<Emp> empList = Stream.of(
			new TestStaticMethodCall.Emp("Emp1"),
			new TestStaticMethodCall.Emp("Emp2"),
			new TestStaticMethodCall.Emp("Emp3"),
			new TestStaticMethodCall.Emp("Emp4"),
			new TestStaticMethodCall.Emp("Emp5")
		).collect(Collectors.toList());
		
		empList.forEach(x -> TestStaticMethodCall.showEmpName(x));
		System.out.println("=================================");
		empList.forEach(TestStaticMethodCall::showEmpName);
		System.out.println("=================================");
		empList.forEach(new TestStaticMethodCall()::showEmpNameNonStatic);
	}

}
