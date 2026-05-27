package com.yedam.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages="com.yedam.app.**.mapper")
@SpringBootApplication
public class Sp07Application {

	public static void main(String[] args) {
		SpringApplication.run(Sp07Application.class, args);
	}

}
