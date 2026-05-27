package com.yedam.app.board.mapper;

import java.util.List;

import com.yedam.app.board.service.BoardVO;

//인터페이스다, 어노테이션 금지. (MapperScan이 있어서, 같이 사용하면 이중으로 읽음)

public interface BoardMapper {
	//전체조회
	public List<BoardVO> selectAll();
}
