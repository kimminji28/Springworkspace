package com.yedam.app.board.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.yedam.app.board.service.BoardService;
import com.yedam.app.board.service.BoardVO;

import lombok.RequiredArgsConstructor;

@Controller //DispatcherServlet에게 정보를 전달
@RequiredArgsConstructor
public class BoardController {
	//⭐⭐⭐⭐⭐⭐⭐기억하기⭐⭐⭐⭐⭐⭐⭐
	private final BoardService boardService;
	
	//게시글 전체조회 : boardList, board/list.html
	@GetMapping("boardList")
	public String boardList(Model model) {
		//1) 제공할 서비스
		List<BoardVO> list = boardService.findAll();
		//2) 페이지에 전달할 데이터
		model.addAttribute("boards", list);
		//3) 사용할 페이지
		return "board/list";
	}
}
