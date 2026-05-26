package com.yedam.app.jpa.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.yedam.app.jpa.service.Customer;

@Repository //Spring Data JPA에서 구현 클래스 생성
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	//Column이 아니라 field명을 기준으로 작성하기.
	//https://docs.spring.io/spring-data/jpa/reference/3.5/jpa/query-methods.html#page-title 연산자 참고 사이트
	
	//SELECT * FROM customer WHERE name = ?
	List<Customer> findByName(String name);
	
	//SELECT * FROM customer WHERE name = ? AND phone = ?
	List<Customer> findByNameAndPhone(String name, String phone);
	
	//SELECT * FROM customer WHERE name LIKE '%'?'%'
	List<Customer> findByNameContaining(String name);
	
	// JPQL : 실제 테이블과 컬럼이 아닌 Entity명과 필드명 사용
	// 1) SELECT (? 옆에는 숫자가 붙어야 함, 매개변수 위치/번호에 들어간다.)
	//@Query("SELECT u FROM Customer u WHERE u.name LIKE '%'?1'%' ORDER BY u.id DESC")
	@Query("SELECT u FROM cust u WHERE u.name LIKE CONCAT(CONCAT('%', ?1),'%') ORDER BY u.id DESC")
	public List<Customer> findByAndSort(String name);
	
	// 2) DML
	@Transactional //트랜잭션 처리, 조회를 바탕으로 진행되는거라 DML 기준으로 추가
	@Modifying    //수정가능하다는 의미의 어노테이션 추가
	@Query("UPDATE cust c SET c.name = ?1 WHERE c.id = ?2")
	public int setFixedNameFor(String name, Long id);
}
