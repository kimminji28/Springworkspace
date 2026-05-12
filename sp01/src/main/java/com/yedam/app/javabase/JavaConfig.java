package com.yedam.app.javabase;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//자바 기준이라 컴파일됨

// Java-based Configuration (자바를 베이스로 설정할땐 클래스명 뒤에 config 붙임)
@Configuration //해당 클래스는 설정정보를 들고있음을 표시
public class JavaConfig {
	@Bean //해당 메소드가 반환한 인스턴스를 Bean을 등록할 때 사용 -> 이 메소드를 반환하는 주체는 IoC Container임
	public Chef chef() {
		return new Chef();
	}
	
	@Bean(name = "res")
	public Restaurant restaurant(Chef chef) {
		//Setter 방식
//		Restaurant res = new Restaurant();
//		res.setChcf(chef);
//		return res;
		
		//생성자 방식
		return new Restaurant(chef);
		
	}
	
}
