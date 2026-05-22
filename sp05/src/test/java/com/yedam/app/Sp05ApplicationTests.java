package com.yedam.app;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yedam.app.emp.service.EmpService;

@SpringBootTest
class Sp05ApplicationTests {
	
	@Autowired
	private EmpService empService;
	
	@Test
	void commonAopFirst() {
		int result = empService.selectInfo("검색대상");
		System.out.println("서비스 실행결과 : " + result);
	}

}
