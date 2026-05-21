package com.yedam.app.dept.service;

import java.util.List;
import java.util.Map;

public interface DeptService {
	//부서전체조회
	public List<DeptVO> findALL();
	
	//부서상세조회
	public DeptVO findDepartmentId(DeptVO deptVO);
	
	//부서등록
	public int addDeptInfo(DeptVO deptVO);
	
	//부서수정
	public Map<String, Object> modifyDeptInfo(DeptVO deptVO);
	
	//부서삭제
	public Map<String, Object> removeDeptInfo(int deptId);	
}
