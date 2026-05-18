package com.yedam.app.dept.mapper;

import java.util.List;

import com.yedam.app.dept.service.DeptVO;

public interface DeptMapper {
	//전체조회
	public List<DeptVO> selectDeptAll();
	
	//단건조회
	public DeptVO selectDept(DeptVO emp);
	
	//등록
	public int insertDept(DeptVO emp);
	
	//수정
	public int updateDept(DeptVO emp);
	
	//삭제
	public int deleteDept(int deptId);
}
