package com.cathaybk.lambda.methodReference;

import java.util.stream.Stream;

public class TestPeek {

	static class Emp {

		String eName;
		Integer salary;

		public Emp(String eName, Integer salary) {
			this.eName = eName;
			this.salary = salary;
		}

		@Override
		public String toString() {
			return "Emp [eName=" + eName + ", salary=" + salary + "]";
		}
		
	}

	public static void main(String[] args) {
		TestPeek.Emp emp1 = new TestPeek.Emp("empA", 18);
		TestPeek.Emp emp2 = new TestPeek.Emp("empB", 19);
		TestPeek.Emp emp3 = new TestPeek.Emp("empC", 20);

		Stream.of(emp1, emp2, emp3).peek(ee -> ee.eName += "-GG").forEach(ee -> {
			System.out.println(ee);
		});
		
		System.out.println("-------------------------");
		
		Stream.of(emp1, emp2, emp3).map(x -> {
			x.eName += "-GG";
			return x;
		}).forEach(System.out::println);
		
	}

}
