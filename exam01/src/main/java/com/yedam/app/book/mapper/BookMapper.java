package com.yedam.app.book.mapper;

import java.util.List;

import com.yedam.app.book.service.BookVO;
import com.yedam.app.emp.service.RentVO;

public interface BookMapper {
	//전체조회
	public List<BookVO> selectAll();
	
	//대여현황
	public List<RentVO>  selectRent();
	
	//등록
	public int bookInsert(BookVO bookVO);
}
