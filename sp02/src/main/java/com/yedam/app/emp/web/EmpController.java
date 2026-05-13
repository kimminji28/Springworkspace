package com.yedam.app.emp.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

import lombok.RequiredArgsConstructor;

//컨트롤러부터 역으로 작성하는중
//express에서의 라우터 모듈과 같은 역할

@Controller //라우팅 정보를 가지는 빈 등록 -> @GetMapping("/empList") 동작 가능
@RequiredArgsConstructor
public class EmpController {
	private final EmpService empService;
	
	/*
	 router.get("/users", async (req, res) => {
  		let result = await surveyService.findAll();
  		res.send(result);
	});
	 */
	@GetMapping("/empList") //메소드 자체는 없고, 어노테이션으로 라우팅 정보를 추가함.
	public String empList(Model model) {
		List<EmpVO> list = empService.findAll();
		model.addAttribute("emps", list);
		return "empList";
	}
	//model : html 파일에 반복문에 데이터를 넘김 => ${emps}
}
