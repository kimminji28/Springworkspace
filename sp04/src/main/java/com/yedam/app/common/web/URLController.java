package com.yedam.app.common.web;

//GET : 브라우저로 조회 가능
//그외 : POSTMAN으로 진행해야함

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;

//주의) 모든 클래스는 어떤 형태로든간에 어노테이션이 붙음
@Controller // web(dispatcherServlet)과 관련된 Bean
			// Route = Endpoint(HTTP Method + URI)
			// 		   + Service
			//		   + Return Type(View or Data)
public class URLController {
	
	// 이 메소드 1개가 1개의 컨트롤러임
//	@RequestMapping(path="/getKeyword", method=RequestMethod.GET)
	@GetMapping("/getKeyword") //이걸 많이 씀
	@ResponseBody //AJAX로 만들어주는 어노테이션
	public String getMappint(String keyword) {
		return "Get Method : keyword, " + keyword;
	}
	
//	@RequestMapping(path="/postKeyword", method=RequestMethod.POST)
	@PostMapping("/postKeyword")
	@ResponseBody //AJAX로 만들어주는 어노테이션
	public String postMapping(String keyword) {
		return "Post Method : keyword, " + keyword;
	}
	
}
