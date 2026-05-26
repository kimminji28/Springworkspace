package com.yedam.app.securify.service;

import java.util.List;

import lombok.Data;

@Data //사람에 대한 정보를 가지는거라 게터+세터 필요함
//로그인 VO랑 DB 데이터(시큐리티) 가지고있는 VO는 분리하는게 좋음
public class UserVO {
	private String loginId;
	private String password;
	private List<String> roleList;
}
