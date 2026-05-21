package com.yedam.app.emp.web;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

import lombok.RequiredArgsConstructor;

@RestController //@Controller + @ResponsBody
@RequiredArgsConstructor //서비스 끌어내는 용도
public class EmpRestController {
	private final EmpService empService;
	
	//전체조회 : GET    + emps
	@GetMapping("emps")
	public List<EmpVO> empList(){
		return empService.findAll();
	}
	
	//단건조회 : GET    + emps/{eid}
	@GetMapping("emps/{eid}")
	public EmpVO empInfo(@PathVariable Integer eid) {
//		EmpVO empVO = new EmpVO();
//		empVO.setEmployeeId(eid);
		EmpVO empVO = EmpVO.builder()
						   .employeeId(eid)
						   .build();
		return empService.findByEmployeedId(empVO);
	}
	
	//등   록 : POST   + emps       + JSON
	@PostMapping("emps")
	public Integer empInsert(@RequestBody EmpVO empVO) {//데이터 받아서 처리중이라 @RequestBody 필요
		return empService.addEmpInfo(empVO);
	}
	
	//수   정 : PUT    + emps/{eid} + JSON
	@PutMapping("emps/{eid}")
	public Map<String, Object> empUpdate(@PathVariable Integer eid, //{eid}
										 @RequestBody EmpVO empVO)  //JSON
	{
		empVO.setEmployeeId(eid); //데이터는 최종적으로 하나만 넘기기때문에 매개변수 2개 합쳐야 함
		return empService.modifyEmpInfo(empVO);
	}
	
	//삭   제 : DELETE + emps/{eid}
	@DeleteMapping("emps/{eid}")
	public Map<String, Object> empDelete(@PathVariable Integer eid){
		return empService.removeEmpInfo(eid);
	}
	
}
