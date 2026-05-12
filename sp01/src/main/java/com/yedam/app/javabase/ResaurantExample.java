package com.yedam.app.javabase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ResaurantExample {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfig.class);
		
		Restaurant res = ctx.getBean(Restaurant.class);
//		res = (Restaurant) ctx.getBean("res");
		res.run();
		
	}

}
