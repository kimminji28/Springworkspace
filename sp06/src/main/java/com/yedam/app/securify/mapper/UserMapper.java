package com.yedam.app.securify.mapper;

import com.yedam.app.securify.service.UserVO;

public interface UserMapper {
//매퍼에선 패스워드 사용안함
//패스워드는 프로바이더에서 설정함
	public UserVO getUserInfo(String id);
}
