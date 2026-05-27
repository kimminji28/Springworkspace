package com.yedam.app.securify.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SimpleController {

	@GetMapping("all")
	public void all() {}
	
	@GetMapping("user")
	public void user() {}
	
	@GetMapping("admin")
	public void admin() {}
	
	@PostMapping("info")
	@ResponseBody
	public String info(String keyword) {
		return "Server Response : " + keyword;
	}
}
