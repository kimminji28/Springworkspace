package com.yedam.app.javabase;
// 레스토랑 안에서 chef가 일을 하니까 chef가 하나의 필드가 됨
public class Restaurant {
	// 필드
	private Chef chef; //객체가 다른 객체에 하나의 정보로 들어가는게 집합관계라고 함
	
	// 생성자 (권장)
	public Restaurant(Chef chef) {
		this.chef = chef;
	}
	
	// 메소드
	public Restaurant() {}	
	public void setChcf(Chef chef) {
		this.chef = chef;
	}
	
	public void run() {
		chef.cooking();
	}
}
