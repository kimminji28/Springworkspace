package com.yedam.app.book.service;

import java.util.List;

import com.yedam.app.emp.service.RentVO;

public interface BookService {
	//전체조회
	public List<BookVO> findAll();
	
	//대여현황
	public List<RentVO> rentAll();
	
	//등록
	public int bookAdd(BookVO bookVO);
}
