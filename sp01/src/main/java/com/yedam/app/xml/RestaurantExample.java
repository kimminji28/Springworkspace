package com.yedam.app.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RestaurantExample {

	public static void main(String[] args) {
		System.out.println("Spring XML 방식 : DI");
		ApplicationContext ctx = new ClassPathXmlApplicationContext("XmlApplicationContext.xml");
		//ClassPathXmlApplicationContext : 쉽게말해서 얘가 컨테이너 (인스턴스 생성) + xml 파일
		//XmlApplicationContext.xml : 4개의 빈이 있음 (삼성티비, 엘지티비, 셰프, 레스토랑)
		
		Restaurant res = ctx.getBean(Restaurant.class);
		res.run();
		
		//세터 인젝션을 이용할 경우 아래 코드처럼 의도치않게 교체 가능
		//생성자 인젝션을 더 권장
		//=> 생성자를 통해 DI 이후 Bean을 교체할 수 없음
		//내가 만드는 인스턴스라 빈에 적용이 안됨 => IoC 컨테이너에서 벗어남 => 일부는 내부에서, 일부는 외부에서 관리하게됨
//		res.setChef(new Chef()); 
//		res.run();
	}

}
