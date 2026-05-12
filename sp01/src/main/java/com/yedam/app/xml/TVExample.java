package com.yedam.app.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVExample {

	public static void main(String[] args) {
		System.out.println("Spring IoC 방식");
		ApplicationContext ctx = new GenericXmlApplicationContext("classpath:XmlApplicationContext.xml");
		// 1) 클래스나 인터페이스 정보를 기반으로 Bean 요청
		// TV tv = ctx.getBean(TV.class);
		
		// 2) Bean의 이름을 기반으로 Bean 요청
		TV tv = (TV) ctx.getBean("tv");
		tv.powerOn();
		tv.volumnUp();
		tv.powerOff();
		
	}

}
