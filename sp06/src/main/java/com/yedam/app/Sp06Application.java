package com.yedam.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages="com.yedam.app.**.mapper") //이거 추가해야 인터페이스를 읽고 매퍼 생성함
@SpringBootApplication
public class Sp06Application {

	public static void main(String[] args) {
		SpringApplication.run(Sp06Application.class, args);
	}

}
