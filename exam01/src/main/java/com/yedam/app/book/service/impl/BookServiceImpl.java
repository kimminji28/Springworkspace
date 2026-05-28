package com.yedam.app.book.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yedam.app.book.mapper.BookMapper;
import com.yedam.app.book.service.BookService;
import com.yedam.app.book.service.BookVO;
import com.yedam.app.emp.service.RentVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService{
	
	private final BookMapper bookMapper;
	
	@Override
	public List<BookVO> findAll() {
		return bookMapper.selectAll();
	}

	@Override
	public int bookAdd(BookVO bookVO) {
		int result = bookMapper.bookInsert(bookVO);
		return result == 1 ? bookVO.getBookNo() : -1;
	}

	@Override
	public List<RentVO> rentAll() {
		return bookMapper.selectRent();
	}

}
