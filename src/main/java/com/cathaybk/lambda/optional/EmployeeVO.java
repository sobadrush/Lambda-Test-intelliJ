package com.cathaybk.lambda.optional;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Optional;
import java.util.function.Supplier;

class Room {
	String roomNum;

	public Room(String roomNum) {
		this.roomNum = roomNum;
	}
}

class Floor {
	Room room;
	Integer floorNum;

	public Floor(Room room) {
		this.room = room;
	}

	public Floor(int floorNum, Room room) {
		this.room = room;
		this.floorNum = floorNum;
	}
}

@ToString
class Company {
	String companyName;
	Floor floor;

	public Company(String companyName) {
		this.companyName = companyName;
	}

	public Company(String compName, Floor floor) {
		this.floor = floor;
		this.companyName = compName;
	}
}

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeVO {
	String empName;
    Company company;

	public EmployeeVO(String empName) {
		this.empName = empName;
	}

	public EmployeeVO(Company company) {
		this.company = company;
	}

	public static void main(String[] args) throws Throwable {
		EmployeeVO empVO = new EmployeeVO("Roger");
		System.err.println(
			Optional.ofNullable(empVO)
				.filter(xx -> !xx.getEmpName().equals("Roger"))
				.map(x -> new Company(x.getEmpName()))
				.orElseThrow((Supplier<Throwable>) () -> new RuntimeException("Can't find EmpVO whose name is Roger"))
		);
	}

    // public static void main(String[] args) {
	// 	// Floor floor = new Floor(3, new Room("18"));
	// 	Floor floor = new Floor(new Room("B區_18房"));
	// 	Company company = new Company("台積電", floor);
	// 	EmployeeVO emp = new EmployeeVO(company);
	//
	// 	// .map(ss::substring(3));
	// 	System.out.println(
	// 			Optional.ofNullable(emp)
	// 			.map(ee -> ee.getCompany())
	// 			.map(cc -> cc.floor)
	// 			.map(ff -> ff.room)
	// 			.map(rr -> rr.roomNum).map(str -> str.split("_")[1])
	// 			.map((str) -> {
	// 				return str + "_GGG_";
	// 			}).get()
	// 	);
	// }
}
