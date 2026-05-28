package com.yedam.app.board.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
	
	//게시글 상세조회 : boardInfo, board/info.html
	@GetMapping("boardInfo") //www-form 타입이라 쿼리스트링 -> 커맨드 vs 리퀘스트파람
	// -> 서비스에서 파라미터를 객체로 보내니 커맨드 객체를 선택해서 boardVO를 받음
	public String boardInfo(BoardVO boardVO, Model model) {
		//1) 제공할 서비스
		BoardVO findVO = boardService.findByBno(boardVO);
		//2) 페이지에 전달할 데이터
		model.addAttribute("board", findVO);
		//3) 사용할 페이지
		return "board/info";
	}
	
	//게시글 등록 : boardInsert, board/insert.html 혹은 redirect
	//페이지 양식
	@GetMapping("boardInsert")
	public String boardInsertForm() {
		return "board/insert";
	}
	
	//등록 처리
	@PostMapping("boardInsert")
	public String boardInsertProcess(BoardVO boardVO) {
		int bno = boardService.addInfo(boardVO);
		return "redirect:boardInfo?bno=" + bno;
	}
	
}
