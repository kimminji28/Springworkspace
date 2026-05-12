package com.yedam.app.xml;

public class LGTV implements TV {

	@Override
	public void powerOn() {
		System.out.println("LG TV를 켭니다.");
	}

	@Override
	public void volumnUp() {
		System.out.println("LG TV의 소리를 키웁니다.");
	}

	@Override
	public void powerOff() {
		System.out.println("LG TV를 끕니다.");
	}

}
