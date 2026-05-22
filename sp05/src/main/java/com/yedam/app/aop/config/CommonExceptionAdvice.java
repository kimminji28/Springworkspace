package com.yedam.app.aop.config;




import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class CommonExceptionAdvice {
	@ExceptionHandler(NoHandlerFoundException.class)
	public String handler404(Exception ex, Model model) {
		model.addAttribute("exception", ex);
		return "error";
	}
}
