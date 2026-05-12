package com.yedam.app.lonbok;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor //필드 전체 사용해서 생성자 만들겠다
@NoArgsConstructor  //기본생성자
@Setter
public class Restaurant {
	// 필드
	private Chef chef; //집합관계
	
	
	public void run() {
		chef.cooking();
	}
}
