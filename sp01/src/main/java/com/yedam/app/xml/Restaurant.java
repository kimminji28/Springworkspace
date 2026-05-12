package com.yedam.app.xml;
// 레스토랑 안에서 chef가 일을 하니까 chef가 하나의 필드가 됨
public class Restaurant {
	// 필드
	private Chef chef; //객체가 다른 객체에 하나의 정보로 들어가는게 집합관계라고 함
	
	// 생성자 (권장)
	public Restaurant(Chef chef) {
		this.chef = chef;
	}
	
	// 메소드
	//세터 사용할거면 기본 생성자 무조건 필요함, 없으면 오류남
	public Restaurant() {}
	
	public void setChef(Chef chef) {
		this.chef = chef;
	}
	
	public void run() {
		chef.cooking();
	}
}
