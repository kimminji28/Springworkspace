package com.yedam.app.emp.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yedam.app.emp.mapper.EmpMapper;
import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

import lombok.RequiredArgsConstructor;

@Service //비느지스 로직을 담당하는 빈 등록
@RequiredArgsConstructor
public class EmpServiceImpl implements EmpService{

	private final EmpMapper empMapper;
	
	@Override
	public List<EmpVO> findAll() {
		return empMapper.selectAll();
	}
	
}
