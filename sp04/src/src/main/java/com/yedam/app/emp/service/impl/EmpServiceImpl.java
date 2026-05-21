package com.yedam.app.emp.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.yedam.app.emp.mapper.EmpMapper;
import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

import lombok.RequiredArgsConstructor;
//lombok : 입력한 데이터를 기준으로 변경사항에 대해 자동 수정해줌
@Service //비즈니스 영역에 해당하는 Bean 등록
		 //트랜잭션 처리
@RequiredArgsConstructor
public class EmpServiceImpl implements EmpService {
	
	final private EmpMapper empMapper; //다대다 관계
	//emp와 서비스는 1대1
	//기능으로 따지면 다대다 (서비스 / 매퍼)

	@Override
	public List<EmpVO> findAll() {
		return empMapper.selectEmpAll();
	}

	@Override
	public EmpVO findByEmployeedId(EmpVO empVO) {
		return empMapper.selectEmp(empVO);
	}

	@Override
	public int addEmpInfo(EmpVO empVO) {
		int result = empMapper.insertEmp(empVO);
		//<selectkey/> 사용으로 가능함.
		return result > 0 ? empVO.getEmployeeId() : -1;
	}

	@Override
	public Map<String, Object> modifyEmpInfo(EmpVO empVO) {
		Map<String, Object> map = new HashMap<>();
		boolean isSuccessed = false;
		
		int result = empMapper.updateEmp(empVO);
		if(result >= 1) {
			isSuccessed = true;
		}
		map.put("result", isSuccessed);
		map.put("target", empVO);
		/*
		 {
		 	"result" : true,
		 	"target" : {
		 			"employeeId" : 100,
		 			"lastName" : "King",
		 			...
		 		}
		 } 
		 */
		return map;
	}

	@Override
	public Map<String, Object> removeEmpInfo(int empId) {
		Map<String, Object> map = new HashMap<>();
		// => map의 변수 : {}; 실제로 빈 객체임
		int result = empMapper.deleteEmp(empId);
		if(result >= 1) {
			map.put("employeeId", empId);
			// => {"employeeId" : 100}
		}
		return map;
	}

}
