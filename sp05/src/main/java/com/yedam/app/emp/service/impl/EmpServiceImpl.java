package com.yedam.app.emp.service.impl;

import org.springframework.stereotype.Service;

import com.yedam.app.emp.mapper.EmpMapper;
import com.yedam.app.emp.service.EmpService;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class EmpServiceImpl implements EmpService {
	final private EmpMapper empMapper;
	
	@Override
	public Integer selectInfo(String keyword) {
		return empMapper.selectEmpInfo();
	}

}
