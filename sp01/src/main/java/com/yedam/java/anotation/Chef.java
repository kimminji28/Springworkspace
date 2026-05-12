package com.yedam.java.anotation;

import org.springframework.stereotype.Component;

@Component //Bean으로 등록하는 어노테이션 / 개발자가 만든 클래스에서만 사용가능한 어노테이션
public class Chef {
	public void cooking() {
		System.out.println("요리를 합니다.");
	}
}
