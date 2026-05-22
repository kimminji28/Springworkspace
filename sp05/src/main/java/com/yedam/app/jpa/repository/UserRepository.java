package com.yedam.app.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yedam.app.jpa.service.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	//JpaRepository(Spring Data JPA에서 제공)<User(entity), Long(식별자)>
}
