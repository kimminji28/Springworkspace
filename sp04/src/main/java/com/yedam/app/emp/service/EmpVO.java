package com.yedam.app.emp.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //내부적으로 총 5개의 어노테이션을 기반으로 동작함 (이 5개가 모두 필요한 게 아니면 data 쓰면 안됨)
@NoArgsConstructor //Mybatis, HanderAdapter에서도 필요한 애임 (생성자 만들어주는거였나 없는거였나 뭐 암튼 빌더를 쓰려면 생성자가 필요함)
@AllArgsConstructor
@Builder
public class EmpVO {
	//DB와 연결 => 컬럼명을 참고해서 필드명 구성
	private Integer employeeId;   //PK
	private String firstName;
	private String lastName;      //NOT NULL
	private String email;         //NOT NULL, Unique
	private String phoneNumber;
	@DateTimeFormat(pattern = "yyyy-MM-dd") //값을 입력해야하는 날짜마다 입력(무조건 개별)
	private Date hireDate;        //NOT NULL
	private String jobId;	      //NOT NULL, FK(jobs)
	private Double salary;	  	  //CHECK 조건으로 인해 무조건 0보다 커야함
	private double commissionPct; //1보다 작아야함
	private int managerId;        //FK(employees)
	private int departmentId;     //FK(departments)
}
