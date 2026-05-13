package com.yedam.app.mybatis.service;

//typeHandler : DateTypeHandler
import java.util.Date;

import lombok.Data;

@Data
public class EmpVO {
	//mapUnderscoreToCamelCase : true 이게 조건이 맞아떨어져서 카멜표기법 사용 가능
	// employee_id => employeeId
	private Integer employeeId;
	// first_name => firstName
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private Date hireDate;
	private String jobId;
	private double salary;
	private double commissionPct;
	private int managerId;
	private int departmentId;
}
