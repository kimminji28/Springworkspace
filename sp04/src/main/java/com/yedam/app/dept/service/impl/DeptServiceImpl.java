package com.yedam.app.dept.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.yedam.app.dept.mapper.DeptMapper;
import com.yedam.app.dept.service.DeptService;
import com.yedam.app.dept.service.DeptVO;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class DeptServiceImpl implements DeptService {

	final private DeptMapper deptMapper;
	
	@Override
	public List<DeptVO> findALL() {
		return deptMapper.selectDeptAll();
	}

	@Override
	public DeptVO findDepartmentId(DeptVO deptVO) {
		return deptMapper.selectDept(deptVO);
	}

	@Override
	public int addDeptInfo(DeptVO deptVO) {
		int result = deptMapper.updateDept(deptVO);
		return result > 0 ? deptVO.getDEPARTMENTID() : -1;
	}

	@Override
	public Map<String, Object> modifyDeptInfo(DeptVO deptVO) {
		Map<String, Object> map = new HashMap<>();
		boolean isSuccessed = false;
		
		int result = deptMapper.updateDept(deptVO);
		if(result >= 1) {
			isSuccessed = true;
		}
		map.put("result", isSuccessed);
		map.put("target", deptVO);
		return map;
	}

	@Override
	public Map<String, Object> removeDeptInfo(int deptId) {
		Map<String, Object> map = new HashMap<>();
		int result = deptMapper.deleteDept(deptId);
		if(result >= 1) {
			map.put("departmentId", deptId);
		}
		return map;
	}

}
