package com.yedam.app.dept.service;

import lombok.Data;

@Data
public class DeptVO {
	private Integer departmentId;   //PK
	private String departmentName;  //NOT NULL, FK(LOCATIONS)
	private int managerId;          //FK(EMPLOYEES)
	private int locationId;         //CHECK 조건으로 인해 무조건 0보다 커야함
}
