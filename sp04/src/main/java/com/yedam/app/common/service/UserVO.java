package com.yedam.app.common.service;

//import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Data 연습이라 이걸 썼었지만 프로젝트때는 이거 쓰면 안됨
@Getter
@Setter
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
public class UserVO {
	private String name;
	private Integer age;	
}
