package com.yedam.app.commom;

public class SamsungTV implements TV {

	@Override
	public void powerOn() {
		System.out.println("삼성 TV를 켭니다.");
	}

	@Override
	public void volumnUp() {
		System.out.println("삼성 TV의 소리를 키웁니다.");
	}

	@Override
	public void powerOff() {
		System.out.println("삼성 TV를 끕니다.");
	}
	
}
