package com.yedam.app.dept.service;

import lombok.Data;

@Data
public class DeptVO {
	private Integer DEPARTMENTID;   //PK
	private String DEPARTMENTNAME;  //NOT NULL, FK(LOCATIONS)
	private int MANAGERID;          //FK(EMPLOYEES)
	private int LOCATIONID;         //CHECK 조건으로 인해 무조건 0보다 커야함
}
