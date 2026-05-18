package com.yedam.app;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yedam.app.mybatis.mapper.EmpMapper;
import com.yedam.app.mybatis.service.EmpVO;

@SpringBootTest //스프링에서 junit을 통해 테스트를 할 수 있게 지원해주는 어노테이션 & IoC/DI정보를 전달해주는 역할
//얘 원래 AutoCommit 기반

class Sp03ApplicationTests {
	@Autowired //필드주입방식 (빈으로 IoC 컨테이너에 저장되어있기때문)
	private EmpMapper empMap;
	//@Test //해당 메소드를 테스트한다는 표시, 메소드 단위로 테스트 진행
	void selectAll() {
		List<EmpVO> list = empMap.selectAll();
		//assertXXX 메소드 : 결과를 단정짓는 메소드 (답정너임)
		//리스트에는 전체조회 데이터가 들어가있기 때문에 리스트 객체는 비어있지않다는 가정하에 트루임
		assertTrue(!list.isEmpty()); // 리스트 객체가 비어있으면 트루!
		//Failures : 1이면 assertTrue가 단정지은 결과가 틀렷다는 것.
		for(EmpVO emp : list) {
			System.out.println(emp);
		}
	}
	
	//@Test
	void selectInfo() {
		EmpVO emp = new EmpVO();
		emp.setEmployeeId(100);
		
		EmpVO findVO = empMap.selectInfo(emp);
		//			 예상결과 = 실제결과가 같으면 우리 쿼리는 정상적으로 동작함
		assertEquals("King", findVO.getLastName());
	}
	
	@Test
	void insertInfo() {
		EmpVO empVO = new EmpVO();
		empVO.setLastName("Hong");
		empVO.setEmail("hong@gmail.com");
		//email이 유니크 제약조건이 걸려있어서 재테스트가 안돼야하는데 롤백 걸려있어서 계속 테스트 가능한 상태?
		empVO.setJobId("IT_PROG");
		
		int result = empMap.insertInfo(empVO);
		assertEquals(1, result);
	}
	
	//@Test
	void updateInfo() {
		EmpVO emp = new EmpVO();
		emp.setEmployeeId(206);
		emp.setFirstName("Adward");
		emp.setSalary(8900);
		
		int result = empMap.updateInfo(emp);
		assertEquals(1, result);
	}

	//@Test
	void deleteInfo() {
		int result = empMap.deleteInfo(206);
		assertEquals(1, result);
	} 
	
}
