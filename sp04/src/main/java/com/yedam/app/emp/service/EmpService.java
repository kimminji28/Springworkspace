package com.yedam.app.emp.service;

import java.util.List;
import java.util.Map;

public interface EmpService {
	//사원전체조회
	public List<EmpVO> findAll();
	
	//사원상세조회
	public EmpVO findByEmployeedId(EmpVO empVO);
	
	//사원등록
	public int addEmpInfo(EmpVO empVO);
	
	//사원수정
	public Map<String, Object> modifyEmpInfo(EmpVO empVO);
	
	//사원삭제
	public Map<String, Object> removeEmpInfo(int empId);
}
