package com.yedam.java.anotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ResaurantExample {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfig.class);
		
		Restaurant res = ctx.getBean(Restaurant.class);
		res.run();
		
	}

}
