package com.yedam.app.emp.web;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; //모델 매개변수는 스프링꺼 => 페이지를 쓰겠다.
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

import lombok.RequiredArgsConstructor;

@Controller //Web(DispatcherServlet)과 관련된 Bean
@RequiredArgsConstructor
public class EmpController {
	
	final private EmpService empService;
	
	//GET : 빈페이지, 조회
	//POST : 데이터 조작(등록, 수정, 삭제)
	//삭제 : 경우에 따라 GET으로 처리하기도 함.
	
	// 1) GET? POST?
	// 2) Content-type 선택 x-www / json / multi
	// 3) 어노테이션 뭐 사용할지 선택
	// 4) 범위를 좁혔으면 service에서 그 메소드의 형태를 보고 어노테이션을 선택
	
	//전제초회 - GET
	@GetMapping("empList") // 1) Endpoint
	public String empList(Model model) {
		// 2) 제공할 서비스
		List<EmpVO> list = empService.findAll();
		// 3) 응답 형태 선택 - view
		// 3-1) 페이지에 저달할 데이터 담기
		model.addAttribute("emps", list);
		// 3-2) 데이터 출력할 페이지 선택
		return "emp/list"; //return은 '/'로 시작하면안됨
		//prefix => classpath:/templates/
		//suffix => .html
		//viewResolver -> classpath:/templates/emp/list.html
	}
	
	//단건조회 - GET
	@GetMapping("empInfo") //QueryString 1)커맨드객체 2)@RequestParam
	 					   //커맨드객체 : @ x, 객체타입
	public String empInfo(EmpVO empVO, Model model) { 
		EmpVO findVO = empService.findByEmployeedId(empVO);
		model.addAttribute("emp", findVO);
		return "emp/info";
	}
	
	//등록, 페이지 - GET
	@GetMapping("empInsert")
	public String empInsertForm() {
		return "emp/insert";
	}
	
	//등록, 처리 - POST => <form/> -> QueryString -> 커맨드객체
	@PostMapping("empInsert")
	public String empInsertProcess(EmpVO empVO) {
		int eid = empService.addEmpInfo(empVO);
		return "redirect:empInfo?employeeId=" + eid; //dispatch servlet이 바로 보내버림
		//redirect는 새로운 컨트롤러 메소드를 호출
	}
	
	//수정, 페이지 - GET => 단건조회랑 동일함 -> QueryString -> 커맨드객체
	@GetMapping("empUpdate")
	public String empUpdateForm(EmpVO empVO, Model model) {
		EmpVO findVO = empService.findByEmployeedId(empVO);
		model.addAttribute("emp", findVO);
		return "emp/update";
	}
	
	//수정, 처리 - POST => AJAX
	@PostMapping("empUpdate")
	@ResponseBody //AJAX용이라 페이지없이 데이터만 반환
				  //=> 리턴 타입이 반환될 데이터를 반영
	 public Map<String, Object> empUpdateProcess
	 							(@RequestBody EmpVO empVO){
		return empService.modifyEmpInfo(empVO);
	 }	
	
	//삭제, 처리 - GET -> 단건조회에서 삭제할 리스트 삭제하면 전체리스트로 돌아감
	//QueryString -> 데이터가 하나라 기본타입(인티저/스트링/더블)으로 처리 -> @RequsetParam
	@GetMapping("empDelete")
	public String empDelete(Integer empId) {
		empService.removeEmpInfo(empId);
		return "redirect:empList";
	}
	
}
