package com.yedam.java.anotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component //Bean으로 등록하는 어노테이션
public class Restaurant {
	// 필드
	private Chef chef; //객체가 다른 객체에 하나의 정보로 들어가는게 집합관계라고 함
	
	// 생성자 (권장)
	public Restaurant(Chef chef) {
		this.chef = chef;
	}
	
	// 메소드
	public Restaurant() {}
	
	@Autowired
	public void setChcf(Chef chef) {
		this.chef = chef;
	}
	
	public void run() {
		chef.cooking();
	}
}
