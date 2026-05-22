package com.yedam.app;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yedam.app.jpa.repository.UserRepository;
import com.yedam.app.jpa.service.User;

@SpringBootTest
public class JPATest {
	@Autowired
	private UserRepository userRep;
	
	@Test
	void insertTest() {
		User first = new User();
		first.setId("Hong");
		first.setPassword("1234");
		first.setAge(28);
		
		userRep.save(first); //save : 식별자가 없으면 등록, 식별자가 있으면 수정
		
		User second = new User();
		second.setId("Kang");
		second.setPassword("1234");
		
		userRep.save(second);
	}
}
