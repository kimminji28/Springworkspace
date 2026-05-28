package com.yedam.app.book.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.yedam.app.book.service.BookService;
import com.yedam.app.book.service.BookVO;
import com.yedam.app.emp.service.RentVO;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BookController {
	private final BookService bookService;
	
	@GetMapping("bookList")
	public String bookList(Model model) {
		List<BookVO> list = bookService.findAll();
		model.addAttribute("books", list);
		return "book/list";
	}

	@GetMapping("rentList")
	public String rentList(Model model) {
		List<RentVO> list = bookService.rentAll();
		model.addAttribute("rents", list);
		return "rent/list";
	}
	
	@GetMapping("bookInsert")
	public String bookInsertForm() {
		return "book/insert";
	}
	
	@PostMapping("bookInsert")
	public String bookInsertProcess(BookVO bookVO) {
		int bkno = bookService.bookAdd(bookVO);
		return "redirect:bookList?bookNo=" + bkno;
	}
	
}
