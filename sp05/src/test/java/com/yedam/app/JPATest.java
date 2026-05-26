package com.yedam.app;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.transaction.annotation.Transactional;

import com.yedam.app.jpa.repository.CustomerRepository;
import com.yedam.app.jpa.repository.UserRepository;
import com.yedam.app.jpa.service.Customer;
import com.yedam.app.jpa.service.User;

//@Transactional
@SpringBootTest
public class JPATest {
	@Autowired
	private UserRepository userRep;
	
	//@Test
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
	
	//@Test
	void findAllTest() {
		List<User> list = userRep.findAll();
		for(User info : list) {
			System.out.println(info);
		}
	}
	
	//@Test
	void findAllByIdTest() {
		// @Id 기반 단건조회
		// orElse 옵셔널의 데이터가 널이라도 강제로 가져오던가
		// 확실하게 값이 있다고 판단되면 겟으로 조회
		// int가 아닌 long 타입이라 1L로 입력
		User user = userRep.findById(1L)
						   .orElse(null);
		System.out.println(user);
	}
	
	//@Test
	void updateTest() {
		// save : Entity 객체는 @ID 값이 필수임
		User user = userRep.findById(1L)
						   .get();
		user.setId("Kim");
		user.setEmail("Kim@hanmail.net");
		
		userRep.save(user);
		
		System.out.println(user);
	}
	
	@Autowired
	private CustomerRepository cusRepo;
	
	//@Test
	void custInsertTest() {
		Customer first = new Customer();
		first.setName("홍길동");
		first.setPhone("01012341234");
		cusRepo.save(first);
		
		Customer second = new Customer();
		second.setName("이한동");
		second.setPhone("01098769876");
		cusRepo.save(second);
	}
	
	//@Test
	void queryMethodTest() {
		List<Customer> list = cusRepo.findByNameAndPhone("이한동", "01098769876");
		for(Customer info : list) {
			System.out.println(info);
		}
		
		list = cusRepo.findByNameContaining("동");
		list.stream()
			.forEach(System.out::println);
	}
	
	@Test
	void jpqlTest() {
		List<Customer> list = cusRepo.findByAndSort("동");
		for(Customer info : list) {
			cusRepo.setFixedNameFor("Hong", info.getId());
		}
	}
	
}
