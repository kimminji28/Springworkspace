package com.yedam.app.jpa.service;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity //JPA를 기준으로 객체 등록
@Table(name = "TBL_USER")//테이블명
public class User {
	//컬럼 타입 설정한하면 기본 타입은 VARCHAR(255)로 설정됨
	
	@Id //식별자
	@GeneratedValue(strategy = GenerationType.AUTO) //ID 자동으로 줄 게 아니라면 굳이 안써도 됨.
	private Long no;
	
	@Column(name="username", length=20, nullable=false, unique=true)
	//length-varchar   nullable-not null                unique=true  중복은 못들어옴
	private String id;
	
	@Column(length=20, nullable=false)
	private String password;
	
	private Integer age;
	private String email;
	
}
