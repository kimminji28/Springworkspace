package com.yedam.app.dept.web;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.dept.service.DeptService;
import com.yedam.app.dept.service.DeptVO;

import lombok.RequiredArgsConstructor;
@Controller
@RequiredArgsConstructor
public class DeptController {
	
	final private DeptService deptService;
	
	//전체조회 GET
	@GetMapping("deptList")
	public String deptList(Model model) {
		List<DeptVO> list = deptService.findALL();
		model.addAttribute("depts", list);
		return "dept/list";
	}
	
	//단건조회 GET
	@GetMapping("deptInfo")
	public String deptInfo(DeptVO deptVO, Model model) {
		DeptVO findVO = deptService.findDepartmentId(deptVO);
		model.addAttribute("dept", findVO);
		return "dept/info";
	}
	
	//등록, 페이지 GET
	@GetMapping("deptInsert")
	public String deptInsertForm() {
		return "dept/insert";
	}
	
	//등록, 처리 POST
	@PostMapping("deptInsert")
	public String deptInsertProcess(DeptVO deptVO) {
		int did = deptService.addDeptInfo(deptVO);
		return "redirect:deptInfo?departmentId=" + did;
	}
	
	//수정, 페이지 GET
	@GetMapping("deptUpdate")
	public String deptUpdateForm(DeptVO deptVO, Model model) {
		DeptVO findVO = deptService.findDepartmentId(deptVO);
		model.addAttribute("dept", findVO);
		return "dept/update";
	}
	
	//수정, 처리 POST
	@PostMapping("deptUpdate")
	@ResponseBody
	public Map<String, Object> deptUpdateProcess(@RequestBody DeptVO deptVO){
		return deptService.modifyDeptInfo(deptVO);
	}
	
	//삭제 GET
	@GetMapping("deptDelete")
	public String depeDelete(Integer deptId) {
		deptService.removeDeptInfo(deptId);
		return "redirect:deptList";
	}
}
