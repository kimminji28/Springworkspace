package com.yedam.app.board.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yedam.app.board.mapper.BoardMapper;
import com.yedam.app.board.service.BoardService;
import com.yedam.app.board.service.BoardVO;

import lombok.RequiredArgsConstructor;

@Service //Transactional = AOP
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{
	
	private final BoardMapper boardMapper;
	
	@Override
	public List<BoardVO> findAll() {
		return boardMapper.selectAll();
	}

	@Override
	public BoardVO findByBno(BoardVO boardVO) {
		return boardMapper.selectInfo(boardVO);
	}

	@Override
	public int addInfo(BoardVO boardVO) {
		int result = boardMapper.insertInfo(boardVO);
		return result == 1 ? boardVO.getBno() : -1;
	}
	
}
