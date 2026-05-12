package com.yedam.app.commom;

public class TVExample {

	public static void main(String[] args) {
		System.out.println("일반적인 방식");
//		TV tv = new SamsungTV();
		TV tv = new LGTV();
		tv.powerOn();
		tv.volumnUp();
		tv.powerOff();
		
	}

}
