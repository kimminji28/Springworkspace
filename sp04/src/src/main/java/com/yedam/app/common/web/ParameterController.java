package com.yedam.app.common.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.common.service.UserVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j //log 확인하는 어노테이션
@Controller
public class ParameterController {
	/* QueryString(질의문자열)
	 * format : key=value&key=value&...
	 * COTNTENT-TYPE : application/x-www-form-urlencoded
	 * Http Method : 전부 가능, 다른 컨텐트 타입과 혼용해서 사용 가능함 */
	
	//보통은    등록 -> submit, 삭제 -> ajax
	//커맨드와 파람은 같은 컨트롤러에서 사용 가능
	
	// 1) 커맨드 객체 : @(어노테이션) 없음. 객체타입
	@RequestMapping("/comobj")
	//@ResponseBody                     //key=value             name=hong&age=20
	public String commandObject(UserVO user) {
		log.info("path : /comobj");
		log.info("= name : " + user.getName());
		log.info("= age : " + user.getAge());
		log.info(user.toString());
		return "success";
		
		//http://localhost:8080/myApp/comobj?name=hong&age=20 이게 경로가 됨
	}
	
	// 2) @RequestParam : @ 존재(default). 기본 데이터형(단일값)_int/double은 공백 처리가 어려워서 사용안함 특정데이터조회/검색
	@RequestMapping("/resparm")
	@ResponseBody
	public String resparm(Integer age
				, @RequestParam String name //필수값 (입력안되면 400번 오류남_bad request)
				, @RequestParam(value = "msg", defaultValue = "No message") String message) {//데이터 입력안하면 디폴트벨류 데이터가 출력됨
				//value가 설정되면 String message 얘는 사용못하고, value = "msg" 얘만 사용됨 (덮어씀)
				//그래서 postman으로 message를 Hello를 보내더라도 버려지고 defaultValue = "No message" 이게 나옴
				//핸들러어댑터가 값을 담을 변수가 없다고 판단하면 내가 보냈다고 하더라도 데이터를 그냥 버림
				//통신에서 가장 권한이 강한 놈은 서버임, 얘가 데이터 퉤하면 별 수 없음
				//그러니 키 값을 msg 이걸로 넣어야 데이터를 넣을 수 있음
				//보안에 강함
		log.info("path : /reqparm");
		log.info("=name : " + name);
		log.info("= age : " + age);
		log.info("= message : " + message);
		return "sucess";
	}
	
	//URI에 값을 포함
	//Content-type : 모든 경우 가능
	//Http Method : 모두 가능
	//@PathVariable : @ 반드시 사용, 기본 데이터형 (단일값)
	//int, double 이런 거 사용 못함 -> 왜냐 참조타입이고, 공백에 대한 처리를 못함
	//pathVariable : 중복 사용 가능해서 정확한 변수명이 필요함 (어지간하면 매개변수명을 경로에 사용함)
	@RequestMapping("pathVal/{name}") //http://localhost:8080/myApp/pathVal/hong (경로), 통신상에서는 데이터로 인식을 안해서 오류가 400이 아니라 404가 뜸
	@ResponseBody
	public String pathVariable(@PathVariable String name) {
		log.info("path : /path/{name}");
		log.info("= name : " + name);
		return "home";
	}
	
	//JSON
	//format : { "key" : "value", "key" : "value", ... }
	//			or [ ]
	//Content-type : application/json
	//Http Method : POST, PUT
	//@RequestBody : @ 반드시 사용, 객체 or 배열 (List 포함)
	//커맨드객체랑 포맷이 다름
	//ajax 기반으로 json 포맷으로 데이터를 받겠다는 것. -----> Map 많이 사용함
	//ajax -> 단일 통신인 거 알아두기.
	//Map<String, Object> : 자바코드에서는 위험함, 무엇이든 담을 수 있지만 어떤 데이터가 담길지 모름
	@PostMapping("resbody") //http://localhost:8080/myApp/resbody
	@ResponseBody
	public Map<String, Object> requestBody(@RequestBody UserVO user){
		Map<String, Object> map = new HashMap<>();
		map.put("path", "resbody");
		map.put("data", user);
		return map;
	}
	
}





