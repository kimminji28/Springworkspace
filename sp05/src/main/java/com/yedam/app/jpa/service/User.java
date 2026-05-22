package com.yedam.app.jpa.service;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity //JPA를 기준으로
@Table(name = "TBL_USER")//이 클래스가 어느 테이블에 연결될건지?
public class User {
	//컬럼 타입 설정한하면 무조건 VARCHAR(255)로 설정됨
	
	@Id //식별자
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long no;
	
	@Column(name="username", length=20, nullable=false, unique=true)
	//length-varchar   nullable-not null                unique=true  중복은 못들어옴
	private String id;
	
	@Column(length=20, nullable=false)
	private String password;
	
	private Integer age;
	private String email;
	
}
