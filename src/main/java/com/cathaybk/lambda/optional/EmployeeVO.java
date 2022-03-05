package com.cathaybk.lambda.optional;

import java.util.Optional;

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

class Company {
	String companyName;
	Floor floor;

	public Company(String compName, Floor floor) {
		this.floor = floor;
		this.companyName = compName;
	}
}

public class EmployeeVO {
	Company company;

	public EmployeeVO(Company company) {
		this.company = company;
	}

	public Company getCompany() {
		return company;
	}

	public static void main(String[] args) {
//		Floor floor = new Floor(3, new Room("18"));
		Floor floor = new Floor(new Room("B區_18房"));
		Company company = new Company("台積電", floor);
		EmployeeVO emp = new EmployeeVO(company);

//		.map(ss::substring(3));
		System.out.println(
				Optional.ofNullable(emp)
				.map(ee -> ee.getCompany())
				.map(cc -> cc.floor)
				.map(ff -> ff.room)
				.map(rr -> rr.roomNum).map(str -> str.split("_")[1])
				.map((str) -> {
					return str + "_GGG_";
				})
		);
	}
}
