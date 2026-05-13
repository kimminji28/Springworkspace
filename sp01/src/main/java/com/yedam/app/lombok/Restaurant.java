package com.yedam.app.lombok;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor //생성자주입->final 필드를 대상으로 함
//@AllArgsConstructor //필드 전체 사용해서 생성자 만들겠다
//@NoArgsConstructor  //기본생성자
//@Setter //클래스 전체 필드를 기준으로 세터 생성
//@Data
public class Restaurant {
	// 필드
	private final Chef chef; //집합관계
	
	//lombok을 사용하면 autowired를 붙여야하는 세터가 없음 -> 추가 주입 필요
	
	//세터주입 (개별적으로 생성이 필요할 때)
//	@Setter(onMethod_ = {@Autowired}) //세터를 만들 때 @Autowired 어노테이션을 추가해서 만든다
//	private Chef chef;
	
	public void run() {
		chef.cooking();
	}
}
