package com.yedam.app.jpa.service;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

//@Entity
@Entity(name="cust")   //테이블명 따로 지정안하면 엔티티 이름을 기준으로 새테이블 만들어버림
@Table(name="Customer")
@Data
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) //디비마다 식별자 주는 게 다름 시퀀스, i로 시작하는 거 등
	private Long id; //식별자 자동부여 (시퀀스=숫자타입만 가능해서 롱타입 사용)
	
	@Column(length=20, nullable=false)
	private String name;
	
	@Column(length = 20, nullable=false, unique=true)
	private String phone;
	
	private String email;
	
	@CreationTimestamp //등록 시 시간 자동생성, hirebernate 환경이 아니면 사용못함
	private Timestamp rdt;
	
	@UpdateTimestamp //수정 시 시간 자동생성
	private Timestamp udt;
}
