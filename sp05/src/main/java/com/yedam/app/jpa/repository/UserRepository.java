package com.yedam.app.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yedam.app.jpa.service.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	//JpaRepository(Spring Data JPA에서 제공)<User(entity), Long(식별자)>
	//findAll(전체조회), fineById(단건조회), save(등록/수정=식별자 기준), deleteById(삭제) => 기본적으로 있는 메소드
}
