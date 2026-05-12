package com.yedam.java.anotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan // 별도의 패키지 정보가 없는 경우 
			   // 자신이 붙은 클래스의 패키지 정보를 활용 -> anotation의 클래스만 가져옴
public class JavaConfig {
	
}
