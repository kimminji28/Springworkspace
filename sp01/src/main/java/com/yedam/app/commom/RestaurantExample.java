package com.yedam.app.commom;

public class RestaurantExample {

	public static void main(String[] args) {
		System.out.println("일반적인 방식 : DI");
		
		// 생성자 방식으로 접근
		Restaurant res = new Restaurant(new Chef());
		res.run();
		
		// 세터 방식으로 접근
		Restaurant sec = new Restaurant();
		sec.setChcf(new Chef());
		sec.run();
	}

}
