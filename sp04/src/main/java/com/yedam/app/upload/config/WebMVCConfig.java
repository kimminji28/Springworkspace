package com.yedam.app.upload.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration //설정
public class WebMVCConfig implements WebMvcConfigurer {
	//인터페이슨에 추상메소드안에 실행 코드가 없어야하는데 업데이트되면서 기능이 추가됨 -> 추상메소드가 일반메소드로 변경됨
	@Value("${file.upload.path}") //운영체제에서 직접 파일을 가져오는 어노테이션이 Value라는거 기억해두기 [[[배포할 때는 이거 사용]]]
	private String uploadPath;
//	private String uploadPath = "D:/upload/"; // 폴더 밑에 / 슬래시 꼭 붙여야 폴더 안에 파일 불러들임 [[[개발할 때는 이거 사용]]]

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/imgs/**") // URI
			.addResourceLocations("file:///" + uploadPath); // Location
	}
}