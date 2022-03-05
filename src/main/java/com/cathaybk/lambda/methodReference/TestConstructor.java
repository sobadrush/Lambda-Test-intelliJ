package com.cathaybk.lambda.methodReference;

//@FunctionalInterface
//interface IDept {
//	Dept create();
//}

@FunctionalInterface
interface IDeptWithArg {
	Dept create(String dName);
}

class Dept {
	String name = "Default Dept Name";

	public Dept() {
		super();
	}

	public Dept(String name) {
		super();
		this.name = name;
	}
}

public class TestConstructor {

	public static void main(String[] args) {
//		IDept dept1 = Dept::new;
//		Dept deptVO1 = dept1.create();
//		System.out.println("1. " + deptVO1.name);
		
		IDeptWithArg dept2 = Dept::new;
		Dept deptVO2 = dept2.create("Roger");
		System.out.println(deptVO2.name);
	}

}
